import sys

n = int(sys.stdin.readline())

people = []

for _ in range(n):
    x, y = sys.stdin.readline().split()
    people.append((int(x), y))

people.sort(key=lambda x: x[0])

for person in people:
    print(f"{person[0]} {person[1]}")
