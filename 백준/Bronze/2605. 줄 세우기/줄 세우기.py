n = int(input())
nums = list(map(int, input().split()))
ans = []

for i in range(n):
    ans.insert(len(ans) - nums[i], i + 1)

print(*ans)