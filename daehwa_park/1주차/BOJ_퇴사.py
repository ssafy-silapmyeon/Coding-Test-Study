import sys

def sol(day, price):
    global ans
    ans = max(ans, price)
    if day == n:
        return

    if day + arr[day][0] <= n:
        sol(day + arr[day][0], price + arr[day][1])
    if day + 1 <= n:
        sol(day + 1, price)

ans = 0

n = int(sys.stdin.readline())

arr = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

sol(0, 0)

print(ans)
