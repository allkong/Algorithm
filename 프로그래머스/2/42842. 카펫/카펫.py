def solution(brown, yellow):
    multi = brown + yellow
    for b in range(1, multi+1):
        a = multi / b
        if a % 1 == 0:
            if a + b == (brown + 4) / 2:
                return a, b