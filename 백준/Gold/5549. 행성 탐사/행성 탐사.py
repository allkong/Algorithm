import sys
input = sys.stdin.readline

M, N = map(int, input().split()) # 가로, 세로
K = int(input()) # 조사 대상 영역의 개수
terrain = {'J': 0, 'O': 1, 'I': 2} # 지형 정보
planet = [[[0] * (N + 1) for _ in range(M + 1)] for _ in range(3)] # 행성 지도

for r in range(1, M + 1):
    line = input()
    for c in range(1, N + 1):
        for d in range(3):
            planet[d][r][c] = planet[d][r - 1][c] + planet[d][r][c - 1] - planet[d][r - 1][c - 1]
        planet[terrain[line[c - 1]]][r][c] += 1

for i in range(K):
    r1, c1, r2, c2 = map(int, input().split())
    
    for i in range(3):
        print(planet[i][r2][c2] - planet[i][r1 - 1][c2] - planet[i][r2][c1 - 1] + planet[i][r1 - 1][c1 - 1], end=' ')
    print()