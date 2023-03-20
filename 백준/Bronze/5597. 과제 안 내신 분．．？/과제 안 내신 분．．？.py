students = [i for i in range(31)]

for i in range(28):
    students.remove(int(input()))

for i in range(1, len(students)):
    print(students[i])
