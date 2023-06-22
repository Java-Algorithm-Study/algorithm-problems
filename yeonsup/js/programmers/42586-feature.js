function solution(progresses, speeds) {
  let answer = [1];
  let days = progresses.map((v,i) => Math.ceil((100 - Number(v)) / speeds[i]));
  let prog = days.shift();
  let i = 0;
  while(days.length > 0) {
    console.log(`${days.length}`)
    if(days[0] <= prog) {
      days.shift();
      answer[i] += 1;
    } else {
      prog = days[0];
      answer[++i] = 0;
    }
  }
  return answer;
}


console.log(solution([93, 30, 55], [1, 30, 5]));
console.log(solution([95, 90, 99, 99, 80, 99], [1, 1, 1, 1, 1, 1]));

