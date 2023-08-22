nums = list(map(int, input().split()))
print("Good") if nums == sorted(nums) else print("Bad")