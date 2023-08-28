import sys
input = sys.stdin.readline

m = int(input())
s = set()

for _ in range(m):
    command = input().split()

    if len(command) == 1:
        if command[0] == 'all':
            s = set (range(1, 21))
        else:
            s = set()
        continue

    c, x = command[0], int(command[1])
    if c == 'add':
        s.add(x)
    elif c == 'remove':
        s.discard(x)
    elif c == 'check':
        print(int(x in s))
    elif c == 'toggle':
        if x in s:
            s.discard(x)
        else:
            s.add(x)