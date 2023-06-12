const filePath = process.platform === "linux" ? "/dev/stdin" : "./input-1769.txt";
const [x] = require("fs").readFileSync(filePath).toString().split("\n");

function solution (x) {
    let y = x;
    let num = 0;
    
    while(y >= 10) {    
        y = y.split("").reduce((a, c) => a += Number(c), 0).toString();
        num++;
    } 
    
    return [num, y % 3 === 0 ? "YES" : "NO"].join("\n");
}

console.log(solution(x));