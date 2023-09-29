package Skin_Consultation_Centre;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WestminsterSkinConsultationManager implements SkinConsultationManager{
    static Doctor[] doctorArray = new Doctor[10];    // maximum no of doctors are 10 (mentioned)
    static Patient[] patientArray = new Patient[20];
    static Consultation[] consultationsArray = new Consultation[20];
    static Consultation[] guiConsultationArray = new Consultation[20];

    // these methods called by main method of the interface(it includes main method)
    public static void addDoctor() {
        Doctor doctor = new Doctor();
        doctor.add();
        doctorArray[Doctor.doctorArrayIndex] = doctor;
        Doctor.doctorArrayIndex++;
        System.out.println("** You successfully add a doctor ** ");

    }
    public static void deleteDoctor() {


        System.out.println("If you want remove a doctor Please enter '--> Medical Licence Number <--' of the doctor");
        System.out.println();
        System.out.println("Available doctors down below");
        for (int i = 0; i < doctorArray.length; i++) {
            if (doctorArray[i] == null) {
                continue;
            } else {
                System.out.println(doctorArray[i].getMedicalLicenceNumber() + " : " + "Dr." + doctorArray[i].getName());

            }

        }
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        int mln = scanner.nextInt();
        scanner.nextLine();        // to skip line
        try {
            for (int y = 0; y < doctorArray.length; y++) {
                if (doctorArray[y] == null) {
                    System.out.println("Please enter correct number");
                    break;
                } else {
                    if (doctorArray[y].getMedicalLicenceNumber() == mln) {
                        doctorArray[y] = null;                           //There is no delete in java, and all objects are created on the heap.
                        System.out.println("Dr " + mln + " has been deleted");// The JVM has a garbage collector that relies on reference counts.
                        break;                                              //Once there are no more references to an object, it becomes available for collection by the garbage collector.
                    } else {
                        continue;
                    }
                }

            }
        } catch (NullPointerException n) {
            System.out.println("Please enter correct number");

        }
        // showing the available doctor count
        int doctorCounter= 0;
        for (int k = 0; k < doctorArray.length; k++ ){
            if (doctorArray[k]== null){
                break;
            }
            else{
                doctorCounter++;
            }
        }
        System.out.println("Total number of doctors in the centre : "+doctorCounter);

    }
    public static void addConsultations(){

        System.out.println("Please enter patient information first to check available doctors and book a consultations");
        Patient patient = new Patient();
        patient.add();


        Consultation consultation = new Consultation();             // creating consultation object
        consultation.setConsultPatientId(patient.getPatientId());  // assign patient id of patient object to patient id of consultation object
        consultation.setConsultPatient(patient.getName());

        patientArray[Patient.patientArrayIndex] = patient;
        Patient.patientArrayIndex++;

        System.out.println("Which specialist do you want to meet? ");
        System.out.println("Press 'c' for cosmetic dermatology \nPress 'm' for medical dermatology \n" +
                "Press 'p' for paediatric dermatology \nPress 'o' for other specialisation");
        Scanner scanner = new Scanner(System.in);
        String requirment = scanner.nextLine();
        String spc = "";

        if (requirment.equals("c")) {
            spc = "cosmetic dermatology";
            consultation.setConsultSpecialisedField("cosmetic dermatology");
        } else if (requirment.equals("m")) {
            spc = "medical dermatology";
            consultation.setConsultSpecialisedField("medical dermatology");
        } else if (requirment.equals("p")) {
            spc = "paediatric dermatology";
            consultation.setConsultSpecialisedField("paediatric dermatology");
        } else if (requirment.equals("o")) {
            spc = "other specialisation";
            consultation.setConsultSpecialisedField("other specialisation");
        } else {
            System.out.println("You entered wrong letter");
        }


        for (int z = 0; z < doctorArray.length; z++) {
            if (doctorArray[z] == null) {
                break;                    //to prevent NullPointerException occurring
            } else {
                if (doctorArray[z].getSpecialisation().equals(spc)) {
                    System.out.println("Enter date");
                    String addDate = scanner.nextLine();
                    consultation.setDate(addDate);

                    System.out.println("Enter time");
                    String addTime = scanner.nextLine();
                    consultation.setTime(addTime);

                    System.out.println("Enter No of Hours to calculate cost  (£25 per hour)");
                    int noOfHours = scanner.nextInt();
                    consultation.setConsultPrice(25*noOfHours);
                    scanner.nextLine();

                    consultation.setConsultDoctor(doctorArray[z].getName());
                    consultationsArray[Consultation.ConsultationArrayIndex] = consultation;
                    Consultation.ConsultationArrayIndex++;

                    System.out.println("*** You successfully booked a consultation ***");
                    System.out.println();
                    System.out.println("Your doctor is Dr." + doctorArray[z].getName() +"\n"+
                            " And he is Specialised on " + doctorArray[z].getSpecialisation() +"\n"+
                            " your consultation date and time are " + consultation.getDate() + " at " + consultation.getTime()+"\n"+
                            " The cost is :"+consultation.getConsultPrice());
                    System.out.println();


                } else {
                    continue;
                }

            }

        }



    }
    public static void cancelConsultations(){

        System.out.println("Booked consultations");
        for (int i = 0; i < consultationsArray.length; i++) {
            if (consultationsArray[i] == null) {
                //continue;
                break;
            } else {
                System.out.println(consultationsArray[i].toString());
                System.out.println();

            }

        }
        System.out.println("Enter the patient id of the patient to --> cancel <-- the booked consultation");
        Scanner scanner = new Scanner(System.in);
        int pid = scanner.nextInt();
        scanner.nextLine();
        for (int j = 0; j < consultationsArray.length; j++) {
            if (consultationsArray[j] == null) {
                break;
            } else {
                if (pid == consultationsArray[j].getConsultPatientId()) {
                    consultationsArray[j] = null;
                    System.out.println("consultation who assigned to patient " + pid + " has been deleted ");

                }
            }
        }



    }
    public static void printListOfDoctors(){

        for (int i = 0; i < doctorArray.length; i++) {
            if (doctorArray[i] == null) {
                //continue;
                break;
            } else {
                System.out.println(doctorArray[i].toString());
                System.out.println();


            }
        }

    }
    public static void printAndSave() throws IOException {

        FileWriter writer = new FileWriter("print_file.txt");
        System.out.println("------------------------------Doctors list------------------------------");
        System.out.println();
        writer.write("------------------------------Doctors list------------------------------\n");     // for text file

        for (int a = 0; a < doctorArray.length; a++) {
            if (doctorArray[a] == null) {
                //continue;
                break;

            } else {
                System.out.println(doctorArray[a].toString());  //printing to console
                System.out.println();
                writer.write(doctorArray[a].toString());       // printing to text file
                writer.write("");
            }

        }
        System.out.println("------------------------------Patient list------------------------------");
        System.out.println();
        writer.write("\n------------------------------Patient list------------------------------\n");
        for (int b = 0; b < patientArray.length; b++) {
            if (patientArray[b] == null) {
                break;
            } else {
                System.out.println(patientArray[b].toString());
                System.out.println();
                writer.write(patientArray[b].toString());
                writer.write("");

            }

        }
        System.out.println("------------------------------Consultation List------------------------------");
        System.out.println();
        writer.write("\n------------------------------Consultation List------------------------------\n");
        writer.write("");

        for (int c = 0; c< consultationsArray.length; c++){
            if(consultationsArray[c]==null){
                break;
            }else{
                System.out.println(consultationsArray[c].toString());
                System.out.println();
                writer.write(consultationsArray[c].toString());
                writer.write("");

            }
        }
        writer.close();


    }


}







