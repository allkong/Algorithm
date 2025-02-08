import sys
input = sys.stdin.readline

def is_prime(target):
    global k
    
    for i in range(2, int(target ** 0.5) + 1):
        if target % i == 0:
            return False

    k -= 1
    return True

k = int(input())
i = 1

while k > 0:
    i += 1
    is_prime(i)

print(i)