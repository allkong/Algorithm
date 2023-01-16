import sys

t = int(input())
for i in range(t):
    cnt = 0
    score = 0
    ox = sys.stdin.readline()
    for o in ox:
        if o == 'O':
            cnt += 1
            score += cnt
        else:
            cnt = 0
    print(score)