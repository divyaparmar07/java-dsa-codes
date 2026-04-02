import java.util.Scanner;

public class factorial {
    public static void main(String[] args) {
        int fact = 1;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        System.out.println("Factorial is: " + fact);
        sc.close();
    }
}
