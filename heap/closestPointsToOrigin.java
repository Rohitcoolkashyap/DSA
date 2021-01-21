package heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class closestPointsToOrigin implements Comparable<closestPointsToOrigin> {

    int key;
    int[] val;

    closestPointsToOrigin(int k, int[] v) {
        key = k;
        val = v;
    }

    @Override
    public int compareTo(closestPointsToOrigin k) {
        if (key > k.key)
            return 1;
        else if (key < k.key) return -1;
        return 0;
    }

    public static void main(String[] arg) {
        int[][] a = {{3, 3}, {5, -1}, {-2, 4}};

        int k = 2;
        System.out.println(Arrays.deepToString(kClosest(a, k)));
    }

    public static int[][] kClosest(int[][] points, int K) {
        PriorityQueue<closestPointsToOrigin> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int[] a : points) {

            pq.offer(new closestPointsToOrigin(a[0] * a[0] + a[1] * a[1], a));
            if (pq.size() > K)
                pq.poll();
        }

        int i = 0;
        int[][] re = new int[pq.size()][];
        while (!pq.isEmpty()) {
            re[i++] = pq.peek().val;
            pq.poll();
        }

        return re;

    }

}
