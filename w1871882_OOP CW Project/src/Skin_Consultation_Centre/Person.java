package Skin_Consultation_Centre;

import java.util.Scanner;

public class Person {
    private String name;
    private String surname;
    private String dateOfBirth;
    private String mobileNumber;       //best data type for storing mobile numbers

                   //setters for access and change private variable
    public void setName(String name){
        this.name=name;
    }
    public void setSurname(String surname){
        this.surname=surname;
    }
    public void setDateOfBirth(String dateOfBirth){
        this.dateOfBirth=dateOfBirth;
    }
    public void setMobileNumber(String mobileNumber){
        this.mobileNumber=mobileNumber;
    }

                    //getters for view object of the variable

    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public String getDateOfBirth(){
        return dateOfBirth;
    }
    public String getMobileNumber(){
        return mobileNumber;
    }

    public void add(){
        Scanner scanner= new Scanner(System.in);

        System.out.println("Enter name");
        String name = scanner.nextLine();
        name=name.trim();
        setName(name);

        System.out.println("Enter Surname");
        String sname = scanner.nextLine();
        sname=sname.trim();
        setSurname(sname);

        System.out.println("Enter Date of birth");
        String dob = scanner.nextLine();
        dob=dob.trim();
        setDateOfBirth(dob);

        System.out.println("Enter Mobile number");
        String mno = scanner.nextLine();
        mno=mno.trim();
        setMobileNumber(mno);
    }
}
