import math

def solution(fees, records):
    answer = []
    
    record_dict = {}
    
    car_list = [-1 for _ in range(10000)]
    
    # 기록에 맞게 계산
    for record in records:
        time, number, rec = record.split()
        h, m = map(int, time.split(":"))
        minute_time = h * 60 + m
        if rec == "IN":
            car_list[int(number)] = minute_time      
        else:
            result = minute_time - car_list[int(number)]
            record_dict[int(number)] = record_dict.get(int(number), 0) + result
            car_list[int(number)] = -1
            
    # 입차 후 출차 기록이 없는 차량
    last_time = 23 * 60 + 59
    for i, car in enumerate(car_list):
        if car != -1:
            record_dict[i] = record_dict.get(i, 0) + (last_time - car)
            
    # 주차 요금 계산
    sorted_list = dict(sorted(record_dict.items()))
    for k, v in sorted_list.items():
        money = 0
        if v <= fees[0]:
            money = fees[1]
        else:
            money = fees[1] + (math.ceil((v - fees[0]) / fees[2]) * fees[3])
        answer.append(money)
    
    return answer