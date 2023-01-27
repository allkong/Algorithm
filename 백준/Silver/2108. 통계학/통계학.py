import sys
from collections import Counter

n = int(sys.stdin.readline())
num = []
for _ in range(n):
    num.append(int(sys.stdin.readline()))

# 산술평균
s = sum(num)
if s >= 0:
    print(int(s / n + 0.5))
elif s < 0:
    print(int(s / n - 0.5))

# 중앙값
num.sort()
print(num[int(n / 2)])

#최빈값
m = Counter(num).most_common()
if len(m) > 1 and m[0][1] == m[1][1]:
    print(m[1][0])
else:
    print(m[0][0])

# 범위
print(abs(num[0] - num[-1]))