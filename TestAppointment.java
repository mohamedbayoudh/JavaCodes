package edu.kit.informatik.calendar;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;


import edu.kit.informatik.calendar.Appointment;
import edu.kit.informatik.calendar.DateTime;
import edu.kit.informatik.calendar.Date;
import edu.kit.informatik.calendar.Time;

public class TestAppointment {
    
    private Appointment firstAppointment;
    private Appointment secondAppointment;
    private Appointment thirdAppointment;
    private Appointment fourthAppointment;
    private Appointment fifthAppointment;
    private Appointment sixthAppointment;
    private Appointment seventhAppointment;

    /**
     * 
     */
    @Before
    public void before() {
        
        // Appointment 1
        
        DateTime beginnigDateTimeOfTheFirstAppointment = new DateTime(
                new Date(2016, 11, 29), 
                new Time(17, 0, 0));
        DateTime endDateTimeOfTheFirstAppointment = new DateTime(
                new Date(2016, 12, 14), 
                new Time(13, 00, 00));
        
        
        firstAppointment = new Appointment(
                "appointment 1", 
                beginnigDateTimeOfTheFirstAppointment, 
                endDateTimeOfTheFirstAppointment);
        
        // Appointment 2
        
        DateTime beginnigDateTimeOfTheSecondAppointment = new DateTime(
                new Date(2016, 12, 13), 
                new Time(17, 0, 0));
        DateTime endDateTimeOfTheSecondAppointment = new DateTime(
                new Date(2017, 1, 11), 
                new Time(13, 00, 0));
        
        
        secondAppointment = new Appointment(
                "appointment 2", 
                beginnigDateTimeOfTheSecondAppointment, 
                endDateTimeOfTheSecondAppointment);
        
        // Appointment 3
        
        DateTime beginnigDateTimeOfTheThirdAppointment = new DateTime(
                new Date(2017, 1, 1), 
                new Time(8, 25, 0));
        DateTime endDateTimeOfTheThirdAppointment = new DateTime(
                new Date(2017, 5, 1), 
                new Time(10, 35, 40));
        
        
        thirdAppointment = new Appointment(
                "appointment 3", 
                beginnigDateTimeOfTheThirdAppointment, 
                endDateTimeOfTheThirdAppointment);
        
        // Appointment 4
        
        DateTime beginnigDateTimeOfTheFourthAppointment = new DateTime(
                new Date(2017, 1, 1), 
                new Time(8, 25, 0));
        DateTime endDateTimeOfTheFourthAppointment = new DateTime(
                new Date(2017, 3, 1), 
                new Time(7, 35, 40));
        
        
        fourthAppointment = new Appointment(
                "appointment 4", 
                beginnigDateTimeOfTheFourthAppointment, 
                endDateTimeOfTheFourthAppointment);
        
        // Appointment 5
        
        DateTime beginnigDateTimeOfTheFifthAppointment = new DateTime(
                new Date(2017, 1, 1), 
                new Time(8, 25, 0));
        DateTime endDateTimeOfTheFifthAppointment = new DateTime(
                new Date(2017, 3, 1), 
                new Time(7, 35, 40));
        
        
        fifthAppointment = new Appointment(
                "appointment 5", 
                beginnigDateTimeOfTheFifthAppointment, 
                endDateTimeOfTheFifthAppointment);
        
        // Appointment 6
        
        DateTime beginnigDateTimeOfTheSixthAppointment = new DateTime(
                new Date(2017, 1, 1), 
                new Time(8, 25, 0));
        DateTime endDateTimeOfTheSixthAppointment = new DateTime(
                new Date(2017, 3, 1), 
                new Time(7, 35, 40));
        
        
        sixthAppointment = new Appointment(
                "appointment 5", 
                beginnigDateTimeOfTheSixthAppointment, 
                endDateTimeOfTheSixthAppointment);
        
        // Appointment 7
        
        DateTime beginnigDateTimeOfTheSeventhAppointment = new DateTime(
                new Date(2017, 4, 25), 
                new Time(8, 25, 0));
        DateTime endDateTimeOfTheSeventhAppointment = new DateTime(
                new Date(2017, 1, 1), 
                new Time(9, 30, 25));
        
        
        seventhAppointment = new Appointment(
                "appointment 7", 
                beginnigDateTimeOfTheSeventhAppointment, 
                endDateTimeOfTheSeventhAppointment);
        
    }
    /**
     * 
     */
    @Test
    public void test() {
        assertTrue(firstAppointment.compareTo(secondAppointment) < 0);
        assertTrue(secondAppointment.compareTo(firstAppointment) > 0);
        assertTrue(secondAppointment.compareTo(thirdAppointment) < 0);
        assertTrue(fourthAppointment.compareTo(fifthAppointment) < 0);
        assertTrue(fifthAppointment.compareTo(fourthAppointment) > 0);
        assertTrue(fifthAppointment.compareTo(sixthAppointment) == 0);
        assertTrue(seventhAppointment.compareTo(firstAppointment) > 0);
    }

}
