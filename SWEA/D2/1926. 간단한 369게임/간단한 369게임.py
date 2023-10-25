N = int(input())

for n in range(1, N+1):
    n = str(n)
    cnt = n.count('3') + n.count('6') + n.count('9')

    if not cnt:
        print(n, end=' ')
    else:
        print('-' * cnt, end=' ')