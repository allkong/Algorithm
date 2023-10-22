for tc in range(1, 11):
    cnt = int(input())
    box = sorted(list(map(int, input().split())))
    while cnt:
        box[-1] -= 1
        box[0] += 1
        cnt -= 1
        box.sort()
    print(f'#{tc}')
    print(box[-1] - box[0])