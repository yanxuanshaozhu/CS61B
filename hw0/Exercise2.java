import java.util.Arrays;

public class Exercise2 {
    
    public static int plainMax(int[] values) {
        int start = -1;
        for(int ele : values) {
            if(ele >= start) {
                start = ele;
            }
        }
        return start;
    }

    public static int max(int[] values) {
        Arrays.sort(values);
        return values[values.length - 1];
    }
    public static void main(String[] args) {
        int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};  
        System.out.println("Arrays.sort-max: " + max(numbers));
        System.out .println("plainMax: " + plainMax(numbers));
     }
}
