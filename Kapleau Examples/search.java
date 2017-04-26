public class Main {

    public static void main(String[] args) {

        Integer[] a = {12, 23, 34, 45, 56, 67, 78, 89, 90};

        System.out.println(bsearch(a, 57));
        System.out.println(ssearch(a, 57));
    }

    public static <T extends Comparable<? super T>> int bsearch(T [] array, T key) {

        int cmp;

        for (int l = 0, r = array.length - 1, m = r / 2; l <= r; m = (l + r) / 2) {
            if ((cmp = key.compareTo(array[m])) == 0) {
                    return m;
            }
            else if (cmp < 0) {
                r = m - 1;
            }
            else {
                l = m + 1;
            }
        }

        return -1;
    }

    public static <T extends Comparable<? super T>> int ssearch(T [] array, T key) {
        for (int i = 0; i < array.length; ++i) {
            if (key.compareTo(array[i]) == 0) {
                return i;
            }
        }

        return -1;
    }
}

class Foo implements Comparable<Foo> {

    public Foo(int foo) {
        this.foo = foo;
    }

    public int compareTo(Foo o) {
        return (foo > o.foo ? 1 : 0) - (foo < o.foo ? 1 : 0);
    }

    public String toString() {
        return Integer.toString(foo);
    }

    private int foo;
}

class Bar extends Foo {

    public Bar(int bar) {
        super(bar);
    }
}
