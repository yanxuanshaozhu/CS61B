public class Exerciese1b {

    public static void drawTriangle(int N) {
        for(int i = 0; i < N; i ++) {
            for(int j = 0; j < i + 1; j ++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        drawTriangle(10);
    }
}
