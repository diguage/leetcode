#!/usr/bin/env python

import ujson as json

file_name = "leetcode.json"
json_file = open(file_name, 'r')
data = json.loads(json_file.read())
# print(data)
problems = data['stat_status_pairs']

for problem in problems:
    id = problem["stat"]["frontend_question_id"]

    if id < 3215:
        continue

    title = "= %d. %s" %(id, problem["stat"]["question__title"])
    url = "https://leetcode.com/problems/%s/[LeetCode - %d. %s ^]" % (problem["stat"]["question__title_slug"], id, problem["stat"]["question__title"])
    filename = "%04d-%s.adoc"%(problem["stat"]["frontend_question_id"], problem["stat"]["question__title_slug"])

    f = open("../docs/"+filename, "a")
    f.write("[#%04d-%s]"%(problem["stat"]["frontend_question_id"], problem["stat"]["question__title_slug"]))
    f.write(title)
    f.write("\n\n")
    f.write(url)
    f.write("\n\n")
    f.close()
    print(filename, " OK…")
