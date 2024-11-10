import sys
input = sys.stdin.readline

def search_z(row, col, cur_size):
    global count

    # 기저 조건: size가 1일 때
    # 배열의 크기가 1 * 1이면 
    if cur_size == 1:
        return

    area_size = cur_size // 2 # 4분할 영역의 크기

    # 현재 좌표가 몇 번째 영역인지 찾는다
    # 해당 영역으로 이동 후에 재귀를 호출한다

    # 왼쪽 위(0)
    if row < area_size and col < area_size:
        search_z(row, col, area_size)

    # 오른쪽 위(1)
    elif row < area_size and col >= area_size:
        count += (cur_size ** 2) // 4 # 1/4
        search_z(row, col - area_size, area_size)

    # 왼쪽 아래(2)
    elif row >= area_size and col < area_size:
        count += (cur_size ** 2) // 4 * 2 # 2/4
        search_z(row - area_size, col, area_size)

    # 오른쪽 아래(3)
    elif row >= area_size and col >= area_size:
        count += (cur_size ** 2) // 4 * 3 # 3/4
        search_z(row - area_size, col - area_size, area_size)
    
N, r, c = map(int, input().split()) # (r, c): 타겟 좌표
size = 2 ** N # 배열의 크기 size * size
count = 0 # 몇 번째로 방문하는지 세는 변수(이동 횟수)
search_z(r, c, size)
print(count)