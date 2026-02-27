import java.util.*;
public class PalindromeCheckerApp {

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

        sc.close();

    }
}