# 将面试题按文档格式整理

grep -E '^\d' company/bytedance.adoc > /tmp/temp.file

while read line
do
  id=$(echo $line | awk -F'.' '{print $1}')
  pid=$(printf %04d $id)
  fileName=$(grep "$pid" docs/files.txt)
  echo ". {doc_base_url}/${fileName}[${line}]" >> company/bytedance.adoc
done < '/tmp/temp.file'
