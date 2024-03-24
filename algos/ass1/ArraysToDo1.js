/* Given an array and an additional value, insert this value at the beginning of the array. You may use .push(), */

function arrayPushFront(arr, val) {
  for (var i = arr.length; i > 0; i--) {
    arr[i] = arr[i - 1];
  }

  arr[0] = val;
  console.log(arr);
}

//Test Cases
console.log("Test Case 1");
var arr1 = [2, 3, 4, 5, 6, 7, 8, 9];
var val1 = 1;
arrayPushFront(arr1, val1);
console.log("********************");

console.log("Test Case 2");
var arr2 = [-1, 2, -3, 4, -5];
var val2 = 0;
arrayPushFront(arr2, val2);
console.log("********************");

console.log("Test Case 3");
var arr3 = ["my", "name", "is", "Asma"];
var val3 = "Hello";
arrayPushFront(arr3, val3);
console.log("********************");

/* Given an array, remove and return the value at the beginning of the array. Prove the value is removed from the array by printing it. You may use .pop(),  */

function arrayPopFront(arr) {
  var temp = arr[0];

  for (var i = 0; i < arr.length; i++) {
    arr[i] = arr[i + 1];
  }

  arr[arr.length - 1] = temp;
  return arr.pop();
}

//Test Cases
console.log("Test Case 1");
var arr1 = [1, 2, 3, 4, 5, 6, 7, 8, 9];
console.log(arrayPopFront(arr1));
console.log("********************");

console.log("Test Case 2");
var arr2 = [-245, 325, -21, 52];
console.log(arrayPopFront(arr2));
console.log("********************");

/* Given array, index, and additional value, insert the value into array at given index.  Do this without using built-in array methods.  You can think of pushFront(arr, val) as equivalent to insertAt(arr, 0, val). */

function arrayInsertAt(arr, ind, val) {
  for (var i = arr.length; i >= ind; i--) {
    arr[i] = arr[i - 1];
  }

  arr[ind] = val;
  console.log(arr);
}

//Test Cases
console.log("Test Case 1");
var arr1 = [1, 2, 4, 5, 6];
var ind1 = 2;
var val1 = 3;
arrayInsertAt(arr1, ind1, val1);
console.log("******************");

console.log("Test Case 2");
var arr2 = ["I", "don't", "like", "it", "when", "you", "my", "sentences"];
var ind2 = 6;
var val2 = "finish";
arrayInsertAt(arr2, ind2, val2);
console.log("******************");

/* Given array and an index into array, remove and return the array value at that index.  Do this without using built-in array methods except pop().  Think of popFront(arr) as equivalent to removeAt(arr, 0). */

function arrayRemoveAt(arr, ind) {
  var temp = arr[ind];

  for (var i = ind; i < arr.length; i++) {
    arr[i] = arr[i + 1];
  }

  arr[arr.length - 1] = temp;
  return arr.pop();
}

//Test Cases
console.log("Test Case 1");
var arr1 = [1, 2, 3, 4, 5, 6, 7, 8, 9];
var ind1 = 3;
console.log(arrayRemoveAt(arr1, ind1));

console.log("Test Case 2");
var arr2 = [-1, 2, -3, "$$$", 4, -5];
var ind2 = 3;
console.log(arrayRemoveAt(arr2, ind2));

/* Swap positions of successive pairs of values of given array.  If length is odd, do not change the final element.  For [1,2,3,4], return [2,1,4,3].  For example, change input ["Brendan", true, 42] to [true, "Brendan", 42].  As with all array challenges, do this without using any built-in array methods. */

function arraySwapPairs(arr) {
  var temp;

  for (var i = 0; i < arr.length - 1; i += 2) {
    temp = arr[i];
    arr[i] = arr[i + 1];
    arr[i + 1] = temp;
  }

  console.log(arr);
}

//Test Case
console.log("Test Case 1");
var arr1 = [1, 2, 3, 4];
arraySwapPairs(arr1);
console.log("*******************");

console.log("Test Case 2");
var arr2 = ["Brendan", true, 42];
arraySwapPairs(arr2);
console.log("*******************");

/* Sara is looking to hire an awesome web developer and has received applications from various sources.  Her assistant alphabetized them but notices some duplicates.  Given a sorted array, remove duplicate values.  Because array elements are already in order, all duplicate values will be grouped together.  As with all these array challenges, do this without using any built-in array methods. */

function arrayRemoveDuplicates(arr) {
  for (var i = 0; i < arr.length; i++) {
    if (arr[i] == arr[i + 1]) {
      for (var j = i; j < arr.length; j++) {
        arr[j] = arr[j + 1];
      }
      arr.length--; //remove last index
      i--; //In case of threes or more
    }
  }

  console.log(arr);
}

//Test Cases
console.log("Test Case 1");
var arr1 = [
  "Alphabet",
  "Amazon",
  "Apple",
  "Apple",
  "Facebook",
  "Tesla",
  "Tesla",
];
arrayRemoveDuplicates(arr1);
console.log("********************");

console.log("Test Case 2");
var arr2 = [
  "Alphabet",
  "Amazon",
  "Apple",
  "Apple",
  "Apple",
  "Facebook",
  "Tesla",
];
arrayRemoveDuplicates(arr2);
console.log("********************");
