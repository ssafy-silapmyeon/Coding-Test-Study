def solution(book_time):
    answer = 0
    
    book_time.sort(key = lambda book_time : book_time[0])
    
    last_m = 0
    last_h = 0
    
    used = [False for _ in range(len(book_time))]
    
    while False in used:
        index = 0
        for i in range(len(used)):
            if not used[i]:
                index = i
                break
        last_h, last_m = map(int, book_time[index][1].split(":"))
        if last_m >= 50:
            last_m -= 50
            last_h += 1
        else:
            last_m += 10
        used[index] = True
        for i in range(len(book_time)):
            start_h, start_m = map(int, book_time[i][0].split(":"))
            if not used[i] and ((start_h == last_h and start_m >= last_m) or start_h > last_h):
                last_h, last_m = map(int, book_time[i][1].split(":"))
                if last_m >= 50:
                    last_m -= 50
                    last_h += 1
                else:
                    last_m += 10
                used[i] = True
        answer += 1
        
    return answer