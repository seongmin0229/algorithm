# 문제
# 어느 날, 미르코는 우연히 길거리에서 양수 N을 보았다. 미르코는 30이란 수를 존경하기 때문에, 그는 길거리에서 찾은 수에 포함된 숫자들을 섞어 30의 배수가 되는 가장 큰 수를 만들고 싶어한다.
# 미르코를 도와 그가 만들고 싶어하는 수를 계산하는 프로그램을 작성하라.

# 입력
# N을 입력받는다. N는 최대 10**5개의 숫자로 구성되어 있으며, 0으로 시작하지 않는다.

# 출력
# 미르코가 만들고 싶어하는 수가 존재한다면 그 수를 출력하라. 그 수가 존재하지 않는다면, -1을 출력하라.

# 해결방안
# 30의 배수이기 위해서는 1의 자리수가 0이어야하고, 나머지의 숫자들의 합이 3의 배수가 되어야 한다. 따라서 가장 큰 수부터 다음 큰수로 계속 탐색하다가 조건을 만족하는 순간 리턴 혹은 브레이크한다.
# 지금 생각해보니까 굳이 다음 큰수로 가면서 탐색할 필요가 없다.. 그냥 나머지 숫자합이 3의 배수가 되면, 그 수의 배열 중 가장 큰 배열을 찾기만 하면 된다
# numpy 쓰면 ModuleNotFound 에러가 나서 안쓰고 직접 sum해줌

# import numpy as np

n = input()

numbers = [int(x) for x in list(n)]

numbers.sort(reverse=True)

sum = 0

for num in numbers:
    sum += num

if 0 not in numbers or sum % 3 != 0:
    print(-1)
else:
    for num in numbers:
        print(num, end="")
