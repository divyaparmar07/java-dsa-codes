// import java.util.Scanner;

public class first {
    public static void main(String[] args) {
        // System.out.println("Hello World");
        // System.out.print("****\n***\n**\n*");
        // int x = 9, y = 12;
        // int a = 2, b = 4, c = 6;

        // int exp = 4 / 3 * (x + 34) + 9 * (a + b * c) + (3 + y * (2 + a)) / (a + b *
        // y);
        // System.out.println(exp);

        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int counter = 1;
        // int sum=0;
        // while (counter <= n) {
        // sum+=counter;
        // counter++;
        // }
        // System.out.println("Sum is "+sum);
        // int i = 10;
        // int num = n;
        // int res = 0;
        // while (num > 0) {
        // int rem = num % 10;
        // res*=i;
        // res+=rem;
        // num /= 10;
        // }
        // System.out.println(res);
        // while(n>0){
        // int lastdigit = n%10;
        // System.out.print(lastdigit);
        // n=n/10;
        // }
        // int i=1;
        // do{
        // System.out.println("Hello World");
        // i++;
        // }while(i<=5);
        // do{
        // System.out.println("Enter your number:");
        // int n = sc.nextInt();
        // if(n%10==0)
        // break;
        // System.out.println(n);
        // }while(true);

        // for(int i=1;i<=5;i++){
        // if(i==3){
        // continue;
        // }
        // System.out.println(i);
        // }

        // do{
        // System.out.println("Enter your number:");
        // int n = sc.nextInt();
        // if(n%10==0){
        // continue;
        // }
        // System.out.println(n);
        // }while(true);

        // Prime numbers : 1,3,5,7,9 => it's divisible by only itself and one.
        // boolean count = true;
        // int n = sc.nextInt();
        // if (n == 2) {
        //     System.out.println("Prime");
        // } else {
        //     for (int i = 2; i <= Math.sqrt(n); i++) { // i<=n-1
        //         if (n % i == 0) {
        //             count = false;
        //         }
        //     }
        //     if (count)
        //         System.out.println("Prime");
        //     else
        //         System.out.println("Not prime");
        // }

        // n = 4;
        // for (int i = 1; i <= n; i++) {
        //     int temp = i + 1;
        //     for (int j = temp; j > 1; j--) {
        //         System.out.print(j);
        //     }
        //     System.out.println();
        // }
        // sc.close();

        // int n = 5;
        // Upper Left traingle
        // for (int i = 1; i <= n; i++) {
        //     for (int j = 1; j <= n; j++) {
        //         if(i+j <= n+1) {
        //             System.out.print("*");
        //         }
        //     }
        //     System.out.println();
        // }

        //Upper Right traingle
        // for (int i = 1; i <= n; i++) {
        //     for (int j = 1; j <= n; j++) {
        //         if(j - i >= 0) { // j >= i
        //             System.out.print("*");
        //         } else {
        //             System.out.print(" ");
        //         }
        //     }
        //     System.out.println();
        // }

        //Lower Left traingle
        // for (int i = 1; i <= n; i++) {
        //     for (int j = 1; j <= n; j++) {
        //         if(j <= i) {
        //             System.out.print("*");
        //         }
        //     }
        //     System.out.println();
        // }
        //Lower Right traingle
        // for (int i = 1; i <= n; i++) {
        //     for (int j = 1; j <= n; j++) {
        //         if(i + j > n) {
        //             System.out.print("*");
        //         } else {
        //             System.out.print(" ");
        //         }
        //     }
        //     System.out.println();
        // }
        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < 2*(n-i-1); j++) {
        //         System.out.print(" ");
        //     }
        //     for(int j = 0; j < 2*i+1; j++) {
        //         System.out.print("*" + " ");
        //     }
        //     System.out.println();
        // }
        int[] arr = {1,2,3,4,5};
        subArrays(arr);
    }

    // prime number function
    public static boolean isPrime(int n) {
        boolean prime = true;
        if (n == 2) {
            return true;
        } else {
            for (int i = 2; i <= n - 1; i++) {
                if (n % i == 0) {
                    prime = false;
                    return prime;
                }
            }
        }
        return prime;
    }

    // prime range 2 to n
    public static void primesInRange(int n) {
        for (int i = 2; i <= n; i++) {
            if (isPrime(n))
                System.out.print(i + " ");
        }
    }

    public static void subArrays(int arr[]) {
        for(int i = 0; i <= arr.length - 1; i++) {
            for(int j = i; j <= arr.length - 1; j++) {
                for(int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
        }
    }

}

//  20 12 15 9 3 10
//  3 12 15 9 20 10 - 1 iteration
//  3 9 15 12 20 10 - 2 iteration
//  3 9 10 12 20 15  -3 iteration
//  