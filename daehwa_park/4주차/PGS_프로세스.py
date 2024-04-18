from collections import deque

def solution(priorities, location):
    answer = 0
    p = deque(priorities)
    sorted_prior = sorted(priorities, reverse=True)
    
    count = 1
    while p:
        cur = p.popleft()
        if sorted_prior[0] == cur:
            if location == 0:
                answer = count
                break
            else:
                sorted_prior.remove(sorted_prior[0])
                location -= 1
                
            count += 1
        else:
            p.append(cur)
            if location == 0:
                location = len(p) - 1
            else:
                location -= 1
        
    return answer