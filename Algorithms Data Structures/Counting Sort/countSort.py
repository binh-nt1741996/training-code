def countSort(arr, k):
    subarr = [0 for i in range(k + 1)]
    for i in range(len(arr)):
        subarr[arr[i]] += 1
    for i in range(1, k + 1):
        subarr[i] = subarr[i] + subarr[i - 1]
    sortarr = [0 for i in range(len(arr))]
    for i in range(len(arr)):
        sortarr[subarr[arr[i]] - 1] = arr[i]
        subarr[arr[i]] = subarr[arr[i]] - 1
    return sortarr

if __name__ == "__main__":
    inpArr = list(map(int, input("Enter a list of integer: ").split(" ")))
    print(f"Before sorting...\n{inpArr}")
    print(f"After sorting..")
    print(countSort(inpArr, max(inpArr)))


