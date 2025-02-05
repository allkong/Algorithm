n = int(input())
isContain = '7' in str(n)
isDivisible = n % 7 == 0
# Print 0 if the number does not contain 7 and is not divisible by 7.
if not isContain and not isDivisible:
    print(0)
# Print 1 if the number does not contain 7 but is divisible by 7.
elif not isContain and isDivisible:
    print(1)
# Print 2 if the number does contain 7 but is not divisible by 7.
elif isContain and not isDivisible:
    print(2)
# Print 3 if the number does contain 7 and is divisible by 7.
else:
    print(3)