import sys
input = sys.stdin.readline

numbers = list(map(int, input().strip()))
print(*sorted(numbers, reverse=True), sep='')