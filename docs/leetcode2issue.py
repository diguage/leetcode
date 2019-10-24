#!/usr/local/bin/python3

import os
import ujson as json
import requests
import pprint
import time
import random
import time

# The repository to add this issue to
# REPO_OWNER = 'mntfun'
REPO_OWNER = 'diguage'
REPO_NAME = 'leetcode'


# curl -i -H "Authorization: token $GITHUB_API_TOKEN" https://api.github.com/user

# {
# "stat": {
#     "question_id": 952,
#     "question__article__live": true,
#     "question__article__slug": "word-subsets",
#     "question__title": "Word Subsets",
#     "question__title_slug": "word-subsets",
#     "question__hide": false,
#     "total_acs": 3128,
#     "total_submitted": 7398,
#     "frontend_question_id": 916,
#     "is_new_question": true
# },
# "status": null,
# "difficulty": {
#     "level": 2
# },
# "paid_only": false,
# "is_favor": false,
# "frequency": 0,
# "progress": 0
# },


class Problem:

    def __init__(self, data):
        stat = data.get('stat', {})
        self.id = int(stat.get('frontend_question_id', 0))
        self.title = stat.get('question__title', "Null")
        self.slug = stat.get('question__title_slug', "null")
        diff = data.get('difficulty', {})
        self.level = diff.get('level', 3)
        if (self.level == 1):
            self.difficulty = "Easy"
        elif (self.level == 2):
            self.difficulty = "Medium"
        else:
            self.difficulty = "Hard"
        self.topics = []
        self.companies = []


# TODO 加载问题列表
# https://leetcode.com/api/problems/all/
# f = open('leetcode.json', 'r')


def headers():
    headers = {
        "Accept": "application/vnd.github.symmetra-preview+json",
        "Authorization": ("token %s" % os.environ['GITHUB_API_TOKEN'])
    }
    return headers


def get_data(url, headers=headers()):
    print(headers)
    r = requests.get(url, headers)
    return r.text


def post_data(url, data):
    return requests.post(url, data, headers=headers())


def patch_data(url, data):
    return requests.patch(url, data, headers=headers())


def get_tags():
    # https://leetcode.com/problems/api/tags/
    file_name = "leetcode-tags.json"
    json_file = open(file_name, 'r')
    data = json.loads(json_file.read())
    result = {}
    for topic in data['topics']:
        name = topic['name']
        for q in topic['questions']:
            id = int(q)
            question = result.get(id, {})
            qts = question.get('topics', [])
            qts.append(name)
            question['topics'] = qts
            result[id] = question

    for topic in data['companies']:
        name = topic['name']
        for q in topic['questions']:
            id = int(q)
            question = result.get(id, {})
            qts = question.get('companies', [])
            qts.append(name)
            question['companies'] = qts
            result[id] = question
    return result

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


def get_problems(json_data):
    jo = json.loads(json_data)
    problems = jo['stat_status_pairs']
    # https://stackoverflow.com/a/403426/951836
    sorted_problems = sorted(
        problems, key=lambda x: x["stat"]["frontend_question_id"], reverse=False)
    return sorted_problems


def make_github_issue(p):
    '''Create an issue on github.com using the given parameters.
      # Copy from https://gist.github.com/JeffPaine/3145490#gistcomment-1856436
      # https://developer.github.com/v3/issues/#create-an-issue
    '''
    # Our url to create issues via POST
    url = 'https://api.github.com/repos/%s/%s/issues' % (REPO_OWNER, REPO_NAME)
    # Create our issue
    # 11. Container With Most Water
    # [Container With Most Water - LeetCode](https://leetcode.com/problems/container-with-most-water/description/)
    labels = list(map(lambda x: "Topic:%s" % x, p.topics))
    labels += list(map(lambda x: "Company:%s" % x, p.companies))
    labels.append("Difficulty:%s" % p.difficulty)
    issue = {'title': "%d. %s" % (p.id, p.title),
             'body': "[%s - LeetCode](https://leetcode.com/problems/%s/description/)" % (p.title, p.slug),
             'labels': labels}
    # Add the issue to our repository
    time.sleep(random.randint(1, 10))
    response = post_data(url, json.dumps(issue))
    if response.status_code == 201:
        result = json.loads(response.text)
        number = int(result['number'])
        print("id:", p.id, ",  number:", number, "success")
        return number
    else:
        print('%d %s error' % (p.id, p.title))
        print('Response:', response.content)
        exit


def update_github_issue(p):
    '''Create an issue on github.com using the given parameters.
      # Copy from https://gist.github.com/JeffPaine/3145490#gistcomment-1856436
      # https://developer.github.com/v3/issues/#create-an-issue
    '''
    # Our url to create issues via POST
    url = 'https://api.github.com/repos/%s/%s/issues/%d' % (
        REPO_OWNER, REPO_NAME, p.id)
    # Create our issue
    # 11. Container With Most Water
    # [Container With Most Water - LeetCode](https://leetcode.com/problems/container-with-most-water/description/)
    labels = list(map(lambda x: "Topic:%s" % x, p.topics))
    labels += list(map(lambda x: "Company:%s" % x, p.companies))
    labels.append("Difficulty:%s" % p.difficulty)
    issue = {'title': "%d. %s" % (p.id, p.title),
             'body': "[%s - LeetCode](https://leetcode.com/problems/%s/description/)" % (p.title, p.slug),
             'labels': labels}
    # Add the issue to our repository
    time.sleep(random.randint(1, 10))
    response = patch_data(url, json.dumps(issue))
    if response.status_code == 200:
        result = json.loads(response.text)
        number = int(result['number'])
        print('%d. %s update success' % (p.id, p.title))
        # return number
    else:
        print('%d %s error' % (p.id, p.title))
        print('Response:', response.content)
        exit


def get_next_id():
    url_issues = "https://api.github.com/repos/%s/%s/issues" % (
        REPO_OWNER, REPO_NAME)
    issues_json = get_data(url_issues)
    issues = json.loads(issues_json)
    last_id = max(int(node['number']) for node in issues)
    return last_id + 1


# 加载问题
URL_LEETCODE_PROBLEMS = 'https://leetcode.com/api/problems/all/'
json_problems = get_data(URL_LEETCODE_PROBLEMS)
problem_list = get_problems(json_problems)
problems = list(map(lambda x: Problem(x), problem_list))
tags = get_tags()
id_to_problem = {}
max_id = 0
for p in problems:
    id = p.id
    if id > max_id:
        max_id = id
    tag = tags.get(id, {})
    p.topics = tag.get('topics', [])
    p.companies = tag.get('companies', [])
    id_to_problem[p.id] = p


# list issue, 然后找出最大的。
next_id = get_next_id()

print("next_id", next_id)
print("max_id", max_id)

success_id = next_id
for i in range(next_id, max_id+1):
    EMPTY = Problem({})
    EMPTY.title = "Empty"
    EMPTY.topics.append("Empty")
    p = id_to_problem.get(success_id, EMPTY)
    if p is EMPTY:
        p.id = i
        print(p.id, "is empty!")
    if(i < next_id+(max_id-next_id+1)):
        success_id = make_github_issue(p)
        success_id += 1

# for i in range(1, 7):
#     EMPTY = Problem({})
#     EMPTY.title = "Empty"
#     EMPTY.topics.append("Empty")
#     p = id_to_problem.get(i, EMPTY)
#     if p is EMPTY:
#         p.id = i
#         print(p.id, "is empty!")
#     update_github_issue(p)
