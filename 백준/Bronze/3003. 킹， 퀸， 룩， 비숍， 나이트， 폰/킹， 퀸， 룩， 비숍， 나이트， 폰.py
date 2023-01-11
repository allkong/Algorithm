white = list(map(int, input().split()))
black = [ 1, 1, 2, 2, 2, 8 ]
need = []

for i in range(len(black)):
  need.append(black[i] - white[i])

print(*need)