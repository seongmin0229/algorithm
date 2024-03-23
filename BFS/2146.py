# 문제
# 여러 섬으로 이루어진 나라가 있다. 이 나라의 대통령은 섬을 잇는 다리를 만들겠다는 공약으로 인기몰이를 해 당선될 수 있었다. 하지만 막상 대통령에 취임하자, 다리를 놓는다는 것이 아깝다는 생각을 하게 되었다. 그래서 그는, 생색내는 식으로 한 섬과 다른 섬을 잇는 다리 하나만을 만들기로 하였고, 그 또한 다리를 가장 짧게 하여 돈을 아끼려 하였다.

# 이 나라는 N×N크기의 이차원 평면상에 존재한다. 이 나라는 여러 섬으로 이루어져 있으며, 섬이란 동서남북으로 육지가 붙어있는 덩어리를 말한다. 다음은 세 개의 섬으로 이루어진 나라의 지도이다.


# 위의 그림에서 색이 있는 부분이 육지이고, 색이 없는 부분이 바다이다. 이 바다에 가장 짧은 다리를 놓아 두 대륙을 연결하고자 한다. 가장 짧은 다리란, 다리가 격자에서 차지하는 칸의 수가 가장 작은 다리를 말한다. 다음 그림에서 두 대륙을 연결하는 다리를 볼 수 있다.


# 물론 위의 방법 외에도 다리를 놓는 방법이 여러 가지 있으나, 위의 경우가 놓는 다리의 길이가 3으로 가장 짧다(물론 길이가 3인 다른 다리를 놓을 수 있는 방법도 몇 가지 있다).

# 지도가 주어질 때, 가장 짧은 다리 하나를 놓아 두 대륙을 연결하는 방법을 찾으시오.

# 입력
# 첫 줄에는 지도의 크기 N(100이하의 자연수)가 주어진다. 그 다음 N줄에는 N개의 숫자가 빈칸을 사이에 두고 주어지며, 0은 바다, 1은 육지를 나타낸다. 항상 두 개 이상의 섬이 있는 데이터만 입력으로 주어진다.

# 출력
# 첫째 줄에 가장 짧은 다리의 길이를 출력한다.

import sys
from collections import deque

n = int(sys.stdin.readline())

field = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
visit = [[0] * n for _ in range(n)]

r_delta = [0, 0, 1, -1]
c_delta = [1, -1, 0, 0]

queue = deque()
country_boundary_set = set()


def bfs_split(country_num):
    while queue:
        r, c = queue.popleft()
        field[r][c] = country_num
        for i in range(4):
            next_r = r + r_delta[i]
            next_c = c + c_delta[i]
            if 0 <= next_r < n and 0 <= next_c < n:
                if visit[next_r][next_c] == 0 and field[next_r][next_c] == 1:
                    queue.append([next_r, next_c])
                    visit[next_r][next_c] = 1
                if field[next_r][next_c] == 0:
                    country_boundary_set.add((r, c))


country_num = 1

for i in range(n):
    for j in range(n):
        if field[i][j] == 1 and visit[i][j] == 0:
            country_num += 1
            queue.append([i, j])
            bfs_split(country_num)

result_set = []


def bfs_result(country_num):
    while queue:
        r, c, distance = queue.popleft()
        visit[r][c] = 1
        for i in range(4):
            next_r = r + r_delta[i]
            next_c = c + c_delta[i]
            if 0 <= next_r < n and 0 <= next_c < n:
                if field[next_r][next_c] == 0 and visit[next_r][next_c] == 0:
                    queue.append([next_r, next_c, distance + 1])
                elif (
                    field[next_r][next_c] != 0 and field[next_r][next_c] != country_num
                ):
                    result_set.append(distance)


for country_boundary in country_boundary_set:
    visit = [[0] * n for _ in range(n)]
    queue.append([country_boundary[0], country_boundary[1], 0])
    bfs_result(field[country_boundary[0]][country_boundary[1]])

print(min(result_set))
