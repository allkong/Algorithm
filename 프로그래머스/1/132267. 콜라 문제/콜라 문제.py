def solution(a, b, n):
    coke = 0
    while n >= a:
        coke += (n // a) * b
        n = (n % a) + (n // a) * b
    return coke