
import java.util.*;

import static ADMINMETHOD.NormalUser.normalUser;
import static Authentication.UserRegistration.registerUser;
import static Authentication.UserLogin. authenticateUser;
import Faculty.*;
import Student.StudentDetails;
import  static ADMINMETHOD.Admin.adminMehthod;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //USED COLLECTIONS FOR ADMIN DATA
        HashMap<String, String> h = new HashMap<>();
        ArrayList<StudentDetails>s=new ArrayList<>();
        ArrayList<FacultyInfo>a= new ArrayList<>();
        ArrayList<String>c=new ArrayList<>();



        h.put("Bhanuprakash", "1234");
        h.put("sohel", "1234");


        String username = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/collagemanagmentsystem";

        int logout=0;
    do{
        System.out.println("PRESS 1 FOR LOGIN: ");
        System.out.println("PRESS 0 FOR REGISTER: ");
        int choice = sc.nextInt();
        if (choice == 1) {
            System.out.println("ENTER USER NAME: ");
            String name = sc.next();
            System.out.println("ENTER PASSWORD: ");
            String password1 = sc.next();
            if (h.containsKey(name)) {
                if (h.get(name).equals(password1)) {
                        System.out.println("ADMIN LOGIN SUCCESFULLY");

                    adminMehthod();

                } else {
                   if(authenticateUser(url, username, password, name, password1))
                   {
                       normalUser(name);
                   }
                }
            } else {
                if(authenticateUser(url, username, password, name, password1))
                {
                    normalUser(name);
                }
            }
        } else if (choice == 0) {
            System.out.println("ENTER USERNAME: ");
            String username1 = sc.next();
            System.out.println("ENTER PASSWORD: ");
            String password2 = sc.next();
            System.out.println("ENTER EMAIL ID: ");
            String email = sc.next();
            registerUser(url, username, password, username1, password2, email);
            System.out.println("FOR LOGIN ");
            System.out.println("ENTER USER NAME: ");
            String name = sc.next();
            System.out.println("ENTER PASSWORD: ");
            String password1 = sc.next();
            if(authenticateUser(url, username, password, name, password1))
            {
                normalUser(name);
            }
        }
        else{
            System.out.println("PLEASE TRY AGAIN");
        }
        System.out.println("PRESS 0 FOR LOGOOUT: ");
        logout=sc.nextInt();
    }while (logout==0);

    }
}
