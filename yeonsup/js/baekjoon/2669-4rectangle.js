const filePath = process.platform === "linux" ? "/dev/stdin" : "./input-2669.txt";
const [...arr] = require("fs").readFileSync(filePath).toString().split("\n");

function solution(arr) {
    let rectangleArr = arr.map(v => {
        let [x, y, n, m] = v.split(" ").map(Number);

        
        return {x, y, n ,m};
    });
    let sum = 0;
    for(let i = 1; i <= 100; i++) {
        for(let j = 1; j <= 100; j++) {
            for(const v of rectangleArr) {
                if(i >= v.x && i < v.n && j >= v.y && j < v.m) {
                    sum++;
                    break;
                }
            }
        }
    }

    return sum;
}



console.log(solution(arr));

