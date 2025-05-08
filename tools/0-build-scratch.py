#!/usr/bin/env python
# -*- coding:utf-8 -*-

import os
import os.path
from os import path
import ujson as json
import requests
import pprint
import time
import random
import time
from re import search
from http.cookies import SimpleCookie
from datetime import datetime
import subprocess

def cookie():
   cookie = SimpleCookie()
   cookie.load(open("./.cookie", 'r').read())
   cookies = {}
   for key, morsel in cookie.items():
       cookies[key] = morsel.value
#    print(cookies)
   return cookies

def get_problems():
    data_file = './leetcode-%s.json'%(datetime.today().strftime('%Y%m%d'))
    problem_json = None
    if path.exists(data_file):
        print("read problems, file=", data_file)
        pjf = open(data_file, "r")
        problem_json = pjf.read()
        pjf.close()
    else:
        r = requests.get('https://leetcode.cn/api/problems/all/')
        print("get problems, status=", r.status_code)
        if r.status_code == 200:
            problem_json = r.text
            f = open(data_file, 'w')
            f.write(result)
            f.close

    if problem_json is None:
        raise Exception("does not get problems json.")

    jo = json.loads(problem_json)
    problems = jo['stat_status_pairs']
    problems = list(filter(lambda x: x["stat"]["frontend_question_id"].isnumeric(), problems))
    # https://stackoverflow.com/a/403426/951836
    sorted_problems = sorted(
        problems, key=lambda x: int(x["stat"]["frontend_question_id"]), reverse=False)
    return sorted_problems

# 所有的题目都可以获取到
# 如果是锁定题目，则 data.question.content 为 null；
def fetch_problem(id, title_slug):
    data_file = "../docs/%04d-%s.adoc.json"%(id, titleSlug)
    if path.exists(data_file):
        pjf = open(data_file, "r")
        problem_json = pjf.read()
        pjf.close()
        return problem_json
    else:
        url = 'https://leetcode.cn/graphql'
        headers = {
            'content-type': 'application/json',
            'Referer': 'https://leetcode.cn/problemset/'
        }
        data = '{"operationName":"questionData","variables":{"titleSlug":"%s"},"query":"query questionData($titleSlug: String\u0021) {\\n  question(titleSlug: $titleSlug) {\\n    questionId\\n    questionFrontendId\\n    boundTopicId\\n    title\\n    titleSlug\\n    content\\n    translatedTitle\\n    translatedContent\\n    isPaidOnly\\n    difficulty\\n    likes\\n    dislikes\\n    isLiked\\n    similarQuestions\\n    contributors {\\n      username\\n      profileUrl\\n      avatarUrl\\n      __typename\\n    }\\n    langToValidPlayground\\n    topicTags {\\n      name\\n      slug\\n      translatedName\\n      __typename\\n    }\\n    companyTagStats\\n    codeSnippets {\\n      lang\\n      langSlug\\n      code\\n      __typename\\n    }\\n    stats\\n    hints\\n    solution {\\n      id\\n      canSeeDetail\\n      __typename\\n    }\\n    status\\n    sampleTestCase\\n    metaData\\n    judgerAvailable\\n    judgeType\\n    mysqlSchemas\\n    enableRunCode\\n    enableTestMode\\n    envInfo\\n    libraryUrl\\n    __typename\\n  }\\n}\\n"}' % title_slug
        response = requests.post(url, headers=headers, cookies=cookie(), data=data)
        print("fetch problem: %s, status: %s"%(title_slug, response.status_code))
        if response.status_code == 200:
            result = response.text
            pjf = open(data_file, "w")
            pjf.write(result)
            pjf.close()
            return result
            return response.text
        else:
            return None

# 如果是锁定题目，则 data.question.content 为 null；
def fetch_translations(id, title_slug):
    data_file = "../docs/%04d-%s.adoc.cn.json"%(id, titleSlug)
    if path.exists(data_file):
        pjf = open(data_file, "r")
        problem_json = pjf.read()
        pjf.close()
        return problem_json
    else:
        url = 'https://leetcode.cn/graphql/'
        referer = 'https://leetcode.cn/problems/%s/' % title_slug
        headers = {'content-type': 'application/json', 'Referer': referer}
        data = '{"query":"\\n    query questionTranslations($titleSlug: String\u0021) {\\n  question(titleSlug: $titleSlug) {\\n    translatedTitle\\n    translatedContent\\n  }\\n}\\n    ","variables":{"titleSlug":"%s"},"operationName":"questionTranslations"}' % (title_slug)
        response = requests.post(url, headers=headers, cookies=cookie(), data=data)
        print("fetch translation: %s, status: %s"%(title_slug, response.status_code))
        if response.status_code == 200:
            result = response.text
            pjf = open(data_file, "w")
            pjf.write(result)
            pjf.close()
            return result
        else:
            return None

problems = get_problems()
print(len(problems))

for problem in problems:
    id = problem["stat"]["frontend_question_id"]
    if not id.isnumeric():
        continue

    id = int(id)

    titleSlug = problem["stat"]["question__title_slug"]

    filename = "%04d-%s.adoc"%(id, titleSlug)

    problem_json = fetch_problem(id, titleSlug)
    translation_json = fetch_translations(id, titleSlug)

    if problem_json is None or translation_json is None:
        print("fetch %d - %s fail" % (id, problem["stat"]["question__title"]))
        continue

    tjo = json.loads(translation_json)
    content = tjo["data"]["question"]["translatedContent"]

    if content is None:
        raise Exception("can not read content.")

    process = subprocess.Popen(
        ['pandoc', '-f', 'html', '-t', 'asciidoc'],
        stdin=subprocess.PIPE,
        stdout=subprocess.PIPE,
        stderr=subprocess.PIPE
    )

    stdout, stderr = process.communicate(input=content.encode('utf-8'))

    if process.returncode != 0:
        print("转换失败：", id, titleSlug, stderr.decode('utf-8'))
        raise Exception("convert to asciidoc error")

    content = stdout.decode('utf-8')

    f = open("../docs/" + filename, "w")
    f.write("[#%04d-%s]\n"%(id, titleSlug))
    translatedTitle = tjo["data"]["question"]["translatedTitle"]
    title = "= %d. %s" %(id, translatedTitle)
    f.write(title)
    f.write("\n\n")
    f.write("https://leetcode.cn/problems/%s/[LeetCode - %d. %s ^]" % (titleSlug, id, translatedTitle))
    f.write("\n\n")
    f.write(content)
    f.write("\n")

    level = problem["difficulty"]["level"]
    originTitle = problem["stat"]["question__title"]
    javaFile = "_%04d_%s.java" % (id, ''.join(filter(str.isalnum, originTitle.title())))
    javaFile2 = "_%04d_%s_2.java" % (id, ''.join(filter(str.isalnum, originTitle.title())))

    # 2、向文件中增加相关模板内容
    f.write("\n\n")
    f.write("== 思路分析\n")
    f.write("\n\n")
    f.write('[[src-%04d]]\n'%(id))
    f.write('[tabs]\n')
    f.write('====\n')
    f.write('一刷::\n')
    f.write('+\n')
    f.write('--\n')
    f.write('[{java_src_attr}]\n')
    f.write('----\n')
    f.write('include::{sourcedir}/%s[tag=answer]\n'%(javaFile))
    f.write('----\n')
    f.write('--\n')
    f.write('\n')
    f.write('// 二刷::\n')
    f.write('// +\n')
    f.write('// --\n')
    f.write('// [{java_src_attr}]\n')
    f.write('// ----\n')
    f.write('// include::{sourcedir}/%s[tag=answer]\n'%(javaFile2))
    f.write('// ----\n')
    f.write('// --\n')
    f.write('====\n')
    f.write("\n\n")
    f.write("== 参考资料\n")
    f.write("\n\n")
    f.close()

#     # 1、向 README.adoc 增加链接
#     with open('../README.adoc', 'a') as rf:
#         rf.write("\n")
#         rf.write("//|{counter:codes}\n")
#         rf.write("//|{leetcode_base_url}/%s/[%d. %s]\n"%(titleSlug, id, translatedTitle))
#         rf.write("//|{source_base_url}/%s[Java]\n"%(javaFile))
#         rf.write("//|{doc_base_url}/%s[题解]\n"%(filename))
#         levelString = 'Easy' if level==1 else ('Medium' if level==2 else 'Hard')
#         rf.write("//|%s\n"%(levelString))
#         rf.write("//|\n")

    print(filename, " OK…")
#     time.sleep(random.randint(1, 4))

