def solution(clothes):
    
    hmap = {}
    
    for n, t in clothes:
        if t not in hmap:
            hmap[t] = 1
        else:
            hmap[t] += 1
    
    count = 1
    
    for k in hmap:
        count *= (hmap[k] + 1)
    
    count -= 1
    
    return count
