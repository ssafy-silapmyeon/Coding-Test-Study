import heapq

def solution(scoville, K):
    answer = 0
    
    heapq.heapify(scoville)
    
    while True:
        first = heapq.heappop(scoville)
        if first < K and len(scoville) > 0:
            second = heapq.heappop(scoville)
            mix = first + (second * 2)
            heapq.heappush(scoville, mix)
            answer += 1
        elif first < K and len(scoville) == 0:
            break
        else:
            return answer
        
    return -1