from collections import deque

def solution(numbers):
    answer = [-1] * len(numbers)
    s = deque()
    
    for i, n in enumerate(numbers):
        while True:
            if not s or s[-1][0] >= n:
                s.append([n, i])
                break
            else:
                tn, ti = s.pop()
                answer[ti] = n
    
    return answer