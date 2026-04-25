package controller;

import java.sql.*;
import java.util.HashMap;

public class JDBC {
    private final HashMap<String, String>  DOCTORLOGIN = new HashMap<>();
    private final HashMap<String, String> DOCTORUSERNAME = new HashMap<>();
    private LinkedList Doctor_patientsLL = new LinkedList();
    private BinaryHeap Doctor_patientsBH = new BinaryHeap(10); //BINARY HEAP SIZE CURRENTLY 10






    //Doctor login information (Gmail and Password)
    public void createDoctorLoginConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Odyssey_Data", "root", "testArea1");
        System.out.println("SQL Database for Doctor Initialize");

        //statement class for query execution to SQL
        Statement state = connection.createStatement();

        //query to SQL
        ResultSet rs = state.executeQuery("SELECT * FROM `Odyssey_Data`.`doctor_login_information`");


        //While result of the table still has next keep inputting into the hashmap
        while(rs.next()){
            String doctorGmail = rs.getString("doctor_GMAIL");
            String password = rs.getString("doctor_PASSWORD");
            this.DOCTORLOGIN.put(doctorGmail, password);
        }

        //Close all connections for memory efficiency
        rs.close();
        state.close();
        connection.close();
    }

    //returns the hashmap results
    public HashMap<String, String> getDoctorLogin(){
        return this.DOCTORLOGIN;
    }






    //Doctor login information (Gmail and Username)
    public void createDoctorUsernameConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Odyssey_Data", "root", "testArea1");
        System.out.println("SQL Database for Doctor Username Initialize");

        //statement class for query execution to SQL
        Statement state = connection.createStatement();

        //query to SQL
        ResultSet rs = state.executeQuery("SELECT * FROM `Odyssey_Data`.`doctor_information_name`");


        //While result of the table still has next keep inputting into the hashmap
        while(rs.next()){
            String doctorGmail = rs.getString("doctor_GMAIL");
            String doctorUsername = rs.getString("doctor_USERNAME");
            this.DOCTORUSERNAME.put(doctorGmail, doctorUsername);
        }

        //Close all connections for memory efficiency
        rs.close();
        state.close();
        connection.close();
    }
    //returns the hashmap results
    public HashMap<String, String> getDoctorUsername(){
        return this.DOCTORUSERNAME;
    }







    //Doctor patient information in linked list(Gmail and Username)
    public void createDoctorPatientConnectionLL() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Odyssey_Data", "root", "testArea1");
        System.out.println("SQL Database for Doctor Patient Database Initialize");

        //statement class for query execution to SQL
        Statement state = connection.createStatement();

        //query to SQL
        ResultSet rs = state.executeQuery("SELECT * FROM `Odyssey_Data`.`doctor_information_patients`");


        //While result of the table still has next keep inputting into the linkedlist
        while(rs.next()){
            String doctorGmail = rs.getString("doctor_GMAIL");
            String patientName = rs.getString("patient_name");
            byte patientAge = rs.getByte("patient_age");
            String patientSickness = rs.getString("patient_sickness");
            String patientContact = rs.getString("patient_contact");
            int severity = rs.getInt("severity");
            this.Doctor_patientsLL.insert(Doctor_patientsLL, doctorGmail, patientName, patientAge, patientSickness, patientContact, severity);
        }

        LinkedList.printList(Doctor_patientsLL);

        //Close all connections for memory efficiency
        rs.close();
        state.close();
        connection.close();
    }





    //Doctor patient information in Binary Heap(Gmail and Username)
    public void createDoctorPatientConnectionBH() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Odyssey_Data", "root", "testArea1");
        System.out.println("SQL Database for Doctor Patient Database Initialize");

        //statement class for query execution to SQL
        Statement state = connection.createStatement();

        //query to SQL
        ResultSet rs = state.executeQuery("SELECT * FROM `Odyssey_Data`.`doctor_information_patients`");


        //While result of the table still has next keep inputting into the binary heap
        while(rs.next()){
            String doctorGmail = rs.getString("doctor_GMAIL");
            String patientName = rs.getString("patient_name");
            byte patientAge = rs.getByte("patient_age");
            String patientSickness = rs.getString("patient_sickness");
            String patientContact = rs.getString("patient_contact");
            int severity = rs.getInt("severity");
            Appointment data = new Appointment(doctorGmail, patientName, patientAge, patientSickness, patientContact, severity);
            this.Doctor_patientsBH.insert(data);
        }

        Doctor_patientsBH.printHeapArray();

        //Close all connections for memory efficiency
        rs.close();
        state.close();
        connection.close();
    }
}
