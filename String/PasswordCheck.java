import java.util.Scanner;
public class PasswordCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Your Password : ");
        String pass = sc.nextLine();
        sc.close();

        if(pass.length() >= 8){ // If password length is at least 8 then , check other condition

            boolean f = true;
            int num = 0;
            int cha = 0;

            for(int i = 0 ; i < pass.length() ;i++){
                char ch = pass.charAt(i); // Get the character at index 1 (e.g., 'e')
                int asciiValue = (int) ch;
                if(asciiValue >= 48 && asciiValue <= 57){ // checking Numbers
                    num++;
                }
                else if(!((asciiValue >= 65 && asciiValue <= 90) || (asciiValue >= 97 && asciiValue <= 122))){ // checking for not letters both uppercase and lowercase
                    System.out.println("Invalid password , Please enter only Letters and Numbers.");
                    f= false;
                    break;
                }
                else {
                    cha++;
                }
            }

            if(num >= 2 && f && cha > 0){ // all above condition satisfy then check for at least 2 numbers and atleast 1 letter
                System.out.println("Valid Password");
            }
            // if(num >= 2 && f){ // all above condition satisfy then check for at least 2 numbers
            //     System.out.println("Valid Password");
            // }
            else if(f){ // Or invalid password
                System.out.println("Invalid password , Please enter only Letters and Numbers.");
            }
        }
        else { // Invalid password , length sholud be >= 8
            System.out.println("Password is Invalid, please enter at least 8 character.");
        }
    }
}
