import java.util.*;
public class PalindromeCheckerApp {

    interface PalindromeStrategy{
        boolean check(String str);
    }

    static class StackStrategy implements PalindromeStrategy{
        public boolean check(String str){
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
    

    static class DequeStrategy implements PalindromeStrategy {
        public boolean check(String str) {
            Deque<Character> deque = new ArrayDeque<>();
            for(char c : str.toCharArray()){
                deque.add(c);
            }
            while(deque.size() > 1){
                if(deque.removeFirst() != deque.removeLast()){
                    return false;
                }
            }
            return true;
        }
    }

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

    static class PalindromeService {
        private PalindromeStrategy strategy;
        public PalindromeService(PalindromeStrategy strategy){
            this.strategy = strategy;
        }
        public boolean checkPalindrome(String str){
            return strategy.check(str);
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

    public static void performanceTest(String str){

        long start;
        long end;

        start = System.nanoTime();
        PalindromeChecker(str);
        end = System.nanoTime();
        System.out.println("Two Pointer Method: " + (end - start) + " ns");


        start = System.nanoTime();
        PalindromeChecker5(str);
        end = System.nanoTime();
        System.out.println("Stack + Queue Method: " + (end - start) + " ns");


        start = System.nanoTime();
        PalindromeChecker6(str);
        end = System.nanoTime();
        System.out.println("Deque Method: " + (end - start) + " ns");


        start = System.nanoTime();
        PalindromeChecker8(str,0,str.length()-1);
        end = System.nanoTime();
        System.out.println("Recursion Method: " + (end - start) + " ns");
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

        PalindromeStrategy strategy;
        strategy = new StackStrategy();
        PalindromeService service = new PalindromeService(strategy);
        boolean result = service.checkPalindrome(str);
        System.out.println("Strategy Result: " + result);

        performanceTest(str);
        sc.close();

    }
}