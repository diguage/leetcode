import ujson as json

file_name = "leetcode.json"
json_file = open(file_name, 'r')
data = json.loads(json_file.read())
# print(data)
problems = data['stat_status_pairs']

for problem in problems:
    title = "== %d. %s" %(problem["stat"]["frontend_question_id"], problem["stat"]["question__title"]) 
    url = "https://leetcode.com/problems/%s/[LeetCode - %s]" % (problem["stat"]["question__title_slug"], problem["stat"]["question__title"])
    filename = "%04d-%s.adoc"%(problem["stat"]["frontend_question_id"], problem["stat"]["question__title_slug"])

    f = open("../docs/"+filename, "a")
    f.write(title)
    f.write("\n\n")
    f.write(url)
    f.write("\n\n")
    f.close()
    print(filename, " OK…")