public class SortingExample {
    public static void main(String[] args) {
        // int arr[] = { 6, 3, 9, 10, 5, 2, 8 }; // Odd and even elements both are working
        // String arr[] = { "sun", "earth", "mars", "mercury"};
        // bubbleSort(arr);
        // mergeSort(arr, 0, arr.length-1);
        // quickSort(arr, 0, arr.length-1);
        // printArray(arr);
        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        // int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int target = 6;
        // System.out.println(binSearch(arr, target));
        System.out.println(search(arr, target, 0, arr.length-1));
        // System.out.println(searchUsingIteration(arr, target));
        // mergeSortInArrayOfStrings(arr);
        // printArrayOfString(arr);
        // int arr[] = {2,2,1,1,1,2,2};
        // countingSort(arr);
        // printArray(arr);
        // System.out.println(majorityElement(arr));
    }

    // binary search - condition is only works on sorted array - Time Complexity O(logn)
    // Linear search - Time Complexity O(n)
    public static int binSearch(int arr[], int key) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (end + start) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    // bubbleSort Time Complexity O(n2) - worst case and best case - O(n)
    // adjacent means bubble
    public static void bubbleSort(int[] arr) {
        for (int turn = 0; turn < arr.length - 1; turn++) {// turns
            int swap = 0;
            for (int j = 0; j < arr.length - 1 - turn; j++) {
                // swap
                if (arr[j] > arr[j + 1]) { // for descending order arr[j]<arr[j+1]
                    swap++;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            // System.out.println(swap);
            if (swap == 0) {
                return;
            }
        }
    }

    // selectionSort Time Complexity O(n2)
    // finding each iteration smallest element at last swap with i
    // Selection --> Smallest
    // 1. Pick smallest element
    // 2. swap with I element
    // 1 and 2 step : repeat till end
    public static void selectionSort(int[] arr) {
        for (int turn = 0; turn < arr.length - 1; turn++) {
            int smallest = turn;
            for (int j = turn + 1; j < arr.length; j++) {
                if (arr[smallest] > arr[j]) { // for descending order arr[smallest]<arr[j]
                    smallest = j;
                }
            }
            // swap
            int temp = arr[smallest];
            arr[smallest] = arr[turn];
            arr[turn] = temp;
        }
    }

    // insertionSort Time Complexity O(n2)
    public static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int pivot = i;
            // int swap=0;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[pivot] > arr[j]) { // for descending order arr[pivot]<arr[j]
                    // swap++;
                    int temp = arr[pivot];
                    arr[pivot] = arr[j];
                    arr[j] = temp;
                }
            }
            // System.out.println(swap);
        }
    }

    public static void countingSort(int[] arr) {
        int largest = Integer.MIN_VALUE;
        // finding range
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }
        int count[] = new int[largest + 1];
        // finding frequency of all elements
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        // sorting the array
        // ascending order
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }

        // descending order
        // int j=arr.length-1;
        // for(int i=0;i<count.length;i++){
        // while (count[i]>0) {
        // arr[j]=i;
        // j--;
        // count[i]--;
        // }
        // }
    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void printArrayOfString(String arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // MergeSort using divide & conquer Time Complexity - O(n*logn) & Space Complexity - O(n)
    // if we have space then use merge sort otherwise not. 
    // Also called Depth-first
    public static void mergeSort(int arr[], int si, int ei) {
        if(si >= ei) { //Base condition
            return;
        }
        //work find mid
        int mid = si + (ei - si) / 2;
        mergeSort(arr, si, mid); // left part
        mergeSort(arr, mid + 1, ei); // right part
        merge(arr, si, mid, ei);
    }

    // merge two arrays Time complexity = O(n)
    public static void merge(int arr[], int si, int mid, int ei) {
        // 0-3 = 4  4-6 = 3 total=7   6-0=6+1=7
        // Temparary array
        int temp[] = new int[ei - si + 1];
        int i = si; //iterator for left part
        int j = mid + 1; // iterator for right part
        int k = 0; // iterator for temp array

        //compairing elements and copy to temp array
        while (i <= mid && j <= ei) {
            if(arr[i] < arr[j]) { // if arr[i] less than arr[j] then add arr[i] into temp array
                temp[k] = arr[i];
                i++;
            } else { // if arr[j] less than arr[j] then add arr[j] into temp array
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        //left part leftover element copy into temp array if right part of elements are all copied
        while(i <= mid) {
            temp[k++] = arr[i++];
        }

        //right part leftover element copy into temp array if left part of elements are all copied
        while(j <= ei) {
            temp[k++] = arr[j++];
        }

        //copy temp array to my original array 
        for(k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    // Quick sort - Time Complexity = Avarage O(nlogn), Worst O(n2), Space Complexity = O(1) Constant
    // fast sorting but we have no space then use
    // pivot and partition
    public static void quickSort(int arr[], int si, int ei) {
        if(si >= ei) { // Base condition
            return;
        }
        //last element
        int pIndex = partition(arr, si, ei);
        quickSort(arr, si, pIndex-1); // left part
        quickSort(arr, pIndex+1, ei); // right part
    }

    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1; // To make place for elments smaller than pivot i =-1
        for(int j = si; j < ei; j++) {
            if(arr[j] <= pivot) {
                i++;
                //swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        //mske place for pivot
        i++;
        //swap
        int temp = pivot; // pivot = arr[i]
        arr[ei] = arr[i];
        arr[i] = temp;

        return i;
    }

    // Search in Rotated Sorted Array using Recursion and Modified Binary Search
    // Using Iteration - Homework using single loop
    public static int search(int arr[], int target, int si, int ei) {
        int mid = si + (ei - si) / 2;
        if(si > ei) { // Base case
            return -1;
        }
        //Case found.
        if(arr[mid] == target) {
            return mid;
        }

        //Line L1
        if(arr[si] <= arr[mid]) {
            if (arr[si] <= target && target <= arr[mid]) {
                return search(arr, target, si, mid - 1); // left part Case-A
            } else {
                return search(arr, target, mid + 1, ei); // right part Case-B
            }
        }
        //Line L2
        else {
            if (arr[mid] <= target && target <= arr[ei]) {
                return search(arr, target, mid + 1, ei); // right part Case-C
            } else {
                return search(arr, target, si, mid - 1); // left part Case-D
            }
        }
    }

    public static int searchUsingIteration(int arr[], int target) {
        int low = 0, high = arr.length - 1;
        while(low <= high) {
            if(arr[low] == target) {
                return low;
            }
            if(arr[high] == target) {
                return high;
            }
            low++;
            high--;
        }
        return -1;
    }

    public static void mergeSortInArrayOfStrings(String arr[]) {

    }

    public static int majorityElement(int nums[]) {
        int temp[] = new int[nums.length + 1];
        int low = 0, high = nums.length - 1;
        //counting sort
        while (low <= high) {
            if (low == high){
                temp[nums[low]]++;
            } else {
                temp[nums[low]]++;
                temp[nums[high]]++;
            }
            low++;
            high--;
        }
        low = 0;
        high = temp.length - 1;
        int max = Integer.MIN_VALUE;
        int index = 0;
        while(low <= high) {
            if(temp[low] > max) {
                max = temp[low];
                index = low;
            }
            if(temp[high]>max) {
                max = temp[high];
                index = high;
            }
            low++;
            high--;
        }
        return index;
    }
}
