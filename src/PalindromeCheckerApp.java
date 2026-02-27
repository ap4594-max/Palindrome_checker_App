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

    public static void main(String[] args) {
        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version: 1.0");
        System.out.println("System initialized successfully");
    }
}