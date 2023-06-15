function solution(participant, completion) {
    let result = [];
    let map = {};
    participant.forEach(v => {
        map[v] = map[v]++ ? map[v]++ : 1;
    });
    

    completion.forEach(v => {
        if(map[v]) {
            map[v]--;
        }
    });
    
    for(let name in map) {
        if(map[name]) {
            for(let i = 0; i < map[name]; i++) {
                result.push(name);
            }
        }
    }
    
    return result.join("");
}


console.log(solution(["leo", "kiki", "eden"],["eden", "kiki"]));
console.log(solution(["mislav", "stanko", "mislav", "ana"],["stanko", "ana", "mislav"]));