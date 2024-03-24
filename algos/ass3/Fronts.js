class Node {
  constructor(value, next = null) {
    this.val = value;
    this.next = next;
  }
}

class SSL {
  constructor() {
    this.head = null;
  }

  addFront(value) {
    let newNode = new Node(value);
    if (!this.head) {
      this.head = newNode;
    } else {
      newNode.next = this.head;
      this.head = newNode;
    }
    return this.head;
  }

  removeFront() {
    if (!this.head) {
      console.log("Empty List - nothing to remove");
      return null;
    } else {
      this.head = this.head.next;
    }
    return this.head;
  }
}

// Tests
mySSL = new SSL();
console.log(mySSL.addFront(5));
console.log(mySSL.addFront(7));
console.log(mySSL.addFront(-3));
console.log(mySSL.addFront(12));
console.log(mySSL.addFront(99));
