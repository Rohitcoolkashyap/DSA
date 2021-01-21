package heap;

import java.util.*;

public class kth_smallest implements Comparable<kth_smallest> {
    int key, val;

    public kth_smallest(int key, int val) {
        this.key = key;
        this.val = val;
    }

    @Override
    public int compareTo(kth_smallest k) {
        if (key > k.key)
            return 1;
        else if (key < k.key) return -1;
        return 0;
    }

    public static void main(String[] arg) {
        int[] arr = {1,1,1,2,2,5,4,8,9};
        int k = 3;
//        int x = 3;
//        System.out.println(kthSmallest(arr, k));
//        System.out.println(kthLargest(arr, k));
//        sortKSortedArray(arr, k);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(closestNumbers(arr, k, x));
        System.out.println(frequentNumbers(arr,k));
    }

//    static int kthSmallest(int[] arr, int k) {
//        if (k > arr.length) return -1;
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//
//        for (int i : arr
//        ) {
//            pq.add(i);
//            if (pq.size() > k && !pq.isEmpty())
//                pq.poll();
//        }
//        return pq.remove();
//    }
//
//    static int kthLargest(int[] arr, int k) {
//        if (k > arr.length) return -1;
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//
//        for (int i : arr
//        ) {
//            pq.add(i);
//            if (pq.size() > k && !pq.isEmpty())
//                pq.poll();
//        }
//        return pq.remove();
//    }
//
//    static void sortKSortedArray(int[] a, int k) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        int i;
//        int j = 0;
//        for (i = 0; i < a.length; i++) {
//            pq.add(a[i]);
//
//            if (pq.size() >= k) {
//                // System.out.println(k+" "+i);
//                a[j++] = pq.remove();
//            }
//
//        }
//        while (!pq.isEmpty() && j < a.length) {
//            a[i - (k - 1)] = pq.remove();
//            i++;
//        }
//    }

    static ArrayList<Integer> closestNumbers(int[] a, int k, int x) {
        PriorityQueue<kth_smallest> pq = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> al = new ArrayList<>();
        for (int j : a) {
            pq.add(new kth_smallest(Math.abs(j - x), j));

            if (pq.size() > k) {
                pq.poll();
            }

        }
        System.out.println(pq);
        while (!pq.isEmpty()) {
            al.add(pq.peek().val);
            pq.poll();
        }
        return al;
    }

    static ArrayList<Integer> frequentNumbers(int[] a, int k) {
        PriorityQueue<kth_smallest> pq = new PriorityQueue<>();

        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> al = new ArrayList<>();
        for (int j : a) {
            if (!map.containsKey(j)) {
                map.put(j, 1);
            } else {
                map.put(j, map.get(j) + 1);

            }


        }
        for (int j : map.keySet()) {
            pq.offer(new kth_smallest(map.get(j), j));

            if (pq.size() > k) {
                pq.poll();
            }

        }

        while (!pq.isEmpty()) {
            al.add(pq.peek().val);
            pq.poll();
        }
        return al;
    }



}
