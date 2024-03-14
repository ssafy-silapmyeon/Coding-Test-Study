from collections import deque

def ttm(time):
    h, m = map(int, time.split(":"))
    t = (h * 60) + m
    return t

def solution(plans):
    answer = []
    
    plans.sort(key=lambda x : x[1])
    s = deque()
    
    for i in range(len(plans)):
        t = ttm(plans[i][1]) + int(plans[i][2]) # 과제 당 걸리는 시간
        if i != len(plans) - 1: # 마지막 과제가 아니라면
            nt = ttm(plans[i + 1][1])
            if t > nt: # 남은 과제가 있음
                s.append([plans[i][0], t - nt]) # 스택에 넣음
            elif t < nt: # 시간이 남음
                answer.append(plans[i][0])
                rt = nt - t
                while s and rt > 0:
                    sub, time = s.pop()
                    if time <= rt: 
                        answer.append(sub)
                        rt -= time
                    else:
                        time -= rt
                        rt = 0
                        s.append([sub, time])
            else:
                answer.append(plans[i][0])
        else:
            answer.append(plans[i][0])
    while s:
        ls, lt = s.pop()
        answer.append(ls)
    
    return answer