def solution(expression):
    oper = [["*", "+", "-"], ["*", "-", "+"], ["+", "*", "-"], ["+", "-", "*"], ["-", "*", "+"], ["-", "+", "*"]]
    m = -1
    
    numlist = []
    oplist = []
    idx = 0
    for i, e in enumerate(expression):
        if e == "+" or e == "-" or e == "*":
            numlist.append(int(expression[idx:i]))
            oplist.append(e)
            idx = i + 1
    numlist.append(int(expression[idx:len(expression)]))
    
    for op in oper:
        tempop = oplist[:]
        tempnum = numlist[:]
        for o in op:
            i = 0
            while i < len(tempop):
                if tempop[i] == o:
                    if o == "*":
                        s = tempnum[i] * tempnum[i + 1]
                    elif o == "+":
                        s = tempnum[i] + tempnum[i + 1]
                    else:
                        s = tempnum[i] - tempnum[i + 1]
                    del tempnum[i:i+2]
                    del tempop[i]
                    tempnum.insert(i, s)
                    i -= 1
                i += 1
        m = max(m, abs(tempnum[0]))
    
    return m