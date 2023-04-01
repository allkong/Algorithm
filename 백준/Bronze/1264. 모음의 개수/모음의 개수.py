while True:
    sen = input().lower()
    if sen == '#':
        break
    cnt = 0
    for s in sen:
        if s == 'a' or s == 'e' or s == 'i' or s == 'o' or s == 'u':
            cnt += 1
    print(cnt)