package geek.problem.diameterbinarytree;

public class BytePrint {
    public static void main(String[] args) {
        byte b = (byte) 0xFF;
        byte b2 = (byte) 0xFF;
        int d = b + b2;
//        System.out.println(b);
//        System.out.println(b & 0x000000ff);
        long l = b | 0x00000000000000FF;
        System.out.println(b | 0x00000000000000FF);
        System.out.println(0x000000FF | 0x000000FF);
    }
}
