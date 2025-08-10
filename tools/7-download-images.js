a = [];
document.querySelectorAll('div.h-full.w-full > div  div > div.w-full > div.break-words > div > div  img').forEach(e => a.push(e.src));
console.error("count=9\nfor f in '" + a.join("'  '") + "'\ndo\n  ((count = count + 1))\n  cnt=$(printf \"%02d\" count)\n  wget $f -O \"-$cnt.png\"\ndone");

// 从 LeetCode 下载图片
// https://stackoverflow.com/a/14306442/951836 -- wget 重命名
// https://stackoverflow.com/a/59817835/951836 -- 自增数字
// https://stackoverflow.com/a/18460742/951836 -- 格式化


count=9
for f in 'https://pic.leetcode-cn.com/1605507691-cNsBDz-image.png'  'https://pic.leetcode-cn.com/1605507724-thDrQv-image.png'  'https://pic.leetcode-cn.com/1605507782-rqZJRC-image.png'  'https://pic.leetcode-cn.com/1605507804-PibNnX-image.png'  'https://pic.leetcode-cn.com/1605507828-objPeT-image.png'  'https://pic.leetcode-cn.com/1605507852-WCTcSX-image.png'  'https://pic.leetcode-cn.com/1605507876-njskmi-image.png'  'https://pic.leetcode-cn.com/1605507921-DhmGDp-image.png'  'https://pic.leetcode-cn.com/1605507946-UraHvN-image.png'
do
    ((count = count + 1))
    cnt=$(printf "%02d" count)
wget $f -O "-$cnt.png"
done
