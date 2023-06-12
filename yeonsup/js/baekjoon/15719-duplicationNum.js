const filePath = process.platform === "linux" ? "/dev/stdin" : "./input-15719.txt";
const [size, input] = require("fs").readFileSync(filePath).toString().split("\n");

function solution(size, input) {
    let A = 0n, B = 0n;
    input = input.split(" ");
    for(let i = 1; i <= size; i++) {
        if(i < size) {
            A += BigInt(i);
        }
        // console.log(input[i]);
        B = B + BigInt(input[i-1]);
    }
    // B = input.split(" ").reduce((a, c) => {
    //     A += i++;
    //     return a = BigInt(a) + BigInt(c);
    // }, 0);

    return Number(B - A);
}

console.log(solution(size, input));