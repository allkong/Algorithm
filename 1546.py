n = int(input())
score = list(map(int, input().split()))
s_sum = 0
for s in score:
    s_sum += s / max(score) * 100
print(s_sum/n)