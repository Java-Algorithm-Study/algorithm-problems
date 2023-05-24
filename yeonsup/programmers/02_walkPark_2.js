function solution(park, routes) {
    const n = park.length, m = park[0].length;
    const map = park.map(v => [...v])
    const direction = {'E': [0, 1], 'W': [0, -1], 'S': [1, 0], 'N': [-1, 0]};
    let i = map.findIndex(v => v.includes('S'));
    let j = map[i].findIndex(v => v === 'S');
    
    routes.forEach(path => {
        let [dir, dis] = path.split(' ');
        let x = i, y = j;
        
        for(let k = 0; k < Number(dis); k++) {
            x += direction[dir][0];
            y += direction[dir][1];

            if(x < 0 || y <0 || x >= n || y >= m || map[x][y] === 'X') {
                   return;
            }
        }
        i = x;
        j = y;
    }); 
    return [i, j];
}

// console.log(solution(["SOXOO","OOOOO","OOOOO", "OOOOO", "OOOOO"], ["E 3"])); // [0, 0]
// console.log(solution(["SOOOX","OOOOO","OOOOO", "OOOOO", "OOOOO"], ["E 3"])); // [0, 3]
// console.log(solution(["XOOOS","OOOOO","OOOOO", "OOOOO", "OOOOO"], ["W 3"])); // [0, 1]
// console.log(solution(["OOXOS","OOOOO","OOOOO", "OOOOO", "OOOOO"], ["W 3"])); // [0, 4]
// console.log(solution(["SOOOO","OOOOO","XOOOO", "OOOOO", "OOOOO"], ["S 3"])); // [0, 0]
// console.log(solution(["SOOOO","OOOOO","OOOOO", "OOOOO", "XOOOO"], ["S 3"])); // [3, 0]
console.log(solution(["OOOOO","OOOOO","XOOOO", "OOOOO", "SOOOO"], ["N 3"])); // [4, 0]
console.log(solution(["XOOOO","OOOOO","OOOOO", "OOOOO", "SOOOO"], ["N 3"])); // [1, 0]
// console.log(solution(["SOXO", "OOOO", "OOOO"], ["E 1", "S 1", "E 2"])); // [1, 3]
// console.log(solution(["OXXO", "XSXO", "XXXX"], ["E 1", "S 1"])); // [1, 1]