import sys
input = sys.stdin.readline

for i in range(3, 0, -1):
    x = input().rstrip()

    if x not in ['Fizz', 'Buzz', 'FizzBuzz']:
        x = int(x) + i
        print('Fizz' * (x % 3 == 0) + 'Buzz' * (x % 5 == 0) or x)
        break