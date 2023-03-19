import sys
input = sys.stdin.readline

n = int(input())
score = [0] * 301
stairs = [0] * 301

for i in range(n):
    score[i] = int(input())

stairs[0] = score[0]
stairs[1] = score[0] + score[1]
for i in range(2, n):
    stairs[i] = max(stairs[i-2] + score[i], stairs[i-3] + score[i-1] + score[i])

print(stairs[n-1])
