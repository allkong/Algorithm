card = [i for i in range(21)]
for i in range(10):
    a, b = map(int, input().split())
    card[a:b+1] = card[b:a-1:-1]
for i in range(1, 21):
    print(card[i], end=' ')
