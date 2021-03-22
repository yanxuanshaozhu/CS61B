public class Exercise3 {

    public static int forMax(int[] values) {
        int start = -1;
        for(int i = 0; i < values.length; i ++) {
            if(values[i] >= start) {
                start = values[i];
            }
        }
        return start;
    }
    public static void main(String[] args) {
        int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};  
        System.out.println("forMax: " + forMax(numbers));
    }
}
