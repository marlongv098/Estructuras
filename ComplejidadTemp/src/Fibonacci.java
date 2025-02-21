public class Fibonacci {
    public static int fibonacciRec(int n) {
        if (n <= 1) return n;
        return fibonacciRec(n - 1) + fibonacciRec(n - 2);
    }

    public static int fibonacciIter(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, temp;
        for (int i = 2; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}
