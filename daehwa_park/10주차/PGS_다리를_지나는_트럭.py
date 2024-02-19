from collections import deque

def solution(bridge_length, weight, truck_weights):
    time = 0
    bridge_w = 0
    
    q = deque()
    
    while True:
        if truck_weights and bridge_w + truck_weights[0] <= weight:
            cur = truck_weights.pop(0)
            q.append([cur, 0])
            bridge_w += cur
        for c in q:
            c[1] += 1
        if q[0][1] == bridge_length:
            w, cnt = q.popleft()
            bridge_w -= w
        time += 1
        if not q and not truck_weights:
            break
    
    return time + 1