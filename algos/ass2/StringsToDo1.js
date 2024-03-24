/* Create a function that, given a string, returns all of that string's contents, but without blanks.  If given the string "Pl   ayTha   tF   u  nkyM  usi    c  ", return "PlayThatFunkyMusic". */

function removeBlanks(str) {
  var newStr = "";
  for (var i = 0; i < str.length; i++) {
    if (str[i] != " ") {
      newStr += str[i];
    }
  }
  return newStr;
}

console.log(removeBlanks("Pl   ayTha   tF   u  nkyM  usi    c  "));

/* Create a JavaScript function that given a string, returns the integer made from that string's digits.  Given "0s1a3y5w7h9a2t4?6!8?0", the function should return the number 1357924680. */

function getDigits(str) {
  var nums = "0123456789".split("");
  console.log(nums);
  var digits = "";
  for (var i = 0; i < str.length; i++) {
    if (nums.includes(str[i])) {
      digits += str[i];
    }
  }
  return digits;
}

console.log(getDigits("0s1a3y5w7h9a2t4?6!8?0"));

/* Create a function that given a string, returns the string's acronym (first letters only, capitalized).  Given " there's no free lunch - gotta pay yer way.", return "TNFL-GPYW".  Given "Live from New York, it's Saturday Night!", return "LFNYISN". */

function acronyms(str) {
  var acronym = "";
  var arr = str.split(" ");
  for (var i = 0; i < arr.length; i++) {
    acronym += arr[i].substr(0, 1).toUpperCase();
  }

  return acronym;
}

console.log(acronyms(" there's no free lunch - gotta pay yer way."));

/* Accept a string and return the number of non-space characters found in the string.  For example, given "Honey pie, you are driving me crazy", return 29 (not 35). */

function countNonSpaces(str) {
  var count = 0;
  for (var i = 0; i < str.length; i++) {
    if (str[i] == " ") {
      count++;
    }
  }
  return count;
}

console.log(countNonSpaces("Honey pie, you are driving me crazy"));

/* Given a string array and value (length), remove any strings shorter than length from array. */

function removeShorter(array, len) {
  var newArray = [];
  for (var i = 0; i < array.length; i++) {
    if (array[i].length >= len) {
      newArray.push(array[i]);
    }
  }
  return newArray;
}

console.log(removeShorter(["Hello", "my", "name", "is", "Kevin"], 3));
