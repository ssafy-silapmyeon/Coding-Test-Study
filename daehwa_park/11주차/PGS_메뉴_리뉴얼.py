from itertools import combinations

def solution(orders, course):
    answer = []
    menu = {}
    
    for c in course:
        for order in orders:
            if len(order) >= c:
                comb = list(combinations(order, c))
                for co in comb:
                    sortco = sorted(co)
                    m = ''.join(sortco)
                    if menu.get(m) == None:
                        menu[m] = 1
                    else:
                        menu[m] += 1
        if menu:
            max_cnt = max(menu.values())
            for k, v in menu.items():
                if v >= 2 and v == max_cnt:
                    answer.append(k)
            menu.clear()
        
    answer.sort()
    
    return answer