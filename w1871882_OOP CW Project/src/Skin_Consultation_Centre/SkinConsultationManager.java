package Skin_Consultation_Centre;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public interface SkinConsultationManager{

   public static void main(String[] args) throws IOException {

      for (int i = 0; i < 100; i++) {

         //display menu

         System.out.println("<<------------------------------------ CONSOLE MAIN MENU ------------------------------------>>");
         System.out.println();
         System.out.println("*** You have to add doctors first to book a consultation ***");
         System.out.println();

         System.out.println("PRESS 1 TO ADD A DOCTOR TO THE LIST");
         System.out.println("PRESS 2 TO DELETE A DOCTOR FROM THE LIST");
         System.out.println("PRESS 3 TO ADD A CONSULTATION");
         System.out.println("PRESS 4 TO CANCEL A CONSULTATION");
         System.out.println("PRESS 5 TO PRINT LIST OF DOCTORS");
         System.out.println("PRESS 6 TO PRINT AND SAVE");
         System.out.println("PRESS 7 TO ENTER ---> GUI MODE <---");


         Scanner scanner = new Scanner(System.in);
         try{
            int choice = scanner.nextInt();
            scanner.nextLine(); // to clear the new line

            if (choice == 1) {
               WestminsterSkinConsultationManager.addDoctor();

            } else if (choice == 2) {
               WestminsterSkinConsultationManager.deleteDoctor();

            } else if (choice == 3) {
               WestminsterSkinConsultationManager.addConsultations();

            } else if (choice == 4) {
               WestminsterSkinConsultationManager.cancelConsultations();

            } else if (choice == 5) {
               WestminsterSkinConsultationManager.printListOfDoctors();


            } else if (choice == 6) {
               WestminsterSkinConsultationManager.printAndSave();

            }else if (choice ==7 ){

               MyFrame myFrame = new MyFrame();
               myFrame.firstFrame();

            }

         }
         catch (InputMismatchException e){
            System.out.println("Please enter only 'integers'\n");
         }
         catch(Exception e){
            System.out.println("Something went wrong\n");
         }



         System.out.println("Would you like to go back to console menu? Press 'Y' to go menu or press 'N' to exit ");
         String respond = scanner.nextLine();
         if (respond.equalsIgnoreCase("Y")) {
            continue;
         } else if (respond.equalsIgnoreCase("N")) {
            break;
         } else {
            System.out.println("Anyways you entered the wrong input you will redirect to console");

         }

      }

   }

}
