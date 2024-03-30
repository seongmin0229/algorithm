import sys

n = int(sys.stdin.readline())

numbers = list(map(int, sys.stdin.readline().split(" ")))

numbers.insert(0, 0)

DP = [0] * (n + 1)

DP[1] = 1
max_num = numbers[1]
max_idx = 1

if n > 1:
    for i in range(2, n + 1):
        if numbers[i] > numbers[i - 1]:
            DP[i] = DP[i - 1]
            max_num = numbers[i]
            max_idx = i
        elif max_num == numbers:
            DP[i] = DP[max_idx]
        elif numbers[i] > max_num:
            DP[i] = DP[max_idx] + 1
            max_num = numbers[i]
            max_idx = i
        else:
            DP[i] = 1

print(DP[n])
