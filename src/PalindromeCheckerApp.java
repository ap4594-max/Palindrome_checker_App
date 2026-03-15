import java.util.*;
public class PalindromeCheckerApp {

    static class PalindromeCheckerclass {

        public boolean checkPalindrome(String str) {
            Stack<Character> stack = new Stack<>();
            for(char c : str.toCharArray()){
                stack.push(c);
            }
            for(char c : str.toCharArray()){
                if(stack.pop() != c){
                    return false;
                }
            }
            return true;
        }
    }

    public static Boolean PalindromeChecker(String str){
        int i = 0;
        int j = str.length()-1;
        while(i<j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static Boolean PalindromeChecker2(String str){
        String duplicateString = str;
        String reverse =  "";
        for(int i = str.length() -1 ;i>=0;i--){
            reverse = reverse + str.charAt(i);
        }
        return duplicateString.equals(reverse);

    }

    public static Boolean PalindromeChecker3(String str){
        char[] chars = str.toCharArray();

        int end  = chars.length -1 ;
        for(int i=0,j=end;i<chars.length;i++,j--){
            if(chars[i] != chars[j]) return false;
        }
        return true;
         
    }

    public static Boolean PalindromeChecker4(String str){
        Stack<Character> st = new Stack<>();

        for(int i=0;i<str.length();i++){
            st.push(str.charAt(i));
        }
        int i=0;
        while(!st.isEmpty()){
            if(st.pop() == str.charAt(i)) return false;
        }
        return true;
    }

    public static Boolean PalindromeChecker5(String str){
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> st = new Stack<>();

        for(int i=0;i<str.length();i++){
            st.push(str.charAt(i));
            queue.add(str.charAt(i));
        }

        while(!st.isEmpty()){
            if(st.pop() != queue.remove()) return false;
        }
        return true;
    }

    public static Boolean PalindromeChecker6(String str){
       Deque<Character> deque = new ArrayDeque<>();

        for(int i=0;i<str.length();i++){
            deque.add(str.charAt(i));
        }

        while(deque.size() > 1){
            char front = deque.removeFirst();
            char last = deque.removeLast();
            if (front != last) return false;
            
        }
        return true;
    }
    public static Boolean PalindromeChecker7(String str){
        LinkedList<Character> list = new LinkedList<>();

        for(char c : str.toCharArray()){
            list.add(c);
        }

        LinkedList<Character> reversed = new LinkedList<>();

        for(char c: list){
            reversed.addFirst(c);
        }

        if(list.equals(reversed)){
            return true;
        }
        return false;
    }

    public static Boolean PalindromeChecker8(String str,int start , int end){
        if(start >= end){
            return true;
        }

        if(str.charAt(start) != str.charAt(end)){
            return false;
        }

        return PalindromeChecker8(str, start+1, end-1);

    }

    public static Boolean PalindromeChecker9(String str){

        str = str.toLowerCase().replaceAll("\\s+","");
        int i = 0;
        int j = str.length() -1;
        while(i<j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version: 1.0");
        System.out.println("System initialized successfully");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter input text : ");
        String str = sc.nextLine();

        System.out.println(PalindromeChecker(str));
        System.out.println(PalindromeChecker2(str));
        System.out.println(PalindromeChecker3(str));
        System.out.println(PalindromeChecker4(str));
        System.out.println(PalindromeChecker5(str));
        System.out.println(PalindromeChecker6(str));
        System.out.println(PalindromeChecker7(str));
        System.out.println(PalindromeChecker8(str, 0, str.length()-1));
        System.out.println(PalindromeChecker9(str));
        PalindromeCheckerclass checker = new PalindromeCheckerclass();
        checker.checkPalindrome(str);
        sc.close();

    }
}