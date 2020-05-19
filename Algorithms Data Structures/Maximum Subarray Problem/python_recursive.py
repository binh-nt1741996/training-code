"""
Using divide-and-conquer method to solve the problem
Complexity time: O[nlog(n)]
"""
import math as m 

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
    input_array = list(map(int, input("Enter a string to find the maximum subarray: ").split(" ")))
    max_subarray = find_max_subarray(input_array, 0, len(input_array))
    print("Maximum subarray starts from {0[0]} to {0[1]} with sum = {0[2]}".format(max_subarray))
