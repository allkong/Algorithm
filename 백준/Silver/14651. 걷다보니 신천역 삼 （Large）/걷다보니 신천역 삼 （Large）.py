import sys
input = sys.stdin.readline

N = int(input())
print(int(2 * 3 ** (N - 2)) % 1_000_000_009)