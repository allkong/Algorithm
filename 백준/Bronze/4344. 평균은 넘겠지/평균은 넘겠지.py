import sys

c = int(input())
for i in range(c):
    score = list(map(int, sys.stdin.readline().split()))
    student = score[0]
    del score[0]
    cnt = 0
    for s in score:
        if s > sum(score) / len(score):
            cnt += 1
    print(f'{cnt / len(score) * 100:.3f}', '%', sep='')
  