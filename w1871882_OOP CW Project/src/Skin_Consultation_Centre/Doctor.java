package Skin_Consultation_Centre;

import java.util.Locale;
import java.util.Scanner;

public class Doctor extends Person {

    private int medicalLicenceNumber;
    private String specialisation;

    static int doctorArrayIndex = 0;


    public void setMedicalLicenceNumber(int medicalLicenceNumber){
        this.medicalLicenceNumber=medicalLicenceNumber;
    }
    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }
    public int getMedicalLicenceNumber(){
        return medicalLicenceNumber;
    }
    public String getSpecialisation(){
        return specialisation;
    }

    @Override
    public void add() {

        super.add();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter medical licence Number of Doctor");
        int lNumber = scanner.nextInt();
        scanner.nextLine(); // to skip new line
        setMedicalLicenceNumber(lNumber);

        System.out.println("Enter his/her specialisation");
        System.out.println("Press 'c' for cosmetic dermatology \nPress 'm' for medical dermatology \n" +
                "Press 'p' for paediatric dermatology \nPress 'o' for other specialisation");
        String choice = scanner.nextLine();
        choice= choice.toLowerCase();
        if (choice.equals("c") ){
            setSpecialisation("cosmetic dermatology");
        }
        else if (choice.equals("m")){
            setSpecialisation("medical dermatology");
        }
        else if (choice.equals("p")){
            setSpecialisation("paediatric dermatology");
        }
        else if (choice.equals("o")){
            setSpecialisation("other specialisation");
        }
        else {
            System.out.println("You entered wrong letter");
        }
    }

    public String toString(){
        return   "Name                   : "+super.getName()+"\n"
                +"Surname                : "+ super.getSurname()+"\n"
                +"Date of birth          : "+ super.getDateOfBirth()+"\n"
                +"Mobile number          : "+ super.getMobileNumber()+"\n"
                +"Medical licence number : "+ getMedicalLicenceNumber() +"\n"
                +"Specialisation         : "+getSpecialisation();
    }
    public String guiToString(){
        return  "Name           : "+"DR."+super.getName()+"\n"+
                "Specialized on :"+getSpecialisation();
    }


}
