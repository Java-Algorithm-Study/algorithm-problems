function solution(name, yearning, photo) {
    let result = photo.map(v =>
        v.reduce(
            (c, v) => c += yearning[name.indexOf(v)] ?? 0, 0
        )
    )
    return result;
}

["a", "a"].indexOf()
console.log(solution(["may", "kein", "kain", "radi"]
                    , [5, 10, 1, 3]
                    , [["may", "kein", "kain", "radi"],["may", "kein", "brin", "deny"], ["kon", "kain", "may", "coni"]]));