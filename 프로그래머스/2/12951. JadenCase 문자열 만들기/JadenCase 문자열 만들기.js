function solution(s) {    
    // 모든 문자로 소문자로 변환
    // 공백 기준으로 분리
    let words = s.toLowerCase().split(' ');
    
    // 각 단어의 첫 문자를 대문자로 변환
    let answer = words.map(word => word.charAt(0).toUpperCase() + word.slice(1))
    
    // 공백 기준으로 단어 합침
    return answer.join(' ');
}