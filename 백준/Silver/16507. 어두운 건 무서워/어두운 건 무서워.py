R, C, Q = map(int, input().split())
picture = [[0] * (C + 1) for _ in range(R + 1)]

for i in range(1, R + 1):
    line = list(map(int, input().split()))
    for j in range(1, C + 1):
        picture[i][j] = line[j - 1] + picture[i][j - 1] + picture[i - 1][j] - picture[i - 1][j - 1]
        

for _ in range(Q):
    r1, c1, r2, c2 = map(int, input().split())
    print((picture[r2][c2] - picture[r1 - 1][c2] - picture[r2][c1 - 1] + picture[r1 - 1][c1 - 1]) // ((r2 - r1 + 1) * (c2 - c1 + 1)))