def solution(edges):
    answer = [0, 0, 0, 0]
    
    nodeCnt = {}
    
    for s, e in edges:
        if not nodeCnt.get(s):
            nodeCnt[s] = [0, 0]
        if not nodeCnt.get(e):
            nodeCnt[e] = [0, 0]

        nodeCnt[s][0] += 1
        nodeCnt[e][1] += 1
    
    for key, node in nodeCnt.items():

        if node[0] >= 2 and node[1] == 0:
            answer[0] = key
        elif node[0] == 0 and node[1] > 0:
            answer[2] += 1
        elif node[0] >= 2 and node[1] >= 2:
            answer[3] += 1
            
    answer[1] = (nodeCnt[answer[0]][0] - answer[2] - answer[3])

    return answer