public class Main {

    public static void main(String[] args) {

        Derived d = new Derived();

        d.foo();
        d.bar();
    }
}

class Base {

    public Base() {
        System.out.println("Base");
    }

    public void foo() {
        System.out.println("Base foo");
    }
}

class Derived extends Base {

    public Derived() {
        System.out.println("Derived");
    }

    public void foo() {
        super.foo();
        System.out.println("Derived foo");
    }

    public void bar() {
        System.out.println("Derived bar");
    }
}
