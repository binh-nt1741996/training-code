class test {
    private static int a = 17;

    public static class NestedClass{
        NestedClass(int b){
            a = b;
        }
    }

    public class InnerClass{
        InnerClass(int c){
            a = c;
        }
    }
}

class Main{
    public static void main(String[] args) {
        test.NestedClass nest = new test.NestedClass(4);
        System.out.println(nest.a);
    }
}