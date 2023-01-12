grade = 'FFFFFFDCBAA'
score = int(input())

if score == 0:
    print('F')
else:
    print(grade[score//10])