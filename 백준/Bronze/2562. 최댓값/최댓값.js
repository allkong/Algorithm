const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split('\n').map(Number);

let ans = input[0];
let k = 0;
for (let i = 0; i < 9; i++) {
    if (ans < input[i]) {
        ans = input[i];
        k = i;
    }
}

console.log(ans);
console.log(k + 1);