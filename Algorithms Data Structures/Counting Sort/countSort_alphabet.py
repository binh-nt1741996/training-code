def countSort(arr):
    output = [0 for i in range(256)]
    count = [0 for i in range(256)]
    for i in arr:
        count[ord(i)] += 1
    for i in range(1, 256):
        count[i] += count[i - 1]
    for i in range(len(arr)):
        output[count[ord(arr[i])] - 1] = arr[i]
        count[ord(arr[i])] -= 1
    ans = ["" for i in arr]
    for i in range(len(arr)):
        ans[i] = output[i]
    return ans

if __name__ == "__main__":
    inArr = input("Enter a string: ")
    print("".join(countSort(inArr)))

