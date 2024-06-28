const fs = require('fs')
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n').map(Number)

console.log(input[0] + input[1] - input[2]) // 수로 생각
console.log(input[0].toString() + input[1].toString() - input[2].toString()) // 문자열로 생각