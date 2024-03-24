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

/* Given a numerical array, reverse the order of values, in-place.  The reversed array should have the same length, with existing elements moved to other indices so that the order of elements is reversed.  Working "in-place" means that you cannot use a second array - move values within the array that you are given.   As always, do not use built-in functions such as splice(). */

function arrayReverse(arr) {
  var temp;

  for (var i = 0; i < arr.length / 2; i++) {
    temp = arr[i];
    arr[i] = arr[arr.length - 1 - i];
    arr[arr.length - 1 - i] = temp;
  }

  console.log(arr);
}

//Test Cases
console.log("Test Case 1");
var arr1 = [1, 2, 3, 4, 5, 6, 7, 8, 9];
arrayReverse(arr1);
console.log("********************");

console.log("Test Case 2");
var arr2 = ["dyslexic", "am", "I"];
arrayReverse(arr2);
console.log("********************");

/* Implement arrayRotate(arr, shiftBy) that accepts array and offset.  Shift array's values to the right by that amount.  "Wrap-around" any values that shift off the array's end to the other side, so that no data is lost in the process.  Operate in-place: given ([1,2,3], 1), change array to [3,1,2].  Don't use built-in functions.

Second: Allow negative shiftBy (shift left, instead of right).

Third: Minimize memory usage.  With no new array, handle arrays/shiftBys in the millions.

Fourth: Minimize the touches of each element. */

function arrayRotate(arr, shiftBy) {
  var temp = arr[arr.length - 1];

  while (shiftBy > 0) {
    for (var i = arr.length - 1; i >= 0; i--) {
      arr[i] = arr[i - 1];
    }

    arr[0] = temp;
    temp = arr[arr.length - 1];
    shiftBy--;
  }
  console.log(arr);
}

//Test Cases
console.log("Test Case 1");
var arr1 = [1, 2, 3];
var shift1 = 1;
arrayRotate(arr1, shift1);
console.log("********************");

console.log("Test Case 2");
var arr2 = [1, 2, 3, 4, 5, 6, 7, 8, 9];
var shift2 = 4;
arrayRotate(arr2, shift2);



/* Alan is good at breaking secret codes.  One method is to eliminate values that lie within a specific known range.  Given arr and values min and max, retain only the array values between min and max.  Work in-place: return the array you are given, with values in original order.  No built-in array functions. */

function arrayFilterRange(arr, min, max) {
  var temp;

  for (var i = 0; i < arr.length; i++) {
    if (arr[i] < min) {
    }
  }
  console.log(arr);
}

//Test Cases
console.log("Test Case1");
var arr1 = [1, 2, 3, 4, 5, 6, 7, 8, 9];
var min1 = 2;
var max1 = 8;
arrayFilterRange(arr1, min1, max1);
console.log("********************");

/* Replicate JavaScript's concat().  Create a standalone function that accepts two arrays.  Return a new array containing the first array's elements, followed by the second array's elements.  Do not alter the original arrays.  Example: arrayConcat(["a","b"], [1,2]) should return new array ["a","b",1,2]. */

function arrayConcat(arr1, arr2) {
  var newArray = [];

  for (var i = 0; i < arr1.length; i++) {
    newArray[i] = arr1[i];
  }
  for (var i = 0; i < arr2.length; i++) {
    newArray[i + arr1.length] = arr2[i];
  }
  console.log(newArray);
}

//Test Cases
console.log("Test Case1");
var arr1 = ["a", "b"];
var arr2 = [1, 2];
arrayConcat(arr1, arr2);
console.log("*******************");

console.log("Test Case2");
var arr1 = ["What's", "up"];
var arr2 = ["Buttercup", "?"];
arrayConcat(arr1, arr2);
console.log("*******************");

console.log("Test Case3");
var arr1 = [1, 2, 3, 4, 5];
var arr2 = [6, 7, 8, 9, 10];
arrayConcat(arr1, arr2);
console.log("*******************");
