const filePath = process.platform === "linux" ? "/dev/stdin" : "./input-8979.txt";
const [n, ...arr] = require("fs").readFileSync(filePath).toString().split("\n");

