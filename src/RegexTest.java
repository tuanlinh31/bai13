import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args) {
        String flag;
        Scanner s = new Scanner(System.in);
        String exp = "";
        String str = "";
        while (true) {
            System.out.println("Enter Expression?");
            exp = s.nextLine();
            Pattern p = Pattern.compile(exp);

            while (true){
                System.out.println("Enter string to search");
                str = s.nextLine();
                Matcher m = p.matcher(str);
                boolean found = false;
                while (m.find()) {
                    found = true;
                    System.out.println("Found: " + m.group());
                    if (!found) {
                        System.out.println("not found.");
                    }else {
                        break;
                    }
                }
                System.out.println("Continue?");
                String rs = s.nextLine();
                if (rs.equalsIgnoreCase("N")) {
                    break;
                }
            }
            System.out.println("Bye bye");
        }
    }
}
