import sys

def rotation(arr, n, m, cnt, r):
    for i in range(r):
        for j in range(cnt):
            tmp = arr[j][j]
            # 위
            for k in range(j, m - j - 1):
                arr[j][k] = arr[j][k+1]
            # 오른쪽
            for k in range(j, n - j - 1):
                arr[k][m-j-1] = arr[k+1][m-j-1]
            # 아래
            for k in range(m - j - 1, j, -1):
                arr[n-j-1][k] = arr[n-j-1][k-1]
            # 왼쪽
            for k in range(n - j - 1, j, -1):
                arr[k][j] = arr[k-1][j]
                
            arr[j+1][j] = tmp
    return arr

n, m, r = map(int, sys.stdin.readline().split())

arr = []

for i in range(n):
    tmp = list(map(int, sys.stdin.readline().split()))
    arr.append(tmp)

# 안쪽 돌릴 횟수
cnt = min(n, m) // 2
arr = rotation(arr, n, m, cnt, r)

for i in range(len(arr)):
    for j in range(len(arr[i])):
        print(arr[i][j], end = " ")
    print()