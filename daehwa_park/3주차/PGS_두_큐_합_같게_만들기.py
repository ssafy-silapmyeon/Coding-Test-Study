from collections import deque

def solution(queue1, queue2):
    answer = -1
    
    q1, q2 = deque(queue1), deque(queue2)
    s1, s2 = sum(queue1), sum(queue2)
    max_count = len(queue1) * 3
    
    if (sum(queue1) + sum(queue2)) % 2 == 1:
        return -1
    
    for i in range(max_count):
        if s1 > s2:
            num = q1.popleft()
            q2.append(num)
            s1 -= num
            s2 += num
        elif s2 > s1:
            num = q2.popleft()
            q1.append(num)
            s2 -= num
            s1 += num
        else:
            return i
        
    
    return answer