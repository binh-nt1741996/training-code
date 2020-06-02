"""
Q1
Write a program which will find all such numbers 
which are divisible by 7 but are not a multiple of 5,
between 2000 and 3200 (both included).
The numbers obtained should be printed in a 
comma-separated sequence on a single line.

"""
def Q1(left, right):
    arr = range(left, right + 1)
    return [x for x in arr if (x%7 == 0) and (x%5 != 0)]


if __name__ == "__main__":
    arr_input = list(map(int, input("Enter the range for the array: ").split(", ")))
    result = Q1(arr_input[0], arr_input[1])
    print(",".join(map(str, result)))

"""
Q2
Write a program which can compute the factorial 
of a given numbers.The results should be printed 
in a comma-separated sequence on a single line.
Suppose the following input is supplied to the 
program: 8 Then, the output should be:40320


def Q2(num):
    if (num == 0 or num == 1):
        return 1
    else:
        return num * Q2(num - 1)


if __name__ == "__main__":
    num_input = int(input("Enter an integer: "))
    print(f"The factorial of {num_input} is {Q2(num_input)}")
"""

"""
Q3:
With a given integral number n, write a program 
to generate a dictionary that contains (i, i x i) 
such that is an integral number between 1 and n 
(both included). and then the program should print 
the dictionary.

def Q3(num):
    return {i : i**2 for i in range(1, num)}

if __name__ == "__main__":
    num_input = int(input("Enter an integer: "))
    print(Q3(num_input))
"""

"""
---------- Q4 ----------
Write a program which accepts a sequence of 
comma-separated numbers from console and 
generate a list and a tuple which contains 
every number.

def Q4(str_input):
    return str_input.split(","), tuple(str_input.split(","))

if __name__ == "__main__":
    str_input = input("Enter a string including many integers: ")
    list_ver, tuple_ver = Q4(str_input)
    print(f"{list_ver}\n{tuple_ver}")
"""

"""
---------- Q5 ----------
Define a class which has at least two methods:

getString: to get a string from console input
printString: to print the string in upper case.
Also please include simple test function to test
 the class methods.

class Q5():
    def __init__(self):
        pass


    def getString(self):
        self.s = input("Enter a string: ")


    def printString(self):
        print(f"{self.s.upper()}")

if __name__ == "__main__":
    strStr = Q5()
    strStr.getString()
    strStr.printString()
"""

"""
---------- Q6 ----------
Write a program that calculates and prints the value according to the given formula:

Q = Square root of [(2 * C * D)/H]

Following are the fixed values of C and H:

C is 50. H is 30.

import math

class Q6:
    #Declare two fixed values
    const1, const2 = 0, 0

    def __init__(self, fix1, fix2):
        self.const1 = fix1
        self.const2 = fix2
    
    def __str__(self):
        print("This is question 6.")
    
    def myfunc(self, arr):
        func = lambda n : math.sqrt((2 * self.const1 * n) / self.const2)
        return list(map(func, arr))
        #[math.floor(func(x)) for x in arr]
    
if __name__ == "__main__":
    arr_input = list(map(int, input("Enter a list of integers: ").split(", ")))
    #With const1 = 50, const2 = 30
    ans1 = Q6(50, 30)
    print(ans1.myfunc(arr_input))
"""

"""
---------- Q7 ----------
Write a program which takes 2 digits, 
X,Y as input and generates a 2-dimensional array. 
The element value in the i-th row and j-th column of
 the array should be i * j.
"""
"""
if __name__ == "__main__":
    x, y = list(map(int, input("Enter two dimensions for array: ").split(" ")))
    arr = [[i * j for j in range(y)] for i in range(x)]
    print(arr)
"""
"""
Daily Coding Problem
"""
"""
def func(arr, key, i, counter):
    if (i >= len(arr) or counter > 3):
        return False
    if (key < arr[i]):
        return func(arr, key, i + 1, counter)
    if (counter + 1 == 3 and i <= len(arr) and key == arr[i]):
        return True
    return func(arr, key - arr[i], i + 1, counter + 1) or func(arr, key, i + 1, counter)
        
if __name__ == "__main__":
    counter = 0
    key = 327
    arr = [20, 303, 3, 4, 25]
    print(func(arr, key, 0, counter))
"""
