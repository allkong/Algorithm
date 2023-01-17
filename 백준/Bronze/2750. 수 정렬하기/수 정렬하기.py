import sys
num = []
n = int(input())
for i in range(n):
    num.append(int(sys.stdin.readline()))
print(*sorted(num), sep='\n')