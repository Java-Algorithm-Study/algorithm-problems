
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input-1343.txt";
const [board] = require("fs").readFileSync(filePath).toString().split("\n");


function solution(board) {
    const polyomino = ['AAAA', 'BB'];
    const asize = polyomino[0].length;
    const bsize = polyomino[1].length;
    if(board.replaceAll(".", "").length % 2 != 0) return -1;
    let result = [];
    for (const v of board.split(".")) {
        let translating = "";
        let vsize = v.length;
        if(v.length % 2 != 0) return -1;

        for (const p of polyomino) {
            let quotient = Math.trunc(vsize / p.length);
            vsize = vsize % p.length;
            if(quotient > 0) {
                for(let i = 0; i < quotient; i++) {
                    translating += p;
                }
            }
            if(vsize === 0) break;

        }
        result.push(translating);
    }

    return result.join(".");
}

console.log(solution(board));