# 문제
# 길이가 N인 수열이 주어졌을 때, 그 수열의 합을 구하려고 한다. 하지만, 그냥 그 수열의 합을 모두 더해서 구하는 것이 아니라, 수열의 두 수를 묶으려고 한다. 어떤 수를 묶으려고 할 때, 위치에 상관없이 묶을 수 있다. 하지만, 같은 위치에 있는 수(자기 자신)를 묶는 것은 불가능하다. 그리고 어떤 수를 묶게 되면, 수열의 합을 구할 때 묶은 수는 서로 곱한 후에 더한다.

# 예를 들면, 어떤 수열이 {0, 1, 2, 4, 3, 5}일 때, 그냥 이 수열의 합을 구하면 0+1+2+4+3+5 = 15이다. 하지만, 2와 3을 묶고, 4와 5를 묶게 되면, 0+1+(2*3)+(4*5) = 27이 되어 최대가 된다.

# 수열의 모든 수는 단 한번만 묶거나, 아니면 묶지 않아야한다.

# 수열이 주어졌을 때, 수열의 각 수를 적절히 묶었을 때, 그 합이 최대가 되게 하는 프로그램을 작성하시오.

# 입력
# 첫째 줄에 수열의 크기 N이 주어진다. N은 50보다 작은 자연수이다. 둘째 줄부터 N개의 줄에 수열의 각 수가 주어진다. 수열의 수는 -1,000보다 크거나 같고, 1,000보다 작거나 같은 정수이다.

# 출력
# 수를 합이 최대가 나오게 묶었을 때 합을 출력한다. 정답은 항상 231보다 작다.

# 해결방안
# 그냥 내림차순으로 정렬하고..위에서부터 두 수씩 묶어서 곱하다가 1이하인 수부터 안 묶으면 되지 않을까 하는 생각(양수)
# 음수와 양수 리스트를 분리해주었다.
# 음수는 -1도 곱해주는게 이득이다.
# 0은 음수리스트에 포함시켜준다.
# 이러면 음수리스트는 그냥 무조건 맞는 놈들은 다 묶어주는게 이득이다.

import sys

n = int(sys.stdin.readline())

num_list = [int(sys.stdin.readline()) for x in range(n)]


positive_list = []
negative_list = []

for i in range(len(num_list)):
    if num_list[i] > 0:
        positive_list.append(num_list[i])
    else:
        negative_list.append(num_list[i])

positive_list.sort(reverse=True)
negative_list.sort()

sum = 0
positive_result_list = []
negative_result_list = []

if len(positive_list) != 0:
    temp = 0
    for i in positive_list:
        if i <= 1:
            positive_result_list.append(i)
        else:
            if temp == 0:
                temp = i
            else:
                positive_result_list.append(temp * i)
                temp = 0
    if temp != 0:
        positive_result_list.append(temp)
    for i in positive_result_list:
        sum += i

if len(negative_list) != 0:
    temp = 1
    for i in negative_list:
        if temp == 1:
            temp = i
        else:
            negative_result_list.append(temp * i)
            temp = 1
    if temp != 1:
        negative_result_list.append(temp)
    for i in negative_result_list:
        sum += i

print(sum)
