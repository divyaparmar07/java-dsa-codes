import java.util.Scanner;

public class EvenOddSolution {
    public static void main(String[] args) {
        int evenSum = 0;
        int oddSum = 0;
        int num = 1;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Enter number:");
            int n = sc.nextInt();
            if (n % 2 == 0)
                evenSum += n;
            else
                oddSum += n;
            System.out.println("If you want to add then press 1 otherwise 0");
            num = sc.nextInt();
        } while (num == 1);
        System.out.println("Even numbers sum: " + evenSum);
        System.out.println("Odd numers sum: " + oddSum);
        sc.close();
    }
}
