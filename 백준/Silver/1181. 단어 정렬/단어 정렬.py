import sys
n = int(input())
sen = [sys.stdin.readline().rstrip() for _ in range(n)]
sen = list(set(sen))
sen.sort()
sen.sort(key=lambda x: len(x))
print(*sen, sep='\n')