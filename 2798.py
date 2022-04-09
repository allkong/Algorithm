n, m = map(int, input().split())
cards = list(map(int, input().split()))
x = len(cards)
ans = 0
for i in range(x-2):
    tmp = 0
    for j in range(i+1, x-1):
        for k in range(j+1, x):
            tmp = cards[i] + cards[j] + cards[k]
            if tmp <= m and abs(m-tmp) < abs(m-ans):
                ans = tmp
print(ans)