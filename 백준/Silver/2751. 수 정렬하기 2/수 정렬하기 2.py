import sys

t = int(input())
nums = []
for i in range(t):
    num = int(sys.stdin.readline())
    nums.append(num)
nums.sort()
print('\n'.join(map(str, nums)))