def insertion_sort(arr):
    for i in range(1, len(arr)):
        key = arr[i]
        j = i - 1
        while (j >= 0 and arr[j] > key):
            arr[j+1] = arr[j]
            j-=1
        arr[j + 1] = key
    return arr

def bucket_sort(arr):
    subArr = []
    slot_num = int(max(arr) * 10)
    for i in range(slot_num):
        subArr.append([])
    
    for i in arr:
        index = int(slot_num * i)
        subArr[index].append(i)
    for i in range(slot_num):
        if not subArr[i]:
            subArr[i] = insertion_sort(subArr[i])
    
    k = 0
    for i in range(slot_num):
        for j in range(len(subArr[i])):
            arr[k] = subArr[i][j]
            k+=1
    return arr

if __name__ == "__main__":
    x = [0.897, 0.565, 0.656, 
     0.1234, 0.665, 0.3434]  
    bucket_sort(x)
    print(x)