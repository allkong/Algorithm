import sys
input = sys.stdin.readline

# 원판 개수(k), 시작점(start), 도착점(end)
# 경유지(6-start-end)
def hanoi(k, start, end):
    # 기저 조건: k가 1일 때
    # k가 1이면 마지막 원반(가장 작은 원반)을 옮기고 끝낸다
    if k == 1:
        print(start, end)
        return

    # k-1개의 원판을 경유지로 옮긴다
    hanoi(k - 1, start, 6-start-end)
    # k번째의 원판을 도착지로 옮긴다
    print(start, end)
    # k-1개의 원판을 도착지로 옮긴다
    hanoi(k - 1, 6-start-end, end)

n = int(input()) # 원판의 개수
print(2 ** n - 1) # 옮긴 횟수
# 원판 개수가 20 이하인 경우에만 수행 과정을 출력한다
if n <= 20:
    hanoi(n, 1, 3)