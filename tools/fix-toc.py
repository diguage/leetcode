#!/usr/bin/env python3

import glob
import re
from bs4 import BeautifulSoup

# 读取文件列表，建立从编号到文件的Map
basePath = ".."

htmlFiles = glob.glob(basePath + "/*.html")

idToHtmlMap = {}
baseLen = len(basePath)
for f in htmlFiles:
    id = f[0:-5]
    if f.startswith(basePath + "/0") or f.startswith(basePath + "/1"):
        id = int(f[baseLen + 1:baseLen + 5])
    idToHtmlMap[id] = f[baseLen + 1:]
print("get file list.")

# 读取 index.html 中目录内容。

indexHtml = basePath + "/index.html"
indexFile = open(indexHtml, "r")
soup = BeautifulSoup(indexFile.read(), 'html.parser')
indexFile.close()

# 修改内容，主要是修改链接地址
headerTag = soup.find(id="header")

tocTag = headerTag.find(id="toc")

for link in tocTag.select('ul.sectlevel1 > li > a'):
    id = link["href"][2:]
    if id.startswith(tuple('0123456789')) and ('_' in id):
        id = int(re.findall(r'(\d+)_', id)[0])
    if id in idToHtmlMap:
        link["href"] = idToHtmlMap[id]
print("change links.")

indexFile = open(indexHtml, "w", encoding='utf8')
indexFile.write(str(soup))
indexFile.close()
print("change index.html.")

# 将修改后的目录内容写入到各个文件中
for f in htmlFiles:
    file = open(f, "r")
    soup = BeautifulSoup(file.read(), 'html.parser')
    file.close()

    subHeaderTag = soup.find(id="header")
    indexOfHeader = subHeaderTag.parent.index(subHeaderTag)
    parent = subHeaderTag.parent
    subHeaderTag.decompose()

    parent.insert(indexOfHeader, headerTag)

    file = open(f, "w", encoding='utf8')
    file.write(str(soup))
    file.close()
    print("change ", f)
print("change all files.")

# 替换掉 index.html 的内容
file = open(indexHtml, "w", encoding='utf8')
origin = open(basePath + "/0001-two-sum.html", "r", encoding='utf8')
file.write(origin.read())
origin.close()
file.close()
print("change index.html files.")
