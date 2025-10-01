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

        m = len(k) # 비반복 구간 길이
        n = len(r) # 반복 구간 길이

        numerator = int(k + r) - int(k or '0')
        denominator = (10 ** (m + n)) - (10 ** m)

    g = gcd(numerator, denominator) # 최대공약수
    print(f'{numerator // g}/{denominator // g}')