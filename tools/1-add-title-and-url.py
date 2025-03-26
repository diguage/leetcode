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
from datetime import datetime


def get_problems(json_data):
    # TODO 缺少异常判断
    jo = json.loads(json_data)
    problems = jo['stat_status_pairs']
    # https://stackoverflow.com/a/403426/951836
    sorted_problems = sorted(
        problems, key=lambda x: x["stat"]["frontend_question_id"], reverse=False)
    return sorted_problems

def get_data(url):
    r = requests.get(url)
    if r.status_code == 200:
        result = r.text
        f = open('./leetcode-%s.json'%(datetime.today().strftime('%Y%m%d')), 'w')
        f.write(result)
        f.close
        return result
    else:
        return None

URL_LEETCODE_PROBLEMS = 'https://leetcode.com/api/problems/all/'
json_problems = get_data(URL_LEETCODE_PROBLEMS)
problems = get_problems(json_problems)

for problem in problems:
    id = problem["stat"]["frontend_question_id"]

    title = "= %d. %s" %(id, problem["stat"]["question__title"])
    url = "https://leetcode.com/problems/%s/[LeetCode - %d. %s ^]" % (problem["stat"]["question__title_slug"], id, problem["stat"]["question__title"])
    filename = "%04d-%s.adoc"%(id, problem["stat"]["question__title_slug"])

    f = open("../docs/"+filename, "a")
    f.write("[#%04d-%s]\n"%(id, problem["stat"]["question__title_slug"]))
    f.write(title)
    f.write("\n\n")
    f.write(url)
    f.write("\n\n")
    f.close()
    print(filename, " OK…")
