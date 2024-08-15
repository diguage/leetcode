#!/usr/bin/env python
# -*- coding:utf-8 -*-
#
# grep source_base_url ../README.adoc | awk -F\| '{print $2}' | awk -F/ '{print $2}' | awk -F\[ '{print $1}' | tee -a sourcs.txt
#

import os, re
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

idToFile = {}
for f in os.listdir('../docs/'):
    if f.endswith('.adoc'):
        idToFile[f[0:4]] = "../docs/"+f

def get_problems():
    jo = json.loads(open("leetcode.json", 'r').read())
    problems = jo['stat_status_pairs']
    # https://stackoverflow.com/a/403426/951836
    sorted_problems = sorted(
        problems, key=lambda x: x["stat"]["frontend_question_id"], reverse=False)
    return sorted_problems

problem_list = get_problems()

for problem in problem_list:
    level = problem["difficulty"]["level"]
    id = problem["stat"]["frontend_question_id"]
    titleSlug = problem["stat"]["question__title_slug"]
    title = problem["stat"]["question__title"]
    filename = "%04d-%s.adoc"%(problem["stat"]["frontend_question_id"], titleSlug)

    if id < 3216:
        continue

    javaFile = "_%04d_%s.java" % (id, ''.join(filter(str.isalnum, title.title())))
    javaFile2 = "_%04d_%s_2.java" % (id, ''.join(filter(str.isalnum, title.title())))

    # 1、向 README.adoc 增加链接
    with open('../README.adoc', 'a') as f:
        f.write("\n")
        f.write("//|{counter:codes}\n")
        f.write("//|{leetcode_base_url}/%s/[%d. %s]\n"%(titleSlug, id, title))
        f.write("//|{source_base_url}/%s[Java]\n"%(javaFile))
        f.write("//|{doc_base_url}/%s[题解]\n"%(filename))
        levelString = 'Easy' if level==1 else ('Medium' if level==2 else 'Hard')
        f.write("//|%s\n"%(levelString))
        f.write("//|\n")

    # 2、向文件中增加相关模板内容
    f = open(idToFile["%4d"%(id)], "a")
    f.write("\n\n")
    f.write("== 思路分析\n")
    f.write("\n\n")
    f.write('[[src-%s]]\n'%(id))
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
    print(idToFile["%4d"%(id)], " OK…")
