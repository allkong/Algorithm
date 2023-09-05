import sys
input = sys.stdin.readline

def moo(total, mid, n):
    if n <= 3:
        return 'moo'[n-1]
    
    left = (total - mid) // 2
    
    if n <= left:
        return moo(left, mid - 1, n)

    elif n > left + mid:
        return moo(left, mid - 1, n - left - mid)

    if n - left == 1:
        return 'm'
    else:
        return 'o'
    
n = int(input())
total = 3
k = 0

while total < n:
    k += 1
    total = 2 * total + k + 3

print(moo(total, k + 3, n))