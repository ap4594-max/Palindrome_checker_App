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

    public static void main(String[] args) {
        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version: 1.0");
        System.out.println("System initialized successfully");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter input text : ");
        String str = sc.nextLine();

        System.out.println(PalindromeChecker(str));
        System.out.println(PalindromeChecker2(str));

    }
}