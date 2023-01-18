import sys
n = int(input())
num = []
for i in range(n):
    num.append(int(sys.stdin.readline()))
num.sort()
print(*num, sep='\n')
