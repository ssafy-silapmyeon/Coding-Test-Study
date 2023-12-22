sale = [10, 20, 30, 40]
max_arr = [0, 0]

def solution(users, emoticons): 
    result = [0 for _ in range(len(emoticons))]
    
    go(0, len(emoticons), users, emoticons, result)
    return max_arr

def go(cnt, dst, users, emoticons, result):
    global max_arr
    if cnt == dst:
        # 계산
        all_price = 0
        all_plus = 0
        for i,j in users:
            price = 0
            for d in range(len(emoticons)):
                if i <= result[d]:
                    price += emoticons[d] * (100 - result[d]) / 100
            if price >= j:
                all_plus += 1
            else:
                all_price += price
        max_arr = max(max_arr, [all_plus, all_price])
        return
    
    for i in sale:
        result[cnt] = i
        go(cnt + 1, dst, users, emoticons,result)