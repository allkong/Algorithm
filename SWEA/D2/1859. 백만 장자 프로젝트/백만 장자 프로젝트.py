T = int(input())
for i in range(1, T+1):
    N = int(input())
    price = list(map(int, input().split()))
    max_price = 0
    income = 0
    for val in price[::-1]:
        if val >= max_price:
            max_price = val
        else:
            income += max_price - val
    print("#", i, " ", income, sep="")