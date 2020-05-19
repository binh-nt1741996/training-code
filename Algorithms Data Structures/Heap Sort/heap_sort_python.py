import math as m

def MAX_HEAPIFY(A, heap_size, i):
    left = 2 * i + 1
    right = 2 * i + 2
    largest = i

    if (left < heap_size) and (A[left] > A[i]):
        largest = left
    if (right < heap_size) and (A[right] > A[largest]):
        largest = right
    if (largest != i):
        A[i], A[largest] = A[largest], A[i]
        MAX_HEAPIFY(A, heap_size, largest)
    
def BUILD_MAX_HEAP(A):
    heap_size = len(A)
    for i in range(int(len(A)/2) - 1, -1, -1):
        MAX_HEAPIFY(A, heap_size, i)

def HEAP_SORT(A):
    BUILD_MAX_HEAP(A)
    for i in range(len(A) - 1, 0, -1):
        A[0], A[i] = A[i], A[0]
        MAX_HEAPIFY(A, i, 0)

if __name__ == "__main__":
    arr = list(map(int, input("Enter a list of integers: ").split(" ")))    
    print("Before sorting...")
    print(arr)
    HEAP_SORT(arr)
    print("After sorting...")
    print(arr)