def solution(k, dungeons):
    answer = -1

    visited = [False for _ in range(len(dungeons))]

    answer = perm(0, len(dungeons), k, visited, dungeons)

    return answer


def perm(cnt, dst, pi, visited, dungeons):  # cnt : 선택한 개수, dst : 최대 가능 개수, pi : 현재 피로도
    if cnt == dst:
        return cnt

    max_ans = cnt
    for i in range(dst):
        if not visited[i] and pi >= dungeons[i][0]:
            visited[i] = True
            max_ans = max(max_ans, perm(cnt + 1, dst, pi - dungeons[i][1], visited, dungeons))
            visited[i] = False
    return max_ans
