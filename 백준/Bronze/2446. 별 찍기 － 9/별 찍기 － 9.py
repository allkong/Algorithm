import sys
input = sys.stdin.readline

N = int(input())

for i in range(N - 1):
    print(' ' * i, end='')
    print('*' * (2 * (N - i) - 1))
    
for i in range(1, N + 1):
    print(' ' * (N - i), end='')
    print('*' * (2 * i - 1))