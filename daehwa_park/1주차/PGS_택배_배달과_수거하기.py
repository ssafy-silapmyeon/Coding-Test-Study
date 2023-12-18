def solution(cap, n, deliveries, pickups):
    answer = 0
    index = n - 1

    for i in range(n - 1, -1, -1):
        index = i
        if deliveries[i] > 0 or pickups[i] > 0:
            break

    curd = 0
    curp = 0
    for i in range(n - 1, -1, -1):
        curd += deliveries[i]
        curp += pickups[i]

        while curd > cap or curp > cap:
            curd -= cap
            curp -= cap
            answer += (index + 1) * 2
            index = i

    if curd != 0 and curp != 0:
        answer += (index + 1) * 2

    return answer