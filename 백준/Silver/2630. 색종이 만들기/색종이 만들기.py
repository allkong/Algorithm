import sys
from collections import deque
input = sys.stdin.readline

# 한 변의 길이가 n일 때, 정사각형 모든 칸의 숫자를 다 더 했을 때
# 0이면 흰색 종이, n * n이면 파란색 종이, 그 외의 숫자면 더 자르기

def cut(r, c, n): # 시작점 (r, c), 한 변의 길이
    global white, blue

    total = sum(map(sum, [row[c:c + n] for row in paper[r:r + n]]))

    if total == 0:
        white += 1
    elif total == n * n:
        blue += 1
    else:
        # 종이 크기가 한 칸이면 종료한다
        if n == 1:
            return
        # 종이를 자른다
        n //= 2
        cut(r, c, n) # 왼쪽 위
        cut(r, c + n, n) # 오른쪽 위
        cut(r + n, c, n) # 왼쪽 아래
        cut(r + n, c + n, n) # 오른쪽 아래


n = int(input())
paper = [list(map(int, input().split())) for _ in range(n)]
white, blue = 0, 0 # 흰색 종이 개수, 파란색 종이 개수

cut(0, 0, n)
print(white)
print(blue)