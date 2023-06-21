def solution(a, b):
    a = str(a)
    b = str(b)
    return int(max(a+b, b+a))