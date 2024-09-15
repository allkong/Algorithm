import sys
input = sys.stdin.readline

def prime_number(target):
    # 1은 소수가 아니다
    if target == 1:
        return False
    
    # 2부터 타겟의 제곱근까의 범위 중에 타겟의 약수가 있는지 찾는다
    for number in range(2, int(target ** 0.5) + 1):
        # 타겟이 나눠지는 값이 있다면 소수가 아니다
        if target % number == 0:
            return False

    return True

min, max = map(int, input().split())
for number in range(min, max + 1):
    if prime_number(number):
        print(number)