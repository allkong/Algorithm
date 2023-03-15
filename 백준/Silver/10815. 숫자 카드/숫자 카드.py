import sys
input = sys.stdin.readline

n = int(input())
cards = list(map(int, input().split()))
m = int(input())
nums = list(map(int, input().split()))
check = {string : 0 for string in cards}

for num in nums:
  if num in check:
    print(1, end=' ')
  else:
    print(0, end=' ')