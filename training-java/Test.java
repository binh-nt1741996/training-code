/**
 * Test
 */
public class Test {

    public static void main(String[] args) {
        hello h1 = new hello();
        hello h2 = new hello();
        h1.a = 17;
        h2.a = 18;

        System.out.println("hello1 has a = " + h1.a);
        System.out.println("hello2 has a = " + h2.a);
        h1.b = 3;
        h2.b = 4;
        hello.b = 5;
        System.out.println("hello1 has b = " + h1.b);
        System.out.println("hello2 has b = " + h2.b);


    }
}

class hello{
    protected int a;
    protected static int b;
    static int increase(){
        b++;
        return b;
    }
}