import sys

n = list(sys.stdin.readline())

n.pop()

n = list(map(int, n))

DP = [[0] * len(n) for _ in range(2)]

if n[0] != 0:
    DP[0][0] = 1
    DP[1][0] = 0

if len(n) > 1:
    if n[1] == 0:
        if 1 <= n[0] <= 2:
            DP[1][1] = DP[0][0]
            DP[0][1] = 0
        else:
            DP[1][1] = 0
            DP[0][1] = 0
    else:
        DP[0][1] = DP[0][0] + DP[1][0]
        if (n[1] <= 6 and n[0] == 2) or (n[1] <= 9 and n[0] == 1):
            DP[1][1] = 1

if len(n) > 2:
    for i in range(2, len(n)):
        if n[i] == 0:
            if 1 <= n[i - 1] <= 2:
                DP[0][i] = 0
                DP[1][i] = DP[0][i - 1]
            else:
                DP[0][i] = 0
                DP[1][i] = 0
        else:
            DP[0][i] = DP[0][i - 1] + DP[1][i - 1]
            if (n[i] <= 6 and n[i - 1] == 2) or (n[i] <= 9 and n[i - 1] == 1):
                DP[1][i] = DP[0][i - 2] + DP[1][i - 2]
            else:
                DP[1][i] = 0

print((DP[0][len(n) - 1] + DP[1][len(n) - 1]) % 1000000)

# 못풀겟어요
