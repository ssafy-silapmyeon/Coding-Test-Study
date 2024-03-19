from collections import deque

def solution(prices):
    answer = [0] * len(prices)
    s = deque()
    
    time = 0
    for i, p in enumerate(prices):
        if not s:
            s.append([p, i])
        else:
            while s and s[-1][0] > p:
                cp, ci = s.pop()
                answer[ci] = time - ci
            s.append([p, i])
        time += 1
    
    while s:
        cp, ci = s.pop()
        answer[ci] = time - ci - 1
    
    return answer