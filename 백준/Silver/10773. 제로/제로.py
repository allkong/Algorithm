import sys

k = int(input())
st = []

for _ in range(k):
    n = int(sys.stdin.readline())
    if n == 0:
        st.pop()
    else:
        st.append(n)

print(sum(st))