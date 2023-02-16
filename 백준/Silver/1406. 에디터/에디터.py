import sys

st_l = list(input())
st_r = []
m = int(input())

for i in range(m):
    com = sys.stdin.readline().split()

    if com[0] == "L" and st_l:
        st_r.append(st_l.pop())
    elif com[0] == "D" and st_r:
        st_l.append(st_r.pop())
    elif com[0] == "B" and st_l:
        st_l.pop()
    elif com[0] == "P":
        st_l.append(com[1])

print("".join(st_l + list(reversed(st_r))))
