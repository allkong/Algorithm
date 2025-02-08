import sys
input = sys.stdin.readline

k = int(input())
n = 7368787

# 2부터 n까지의 숫자가 지워졌는지 여부를 나타내는 체
sieve = [True] * (n + 1)

for i in range(2, n + 1):
    # 아직 지워지지 않은 경우
    if sieve[i]:
        k -= 1
        # i의 배수를 모두 제거
        for j in range(i, n + 1, i):
            if sieve[j]:
                sieve[j] = False

        # k번째로 지워진 수 찾기
        if k == 0: 
            print(i)
            exit()