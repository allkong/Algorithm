import sys
input = sys.stdin.readline

n = int(input())
st = []
for _ in range(n):
    com = input().split()

    if com[0] == '1':
        st.append(com[1])
    
    elif com[0] == '2':
        if st:
            print(st.pop())
        else:
            print(-1)
    
    elif com[0] == '3':
        print(len(st))
    
    elif com[0] == '4':
        if not st:
            print(1)
        else:
            print(0)
        
    elif com[0] == '5':
        if st:
            print(st[-1])
        else:
            print(-1)