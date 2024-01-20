# 문제
# 한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다. 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자. 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다. 회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.

# 입력
# 첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 시작 시간과 끝나는 시간은 231-1보다 작거나 같은 자연수 또는 0이다.

# 출력
# 첫째 줄에 최대 사용할 수 있는 회의의 최대 개수를 출력한다.

# 해결방안
# 일단 끝나는 시간으로 정렬하는 건 확실한 거 같은데...
# + 반례를 보니까.. 정렬을 일단 시작 시간으로 정렬하고 그 다음에 끝나는 시간으로 정렬해야함
# 일단 첫번째꺼를 고르고 그 다음에 첫번째의 끝나는 시간보다 시작시간이 큰 애들중에 끝나는 시간이 가장 작은 애를 고르면 된다.
# 그니까 그냥 바로 나오는 애가 가장 좋다는 거임.

import sys

n = int(sys.stdin.readline())

time_list = []

for i in range(n):
    start, end = map(int, sys.stdin.readline().split())
    time_list.append([start, end])

time_list.sort(key=lambda x: x[0])
time_list.sort(key=lambda x: x[1])

count = 0
end = -1
for i in range(len(time_list)):
    cur_start = time_list[i][0]
    if cur_start >= end:
        end = time_list[i][1]
        count += 1

print(count)
