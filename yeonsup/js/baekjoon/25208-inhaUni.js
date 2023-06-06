const filePath = process.platform === "linux" ? "/dev/stdin" : "./input-25208.txt";
const [...subjects] = require("fs").readFileSync(filePath).toString().split("\n");
const JumsooTable = {
    "A+":	4.5,
    "A0":	4.0,
    "B+":	3.5,
    "B0":	3.0,
    "C+":	2.5,
    "C0":	2.0,
    "D+":	1.5,
    "D0":	1.0,
    "F":    0.0
}

function solution(JumsooTable, subjects) {
    let sum = 0;
    let creditSum = 0;
    subjects.forEach(v => {
        let [name, credit, jumsoo] = v.split(" ");
        if(jumsoo !== "P") {            
            sum += (JumsooTable[jumsoo] * Number(credit));
            creditSum += Number(credit);
        }
    });
    return Number(sum / creditSum).toFixed(6);
}

console.log(solution(JumsooTable, subjects));
