import sys
input = sys.stdin.readline

l = int(input())
a = input()
h = 0
for i in range(l):
    h += (ord(a[i]) - 96) * (31 ** i) % 1234567891
print(h)