while True:
    length = list(map(int, input().split()))
    if sum(length) == 0:
        break
    m = max(length)
    length.remove(m)
    if length[0] ** 2 + length[1] ** 2 == m ** 2:
        print("right")
    else:
        print("wrong")