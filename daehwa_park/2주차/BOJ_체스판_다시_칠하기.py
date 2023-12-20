import sys

n, m = map(int, sys.stdin.readline().split())

board = [list(sys.stdin.readline().strip()) for _ in range(n)]

min_num = 1000000
for k in range(n - 7):
    for l in range(m - 7):
        for p in range(2):
            count = 0
            for i in range(k, k + 8):
                for j in range(l, l + 8):
                    if p == 0: # W 시작
                        if (i % 2 == j % 2 and board[i][j] == 'B') or (i % 2 != j % 2 and board[i][j] == 'W'):
                            count += 1
                    else: # B 시작
                        if (i % 2 == j % 2 and board[i][j] == 'W') or (i % 2 != j % 2 and board[i][j] == 'B'):
                            count += 1
            min_num = min(min_num, count)

print(min_num)
