def solution(elements):
    answer = 0
    
    dic = {}
    
    for i in range(1, len(elements)):
        s = 0
        e = i
        snum = sum(elements[:i])
        dic.setdefault(snum, 0)
        for j in range(len(elements) - 1):
            snum -= elements[s]
            snum += elements[e]
            dic.setdefault(snum, 0)
            s += 1
            e = (e + 1) % len(elements)
    answer = len(dic) + 1
    return answer