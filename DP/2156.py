import sys

n = int(sys.stdin.readline())

wines = [0] * (n + 1)

for i in range(n):
    wines[i + 1] = int(sys.stdin.readline())

DP = [[0] * (n + 1) for _ in range(3)]

DP[0][1] = 0
DP[1][1] = 0
DP[2][1] = wines[1]

if n > 1:
    DP[0][2] = wines[1]
    DP[1][2] = wines[2]
    DP[2][2] = DP[2][1] + wines[2]

if n > 2:
    for i in range(3, n + 1):
        DP[0][i] = max(DP[1][i - 1], DP[2][i - 1])
        DP[0][i] = max(DP[0][i - 1], DP[0][i])
        DP[1][i] = DP[0][i - 1] + wines[i]
        DP[2][i] = DP[1][i - 1] + wines[i]

ans = max(DP[0][n], DP[1][n])
ans = max(DP[2][n], ans)

print(ans)
