import java.util.Scanner;

public class FunctionQuestions {
    public static void main(String[] args) {
        // int average = averageOfThreeNumbers(5, 10, 15);
        // System.out.println(average);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (isPalindrome(n))
            System.out.println("Number is palindrome.");
        else
            System.out.println("Number is not palindrome.");
        // System.out.println("Sum of Digit: "+sumOfDigit(n));
        // if(isEven(n)) System.out.println("Number is Even");
        // else System.out.println("Number is odd.");
        sc.close();
    }

    // Average of three numbers
    public static int averageOfThreeNumbers(int a, int b, int c) {
        return (a + b + c) / 3;
    }

    public static boolean isPalindrome(int n) {
        int num = n;
        int res = 0;
        int decimal = 1;
        while (num > 0) {
            int rem = num % 10;
            res = (res * decimal * 10) + rem;
            num /= 10;
        }
        if (res == n)
            return true;
        else
            return false;
    }

    public static int sumOfDigit(int n) {
        int num = n;
        int sum = 0;
        while (num > 0) {
            int rem = num % 10;
            sum += rem;
            num /= 10;
        }
        return sum;
    }

    public static boolean isEven(int n) {
        if (n % 2 == 0)
            return true;
        else
            return false;
    }
}
