import sys

T = int(sys.stdin.readline())

DP = [0] * 101

DP[1] = 1
DP[2] = 1
DP[3] = 1
DP[4] = 2
DP[5] = 2

for i in range(6, 101):
    DP[i] = DP[i - 1] + DP[i - 5]

for _ in range(T):
    n = int(sys.stdin.readline())
    print(DP[n])
