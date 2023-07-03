// 백준 실버 1
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input-2504.txt";
const brackets = require("fs").readFileSync(filePath).toString().split("");



function solution(brackets) {
  const bracket2dArr = [];
  const openStack = [];
  const valMap = {'(': 2, '[': 3};
  let depth = 0;
  let bracket = "";

  for(let i = 0; i < brackets.length; i++) {
    bracket = brackets[i];
    depth = openStack.length;
    
    if(bracket === "(" || bracket === "[") {
      openStack.push(bracket);
      if(bracket2dArr[depth]) bracket2dArr[depth].push(valMap[bracket])
      else bracket2dArr[depth] = [valMap[bracket]];
    } else {
      let sum = 0;
      let value = openStack.pop();

      if(!validateInput(value, bracket)) return 0;
      let length = bracket2dArr[depth]?.length
      for(let j = 0; j < length || 0; j++) {
        sum += bracket2dArr[depth].pop();
      }
      
      if(sum > 0) {
        sum = bracket2dArr[depth - 1].pop() * sum;
        bracket2dArr[depth - 1].push(sum);
      }
    }
  }

  return openStack.length === 0 ? bracket2dArr[0].reduce((a, c) => a + c) : 0;
}

console.log(solution(brackets));

function validateInput(open, close) {
  const map = {')' : '(', ']': '['};
  let openTemp = open;
  return openTemp?.replace(map[close], "").length === 0;
}




