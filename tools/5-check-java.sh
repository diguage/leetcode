#!/usr/bin/env bash
#
# 检查代码是否被正确引用
#

# 检查代码文件是否都被 include 到了 adoc 文件中
declare -a files=(`find ../src/main/java/com/diguage/algo/leetcode -name "*.java" | awk -F"/" '{print $NF}' | sort`)
for f in "${files[@]}"
do
  # https://stackoverflow.com/a/428580
  idx=${f:1:4}
#  find the adoc
  if ! grep -q $f ../docs/${idx}-*.adoc; then
    echo "$f"
  fi
done

# 检查 README 文件中引用的 Java 文件是否存在
echo "start to check README"
declare -a rfs=(`grep "{source_base_url}" ../README.adoc | grep -v "//" | awk -F'/' '{print $NF}' | awk -F'[' '{print $1}' | sort`)
for f in "${rfs[@]}"
do
  # https://stackoverflow.com/a/638980
  if [ ! -f ../src/main/java/com/diguage/algo/leetcode/${f} ]; then
      echo "${f} not found!"
  fi
done
