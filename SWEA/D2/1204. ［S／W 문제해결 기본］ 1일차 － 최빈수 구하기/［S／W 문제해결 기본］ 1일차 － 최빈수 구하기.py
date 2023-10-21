from collections import Counter
T = int(input())
for _ in range(T):
    i = int(input())
    nums = list(map(int, input().split()))
    cnt = Counter(nums)
    print(f'#{i}', cnt.most_common(1)[0][0])