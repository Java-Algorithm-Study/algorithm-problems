function solution(id_list, report, k) {
    var answer = [];
    let reportCntArr = [];
    let reportUserId = {};
    let reports = [...new Set(report)].map(a => {return a.split(' ')});

    reports.forEach(v => {
        let [report, reported] = v;
        reportCntArr[id_list.indexOf(reported)] = reportCntArr[id_list.indexOf(reported)] + 1 || 1;
    });

    for(const report of reports) {
        if(reportCntArr[id_list.indexOf(report[1])] >= k) {
            answer[id_list.indexOf(report[0])] = answer[id_list.indexOf(report[0])] + 1 || 1; 
        }
    }
    
    return id_list.map((v, i) => answer[i]??0);
}

console.log(solution(["con", "ryan"],["ryan con", "ryan con", "ryan con", "ryan con"], 3));
console.log(solution(["muzi", "frodo", "apeach", "neo"],["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"], 2));
