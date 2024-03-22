def solution(topping):
    answer = 0
    topA = {}
    topB = {}
    
    topA[topping[0]] = 1
    for i in range(1, len(topping)):
        if topB.get(topping[i]) == None:
            topB[topping[i]] = 1
        else:
            topB[topping[i]] += 1
    if len(topA) == len(topB):
        answer += 1
    
    for i in range(1, len(topping)):
        topB[topping[i]] -= 1
        if topB[topping[i]] == 0:
            del topB[topping[i]]
        if topA.get(topping[i]) == None:
            topA[topping[i]] = 1
        else:
            topA[topping[i]] += 1
        if len(topA) == len(topB):
            answer += 1
    
    return answer