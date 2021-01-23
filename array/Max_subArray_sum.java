package array;

public class Max_subArray_sum {
    public static void main(String[] arg) {
        int[] arr = {9,0,0,9,0,40,2,12,3,0,9999};
        int winow_sum = 0;
        int curr_sum = 0;
        int k = 2;
        int i = 0;
        for (i = 0; i < k; i++) {
            winow_sum += arr[i];
        }
        curr_sum = winow_sum;
        int start = 0;
        for (int j = i; j < arr.length; j++) {
            winow_sum = winow_sum - arr[start++] + arr[j];

            if (winow_sum > curr_sum)
                curr_sum = winow_sum;


        }
        System.out.println(curr_sum);

    }
}
