function solution(N, sequence) {
  return sequence.reduce((a, v, i) => {
    return a + Math.min(Math.abs(v - (sequence[i - 1] || 1)), N - Math.abs((sequence[i - 1] || 1) - v));
  }, 0);
}
console.log('answer : '+ solution(5, [1,2,3,4,5]));
console.log('answer : '+ solution(5, [3,5,4,1,2]));
console.log('answer : '+ solution(10, [1,10,9,2,3,5,4,7,8]));
