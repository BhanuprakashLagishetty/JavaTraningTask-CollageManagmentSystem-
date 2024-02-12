package Faculty;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FacultyInfo implements FacultyDetails {
    public String name;
    public String CollageName;
    public String Place;
    public HashMap<String,Integer>hcourse=new HashMap<>();

    public  void getDetails()
    {
        System.out.println("NAME OF THE FACULTY IS: "+name);
        System.out.println("COLLAGE WHERE FACULTY BELONGS TO: "+CollageName);
        System.out.println("PLACE WHERE FACULTY BELONGS TO: "+Place);
        System.out.println("COURSES AND EXPIRY DATES OF FACULTY: "+name);
        hcourse.entrySet().forEach((e)->{
            System.out.println("Course: "+e.getKey()+"------->EXPIRY Date: "+e.getValue());
        });
    }

}
