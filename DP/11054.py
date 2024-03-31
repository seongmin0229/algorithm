import sys

n = int(sys.stdin.readline())

numbers = list(map(int, sys.stdin.readline().split(" ")))

DP = [[1] * n for _ in range(2)]

for i in range(n):
    for j in range(i):
        if numbers[i] > numbers[j]:
            DP[0][i] = max(DP[0][i], DP[0][j] + 1)
        elif numbers[i] < numbers[j]:
            DP[1][i] = max(DP[1][i], max(DP[0][j] + 1, DP[1][j] + 1))
        else:
            DP[0][i] = DP[0][j]
            DP[1][i] = DP[1][j]

print(max(max(DP[0]), max(DP[1])))
