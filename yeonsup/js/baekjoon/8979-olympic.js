const filePath = process.platform === "linux" ? "/dev/stdin" : "./input-8979.txt";
const [question, ...arr] = require("fs").readFileSync(filePath).toString().split("\n");

function solution(question, arr) {
    let contries = []
    
    let q = question.split(" ").map(Number);
    arr.forEach(v => {
        let temp = v.split(" ").map(Number);
        let medals = [];
        for(let i = 0; i < temp.length-1; i++) {
            medals[i] = temp[i + 1];
        }

        contries[temp[0] - 1] = medals;
    });

    let rank = 1;
    let k = q[1] - 1;
    for(let i = 0; i < q[0]; i++) {
        if(i === k) continue;
        if(contries[k][0] < contries[i][0]) {
            rank++;
            continue;
        } else if(contries[k][0] === contries[i][0]) {
            if(contries[k][1] < contries[i][1]) {
                rank++;
                continue;
            } else if(contries[k][1] === contries[i][1]) {
                if(contries[k][2] < contries[i][2]) {
                    rank++;
                }
            }
        }

    }
    return rank;
}


console.log(solution(question, arr));