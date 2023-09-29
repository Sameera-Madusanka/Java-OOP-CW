package Skin_Consultation_Centre;

public class Consultation {
    private String date;
    private String time;

    private String consultPatient;
    private int consultPatientId;
    private String consultDoctor;
    private String consultSpecialisedField;
    private int consultPrice;                //for console and gui

    private String consultPatientSurname;     //for gui not used in console
    private String consultDOB;                 //for gui not used in console
    private String consultMobile;               //for gui not used in console



    static int ConsultationArrayIndex = 0;      // to increment no of object_array index
    static int guiConsultationArrayIndex = 0;


    public void setDate(String date){
        this.date=date;
    }
    public void setTime(String time){
        this.time=time;
    }
    public void setConsultPatient(String consultPatient){
        this.consultPatient = consultPatient;
    }
    public void setConsultPatientId(int consultPatientId){
        this.consultPatientId = consultPatientId;
    }
    public void setConsultDoctor(String consultDoctor){
        this.consultDoctor=consultDoctor;
    }
    public void setConsultSpecialisedField(String consultSpecialisedField){
        this.consultSpecialisedField = consultSpecialisedField;
    }


    public void setConsultPatientSurname(String consultPatientSurname){        //for gui
        this.consultPatientSurname= consultPatientSurname;
    }
    public void setConsultDOB(String consultDOB){                              //for gui
        this.consultDOB=consultDOB;
    }
    public void setConsultMobile(String consultMobile){                         //for gui
        this.consultMobile=consultMobile;
    }
    public void setConsultPrice(int consultPrice){
        this.consultPrice=consultPrice;
    }


    public String getDate(){
        return date;
    }
    public String getTime(){
        return time;
    }
    public String getConsultPatient(){
        return consultPatient;
    }
    public int getConsultPatientId(){
        return consultPatientId;
    }
    public String getConsultDoctor(){
        return consultDoctor;
    }
    public String getConsultSpecialisedField(){
        return consultSpecialisedField;
    }

    public String getConsultPatientSurname(){    //gui
        return consultPatientSurname;
    }
    public String getConsultDOB(){              //gui
        return consultDOB;
    }
    public String getConsultMobile(){          //gui
        return consultMobile;
    }
    public int getConsultPrice(){
        return consultPrice;
    }




    public String toString(){
        return  "Patient name : "+getConsultPatient()+"\n"+
                "Patient Id   : "+getConsultPatientId()+"\n"+
                "booked Consultation date and time: "+getDate()+" At "+getTime()+"\n"+
                "Consultation conduct by--> "+getConsultSpecialisedField()+" <--Specialist Dr."+getConsultDoctor()+"\n"+
                "Consultation cost : "+getConsultPrice();



    }
    public String guiConsultString(){
        return  "Patient name    : "+ getConsultPatient()+"\n"+
                "Patient surname : "+getConsultPatientSurname()+"\n"+
                "Patient DOB     : "+getConsultDOB()+"\n"+
                "Patient mobile number : "+getConsultMobile()+"\n"+
                "Patient ID : "+getConsultPatientId()+"\n"+
                "booked Consultation date and time: "+getDate()+" At "+getTime()+"\n"+
                "Consultation conduct by--> Dr."+getConsultDoctor()+" <--"+"\n"+
                "Price for the Consultation : "+getConsultPrice();

    }
}
