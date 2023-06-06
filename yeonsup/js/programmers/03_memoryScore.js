function solution(name, yearning, photo) {
    const score = {};
    yearning.forEach((v, i) => { score[name[i]] = v});

    let result = photo.map(v => {
        let sum = 0;
        v.forEach(v => {
            
            sum += score[v] ? score[v] : 0;
        })
        return sum;
    });

    return result;
}


console.log(solution(["may", "kein", "kain", "radi"]
                    , [5, 10, 1, 3]
                    , [["may", "kein", "kain", "radi"],["may", "kein", "brin", "deny"], ["kon", "kain", "may", "coni"]]));