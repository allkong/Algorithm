import sys
input = sys.stdin.readline

n = int(input())
tower = list(map(int, input().split()))
st = []
ans = [0] * n

for i in range(n):
    while st:
        if tower[i] < st[-1][1]:
            ans[i] = st[-1][0] + 1
            break
        else:
            st.pop()
    
    st.append((i, tower[i]))

print(*ans)