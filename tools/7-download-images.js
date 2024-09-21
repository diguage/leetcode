a = [];
document.querySelectorAll('div.w-full > div.break-words > div > div > div > div > img').forEach(e => a.push(e.src));
console.log("count=0\nfor f in '" + a.join("'  '") + "'\ndo\n  ((count = count + 1))\n  cnt=$(printf \"%02d\" count)\n  wget $f -O \"-$cnt.png\"\ndone");

// 从 LeetCode 下载图片
// https://stackoverflow.com/a/14306442/951836 -- wget 重命名
// https://stackoverflow.com/a/59817835/951836 -- 自增数字
// https://stackoverflow.com/a/18460742/951836 -- 格式化

