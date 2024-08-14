#!/usr/bin/env python3
#
# grep source_base_url ../README.adoc | awk -F\| '{print $2}' | awk -F/ '{print $2}' | awk -F\[ '{print $1}' | tee -a sourcs.txt
#

import os, re

idToFile = {}
for f in os.listdir('../docs/'):
    if f.endswith('.adoc'):
        idToFile[f[0:4]] = "../docs/"+f

with open('./sourcs.txt', 'rb') as fh:
    for nb in fh.readlines():
        name = nb.decode("utf-8").strip()
        id = name[1:5]

#         if int(id) > 5:
#             break

        f = open(idToFile[id], "a")

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
        f.write('include::{sourcedir}/%s[]\n'%(name))
        f.write('----\n')
        f.write('--\n')
        f.write('====\n')
        f.write("\n\n")
        f.write("== 参考资料\n")
        f.write("\n\n")
        f.close()
        print(name, " OK…")
