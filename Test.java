import java.util.PriorityQueue;

class Test {

    // Static Pair class for making pairs
    static class Pair {
        int key;
        int val;

        public Pair(int _key, int _val) {
            key = _key;
            val = _val;
        }
    }

    public static void main(String[] arg) {

        // Comparator shortcut method

        // Min heap
        //PriorityQueue<Pair> pq = new PriorityQueue<>((t1, t2) -> Integer.compare(t1.key, t2.key));

        // Max heap
        PriorityQueue<Pair> pq = new PriorityQueue<>((t1, t2) -> Integer.compare(t2.key, t1.key));

        pq.add(new Pair(1, 22));
        pq.add(new Pair(3, 43));
        pq.add(new Pair(8, 33));
        pq.add(new Pair(2, 21));

        while (!pq.isEmpty()) {
            System.out.println(pq.peek().key + " " + pq.peek().val);
            pq.poll();
        }


    }
}