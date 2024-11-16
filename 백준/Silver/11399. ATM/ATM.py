import sys
input = sys.stdin.readline

n = int(input())
p = list(map(int, input().split()))
p.sort()
time = 0

for i in range(1, n + 1):
    time += sum(p[:i])

print(time)