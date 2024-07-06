#!/usr/bin/env bash
#
# 选取代码块
#

# 给 Java 代码增加起始 tag
sed -i 's/\(^public *class.*{\)/\1\n  \/\/ tag::answer[]/g' *.java

# 给含有 main 方法的代码增加结束 tag
sed -i 's/\(.*public static void main\)/  \/\/ end::answer[]\n\n\n\1/g'  *.java

# 给不含 main 方法的代码增加结束 tag
for file in *.java
do
  # 不含 main 方法则增加
  if ! grep -q 'public static void main' "$file"; then
    sed -i 's/^}/  \/\/ end::answer[]\n}/g' $file
  fi
done

# 给 AsciiDoc 文档增加代码选取 tag
sed -i 's/\.java\[\]/\.java\[tag=answer\]/g' *.adoc
