def solution(triangle):
    answer = 0
    lt = len(triangle)
    dp = [[-1 for _ in range(lt)] for _ in range(lt)]
    dp[0][0] = triangle[0][0]
    
    for i in range(1, lt):
        for j in range(lt):
            if dp[i - 1][j - 1] == -1 and dp[i - 1][j] == -1:
                break
            if j - 1 < 0:
                dp[i][j] = dp[i - 1][j] + triangle[i][j]
            elif dp[i - 1][j] == -1:
                dp[i][j] = dp[i - 1][j - 1] + triangle[i][j]
            else:
                dp[i][j] = max(dp[i - 1][j] + triangle[i][j], dp[i - 1][j - 1] + triangle[i][j])
    
    answer = max(dp[-1])
    
    return answer