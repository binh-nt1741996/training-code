import numpy as np
import matplotlib.pyplot as plt
import math as m 
import timeit

def brute_force(arr):
    n = len(arr)
    max_value = -1_000_000

    for i in range(n-1):                                #Loop through array from index 0 to n-2
        total = arr[i]
        for j in range(i+1, n):                         #Loop through array from index 1 to n-1
            total = total + arr[j]                      #Accumulate the sum while looping
            if (total > max_value): 
                left_index = i                          #Starting index of max-subarray
                right_index = j                         #Ending index of max-subarray
                max_value = total
    return left_index, right_index, max_value

def find_max_crossing(arr, low, mid, high):             #Find a maximum subarray crossing the midpoint
    left_sum = -1000000
    right_sum = -1000000
    total, max_left, max_right = 0, 0, 0
    
    for i in range(mid, low - 1, -1):                   
        total = total + arr[i]
        if (total > left_sum):
            left_sum = total                            #Hold the max sum on left-side
            max_left = i                                #Update the index which max sum is hold
    total = 0
    for j in range(mid + 1, high):
        total = total + arr[j]
        if (total > right_sum):
            right_sum = total                           #Hold the max sum on right-side
            max_right = j                               #Update the index which max sum is hold
    return (max_left, max_right, left_sum + right_sum)  #Return two terminals and the max sum crossing the midpoint

def find_max_subarray(arr, low, high):                  #Find a maximum subarray of the array
    if (low == high):
        return (low, high, arr[high-1])
    else:
        mid = m.floor((low + high)/2)
        
        #Respectively find a maximum subarray on the left side, right side and crossing the midpoint
        left_low, left_high, left_sum = find_max_subarray(arr, low, mid)
        right_low, right_high, right_sum = find_max_subarray(arr, mid+1, high)
        cross_low, cross_high, cross_sum = find_max_crossing(arr, low, mid, high)

        #Find the greatest sum amongst three parts
        if max(left_sum, right_sum, cross_sum) == left_sum:
            return (left_low, left_high, left_sum)
        elif max(left_sum, right_sum, cross_sum) == right_sum:
            return (right_low, right_high, right_sum)
        else:
            return (cross_low, cross_high, cross_sum)
if __name__ == "__main__":
    plt.style.use("fivethirtyeight")

    #create empty array containing time for bruteFroce and recursive
    bruteForceTime, recurTime = [], []
    for i in range(2,50):
        #generate random array for implement algorithm
        arrIn = np.random.randint(-20, 20, size = i)

        #start counting time for brute force method
        starttime = timeit.default_timer()
        left, right, max_value = brute_force(arrIn)
        bruteForceTime.append(timeit.default_timer() - starttime)

        #start counting time for recursive method
        starttime = timeit.default_timer()
        left, right, max_value = find_max_subarray(arrIn, 0, len(arrIn))
        recurTime.append(timeit.default_timer() - starttime)
    
    #plotting
    plt.plot(np.arange(2,50), bruteForceTime, label="Brute Force")
    plt.plot(np.arange(2,50), recurTime, label="Recursive")
    
    plt.legend()
    plt.title("Brute Force vs Recursive Method")
    plt.yscale("log")
    plt.tight_layout()
    plt.show()

