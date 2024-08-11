import sys
input = sys.stdin.readline

test_case = int(input())
numbers = []

for _ in range(test_case):
    numbers.append(int(input()))
    
print(*sorted(numbers))