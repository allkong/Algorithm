n = int(input())
for i in range(n * 2):
    print(' ' * i, end='')
    print('*' * (n * 2 - 1 - (i * 2)))