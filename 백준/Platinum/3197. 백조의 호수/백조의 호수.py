import sys
from collections import deque
input = sys.stdin.readline

# 백조들이 만날 수 있는지 확인하기
def move_swan():
    next_swan_q = deque()

    # 오늘 이동 가능한 칸만 탐색하기
    while cur_swan_q:
        y, x = cur_swan_q.popleft()
        
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            
            # 백조 둘이 만났으면 종료하기
            if (ny, nx) == swan[1]:
                return True, None
            
            # 호수 범위 안에 들고 방문한 적이 없는 칸
            if 0 <= ny < R and 0 <= nx < C and not swan_visited[ny][nx]:
                # 물 칸이면 이어서 탐색하기
                if lake[ny][nx] == '.':
                    cur_swan_q.append((ny, nx))
                # 빙하 칸이면 다음에 이동할 큐에 넣기
                elif lake[ny][nx] == 'X':
                    next_swan_q.append((ny, nx))
                swan_visited[ny][nx] = True

    return False, next_swan_q

# 빙판 녹이기 (하루)
def melt_ice():
    next_water_q = deque()
    
    while cur_water_q:
        y, x = cur_water_q.popleft()
        
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            
            # 호수 범위 안에 들고 방문한 적이 없는 칸
            if 0 <= ny < R and 0 <= nx < C and not water_visited[ny][nx]:
                # 빙하 칸이면 녹이기
                if lake[ny][nx] == 'X':
                    lake[ny][nx] = '.'
                    next_water_q.append((ny, nx))
                    water_visited[ny][nx] = True
    
    return next_water_q

R, C = map(int, input().split())
lake = [list(input().rstrip()) for _ in range(R)] # 호수 정보

dy = [-1, 1, 0, 0] # 상하좌우
dx = [0, 0, -1, 1]

swan = [] # 백조 위치
cur_water_q = deque() # 물 칸
water_visited = [[False] * C for _ in range(R)]

# 초기 위치 찾기
for i in range(R):
    for j in range(C):
        if lake[i][j] in ('.', 'L'):
            if lake[i][j] == 'L':
                swan.append((i, j))
            cur_water_q.append((i, j))
            water_visited[i][j] = True

cur_swan_q = deque([swan[0]]) # 백조가 오늘 갈 수 있는 칸
swan_visited = [[False] * C for _ in range(R)]
swan_visited[swan[0][0]][swan[0][1]] = True

days = 0 # 백조들이 만나는 데까지 걸리는 날

while True:
    # 백조들이 만날 수 있는지 확인하고 만났다면 종료하기
    can_meet, next_swan_q = move_swan()
    if can_meet:
        print(days)
        break
    
    # 빙판 녹이기
    cur_water_q = melt_ice()
    
    # 하루 마무리하기
    cur_swan_q = next_swan_q
    days += 1