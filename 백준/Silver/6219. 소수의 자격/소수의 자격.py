import sys
input = sys.stdin.readline

A, B, D = map(int, input().split())
sieve = [1] * (B + 1) # 숫자가 지워졌는지 여부를 나타내는 체

for i in range(2, B + 1):
    # 아직 지워지지 않은 경우
    if sieve[i]:
        # i의 배수를 모두 제거
        for j in range(i * i, B + 1, i):
            if sieve[j]:
                sieve[j] = 0

for i in range(A, B + 1):
    if sieve[i] and str(D) not in str(i):
        sieve[i] = 0

print(sum(sieve[A:]))