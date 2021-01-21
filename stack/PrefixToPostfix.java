package stack;

import java.util.Stack;

public class PrefixToPostfix {
    public static void main(String[] arg){
        Stack<String> stack = new Stack<>();
        String s = "*+AB-CD";
        for (int i = s.length()-1; i >-1 ; i--) {
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c))
            {
                stack.push(String.valueOf(c));
            }
            else{
                String s1 = stack.pop();
                String s2 = stack.pop();
                String temp =  s1 + s2 + c ;
                stack.push(temp);
            }

        }
        System.out.println(stack);

    }
}
