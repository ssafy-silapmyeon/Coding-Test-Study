from collections import deque
import math

def solution(progresses, speeds):
    answer = []
    
    q = deque()
    
    for i in range(len(progresses)):
        q.appendleft(math.ceil((100 - progresses[i]) / speeds[i]))
    
    count = 0
    stan = q[-1]
    while q:
        num = q.pop()
        if num <= stan:
            count += 1
        else:
            answer.append(count)
            count = 1
            stan = num
    answer.append(count)
    
    return answer