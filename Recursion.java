public class Recursion {
    public static void main(String args[]) {
        // int n = 5;
        // int nums[] = {5,5,5,5,10,2,3};
       
        // removeDuplicate("appnnacollege", 0, new StringBuilder(""),new boolean[26]);
        // System.out.println(friendsPairingProblem(4));
        // printBinaryStringProblem(3, 0, new String(""));
        // int arr[] = {3, 2, 4, 5, 6, 2, 7, 2, 2};
        // que1(arr, 0, 2);
        // System.out.print(que3("Parmar", 0, 0));
        // System.out.print(que2(2019, new StringBuilder("")));
        System.out.println(que4("abcab", 0, new String("")));
        // System.out.println(revNum(1947, 0));
        System.out.println(que2(revNum(1947, 0), new StringBuilder("")));
    }

    public static void printDec(int n) {
        if (n == 1) { // Base case
            System.out.print(n);
            return;
        }
        System.out.print(n + " "); // Define what function do
        printDec(n - 1); // inner function
    }

    public static void printInc(int n) {
        if (n == 1) { // Base case
            System.out.print(n + " ");
            return;
        }
        printInc(n - 1); // inner function
        System.out.print(n + " "); // Define what function do
    }

    // Time complexity - O(n) & Space Complexity - O(n)
    public static int factorial(int n) {
        if (n == 0) { // Base case
            return 1;
        }
        // int fnm1 = factorial(n-1); // f of n minus 1 = fnml
        int fn = n * factorial(n - 1);
        return fn;
    }

    // Print sum of N Natural Numbers Time complexity - O(n) & Space Complexity - O(n)
    // O(n)
    public static int sumOfNumber(int n) {
        if (n == 1) { // Base case
            return 1;
        }
        int sum = n + sumOfNumber(n - 1);
        return sum;
    }

    // Print N fibonacci Number - Time complexity - O(2 to the power n) & Space Complexity - O(2^n)=O(n)
    // Exponential time
    public static int fibonacciSeries(int n) {
        // f(0) = 0 and f(1) = 1
        // f(2) = (f(1)+f(0)) 0,1,1
        // f(3) = f(2) + f(1) = 1 + 1 = 2 0,1,1,2
        // f(4) = f(3) + f(2) = 2 + 1 = 3 0,1,1,2,3
        // f(5) = f(4) + f(3) = 3 + 2 = 5 0,1,1,2,3,5
        // f(6) = f(5) + f(4) = 5 + 3 = 8 0,1,1,2,3,5,8
        // f(7) = f(6) + f(5) = 8 + 5 = 13 0,1,1,2,3,5,8,13
        // if (n == 1) { // Base case
        // return 1;
        // }
        // if(n == 0) { // Base case
        // return 0;
        // }
        if (n == 1 || n == 0) { // Base case
            return n; // if 1 then return 1 and if 0 then return 0
        }
        int fibonacci = fibonacciSeries(n - 1) + fibonacciSeries(n - 2);
        return fibonacci;
    }

    // Check if given array is sorted or not Time complexity - O(n) & Space
    // complexity - O(n)
    public static boolean isSorted(int arr[], int i) {
        if (i == arr.length - 1) { // Base condition
            return true;
        }
        if (arr[i] > arr[i + 1]) {
            return false;
        }
        return isSorted(arr, i + 1);
    }

    // WAF to find the first occurance of an element in an array - Time complexity -
    // O(n) & Space complexity - O(n)
    public static int findFirstOccurance(int arr[], int key, int i) {
        if (i == arr.length - 1) { // Base condition
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }
        return findFirstOccurance(arr, key, i + 1);
    }

    // WAF to fidn the last occurance of an element in an array
    public static int findLastOccurance(int arr[], int key, int i) {
        // first approach
        // if(i == 0) { // Base condition
        // return -1;
        // }
        // if(arr[i] == key) {
        // return i;
        // }
        // return findLastOccurance(arr, key, i-1);

        // second approach
        if (i == arr.length - 1) { // Base Condition
            return -1;
        }
        int isFound = findLastOccurance(arr, key, i + 1);
        if (isFound == -1 && arr[i] == key) {
            return i;
        }
        return isFound;
    }

    // finding power of n - Time complexity O(n) Space complexity - O(n)
    public static int powerOfN(int x, int n) {
        if (n == 0) { // Base condition
            return 1;
        }
        // if(n == 1) { // Base Condition
        // return x;
        // }
        return x * powerOfN(x, n - 1);
    }

    // Time complexity = O(logn) & Space Complexity = O(logn)
    // if we are dividing one problem to n/2 then click in mind that tc will be logn
    public static int optimizedPowerOfN(int x, int n) {
        if (n == 0) { // Base Condition
            return 1;
        }
        int halfPower = optimizedPowerOfN(x, n / 2);
        int halfPowerSquare = halfPower * halfPower; // power is even
        if (n % 2 != 0) { // power is odd
            halfPowerSquare = x * halfPowerSquare;
        }
        return halfPowerSquare;
    }

    //tile 4^1 floor 4^n then also same
    //using DP we can optimize the solution in which we can store values which are repeatedly calculating.
    public static int tilingProblem(int n) {
        // recursive function n = length
        // 2*1 = one tile 
        // 2-floor & 2-tile = 2*1 in this 2 is common
        //total number of ways = horizontally & vertically
        // n = 3 then 2 = 3 ==> 2*3
        //if n=0 then no tile place that is also a way So 2*0=1 * if n=1 then we can place vertically 1 tile So 2*1 = 1 way.
        if(n == 1 || n == 0) { // Base condtion
            return 1;
        }
        //two condition: vertical & horizontal
        // if vertically then n-1
        // if horizontally then n-2 
        return tilingProblem(n - 1) + tilingProblem(n - 2);
    }

    // a-z only we we have A-Z/&: then we have to use HashSet
    public static void removeDuplicate(String s, int i, StringBuilder newString, boolean map[]) { 
        if(i == s.length()) { // Base case condition
            System.out.println(newString);
            return;
        }
        //currentcharacter - a = currentIndex of track array
        char currentChar = s.charAt(i);
        if(map[currentChar-'a'] == true) {
            //Duplicate
            removeDuplicate(s, i + 1, newString, map);
        } else {
            map[currentChar-'a']=true;
            removeDuplicate(s, i + 1, newString.append(currentChar), map);
        }
    }

    //Permutation and Combination
    //recursion is like driving practice
    public static int friendsPairingProblem(int n) { // friends = n
        if(n == 1 || n == 2) { // Base case
            return n;
        }
        //Choice-1: solo (n-1)
        // int solo = friendsPairingProblem(n-1);  //single
        //Choice-2: pair (n-2)
        // int pair = (n-1) * friendsPairingProblem(n-2); 
        // System.out.println(solo+" "+pair);
        // return solo + pair;
        
        // totalNumberOfPairs=(n-1)
        //  friendsPairingProblem(n-2) = pair choices
        return friendsPairingProblem(n - 1) + ((n - 1) * friendsPairingProblem(n - 2));
    }

    public static void printBinaryStringProblem(int n, int lastPlace, String str) {
        if(n == 0) {
            System.out.println(str);
            return;
        }
        printBinaryStringProblem(n-1, 0, str+"0");
        if(lastPlace == 0) { // lastplace is 0 then we can sit 1 to this
            printBinaryStringProblem(n-1,1, str+"1");
        }
    }

    // Q1: For a given integer array of size N. You have to find all the occurrences(indices)of a given element(Key) and print them.
    public static void que1(int arr[], int i, int key) {
        if(i == arr.length){ //Base condition
            return;
        }
        if(arr[i] == key){ // Work logic
            System.out.print(i + " ");
        }
        que1(arr, i + 1, key); // Function calling inself
    }

    public static String que2(int num, StringBuilder str) {
        if(num == 0) { // Base condition
            return str.toString();
        }
        while(num!=0) {
            int rem = num%10;
            num/=10;
            if(rem == 1) {
                str.append("one ");
            } else if(rem == 2) {
                str.append("two ");
            } else if(rem == 3) {
                str.append("three ");
            } else if(rem == 4) {
                str.append("four ");
            } else if(rem == 5) {
                str.append("five ");
            } else if(rem == 6) {
                str.append("six ");
            } else if(rem == 7) {
                str.append("seven ");
            } else if(rem == 8) {
                str.append("eight ");
            } else if(rem == 9) {
                str.append("nine ");
            } else if(rem == 0) {
                str.append("zero ");
            }
        }
        return que2(num, str);
    }

    //Finding a length of a string using recursion
    public static int que3(String str, int i, int len) {
        if(i == str.length()) { //Base case
            return len;
        }
        len++; //Work
        return que3(str, i+1, len);
    }

    public static String que4(String str, int index, String subStr) {
        if(str.length() == index) { // Base condition
            return subStr;
        }
        for(int i = index; i <=index; i++) { // only works for 1 char that is currently is as index. for printing substrings
            for(int j = i; j < str.length(); j++) {
                for(int k=i; k <= j; k++) {
                    // System.out.print(subStr + str.charAt(k));
                    subStr = subStr + str.charAt(k);
                }
                // System.out.print(" ");
                if(subStr.length() == 1) {
                    System.out.print(subStr + " ");
                } else {
                    if(subStr.charAt(0) == subStr.charAt(subStr.length()-1)) { // checking for starting and ending character is same then that substring is print
                        System.out.print(subStr + " ");
                    }
                }
                subStr = "";
            }
            // System.out.println();
        }

        return que4(str, index + 1, subStr);
    }
    
    public static int revNum(int num, int rev) {
        if(num == 0) {
            return rev;
        }
        int rem = num%10;
        num /= 10;
        rev=(rev*10)+rem;

        return revNum(num, rev);
    }
}

// How to approach a questions 
// 1. Brute Force (logical)
// 2. Then Optimized (Time)
// 3. On
//
// Online judge = 1 sec = 10^8 operations we can perform
//10^6 = Linear search 10^6
// Binary search log(10^6) = 20 operations 

// n=10^9 linear = 10^9 binary = log(10^9) = 30 operations
// in linear --> TIme limit exceeded error
//10^9 --> then use binary search