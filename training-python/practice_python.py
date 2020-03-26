import timeit
if __name__ == "__main__":
    a = {0:1, 1:3, 2:4, 3:2, 4:2, 5:2, 6:0, 7:1, 8:1, 9:1, 10:2}
    b = [0,1,2,3,4,5,6,7,8,9,10]

    start = timeit.default_timer()
    print(20 in a.keys())
    print(timeit.default_timer() - start)

    start = timeit.default_timer()
    print(20 in b)
    print(timeit.default_timer() - start)