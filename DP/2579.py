import sys

n = int(sys.stdin.readline())

stairs = [int(sys.stdin.readline()) for _ in range(n)]

DP = [[0] * n for _ in range(2)]

DP[0][0] = stairs[0]
DP[1][0] = stairs[0]

if n > 1:
    DP[0][1] = stairs[1]
    DP[1][1] = DP[1][0] + stairs[1]

if n > 2:
    for i in range(2, n):
        DP[0][i] = max(DP[0][i - 2], DP[1][i - 2]) + stairs[i]
        DP[1][i] = DP[0][i - 1] + stairs[i]

print(max(DP[0][n - 1], DP[1][n - 1]))
