h, m = map(int, input().split())
time = int(input())

if m + time < 60:
    print(h, m + time)
else:
    h += (m + time) // 60
    m = (m + time) % 60

    if h > 23:
        print(h - 24, m)
    else:
        print(h, m)