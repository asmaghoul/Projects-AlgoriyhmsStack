function btNode(value) {
  this.val = value;
  this.left = null;
  this.right = null;
}
function bst() {
  this.root = null;
  this.add = function (value) {
    if (!this.root) {
      this.root = new btNode(value);
      return;
    }
    var currentNode = this.root;
    var newNode = new btNode(value);
    while (currentNode) {
      //      right side
      if (value > currentNode.val) {
        if (!currentNode.right) {
          currentNode.right = newNode;
          break;
        } else {
          currentNode = currentNode.right;
        }
      }
      //    left side
      if (value < currentNode.val) {
        if (!currentNode.left) {
          currentNode.left = newNode;
          break;
        } else {
          currentNode = currentNode.left;
        }
      }
    }
  };
  this.contains = function (value) {
    if (!this.root) {
      return false;
    }
    var currentNode = this.root;
    while (currentNode) {
      if (value === currentNode.val) {
        return true;
      }
      //       left side
      if (value < currentNode.val) {
        currentNode = currentNode.left;
        //       right side
      } else {
        currentNode = currentNode.right;
      }
    }
    return false;
  };
  this.min = function () {
    if (!this.root) {
      return false;
    }
    var currentNode = this.root;
    while (currentNode.left) {
      currentNode = currentNode.left;
    }
    return currentNode.val;
  };
  this.max = function () {
    if (!this.root) {
      return false;
    }
    var currentNode = this.root;
    while (currentNode.right) {
      currentNode = currentNode.right;
    }
    return currentNode.val;
  };
}

var myBst = new bst();
myBst.add(5);
myBst.add(6);
myBst.add(7);
myBst.add(4);
myBst.add(50);
console.log(myBst.contains(10));
console.log(myBst.min());
console.log(myBst.max());
