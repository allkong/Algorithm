T = int(input())
k = [2, 3, 5, 7, 11]

def cal(n):
    ans = [0, 0, 0, 0, 0]
    i = 0
    while i < 5:
        if n % k[i] == 0:
            n //= k[i]
            ans[i] += 1
        else:
            i += 1
    return ans

for i in range(1, T+1):
    n = int(input())
    ans = cal(n)
    print('#%d' % i, *ans)