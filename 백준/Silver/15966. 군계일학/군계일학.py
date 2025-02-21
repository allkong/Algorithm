import sys
from collections import defaultdict

input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))
dp = defaultdict(int) # 딕셔너리를 사용하여 자동 초기화

for num in arr:
    dp[num] = max(dp[num], dp[num - 1] + 1) # 연속된 수열 업데이트

print(max(dp.values())) # 가장 긴 길이 출력