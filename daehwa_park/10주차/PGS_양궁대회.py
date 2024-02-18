nmax = 0
ans = [-1]

def solution(n, info):
    global ans
    
    ret = [0 for _ in range(11)]
    dfs(info, n, ret, 0)
    answer = ans
    
    return answer

def dfs(info, n, ret, cnt):
    global nmax, ans
    if n == 0 or cnt == 11:
        #계산
        ap = 0
        li = 0
        for i in range(11):
            if ret[i] == 0 and info[i] == 0: # 둘다 못맞힘
                continue
            elif ret[i] > info[i]: # 라이언 승
                li += 10 - i
            else: # 어피치 승
                ap += 10 - i
        if nmax < li - ap:
            nmax = li - ap
            ans = ret[:]
        elif nmax and nmax == li - ap:
            for i in range(10, -1, -1):
                if ret[i] == ans[i]:
                    continue
                elif ret[i] > ans[i]:
                    ans = ret[:]
                    break
                else:
                    break
        return
    
    if cnt == 10:
        ret[cnt] = n
        dfs(info, 0, ret, cnt + 1)
    elif n >= info[cnt] + 1:
        ret[cnt] = info[cnt] + 1
        dfs(info, n - (info[cnt] + 1), ret, cnt + 1) # 이겨
    ret[cnt] = 0
    dfs(info, n, ret, cnt + 1) # 져