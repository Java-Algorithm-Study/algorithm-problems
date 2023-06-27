function solution(babbling) {
    let babyWord = ["aya", "woo", "ye", "ma"];
    
    return babbling.reduce((a , bab) => {
        let preWord;
        for(let i = 0; i < babyWord.length; i++) {
            
            if(bab.includes(babyWord[i]) && babyWord[i] !== preWord && bab[0] === babyWord[i][0]) {
                preWord = babyWord[i];
                bab = bab.replace(preWord, "");
                i = -1;
            }
        }
        return bab.length === 0 ? ++a : a;
    }, 0);
}

console.log(solution(["aya", "yee", "u", "maa"]));
console.log(solution(["ayaye", "uuu", "yeayaye", "yemawoo", "ayaayaa", "woowo", "yeayaye"]));

/* 다른 사람이 정규식으로 푼 문제 */
function solution(babbling) {
  const regexp1 = /(aya|ye|woo|ma)\1+/;
  const regexp2 = /^(aya|ye|woo|ma)+$/;

  return babbling.reduce((ans, word) => {
        console.log('%s, %s %s', word, !regexp1.test(word), regexp2.test(word));
        return !regexp1.test(word) && regexp2.test(word) ? ++ans : ans
    }
  , 0);
}

console.log(solution(["aya", "yee", "u", "maa"]));
console.log(solution(["ayaye", "uuu", "yeayaye", "yemawoo", "ayaayaa", "woowo", "yeayaye"])); 