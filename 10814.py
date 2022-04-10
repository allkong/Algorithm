import sys
n = int(input())
member = []
for i in range(n):
    member.append(sys.stdin.readline().split())
member.sort(key=lambda x:int(x[0]))
for m in member:
    print(m[0], m[1])