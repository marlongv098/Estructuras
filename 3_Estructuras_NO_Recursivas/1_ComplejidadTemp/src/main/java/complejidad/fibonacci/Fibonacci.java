package complejidad.fibonacci;

public class Fibonacci {

    /** Recursivo directo. Tiempo O(2^n), espacio O(n) por la pila de recursión. */
    public static int fibonacciRec(int n) {
        if (n <= 1) return n;
        return fibonacciRec(n - 1) + fibonacciRec(n - 2);
    }

    /** Iterativo optimizado: solo guarda los dos últimos valores. Tiempo O(n), espacio O(1). */
    public static int fibonacciOptimizado(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, temp;
        for (int i = 2; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return b; // mantiene solo el ultimo elemento
    }

    /** Iterativo con array (programación dinámica "de libro"). Tiempo O(n), espacio O(n). */
    public static int fibonacciIterativo(int n) {
        if (n <= 1) return n;

        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }

    /**
     * Exponenciación de matrices: [[1,1],[1,0]]^n tiene a F(n+1), F(n), F(n), F(n-1)
     * como entradas. Elevar la matriz a la n usando "exponenciación rápida" (dividir el
     * exponente a la mitad en cada paso, igual que potencia rápida de un número) da
     * tiempo O(log n) en vez de O(n). Espacio O(log n) por la pila de recursión
     * (o O(1) si se implementa de forma iterativa).
     */
    public static long fibonacciMatriz(int n) {
        if (n <= 1) return n;
        long[][] base = {{1, 1}, {1, 0}};
        long[][] resultado = potencia(base, n - 1);
        return resultado[0][0];
    }

    private static long[][] potencia(long[][] m, int exp) {
        if (exp == 0) {
            return new long[][]{{1, 0}, {0, 1}}; // matriz identidad
        }
        if (exp == 1) {
            return m;
        }
        long[][] mitad = potencia(m, exp / 2);
        long[][] cuadrado = multiplicar(mitad, mitad);
        if (exp % 2 == 0) {
            return cuadrado;
        }
        return multiplicar(cuadrado, m);
    }

    private static long[][] multiplicar(long[][] a, long[][] b) {
        return new long[][]{
                {a[0][0] * b[0][0] + a[0][1] * b[1][0], a[0][0] * b[0][1] + a[0][1] * b[1][1]},
                {a[1][0] * b[0][0] + a[1][1] * b[1][0], a[1][0] * b[0][1] + a[1][1] * b[1][1]}
        };
    }
}
