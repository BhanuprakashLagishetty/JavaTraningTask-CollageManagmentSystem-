package ADMINMETHOD;

import Student.StudentDetails;

import java.util.Scanner;

import static ADMINMETHOD.Admin.a;
import static ADMINMETHOD.Admin.s;

public class NormalUser {
    public  static void normalUser(String name)
    {
        Scanner sc=new Scanner(System.in);
        StudentDetails s3=new StudentDetails();
        System.out.println("AVAILABLE COURSE");
        System.out.println("<----------------AVAILABLE COURSES ARE------------------>");
        //USED STEAM
        a.forEach((e)->{
            e.hcourse.entrySet().forEach((e2)->{
                System.out.println("COURSE IS: "+e2.getKey()+" EXPIRY DATE: "+e2.getValue());
            });
        });
        System.out.println("<------------------------------------------------------->");
        System.out.println("CHOOSE COURSE: ");
        s3.Course=sc.next();
        s3.Name=name;
        s.add(s3);
        System.out.println("COURSE REGISTERD SUCCESFULLY");
        int operation3=1;
        do{
            System.out.println("1 FOR GET  NAMES OF THE FACULTIES");
            System.out.println("2. FOR GET AVAILABLE COURSES");
            System.out.println("3. FOR GET FACULTY NAMES");
            System.out.println("4. FOR GET NUMBER OF STUDENTS REGISTER FOR PARTICULAR COURSE");
            System.out.println("5. FOR GET AVAILABLE COURSES BASED ON EXPIRY DATE");
            System.out.println("6. FOR EXIT");
            int choose=sc.nextInt();
            switch (choose)
            {
                case 1:
                    a.forEach((e)->{
                        System.out.println();
                        System.out.println("--------------------------><----------------------");
                        e.getDetails();
                        System.out.println("--------------------------><----------------------");
                        System.out.println();
                    });
                    break;
                case 2:
                    System.out.println("<----------------AVAILABLE COURSES ARE------------------>");
                    a.forEach((e)->{
                        e.hcourse.forEach((key, value) -> System.out.println("COURSE IS: " + key + " EXPIRY DATE: " + value));
                    });
                    System.out.println("<------------------------------------------------------->");
                    break;
                case 3:
                    System.out.println("<----------------------NAMES OF FACULTY------------------->");
                    System.out.println("FACULTY NAMES ARE: ");
                    a.forEach((e)->{
                        System.out.println(e.name);
                    });
                    System.out.println("ENTER FACULTY NAME TO GET COURSE TEACHED BY FACULTY: ");
                    String facultycourse=sc.next();
                    System.out.println("<------------DETAILS OF FACULTY-------------->");
                    a.forEach((e)->{
                        if(e.name.equals(facultycourse))
                        {
                            e.hcourse.forEach((key, value) -> System.out.println("COURSE NAME: " + key + "  EXPIRy DATE: " + value));
                        }
                    });
                    System.out.println("<----------------------------------------------->");
                    break;
                case 4:
                    System.out.println("ENTER COURSE NAME: ");
                    String c1name=sc.next();
                    System.out.println();
                    System.out.println("<--------------------REGISTERED STUDENTS------------------>-");
                    System.out.println();
                    System.out.println(s.size());
                    s.forEach((e)->{
                        if(e.Course.equals(c1name))
                        {
                            System.out.println();
                            System.out.println("STUDENT NAME: "+e.Name);
                            System.out.println("COURSE: "+e.Course);
                            System.out.println();
                        }
                    });
                    System.out.println();
                    System.out.println("--------------------------------------------------------");
                    break;
                case 5:
                    System.out.println("ENTER EXPIRY YEAR");
                    int year=sc.nextInt();
                    System.out.println("<-------------------COURSE ON EXPIRY YEAR----------------->");
                    try{
                        a.forEach((e)->{
                            //USED STEAM
                            e.hcourse.forEach((key, value) -> {
                                if (value == year) {
                                    System.out.println("NAME OF FACULTY IS: " + e.name);
                                    System.out.println("COUR AVAILABLE IN THIS " + year + " IS" + key);
                                }
                            });
                        });
                        System.out.println("--------------------------------------------------------");
                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;
                case 6:
                    operation3=2;
            }
        }while (operation3==1);
    }
}
