n = int(input())
b_seq = list(map(int, input().split()))
a_seq = [b_seq[0]]
for i in range(1, n):
    a_seq.append(b_seq[i]*(i+1)-sum(a_seq))
for a in a_seq:
    print(a, end=' ')