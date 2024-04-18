from collections import deque

def solution(storey):
    answer = 0
    
    slist = []
    while storey != 0:
        slist.append(storey % 10)
        storey = storey // 10
    
    for i, num in enumerate(slist):
        if num > 5:
            answer += 10 - num
            if i == len(slist) - 1:
                answer += 1
            else: 
                slist[i + 1] += 1
        elif num < 5:
            answer += num
        else:
            if i != len(slist) - 1 and slist[i + 1] > 4:
                answer += 5
                slist[i + 1] += 1
            elif i != len(slist) - 1 and slist[i + 1] <= 4:
                answer += 5
            else:
                answer += 5
                
    return answer