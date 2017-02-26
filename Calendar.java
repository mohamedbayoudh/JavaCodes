package edu.kit.informatik;

import edu.kit.informatik.calendar.Appointment;
import edu.kit.informatik.calendar.Date;
import edu.kit.informatik.calendar.DateTime;
import edu.kit.informatik.calendar.DateUtil;
import edu.kit.informatik.calendar.Time;
import edu.kit.informatik.sortierteListe.LinkedSortedAppendList;
import edu.kit.informatik.sortierteListe.SortedIterator;

public class Calendar {
     /**
      * 
      */
     LinkedSortedAppendList<Appointment> lApp = new LinkedSortedAppendList<Appointment>();

     /**
      * 
      * @param givenStatement
      *            the given Statement
      */
     protected void doWork(String givenStatement) {
          String test = "";
          int i = 0;
          while (givenStatement.charAt(i) != ' ') {
               test = test + givenStatement.charAt(i);
               i++;
          }
          switch (test) {
          case "add":
               doAdd(givenStatement);
               break;
          case "print":
               doPrint(givenStatement);
               break;
          default:
               Terminal.printLine("you have added the falsch statement please repeat");
               break;
          }
     }

     /**
      * 
      * @param givenStatement
      *            the given Statement
      */
     private void doAdd(String givenStatement) {
          int i = 16;
          String statement = "";
          while (i < givenStatement.length()) {
               statement = statement + givenStatement.charAt(i);
               i++;
          }
          Appointment app = DateUtil.parseAppointment(statement);
          this.lApp.addSorted(app);

     }

     /**
      * 
      * @param givenStatement
      *            the given Statement
      */
     private void doPrint(String givenStatement) {
          if (givenStatement.compareTo("print appointments") == 0) {
               SortedIterator<Appointment> it = lApp.iterator();
               while (it.hasNext()) {
                    Terminal.printLine(it.next().toString());
               }
          } else {
               String a = delete(givenStatement, 19);
               String abbreviation = "";
               abbreviation = abbreviation + a.charAt(0);
               abbreviation = abbreviation + a.charAt(1);
               switch (abbreviation) {
               case "on":
                    doOn(a);
                    break;
               case "in":
                    doIn(a);
                    break;
               case "th":
                    doThat(a);
                    break;
               default:
                    Terminal.printLine("Please enter a valid Kommando");
                    break;
               }
          }
     }

     /**
      * 
      * @param givenStatement
      *            the given Statement
      */
     private void doOn(String givenStatement) {
          String a = delete(givenStatement, 3);
          Date onDate = DateUtil.parseDate(a);
          SortedIterator<Appointment> it = lApp.iterator();
          while (it.hasNext()) {
               Appointment app = it.next();
               DateTime from = app.getFrom();
               Date fromDate = from.getDate();
               Time fromTime = from.getTime();
               DateTime to = app.getTo();
               Date toDate = to.getDate();
               Time toTime = to.getTime();
               if ((onDate.compareTo(fromDate) == 0) && (onDate.compareTo(toDate) == 0)
                         && (fromTime.compareTo(new Time(00, 00, 00)) >= 0)
                         && (toTime.compareTo(new Time(23, 59, 59)) <= 0)) {
                    Terminal.printLine(app);
               }
          }
     }

     /**
      * 
      * @param givenStatement
      *      the given Statement
      */
     private void doIn(String givenStatement) {
          String a = delete(givenStatement, 12);
          int i = 0;
          String startDate = "";
          while (a.charAt(i) != ' ') {
               startDate = startDate + a.charAt(i);
               i++;
          }
          String endDate = delete(a, i + 1);
          DateTime sDate = DateUtil.parseDateTime(startDate);
          DateTime eDate = DateUtil.parseDateTime(endDate);
          SortedIterator<Appointment> it = lApp.iterator();
          while (it.hasNext()) {
               Appointment app = it.next();
               DateTime from = app.getFrom();
               DateTime to = app.getTo();
               if ((from.compareTo(sDate) >= 0) && (to.compareTo(eDate) <= 0)) {
                    Terminal.printLine(app);
               }
          }

     }

     /**
      * 
      * @param givenStatement
      *      the given Statement
      */
     private void doThat(String givenStatement) {
          String a = delete(givenStatement, 5);
          switch (a.charAt(0)) {
          case 'c':
               doConflict(a);
               break;
          case 's':
               doStart(a);
               break;
          default:
               Terminal.printLine("Please Type a Valid Kommando");
               break;
          }
     }

     /**
      * 
      * @param givenStatement
      *      the given Statement
      */
     private void doConflict(String givenStatement) {
          String initialisation = "Appointment not found.";
          String name = "";
          SortedIterator<Appointment> it = lApp.iterator();
          String a = delete(givenStatement, 14);
          DateTime appFrom = null;
          DateTime appTo = null;
          Appointment app = null;
          while (it.hasNext()) {
               app = it.next();
               name = app.getName();
               appFrom = app.getFrom();
               appTo = app.getTo();
               if (name.compareTo(a) == 0) {
                    initialisation = "";
                    break;
               } else {
                    initialisation = "Appointment not found.";
               }
          }
          if (initialisation.compareTo("") != 0) {
               Terminal.printLine(initialisation);
               return;
          } else {
               it = lApp.iterator();
               while (it.hasNext()) {
                    Appointment currentApp = it.next();
                    DateTime currentFrom = currentApp.getFrom();
                    DateTime currentTo = currentApp.getTo();
                    if (currentTo.compareTo(appFrom) >= 0) {
                         if (((currentFrom.compareTo(appFrom) <= 0) && (currentTo.compareTo(appTo) <= 0))
                                   || ((currentFrom.compareTo(appFrom) >= 0) && (currentTo.compareTo(appTo) <= 0))) {
                              if (currentApp.compareTo(app) != 0) {
                                   Terminal.printLine(currentApp);
                              }
                         }

                    }
               }
          }
     }

     /**
      * 
      * @param givenStatement
      *      the given Statment
      */
     private void doStart(String givenStatement) {
          String a  = delete(givenStatement, 13);
          DateTime pointOfTime = DateUtil.parseDateTime(a);
          SortedIterator<Appointment> it = lApp.iterator();
          while (it.hasNext()) {
               Appointment app = it.next();
               DateTime from = app.getFrom();
               if (from.compareTo(pointOfTime) < 0) {
                    Terminal.printLine(app);
               }
          }
     }

     /**
      * 
      * @param str : the string to change it 
      * @param until : the number of the caracters to delete it 
      * @return a new String with the new changes
      */
     private String delete(String str, int until) {
          int i;
          String test = "";
          for (i = until; i < str.length(); i++) {
               test = test + str.charAt(i);

          }
          return test;
}
}