function solution(s) {
    let numbers = s.split(' ').map(Number)
    // Math.min/Math.max를 쓸 때는 전개 연산자로 배열을 풀어야 한다
    let answer = `${Math.min(...numbers)} ${Math.max(...numbers)}`
    return answer;
}