package Skin_Consultation_Centre;

public class Patient extends Person{
    private int patientId;
    static int patientIndex = 10;
    static int patientArrayIndex = 0;


    public void setPatientId(int patientId){
        this.patientId=patientId;
    }
    public int getPatientId(){
        return patientId;
    }

    @Override
    public void add() {
        super.add();
        System.out.println("Your id is "+patientIndex+" please wait");
        setPatientId(patientIndex);

        patientIndex++;

    }
    public String toString(){
        return  "Patient id        : "+getPatientId()+"\n" +
                "Patient name      : "+super.getName()+"\n"+
                "Patient surname   : "+super.getSurname()+"\n"+
                "Patient DOB       : "+super.getDateOfBirth()+"\n"+
                "Patient mobile NO : "+super.getMobileNumber();
    }


}
