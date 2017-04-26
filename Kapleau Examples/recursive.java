public class Main {

    public static void main(String[] args) {

        System.out.println(choose(52, 2));
        System.out.println(fact(10));
        System.out.println(fibo(10));
        System.out.println(pow(2, 10));
        System.out.println(sum(10));

        tower(4, 'A', 'C', 'B');
    }

    public static int choose(int n, int k) {

        if (k > n) {
            return 0;
        }
        else if (k == 0 || k == n) {
            return 1;
        }

        return choose(n-1, k-1) + choose(n-1, k);
    }

    public static int fact(int n) {

        if (n == 0) {
            return 1;
        }

        return n * fact(n-1);
    }

    public static int fibo(int n) {

        if (n == 0 || n == 1) {
            return n;
        }

        return fibo(n-1) + fibo(n-2);
    }

    public static int pow(int x, int n) {

        if (n == 0) {
            return 1;
        }
        else if (n % 2 == 0) {
            return pow(x * x, n / 2);
        }
        else {
            return x * pow(x * x, n / 2);
        }
    }

    public static int sum(int n) {

        if (n == 0) {
            return 0;
        }

        return n + sum(n-1);
    }

    public static void tower(int n, char from, char to, char use) {

        if (n > 0) {
            tower(n-1, from, use, to);
            System.out.println("Move disk " + n + " from " + from + " to " + to + ".");
            tower(n-1, use, to, from);
        }
    }
}
