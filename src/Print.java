
public class Print {
    
    public void print() {};

    public <T> void print(T any) {
        String end = "\n";
        System.out.print(any);
        System.out.print(end);
    }

    public <T> void print(T any, String end) {
        System.out.print(any);
        System.out.print(end);
    }

}