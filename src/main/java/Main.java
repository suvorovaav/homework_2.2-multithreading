
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        Thread first = new Thread(() -> {
            try {
                foo.first(() -> System.out.println("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread second = new Thread(() -> {
            try {
                foo.second(() -> System.out.println("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread third = new Thread(() -> {
            try {
                foo.third(() -> System.out.println("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        second.start();
        first.start();
        third.start();

        second.join();
        first.join();
        third.join();
    }
}
