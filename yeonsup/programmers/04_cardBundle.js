function solution(card1, card2, goal) {
    let sentence = goal.map(word => card1.includes(word) ? card1.shift() : card2.includes(word) ? card2.shift() : "");
    return goal.join("") === sentence.join("") ? "YES" : "NO";
}


console.log(solution(["i", "drink", "water"], ["want", "to"], ["i", "want", "to", "drink", "water"]));
console.log(solution(["i", "water", "drink"], ["want", "to"], ["i", "want", "to", "drink", "water"]));
console.log(solution(["i", "drink", "water"], ["to", "want"], ["i", "want", "to", "drink", "water"]));
