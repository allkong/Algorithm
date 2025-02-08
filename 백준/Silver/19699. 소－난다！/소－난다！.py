import sys
from itertools import combinations
input = sys.stdin.readline

def is_prime(target):
    if target == 1:
        return False
    for i in range(2, int(target ** 0.5) + 1):
        if target % i == 0:
            return False
    return True

n, m = map(int, input().split())
h = list(map(int, input().split()))
ans = set()

# m마리의 소를 뽑아 몸무게 합 구하기
candidates = list((combinations(h, m)))

for candidate in candidates:
    total = sum(candidate)
    # 몸무게의 합이 소수이면 저장
    if is_prime(total):
        ans.add(total)

print(' '.join(map(str, sorted(ans))) or -1)