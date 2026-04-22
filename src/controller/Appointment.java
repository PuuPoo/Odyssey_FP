package controller;
//NOTE: THIS IS A CLASS OF OBJECT TO USE TOWARDS THE BINARY HEAP CLASS
//(MEANING: THIS HOLDS THE DATA FOR THE BINARY HEAP CLASS)

public class Appointment {
    private String gmail;
    private String patient;
    private int severity;

    public Appointment(String gmail, String patient, int severity){
        this.gmail = gmail;
        this.patient = patient;
        this.severity = severity;
    }

    public String getGmail(){
        return gmail;
    }

    public String getPatient(){
        return patient;
    }

    public int getSeverity(){
        return severity;
    }
}
