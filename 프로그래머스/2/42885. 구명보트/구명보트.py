from collections import deque

def solution(people, limit):
    answer = 0
    people = deque(sorted(people, reverse=True))
    
    while len(people) > 1:
        answer += 1
        if people.popleft() + people[-1] <= limit:
            people.pop()
    return answer + 1 if people else answer