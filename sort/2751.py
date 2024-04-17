import sys

n = int(sys.stdin.readline())

numbers = [int(sys.stdin.readline()) for _ in range(n)]

numbers.sort()

for num in numbers:
    print(num)
