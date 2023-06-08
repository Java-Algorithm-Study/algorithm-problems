const filePath = process.platform === "linux" ? "/dev/stdin" : "./input-1181.txt";
const [size, ...input] = require("fs").readFileSync(filePath).toString().split("\n");

function solution(size, input) {
    let words = Array.of(...new Set(input)).flat();
    words.sort((a, b) => {
        if(a.length < b.length) {
            return -1;
        } else if (a.length === b.length) {
            if(a.toUpperCase() < b.toUpperCase()) {
                return -1;
            } else {
                return 1;
            }
        } else {
            return 0;
        }
    });

    return words.join("\n");
}

console.log(solution(size, input));