import sys
nums = []
for i in range(10):
    nums.append(int(sys.stdin.readline())%42)
print(len(set(nums)))