import sys
input = sys.stdin.readline

pattern = list(input().rstrip())
s = ''

for p in pattern:
    if p == 'O':
        s += '1'
    else:
        s += '0'

print(int(s[::-1], 2) % (1_000_000_007))