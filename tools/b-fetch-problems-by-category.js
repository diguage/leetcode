// 中国站
items = document.querySelectorAll('div.absolute.left-0.top-0.h-full.w-full > div > a.group');
array = [];
items.forEach(a => {
    var title = a.querySelector('div.ellipsis.line-clamp-1').innerHTML;
    var href = a.href;
    href = href.substring(0, href.indexOf('?'));
    var slug = href.substring(href.lastIndexOf('problems/') + 9, href.lastIndexOf('/'));
    var id = title.substring(0, title.indexOf('.'));
    var fid = id.padStart(4, '0');
    let xref = '. xref:' + fid + '-' + slug + '.adoc[' + title + ']';
    console.log(xref);
    array.push(xref);
});

console.log(array.join("\n"));
