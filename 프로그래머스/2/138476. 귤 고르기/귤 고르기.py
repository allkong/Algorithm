from collections import Counter

def solution(k, tangerine):
    answer, cnt = 0, 0
    tangerine = sorted(Counter(tangerine).items(), key=lambda x: x[1], reverse=True)
    for t in tangerine:
        cnt += t[1]
        answer += 1
        if cnt >= k:
            break
    return answer