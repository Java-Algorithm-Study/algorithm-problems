
function solution(players, callings) {
    let map = {};
    players.forEach((v, i) => {
        map[v] = i;
    });

    callings.forEach(c => {
        let frontPlayer = players[map[c] - 1];
        swap(players, map[c], map[c] - 1);
        map[c] -= 1;
        map[frontPlayer] += 1;  
    });
    
    return players;
}

function swap(arr, anum, bnum) {
    let temp = arr[bnum];
    arr[bnum] = arr[anum];
    arr[anum] = temp;
}

let result = solution(["mumu", "soe", "poe", "kai", "mine"], ["kai", "kai", "mine", "mine"]);

console.log("Result : %s", result.join(" "));
console.log("answer : %s", ["mumu", "kai", "mine", "soe", "poe"].join(" "));
