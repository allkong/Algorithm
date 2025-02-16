import sys
input = sys.stdin.readline

MAX = 10 ** 21000
fibo = [0, 1]
num = 0
# 피보나치 수 배열 만들기
while num <= MAX:
    num = fibo[-1] + fibo[-2]
    fibo.append(num)

t = int(input())
for _ in range(t):
    f = int(input()) # 피보나치 수 Fn
    start, end = 0, len(fibo) # [s, e)

    while start + 1 < end:
        mid = (start + end) // 2

        # 현재 mid의 피보나치 수가 Fn보다 작으면 오른쪽 탐색
        if fibo[mid] <= f:
            start = mid
        # 현재 mid의 피보나치 수가 Fn보다 크면 왼쪽 탐색
        else:
            end = mid
    
    # end가 1일 때는 인덱스가 가장 큰 2를 출력
    print(start if end != 1 else 2)