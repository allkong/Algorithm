import sys
input = sys.stdin.readline

s = input().rstrip().replace('O', '1').replace('X', '0')

print(int(s[::-1], 2) % (1_000_000_007))