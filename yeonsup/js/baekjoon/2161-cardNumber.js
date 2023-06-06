const filePath = process.platform === "linux" ? "/dev/stdin" : "./input-2161.txt";
const [size] = require("fs").readFileSync(filePath).toString().split("\n").map(Number);

class Node {
    constructor(data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    constructor() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    enqueue() {
        const newNode = Node(data);

        if(!this.head) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }

        this.size++;
    }

    dequeue() {
        if(!this.head) return null;
        const removeNode = this.head;
        this.head.next = this.tail;

        if(!this.tail) this.tail = null;
        
        this.size--;
        
        return removeNode.data;
    }
}


let cards = [];
let result = [];
for(let i = 0; i < size; i++) {
    cards[i] = i + 1;
}

let index = 1;
while(cards.length != 0) {
    if(index % 2 == 0) {
        cards.push(cards.shift());
    } else {
        result.push(cards.shift());
    }
    index++;
}

console.log(result.join(" "));

