import sys

n = int(input())
st = []

for _ in range(n):
    c = sys.stdin.readline().split()

    if c[0] == 'push':
        st.append(c[1])
    
    elif c[0] == 'pop':
        if not st:
            print(-1)
        else:
            print(st.pop())
        
    elif c[0] == 'size':
        print(len(st))
    
    elif c[0] == 'empty':
        print(int(len(st) == 0))
    
    elif c[0] == 'top':
        if not st:
            print(-1)
        else:
            print(st[-1])
