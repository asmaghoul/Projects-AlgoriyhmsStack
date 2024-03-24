function rSigma(num) {
    //   base case
    if (num <= 0) {
      return 0;
    } else {
      return Math.floor(num) + rSigma(Math.floor(num) - 1);
    }
  }
  
  console.log(rSigma(-1));
  
  function rBinarySearch(arr, value) {
    //   base case
    if (arr.length) {
      if (arr[arr.length - 1] === value) {
        return true;
      } else {
        arr.pop();
        return rBinarySearch(arr, value);
      }
    }
    //   array will eventually be empty
    return false;
  }
  
  console.log(rBinarySearch([1, 2, 3], 0));
  
  function rFib(num) {
    //   first base case
    if (num <= 0) {
      return 0;
      //     second base case
    } else if (num === 1) {
      return 1;
      //     recursive call
    } else {
      return rFib(num - 1) + rFib(num - 2);
    }
  }
  
  console.log(rFib(4));
  var canvas = [
    [3, 2, 3, 4, 3],
    [2, 3, 3, 4, 0],
    [7, 3, 3, 4, 1],
    [6, 5, 3, 4, 1],
    [1, 2, 3, 3, 3],
  ];
  var startXY = [2, 2];
  
  console.log(canvas);
  floodFill(canvas, startXY, 9);
  console.log(canvas);
  
  function floodFill(canvas, startXY, newColor, oldColor) {
    //   row
    var x = startXY[0];
    //   column
    var y = startXY[1];
  
    if (!oldColor) {
      oldColor = canvas[y][x];
    }
    //    base case
    if (canvas[y][x] !== oldColor) {
      return;
    }
    //   swap values
    canvas[y][x] = newColor;
  
    //  bottom side
    if (y + 1 < canvas.length) {
      floodFill(canvas, [x, y + 1], newColor, oldColor);
    }
    //   top side
    if (y - 1 >= 0) {
      floodFill(canvas, [x, y - 1], newColor, oldColor);
    }
    // left side
    if (x + 1 < canvas[y].length) {
      floodFill(canvas, [x + 1, y], newColor, oldColor);
    }
    // right side
    if (x - 1 >= 0) {
      floodFill(canvas, [x - 1, y], newColor, oldColor);
    }
  }
  