import sys
input = sys.stdin.readline

n, m = map(int, input().split())
site = {}

for _ in range(n):
    adr, pw = input().split()
    site[adr] = pw

for _ in range(m):
    print(site[input().rstrip()])