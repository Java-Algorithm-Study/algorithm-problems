const filePath = process.platform === "linux" ? "/dev/stdin" : "./input-1417.txt";
const [n, ...candidates] = require("fs").readFileSync(filePath).toString().split("\n").map(Number);
const MAX_SIZE = 10000;

// 최대 힙 우선순위 큐

class PriorityQueue {
    constructor() {
        this.heap = new Array(MAX_SIZE);
        this.count = 0;
    }

    swap(a, b) {
        let temp = this.heap[a];
        this.heap[a] = this.heap[b];
        this.heap[b] = temp;
    }
    

    push(data) {
        if(this.count >= MAX_SIZE) return;
        this.heap[this.count] = data;
        let now = this.count;
        let parent = (this.count - 1) / 2;
        while(now > 0 && this.heap[now] > this.heap[parent]) {
            this.swap(now, parent);
            now = parent;
            parent = (parent - 1) / 2;
        }

        this.count++;
    }

    pop() {
        if(this.count <= 0) return -1;
        let res = this.heap[0]--;
        let now = 0, leftChild = 1, rightChild = 2;
        let target = now;

        while(leftChild < this.count) {
            if(this.heap[target] < this.heap[leftChild]) target = leftChild;
            if(this.heap[target] < this.heap[rightChild] && rightChild < this.count) target = rightChild;
            if(target == now) break;
            else {
                this.swap(now, target);
                now = target;
                leftChild = now * 2 + 1;
                rightChild = now * 2 + 2;
            }
        }

        return res;
    }
    
    getMax() {
        return this.heap[0];
    }

}


function solution(candidates) {
    let [dasom, ...others] = candidates;
    others = others.filter(v => v);
    
    const priorityQueue = new PriorityQueue();
    let cnt = 0;

    for(let i = 0; i < others.length; i++) {
        priorityQueue.push(others[i]);
    }
    
    while (1) {

        if(!priorityQueue.getMax() || dasom > priorityQueue.getMax()) break;
        priorityQueue.pop();
        dasom++;
        cnt++;
        
    }

    return cnt;
}

console.log(solution(candidates));








// // 정렬 구현 방식
// function solution(count, candidates) {
//     let cnt = 0;
//     let [dasom, ...others] = candidates;

//     others.sort((a, b) => b - a);

//     while (dasom <= others[0]) {    
//         others[0]--;
//         dasom++;
//         cnt++;
//         others.sort((a, b) => b - a);
//     }

//     return cnt;
// }

// console.log(solution(count, candidates));