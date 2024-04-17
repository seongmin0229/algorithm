import sys

n = int(sys.stdin.readline())

numbers = [int(sys.stdin.readline()) for _ in range(n)]


def heapify(arr):
    for i in range(len(arr)):
        c = len(arr) - i - 1
        swap_idx = c
        while c != 0:
            r = (c - 1) // 2  # r = 0, 0,..... 부모노드의 index
            if arr[r] < arr[c]:  # arr[0] < arr[1]
                arr[r], arr[c] = arr[c], arr[r]
            c = c - 1
        arr[0], arr[swap_idx] = arr[swap_idx], arr[0]


heapify(numbers)

for num in numbers:
    print(num)
