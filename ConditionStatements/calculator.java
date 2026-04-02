import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        char ch = s.next().charAt(0);
        switch (ch) {
            case '+':
                System.out.println(a + b);
                break;
            case '-':
                System.out.println(a - b);
                break;
            case '*':
                System.out.println(a * b);
                break;
            case '/':
                System.out.println(a / b);
                break;
            case '%':
                System.out.println(a % b);
                break;
            default:
                System.out.println("Wrong choice.");
                break;
        }
        s.close();
    }
}
