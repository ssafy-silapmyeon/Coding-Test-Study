from itertools import product

def solution(users, emoticons):
    answer = [0, 0]
    
    l_em = len(emoticons)
    
    em_discount = [[i * j // 10 for i in range(9, 5, -1)] for j in emoticons]
    
    for discounts in product([40, 30, 20, 10], repeat = l_em):
        subscriber = 0
        profit = 0
        
        for user in users:
            user_profit = 0
            
            for i in range(l_em):
                if discounts[i] >= user[0]:     # 할인율이 유저의 구매 허용 비율보다 높다면
                    user_profit += em_discount[i][discounts[i] // 10 - 1]     # 할인된 금액을 넣음
                    
            if user_profit >= user[1]:
                subscriber += 1
            else:
                profit += user_profit
        
        answer = max(answer, [subscriber, profit])
    
    return answer
  
  
print(solution([[40, 10000], [25, 10000]], 	[7000, 9000]))