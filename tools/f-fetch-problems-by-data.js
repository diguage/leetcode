var data = {}; // 从 https://leetcode.cn/studyplan/<*>/ 中找
var a = [];

data.data.studyPlanV2Detail.planSubGroups.forEach(e => {
    e.questions.forEach(ee => {
        a.push(". xref:" + String(ee.questionFrontendId).padStart(4, '0') + "-" + ee.titleSlug + ".adoc[" + ee.questionFrontendId + ". " + ee.title + "]");
    });
});

console.log(a.join("\n"));

var ps = {}; // 题目全集的 JSON
var b = [];
data.data.studyPlanV2Detail.planSubGroups.forEach(e => {
    e.questions.forEach(ee => {
        ps.stat_status_pairs.forEach(pe => {
            if (pe.stat['question__title_slug'] === ee.titleSlug) {
                var id = pe.stat['frontend_question_id'];
                b.push(". xref:" + String(id).padStart(4, '0') + "-" + ee.titleSlug + ".adoc[" + id + ". " + pe.stat['question__title'] + "]");
            }
        })
    });
});

console.log(b.join("\n"));
