import java.util.Scanner;

public class BitManipulationExample {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        // int num = sc.nextInt();
        // OddEven(num);
        System.out.println(countSetNumber(12));
        // System.out.println(clearRangeOfBits(10,2,4)); //n=2515, i=2, j=7 answer=2307
        // System.out.println(fastExpo(5,3));
        // System.out.println(XorOfX(567));
        sc.close();
        swap(10, 30);
    }

    // Check if number is Odd or Even
    // for example (100)-->LSB is 0 then n&1 means 100&001=000 we get 0 if number is
    // even and
    // if num is (101)-->LSB is 1(Non-zero value) then n&1 means 101&001=001 is 1.
    // So that number is odd.
    public static void OddEven(int num) {
        int bitmask = 1;
        if ((num & bitmask) == 1) {
            System.out.println("Number is Odd");
        } else {
            System.out.println("Number is Even");
        }
    }

    // getting ith bit
    public static int getIthBit(int n, int i) {
        int bitmask = 1 << i;
        if ((n & bitmask) == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    // set ith bit means set ith bit to 1.
    public static int setIthBit(int n, int i) {
        int bitmask = 1 << i;
        return n | (bitmask);
    }

    // clear ith bit means set ith bit to 0. n is 1010 ith bit is 1 then ans should
    // be eight bitmask = 0010. then bitwise not = 1101. Now, 1010&1101=1000 (8 in
    // decimal).
    public static int clearIthBit(int n, int i) {
        int bitmask = ~(1 << i);
        return n & bitmask;
    }

    public static int updateIthBit(int n, int i, int newBit) {
        // first approach
        // if(newBit == 0){
        // return clearIthBit(n, i);
        // }else{
        // return setIthBit(n, i);
        // }
        // second approach
        n = clearIthBit(n, i);
        int bitmask = newBit << i;
        return n | bitmask;
    }

    // clear last ith bits means 1111=15 is number and i is 2, then we want last 2
    // bits should be cleared or 0 and answer is 1100 which is 12.
    public static int clearLastIBits(int n, int i) {
        int bitmask = (~0) << i; // (-1)<<i minus one left shift ith time
        return n & bitmask;
    }

    public static int clearRangeOfBits(int n, int i, int j) {
        // first my approach
        // for(int x=i;x<=j;x++){
        // n=clearIthBit(n, x);
        // }
        // return n;
        // second approach
        int a = (~0) << (j + 1);
        int b = (1 << i) - 1;
        int bitmask = a | b;
        return n & bitmask;
    }

    // number is 2 power or not
    public static boolean isPowerOf2(int n) {
        return (n & (n - 1)) == 0;
    }

    public static int countSetNumber(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) != 0) { // check LSB
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    // Fast Exponentiation (a power n )- O(logn) Time Complexity
    public static int fastExpo(int a, int n) {
        int ans = 1;
        while (n > 0) {
            if ((n & 1) != 0) { // checking LSB if it is given us non-zero(1) value then we can multiply it will
                                // ans.
                ans *= a;
            }
            a *= a; // a to a2
            n = n >> 1; // right shift by 1 when n!=0
        }
        return ans;
    }

    public static int XorOfX(int x) {
        return x ^ x;
    }
    // Modular Exponentiation - a power n % x - Google

    // Swap two numbers without using any third variable.
    public static void swap(int a, int b) {
        System.out.println("Before swap " + a + " " + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.print("After swap " + a + " " + b);
    }
}
