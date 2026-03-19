package controller;

import java.sql.*;
import java.util.HashMap;

public class JDBC {
    private final HashMap<String, String>  DOCTORLOGIN = new HashMap<>();


    public void createDoctorLoginConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Odyssey_Data", "root", "Killerman1");
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
}
