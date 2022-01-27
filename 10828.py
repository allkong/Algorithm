import sys

n = int(input())
st = []

for i in range(n):
    a = sys.stdin.readline().split()

    if a[0] == 'push':
        st.append(int(a[1]))

    elif a[0] == 'pop':
        if len(st) == 0:
            print(-1)
        else:
            print(st.pop())

    elif a[0] == 'size':
        print(len(st))

    elif a[0] == 'empty':
        print(int(len(st) == 0))

    elif a[0] == 'top':
        if len(st) == 0:
            print(-1)
        else:
            print(st[-1])