package controller;
//NOTE: THIS IS A CLASS OF OBJECT TO USE TOWARDS THE BINARY HEAP CLASS
//(MEANING: THIS HOLDS THE DATA FOR THE BINARY HEAP CLASS)

public class Appointment {
    private String gmail;
    private String patientName;
    private byte patientAge;
    private String patientSickness;
    private String patientContact;
    private int patientSeverity;

    public Appointment(String gmail, String patientName, byte patientAge, String patientSickness, String patientContact, int patientSeverity){
        this.gmail = gmail;
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.patientSickness = patientSickness;
        this.patientContact = patientContact;
        this.patientSeverity = patientSeverity;
    }

    public String getGmail(){
        return gmail;
    }

    public String getPatientName(){
        return patientName;
    }

    public byte getPatientAge(){
        return patientAge;
    }

    public String getPatientSickness(){
        return patientSickness;
    }

    public String getPatientContact(){
        return patientContact;
    }

    public int getPatientSeverity(){
        return patientSeverity;
    }
}
