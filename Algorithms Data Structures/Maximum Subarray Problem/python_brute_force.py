def brute_force(arr):
    n = len(arr)
    max_value = -1_000_000

    for i in range(n-1):            #Loop through array from index 0 to n-2
        total = arr[i]
        for j in range(i+1, n):     #Loop through array from index 1 to n-1
            total = total + arr[j]  #Accumulate the sum while looping
            if (total > max_value): 
                left_index = i      #Starting index of max-subarray
                right_index = j     #Ending index of max-subarray
                max_value = total
    return left_index, right_index, max_value

if __name__ == "__main__":
    arrIn = list(map(int, input("Enter an integer array: ").split(" ")))
    left, right, max_value = brute_force(arrIn)
    print(f"The maximum value is {max_value}, which starts from {left} to {right}")
