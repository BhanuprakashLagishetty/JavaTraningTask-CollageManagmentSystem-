package ADMINMETHOD;

import Faculty.FacultyInfo;
import Student.StudentDetails;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class Admin {
    public static Scanner sc=new Scanner(System.in);
    public static ArrayList<FacultyInfo> a= new ArrayList<>();
   public static ArrayList<StudentDetails>s=new ArrayList<>();
    public  static ArrayList<String>c=new ArrayList<>();
    public static  void adminMehthod(){
        int exit=1;
        do{
            System.out.println("PRESS 1 TO GET AVAILABLE FACULTY");
            System.out.println("PRESS 2 TO ADD FACULTY: ");
            System.out.println("PRESS 3 TO REMOVE FACULTY: ");
            System.out.println("PRESS 4 TO SKIP: ");
            int chooseoption=sc.nextInt();
            switch (chooseoption)
            {
                case 1:
                    System.out.println("AVAILABLE FACULTYS ARE: ");
                    if(a.size()==0)
                    {
                        System.out.println("<-----------------AVAILABLE FACULTY ARE-------------->");
                        System.out.println();
                        System.out.println("NO RECORDS FOUND");
                        System.out.println();
                        System.out.println("<---------------------------------------------------->");
                    }
                    else{
                        a.forEach((e)->{
                            System.out.println();
                            System.out.println("--------------------------><----------------------");
                            e.getDetails();
                            System.out.println("--------------------------><----------------------");
                            System.out.println();
                        });
                    }
                    break;
                case 2:
                    System.out.println("ENTER FACULTY NAME");
                    String Facultyname=sc.next();
                    System.out.println("ENTER ENTER COLLAGE THEY BELONGS TO: ");
                    String FacultyCollage=sc.next();
                    System.out.println("ENTER PLACE THEY BELONGS TO: ");
                    String FacultyPlace=sc.next();
                    FacultyInfo f=new FacultyInfo();
                    f.name=Facultyname;
                    f.CollageName=FacultyCollage;
                    f.Place=FacultyPlace;
                    int morecourse=1;
                    do{
                        System.out.println("ENTER THE COURSE NAME: ");
                        String courname=sc.next();
                        System.out.println("ENTER THE EXPIRY DATE OF COURSE: ");
                        int expery2=sc.nextInt();
                        f.hcourse.put(courname,expery2);
                        System.out.println("DO YOU WANT TO ENTER MORE COURSES: ");
                        System.out.println("PRESS 1 FOR  ONE MORE COURSE: ");
                        System.out.println("PRESS O FOR EXIT: ");
                        morecourse=sc.nextInt();
                    }while(morecourse==1);
                    a.add(f);
                    break;
                case 3:
                    System.out.println("PLEASE ENTER FACULTY NAME: ");
                    String facultyname1=sc.next();
                    //USED STEAMS
                    Iterator iterator = a.iterator();
                    int n=a.size();
                    for(int i=0;i<n;i++)
                    {
                        if(a.get(i).name.equalsIgnoreCase(facultyname1))
                        {
                            a.remove(i);
                        }
                    }
                    break;
                case 4:
                    exit=2;
                    break;
            }
        }while (exit==1);
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
                    //USED STEAMS
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
                        e.hcourse.entrySet().forEach((e2)->{
                            System.out.println("COURSE IS: "+e2.getKey()+" EXPIRY DATE: "+e2.getValue());
                        });
                    });
                    System.out.println("<------------------------------------------------------->");
                    break;
                case 3:
                    System.out.println("<----------------------NAMES OF FACULTY------------------->");
                    System.out.println("FACULTY NAMES ARE: ");

                    //USED STEAM
                    a.forEach((e)->{
                        System.out.println(e.name);
                    });
                    System.out.println("ENTER FACULTY NAME TO GET COURSE TEACHED BY FACULTY: ");
                    String facultycourse=sc.next();
                    System.out.println("<------------DETAILS OF FACULTY-------------->");
                    a.forEach((e)->{
                        if(e.name.equals(facultycourse))
                        {
                            //USED STEAM
                            e.hcourse.entrySet().forEach((e2)->{
                                System.out.println("COURSE NAME: "+e2.getKey()+"  EXPIRy DATE: "+e2.getValue());
                            });
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
                    //USE STEAM
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
                        //USED STEAM
                        a.forEach((e)->{
                            e.hcourse.entrySet().forEach((e2)->{
                                if(e2.getValue()==year)
                                {
                                    System.out.println("NAME OF FACULTY IS: "+e.name);
                                    System.out.println("COUR AVAILABLE IN THIS "+ year+" IS"+e2.getKey());
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

