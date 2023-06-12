const filePath = process.platform === "linux" ? "/dev/stdin" : "./input-1662.txt";
const [size, ...room] = require("fs").readFileSync(filePath).toString().split("\n");

function solution(size, room) {
    let result = [];
    let n = 0;
    room = room.map(v => v.split(""));
    for(let i = 0; i < size; i++) {
        let line = room[i];
        let p = 0;
        
        for(let j = 0; j < size; j++) {
            if(line[j] === '.') p++;
            if( j === size - 1 || line[j+1] === "X" ) {
                if( p >= 2 ) n++;
                p = 0;
            }
        }
    }

    result.push(n);

    n = 0;
    for(let i = 0; i < size; i++) {
        let p = 0;
        for(let j = 0; j < size; j++) {
            if(room[j][i] === '.') p++;
            if( j === size - 1 || room[j+1][i] === "X" ) {
                if( p >= 2 ) n++;
                p = 0;
            }
        }
    }
    result.push(n);
    return result.join(" ");
}


console.log(solution(size, room));