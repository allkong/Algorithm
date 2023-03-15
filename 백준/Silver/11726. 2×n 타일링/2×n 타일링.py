import sys
input = sys.stdin.readline

n = int(input())

rec = [0] * 1001
rec[1] = 1
rec[2] = 2

for i in range(3, 1001):
    rec[i] = rec[i-1] + rec[i-2]

print(rec[n] % 10007)