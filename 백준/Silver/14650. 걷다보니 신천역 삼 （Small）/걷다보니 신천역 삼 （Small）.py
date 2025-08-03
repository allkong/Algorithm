import sys
from itertools import product
input = sys.stdin.readline

N = int(input())
num = ['0', '1', '2']
cnt = 0

for p in product(num, repeat=N):
    if p[0] == '0':
        continue
    if int(''.join(p)) % 3 == 0:
        cnt += 1

print(cnt)