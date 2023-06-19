def solution(s):
    answer = True
    a = 0
    for bracket in s:
        if bracket == '(':
            a += 1
        else:
            if a > 0:
                a -= 1
            else:
                answer = False
    if a != 0:
        answer = False
    return answer