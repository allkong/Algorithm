import sys
input = sys.stdin.readline

coordinate_count = int(input()) # 좌표 개수
coordinates = [list(map(int, input().split())) for _ in range(coordinate_count)]
coordinates.sort(key=lambda x: (x[1], x[0])) # y좌표가 증가하는 순으로, y좌표가 같으면 x좌표가 증가하는 순서로 정렬

for coordinate in coordinates:
    print(*coordinate)