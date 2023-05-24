function solution(park, routes) {
    var answer = [];
    const xMax = park.length;
    const yMax = park[0].length;
    let x = 0;
    park = park.map(v => {
        let index = v.indexOf("S", 0);
        if(index >= 0) {
            answer = [x, index];
        }
        x++;
        return v.split("");
    });
    routes.forEach(v => {
        let path = v.split(" ");
        let direction = path[0];
        let distance = parseInt(path[1]);
        let x = parseInt(answer[0]);
        let y = parseInt(answer[1]);
        
        if(direction === "N") {
            if((x - distance) < 0) return;
            else {
                let temp = x;
                while(distance--) {
                    temp--;
                    if(isX(park[temp][y])) {
                        answer = [x, y];
                        break;
                    } else {
                        answer = [temp, y];
                    }
                }
            }
        } else if(direction === "S") {1
            if((x + distance) >= xMax) return;
            else {
                let temp = x;
                while(distance--) {
                    temp++;
                    if(isX(park[temp][y])) {
                        answer = [x, y];
                        break;
                    } else {
                        answer = [temp, y];
                    }
                }
            }
        } else if(direction === "W") {
            if((y - distance) < 0) return;
            else {
                let temp = y;
                while(distance--) {
                    temp--;
                    if(isX(park[x][temp])) {
                        answer = [x, y];
                        break;
                    } else {
                        answer = [x, temp];
                    }
                }
            }
        } else if(direction === "E") {
            if((y + distance) >= yMax) return;
            else {
                let temp = y;
                while(distance--) {
                    temp++;
                    if(isX(park[x][temp])) {
                        answer = [x, y];
                        break;
                    } else {
                        answer = [x, temp];
                    }
                }
            }
        }
    });
    return answer;
}

function isX(park) {
    return park === "X";
}

// const answer = solution(["SOO","OOO","OOO"], ["E 3","S 2","E 1"]);

// console.log("answer : %s", answer.join(" "));
// console.log("result : %s", [2,1]);

// console.log(solution(["SOXOO","OOOOO","OOOOO", "OOOOO", "OOOOO"], ["E 3"])); // [0, 0]
// console.log(solution(["SOOOX","OOOOO","OOOOO", "OOOOO", "OOOOO"], ["E 3"])); // [0, 3]
// console.log(solution(["XOOOS","OOOOO","OOOOO", "OOOOO", "OOOOO"], ["W 3"])); // [0, 1]
// console.log(solution(["OOXOS","OOOOO","OOOOO", "OOOOO", "OOOOO"], ["W 3"])); // [0, 4]
// console.log(solution(["SOOOO","OOOOO","XOOOO", "OOOOO", "OOOOO"], ["S 3"])); // [0, 0]
// console.log(solution(["SOOOO","OOOOO","OOOOO", "OOOOO", "XOOOO"], ["S 3"])); // [3, 0]
// console.log(solution(["OOOOO","OOOOO","XOOOO", "OOOOO", "SOOOO"], ["N 3"])); // [4, 0]
// console.log(solution(["XOOOO","OOOOO","OOOOO", "OOOOO", "SOOOO"], ["N 3"])); // [1, 0]
// console.log(solution(["SOXO", "OOOO", "OOOO"], ["E 1", "S 1", "E 2"])); // [1, 3]
console.log(solution(["OXXO", "XSXO", "XXXX"], ["E 1", "S 1"])); // [1, 1]