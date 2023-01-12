h, m = map(int, input().split())

if m >= 45:
    print(h, m - 45)
else:
    if h == 0:
        print(23, m + 15) # m + 15 == 60 + m - 45
    else:
        print(h - 1, m + 15)