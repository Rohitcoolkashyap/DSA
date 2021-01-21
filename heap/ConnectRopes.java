package heap;

import java.util.PriorityQueue;

public class ConnectRopes {
    public static void main(String[] arg) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int[] a = {1, 2, 3, 4, 5};

        for (int i : a
        ) {
            pq.offer(i);
        }
        int cost = 0;
        while (pq.size() >= 2) {
            int x = pq.remove();
            int y = pq.remove();

            pq.offer(x + y);
            cost += x + y;
        }
        System.out.println(cost);
    }
}
