def add(a, b):
    return a +b

def sum(lst):
    return reduce(lst, add, 0)

def reduce(lst, add, index):
    if (len(lst) - index) == 1:
        return lst[index]
    elif (len(lst) - index) == 2:
        return add(lst[index], lst[index + 1])
    else:
        return add(add(lst[index], lst[index+1]), reduce(lst, add, index + 2))

if __name__ == "__main__":
    print(sum([1,2,3,4,5]))