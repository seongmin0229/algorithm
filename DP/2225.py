import sys

n, k = map(int, sys.stdin.readline().split())

DP = [[0] * (k + 1) for _ in range(n + 1)]

for i in range(1, n + 1):
    DP[i][1] = 1

if k > 1:
    for i in range(1, n + 1):
        DP[i][2] = i + 1

for i in range(1, k + 1):
    DP[0][i] = 1

if k > 2:
    for i in range(3, k + 1):
        for j in range(1, n + 1):
            for l in range(j + 1):
                DP[j][i] += DP[l][i - 1]

print(DP[n][k] % 1000000000)
