# 从截图提取文字，然后转换成题目列表

for id in `cat /tmp/dp.txt | grep '#' | sed 's/[^0-9]//g'`; do
  pid=$(printf %04d $id)
  fileName=$(grep "$pid" docs/files.txt)
  title=$(cat docs/$fileName | sed -n '2p' | sed 's/..//')
#  echo $pid $title $fileName
  echo ". xref:${fileName}[${title}]"
done
