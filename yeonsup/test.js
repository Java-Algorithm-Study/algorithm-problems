const filePath = process.platform === "linux" ? "/dev/stdin" : "./input-2740.txt";
const stdin = require("fs").readFileSync(filePath).toString().split("\n");

console.log("Hello World");