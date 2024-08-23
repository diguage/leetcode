#!/usr/bin/env bash
#
# 在文件第一行增加锚点，在增加之前做判断，没有则增加。
#

for file in ../docs/*.adoc
do
  filename=$(basename -- "$file")
  # 文件名即锚点值
  filename="${filename%.*}"
  # https://stackoverflow.com/a/57158235
  if ! grep -q $filename "$file"; then
    # https://unix.stackexchange.com/a/99351
    gsed -i "1 i\[#${filename}]" $file

    echo $file
  fi
done

