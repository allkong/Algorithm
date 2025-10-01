import sys
from math import gcd
input = sys.stdin.readline

for _ in range(int(input())):
    s = input().rstrip()[2:]

    if '(' not in s:
        numerator = int(s) # 분자
        denominator = 10 ** len(s) # 분모

    else:
        i = s.index('(')
        k = s[:i] # 비반복 구간
        r = s[i + 1:-1] # 반복 구간

        m = len(k) if k else 0 # 비반복 구간 길이
        n = len(r) # 반복 구간 길이

        k = int(k) if k else 0
        r = int(r)

        numerator = k * 10 ** n + r - k
        denominator = (10 ** (m + n)) - (10 ** m)

    divisor = gcd(numerator, denominator) # 최대공약수
    print(f'{numerator // divisor}/{denominator // divisor}')