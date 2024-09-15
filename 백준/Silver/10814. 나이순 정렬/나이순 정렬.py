import sys
input = sys.stdin.readline

n = int(input())
members = [input().split() for _ in range(n)]
members.sort(key=lambda x: int(x[0]))

for member in members:
    print(member[0], member[1])