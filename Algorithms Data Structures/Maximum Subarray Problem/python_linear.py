def linear_solution(arr):
    n = len(arr)
    currMax = arr[0]                        #declare current Max, which is arr[0] now
    sofarMax = arr[0]                       #declare so far Max, which is arr[0] now
    left, right = 0, 0                      #declare left, right indexes of max sub-array
    for i in range(1, n):
        """
        ###     NOT RETURNING LEFT/RIGHT INDEXES CASE       ###
        currMax = 0 if (currMax + arr[i] < 0) else currMax + arr[i]
        sofarMax = max(sofarMax, currMax)
        """
        currMax = currMax + arr[i]
        if (currMax < 0):                   
            currMax = 0                     #reset the currMax, in case currMax + next element < 0
            left, right = i + 1, i + 1
        if (currMax > sofarMax):
            sofarMax = currMax
            right = i + 1
    return left, right, sofarMax


if __name__ == "__main__":
    arrInput = list(map(int, input("Enter an integer array: ").split(" ")))
    result = linear_solution(arrInput)
    print(f"The maximum subarray's sum is: {result[2]}, ranging from {result[0]} to {result[1]}")
