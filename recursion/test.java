package recursion;

class Recursion {
//    static int count = 0;
//    static LinkedList<Integer> list = new LinkedList<>();

    public static void main(String[] arg) {
//        int[] arr = {1, 2, 3};

//        System.out.println(pow(2, 4));
//       System.out.println("count = " + count);
//        System.out.println(path(22,1));
//        sort(arr, arr.length - 1);
//        System.out.println(list);
//        Stack<Integer> s = new Stack<>();
//        s.add(1);
//        s.add(2);
//        s.add(3);
//
//        System.out.println(s);
//
//        reverse(s);
//        System.out.println(s);
//        int n = 30;
//        "s".contentEquals()
//        towerOfHanio(1, 2, 3, n);
//        System.out.println("count = " + count);
        // String s = "a1b2";

        // permutationWithLetterCaseChange(s, "");
        //  System.out.println("1".toLowerCase());
        // permutationWithSpaces(s.substring(1), s.substring(0, 1));

        //  permutationWithCaseChange(s, "");
//        int A = 3;
//        int n = 25;
//
//        ArrayList<Integer> al = new ArrayList<>();
//
//        for (int i = 0; i < n; i++) {
//            al.add(i + 1);
//        }
//        System.out.println(al);
//        balancedParaenthesis(A, A, "", al);
//        System.out.println(al);
//        int k = 6;
        // n_bit_binaryNumber(0,0,"",n);
//        josephus(0, k - 1, al);
    }

    // recursion questions


    //
//    static int pow(int a, int b) {
//        count++;
//        if (b == 0)
//            return 1;
//        int temp = pow(a, b / 2);
//        if (b % 2 == 0)
//            return temp * temp;
//        else
//            return a * temp * temp;
//
//
//    }
//    static int path(int n,int m){
//        if(n ==1 || m==1) return 1;
//        return path(n,m-1) + path(m,n-1);
//    }
//    static void sort(int[] arr, int r) {
//        if (r == 0) {
//            list.add(arr[r]);
//            return;
//        }
//        sort(arr, r - 1);
//        // inserting array at correct position
//
//        int last = list.size() - 1;
//        insert(arr, last, r);
//    }
//
//    static void insert(int[] arr, int last, int r) {
//        if (last < 0 || list.isEmpty() || list.get(last) < arr[r]) {
//            list.add(++last, arr[r]);
//            return;
//        }
//
//        insert(arr, last - 1, r);
//    }
//    static void middle(int[] arr,int r,int k){
//        if(r == k-1)
//        {
//
//        }
//
//        int temp = arr[r];
//        middle(arr,r-1);
//
//    }
//    static void reverse(Stack<Integer> s) {
//        if (s.size() == 0)
//            return
//        int temp = s.pop();
//        reverse(s);
//        insert(s, temp);
//    }
//    static void insert(Stack<Integer> s,int temp){
//
//        if(s.isEmpty()) s.add(temp);
//        else{
//            int c = s.peek();
//            s.pop();
//            insert(s,temp);
//
//            s.add(c);
//        }
//    static void towerOfHanio(int s, int d, int h, int n) {
//        count++;
//        if (n == 1) {
//            System.out.printf("movee %d from %d to %d\n", n, s, d);
//            return;
//        }
//        towerOfHanio(s, h, d, n - 1);
//
//        System.out.printf("move %d from %d to %d\n", n, s, d);
//
//
//        towerOfHanio(h, d, s, n - 1);
//
//    }

//    static void permutationWithSpaces(String s, String output) {  //permutations with spaces
//        if (s.length() == 0) {
//            System.out.println(output);
//            return;
//        }
//        String out1 = output;
//        String out2 = output;
//
//        out1 += "-" + s.charAt(0);
//        out2 += s.charAt(0);
//
//        String input = s.substring(1);
//        permutationWithSpaces(input, out1);
//        permutationWithSpaces(input, out2);
//
//    }

//    static void permutationWithCaseChange(String s, String output) {
//        if (s.length() == 0) {
//            System.out.println(output);
//            return;
//        }
//        String out1 = output;
//        String out2 = output;
//
//        out1 += s.charAt(0);
//        out2 += s.toUpperCase().charAt(0);
//
//        String input = s.substring(1);
//        permutationWithCaseChange(input, out1);
//        permutationWithCaseChange(input, out2);
//
//    }

//    static void permutationWithLetterCaseChange(String s, String output) {
//        if (s.length() == 0) {
//            System.out.println(output);
//            return;
//        }
//
//
//        if (Character.isDigit(s.charAt(0))) {
//            String out1 = output;
//            out1 += s.charAt(0);
//            String input = s.substring(1);
//
//            permutationWithLetterCaseChange(input, out1);
//        } else {
//            String out1 = output;
//            String out2 = output;
//            out1 += s.toLowerCase().charAt(0);
//            out2 += s.toUpperCase().charAt(0);
//            String input = s.substring(1);
//            permutationWithLetterCaseChange(input, out1);
//            permutationWithLetterCaseChange(input, out2);
//        }


    //    }
//
//    static void balancedParaenthesis(int open, int close, String output, List<String> al) {
//        if (open == 0 && close == 0) {
//            al.add(output);
//            return;
//        }
//        if (open != 0) {
//            String out1 = output;
//            out1 += "(";
//            balancedParaenthesis(open - 1, close, out1, al);
//        }
//        if (close > open) {
//            String out2 = output;
//            out2 += ")";
//            balancedParaenthesis(open, close - 1, out2, al);
//        }
//
//    }
//
//    static void n_bit_binaryNumber(int ones, int zeros, String output, int n) {
//        if (n == 0) {
//            System.out.println(output);
//            return;
//        }
//
//        if (ones == zeros) {
//            String out1 = output;
//            out1 += "1";
//            n_bit_binaryNumber(ones + 1, zeros, out1, n - 1);
//        } else if (ones > zeros) {
//            String out1 = output;
//            String out2 = output;
//
//            out1 += "1";
//            out2 += "0";
//            n_bit_binaryNumber(ones + 1, zeros, out1, n - 1);
//            n_bit_binaryNumber(ones, zeros + 1, out2, n - 1);
//
//        }
//    }
//
//    static void josephus(int index, int k, ArrayList<Integer> al) {
//        if (al.size() <= 1) {
//            System.out.println("ans = " + al);
//            return;
//        }
//
//        int remove_index = (index + k) % al.size();
//        al.remove(remove_index);
//
//        josephus(remove_index, k, al);
//
//    }
}


