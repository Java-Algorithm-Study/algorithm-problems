function solution(keymap, targets) {
    let map = {};
    keymap.forEach(v=> {
        v.split("").forEach((v, i) => {
            if((i + 1) < (map[v] ?? 102)) map[v] = i + 1;
        });
    }); 
    return targets.map(v => {
        let sum = v.split("").reduce((a, c) => a += map[c] , 0);
        return sum || -1;
    });
}


console.log(solution(["ABACD", "BCEFD"], ["ABCD","AABB"]));
console.log(solution(["AAC"], ["BAACA"]));
console.log(solution(["AGZ", "BSSS"], ["ASA","BGZ"]));