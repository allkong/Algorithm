import sys
input = sys.stdin.readline

# 원판 개수, 시작점, 도착점, 경유지
def hanoi(k, start, end, via):
    # 기저 조건: k가 1일 때
    # k가 1이면 마지막 원반(가장 작은 원반)을 옮기고 끝낸다
    if k == 1:
        print(start, end)
        return

    # k-1개의 원판을 경유지로 옮긴다
    hanoi(k - 1, start, via, end)
    # k번째의 원판을 도착지로 옮긴다
    print(start, end)
    # k-1개의 원판을 도착지로 옮긴다
    hanoi(k - 1, via, end, start)

n = int(input()) # 원판의 개수
print(2 ** n - 1) # 옮긴 횟수
hanoi(n, 1, 3, 2)