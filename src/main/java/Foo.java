class Foo {

    public Foo() {
    }

    Thread first;
    Thread second;

    public void first(Runnable printFirst) throws InterruptedException {
        first = Thread.currentThread();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        second = Thread.currentThread();
        while (first==null){
            Thread.sleep(50);
        }
        first.join();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (second==null){
            Thread.sleep(50);
        }
        second.join();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
