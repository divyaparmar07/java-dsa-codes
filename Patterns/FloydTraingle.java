public class FloydTraingle {
    public static void main(String[] args) {
        int count = 1;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                if (count <= 9)
                    System.out.print(" " + count + " ");
                else
                    System.out.print(count + " ");
                count++;
            }
            System.out.println();
        }
    }
}
