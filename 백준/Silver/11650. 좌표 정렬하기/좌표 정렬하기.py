import sys
input = sys.stdin.readline

coordinate_count = int(input()) # 좌표 개수
coordinates = []

for _ in range(coordinate_count):
    coordinates.append(list(map(int, sys.stdin.readline().split())))

coordinates.sort()

for coordinate in coordinates:
    print(coordinate[0], coordinate[1])