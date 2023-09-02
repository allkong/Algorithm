n = int(input())
li = list(set(map(int, input().split())))
li.sort()
print(*li)