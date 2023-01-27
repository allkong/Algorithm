import sys

num = []
for _ in range(9):
    num.append(list(map(int, sys.stdin.readline().split())))
  
max_value = max(map(max, num))
print(max_value)

for i in range(9):
    for j in range(9):
        if num[i][j] == max_value:
            print(i + 1, j + 1)