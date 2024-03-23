import sys

n = int(sys.stdin.readline())

DP = [[0 for _ in range(n + 1)] for _ in range(10)]


for i in range(10):
    DP[i][1] = 1

DP[0][1] = 0

if n > 1:
    for i in range(2, n + 1):
        for j in range(10):
            if j == 0:
                DP[j][i] = DP[j + 1][i - 1]
            elif j == 9:
                DP[j][i] = DP[j - 1][i - 1]
            else:
                DP[j][i] = DP[j - 1][i - 1] + DP[j + 1][i - 1]

sum = 0

for i in range(10):
    sum += DP[i][n]

print(sum % 1000000000)
