from itertools import combinations

def perm(dice, dlist, cnt, sum, arr):
    if cnt == len(dice) // 2:
        arr.append(sum)
        return
    for i in range(6):
        perm(dice, dlist, cnt + 1, sum + dice[dlist[cnt]][i], arr)
        
    

def solution(dice):
    answer = []
    m = -1
    
    ll = len(dice)
    
    dice_list = [i for i in range(ll)]
    comb = combinations(dice_list, ll // 2)
    
    for c in comb:
        arrA = []
        arrB = []
        adice = list(c)
        bdice = []
        for i in range(ll):
            if i not in adice:
                bdice.append(i)
        perm(dice, adice, 0, 0, arrA)
        perm(dice, bdice, 0, 0, arrB)
        arrA.sort()
        arrB.sort()
        i = 0
        sum = 0
        s = 0
        while i != len(arrA):
            while s != len(arrB) and arrA[i] > arrB[s]:
                s += 1
            sum += s
            i += 1
        if m < sum:
            m = sum
            answer = [i + 1 for i in adice]
    
    return answer