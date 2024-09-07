import sys
input = sys.stdin.readline

def install_routers(start, end):
    global max_distance
    
    while start <= end:
        mid = (start + end) // 2 # 현재 설치한 공유기 사이의 최소 거리
        install_count = 1 # 설치한 공유기 개수
        current = houses[0] # 무조건 0번째 집에 공유기를 설치하고 시작

        # 공유기 몇 대 설치할 수 있는지 확인
        for idx in range(1, len(houses)):
            # 현재 위치에서 mid만큼 이동한 좌표를 포함해 오른쪽에 집이 있다면 해당 집에 공유기 설치
            if houses[idx] >= current + mid:
                install_count += 1
                current = houses[idx] # 방금 설치한 집부터 다시 거리 이동

        # 현재 조건에서 설치할 수 있는 만큼 다 설치했다

        # 여태까지 설치한 공유기 개수가 설치해야 하는 공유기 개수보다 적다면 더 설치해야 한다
        # 더 설치하려면 공유기 사이의 거리(mid)를 더 짧게 해야 한다
        if install_count < router_count:
            end = mid - 1
        # 여태까지 설치한 공유기 개수가 설치해야 하는 공유기 개수 이상이라면
        # 현재 공유기 사이의 최소 거리를 저장하고
        # 더 멀리 설치해도 되는지 거리를 늘려본다
        else:
            max_distance = mid
            start = mid + 1
        
    return max_distance

house_count, router_count = map(int, input().split())
houses = [int(input()) for _ in range(house_count)]
houses.sort()
max_distance = 0 # 가장 인접한 두 공유기 사이의 최대 거리

print(install_routers(1, houses[-1] - houses[0]))