package edu.kit.informatik;

public class CalendarManagement {
     /**
      * the main Method 
      *
      * @param args
      *    main parameter
      */
    public static void main(String[] args) {
         Calendar c = new Calendar();
         String givenStatement = "";
         while (givenStatement.compareTo("quit") != 0) {
         givenStatement = Terminal.readLine();
         if (givenStatement.compareTo("quit") != 0) {
              c.doWork(givenStatement);
         }
         }
    }
}
