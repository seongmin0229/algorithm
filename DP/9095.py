import sys

T = int(sys.stdin.readline())

n_list = [int(sys.stdin.readline()) for _ in range(T)]

for n in n_list:
    DP = [0] * (n + 1)
    DP[1] = 1
    if n > 1:
        DP[2] = 2
    if n > 2:
        DP[3] = 4
    if n > 3:
        for i in range(4, n + 1):
            DP[i] = DP[i - 1] + DP[i - 2] + DP[i - 3]
    print(DP[n])
