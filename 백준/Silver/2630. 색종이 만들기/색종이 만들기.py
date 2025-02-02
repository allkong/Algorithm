import sys
input = sys.stdin.readline

def cut(r, c, n): # 시작점 (r, c), 한 변의 길이
    global white, blue

    color = paper[r][c]

    for i in range(r, r + n):
        for j in range(c, c + n):
            # 다른 색인 칸이 있으면 종이를 자른다
            if color != paper[i][j]:
                n //= 2
                cut(r, c, n) # 왼쪽 위
                cut(r, c + n, n) # 오른쪽 위
                cut(r + n, c, n) # 왼쪽 아래
                cut(r + n, c + n, n) # 오른쪽 아래
                return

    if color == 0:
        white += 1
    elif color == 1:
        blue += 1

n = int(input())
paper = [list(map(int, input().split())) for _ in range(n)]
white, blue = 0, 0 # 흰색 종이 개수, 파란색 종이 개수

cut(0, 0, n)
print(white)
print(blue)