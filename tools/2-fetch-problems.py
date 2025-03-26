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

# def get_problems(json_data):
#     jo = json.loads(json_data)
#     problems = jo['stat_status_pairs']
#     # https://stackoverflow.com/a/403426/951836
#     sorted_problems = sorted(
#         problems, key=lambda x: x["stat"]["frontend_question_id"], reverse=False)
#     return sorted_problems
#
# def get_data(url):
#     r = requests.get(url)
#     return r.text
#
# URL_LEETCODE_PROBLEMS = 'https://leetcode.com/api/problems/all/'
# json_problems = get_data(URL_LEETCODE_PROBLEMS)
# problem_list = get_problems(json_problems)

def get_problems():
    jo = json.loads(open("leetcode.json", 'r').read())
    problems = jo['stat_status_pairs']
    # https://stackoverflow.com/a/403426/951836
    sorted_problems = sorted(
        problems, key=lambda x: x["stat"]["frontend_question_id"], reverse=False)
    return sorted_problems

# 所有的题目都可以获取到
# 如果是锁定题目，则 data.question.content 为 null；
def fetch_problem(title_slug):
    url = 'https://leetcode.com/graphql'
    headers = {'content-type': 'application/json'}
    data = '{"operationName":"questionData","variables":{"titleSlug":"%s"},"query":"query questionData($titleSlug: String\u0021) {\\n  question(titleSlug: $titleSlug) {\\n    questionId\\n    questionFrontendId\\n    boundTopicId\\n    title\\n    titleSlug\\n    content\\n    translatedTitle\\n    translatedContent\\n    isPaidOnly\\n    difficulty\\n    likes\\n    dislikes\\n    isLiked\\n    similarQuestions\\n    contributors {\\n      username\\n      profileUrl\\n      avatarUrl\\n      __typename\\n    }\\n    langToValidPlayground\\n    topicTags {\\n      name\\n      slug\\n      translatedName\\n      __typename\\n    }\\n    companyTagStats\\n    codeSnippets {\\n      lang\\n      langSlug\\n      code\\n      __typename\\n    }\\n    stats\\n    hints\\n    solution {\\n      id\\n      canSeeDetail\\n      __typename\\n    }\\n    status\\n    sampleTestCase\\n    metaData\\n    judgerAvailable\\n    judgeType\\n    mysqlSchemas\\n    enableRunCode\\n    enableTestMode\\n    envInfo\\n    libraryUrl\\n    __typename\\n  }\\n}\\n"}' % title_slug
    response = requests.post(url, headers=headers, data=data)
    if response.status_code == 200:
        return response.text
    else:
        return None

# 如果是锁定题目，则 data.question.content 为 null；
def fetch_translations(title_slug):
    url = 'https://leetcode.cn/graphql/'
    headers = {'content-type': 'application/json'}
    data = '{"query":"\n    query questionTranslations($titleSlug: String!) {\n  question(titleSlug: $titleSlug) {\n    translatedTitle\n    translatedContent\n  }\n}\n    ","variables":{"titleSlug":"%s"},"operationName":"questionTranslations"}' % title_slug
    response = requests.post(url, headers=headers, data=data)
    if response.status_code == 200:
        return response.text
    else:
        return None

problem_list = get_problems()

for problem in problem_list:
    id = problem["stat"]["frontend_question_id"]
    titleSlug = problem["stat"]["question__title_slug"]
    filename = "%04d-%s.adoc"%(id, titleSlug)

    filepath = "../docs/"+filename
    problem_file = filepath+".json"
    if path.exists(problem_file):
#         print(problem_file, " exists…")
#         pjson = open(problem_file, 'r').read()
        continue
    else:
        print("fetch %d - %s" % (id, problem["stat"]["question__title"]))
        pjson = fetch_problem(titleSlug)

    if pjson is None:
        print("fetch %d - %s fail" % (id, problem["stat"]["question__title"]))
        continue

    jo = json.loads(pjson)
    content = jo["data"]["question"]["content"]

    if content is None:
        continue
    else:
        if not path.exists(problem_file):
            pjf = open(problem_file, "w")
            pjf.write(pjson)
            pjf.close()

    if id < 3213:
        continue

    content = content.replace("<pre>", "[subs=\"verbatim,quotes\"]\n----")

    if search("[\\w\\]\\}\\)\\.\"`]</pre>", content):
        content = content.replace("</pre>", "\n----")
    else:
        content = content.replace("</pre>", "\n----")

    content = content.replace("<strong>", "*")
    content = content.replace("</strong>", "*")

    content = content.replace("<b>", "*")
    content = content.replace("</b>", "*")

    content = content.replace("<p>", "")
    content = content.replace("</p>", "")

    content = content.replace("<div>", "")
    content = content.replace("</div>", "")

    content = content.replace("<span>", "")
    content = content.replace("</span>", "")

    content = content.replace("</font>", "")

    content = content.replace("<em>", "_")
    content = content.replace("</em>", "_")

    content = content.replace("<em>", "_")
    content = content.replace("</em>", "_")

    content = content.replace("<i>", "_")
    content = content.replace("</i>", "_")

    content = content.replace("<code>", "`")
    content = content.replace("</code>", "`")

    content = content.replace("<sup>", "^")
    content = content.replace("</sup>", "^")

    if content.count("<ul>") > 0:
        content = content.replace("<ul>", "")
        content = content.replace("</ul>", "")
        content = content.replace("	<li>", "* ")
        content = content.replace("</li>", "")
    if content.count("<ol>") > 0:
        content = content.replace("<ol>", "")
        content = content.replace("</ol>", "")
        content = content.replace("	<li>", ". ")
        content = content.replace("</li>", "")

    content = content.replace("<u>", "[.underline]#")
    content = content.replace("</u>", "#")

    content = content.replace("<small>", "[.small]#")
    content = content.replace("</small>", "#")

    content = content.replace("<br />", "\n\n")

    content = content.replace("&quot;", "\"")
    content = content.replace("&#39;", "'")
    content = content.replace("&gt;", ">")
    content = content.replace("&lt;", "<")
    content = content.replace("&nbsp;", " ")
    content = content.replace("&minus;", "-")
    content = content.replace("&ge;", "≥")
    content = content.replace("&le;", "≤")

    with open(filepath, 'rb') as fh:
        r=reversed(fh.readlines())
        last = next(r)

    f = open(filepath, "a+")
    if len(last) > 2 :
        f.write("\n\n")
    f.write(content)
    f.write("\n")
    f.close()
    print(filename, " OK…")
