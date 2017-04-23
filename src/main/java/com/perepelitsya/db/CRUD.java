package com.perepelitsya.db;

import java.sql.*;

/**
 * Created by Andriu on 23.04.2017.
 */
public class CRUD {

    Connection con;
    PreparedStatement ps;

    public CRUD() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/testdb?user=root&password=root");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertUser(int user_id, String username, String password, String email) {
        try {
            ps = con.prepareStatement("insert into users values(?,?,?,?)");
            ps.setInt(1, user_id);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.setString(4, email);
            int i = ps.executeUpdate();
            if (i != 0) {
                System.out.println("Inserted");
            } else {
                System.out.println("not Inserted");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUser(String username, String password, String email) {
        try {
            ps = con.prepareStatement("update users set username=?,password=? where email=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            int i = ps.executeUpdate();
            if (i != 0) {
                System.out.println("updated");
            } else {
                System.out.println("not updated");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) {
        try {
            ps = con.prepareStatement("delete from users where user_id=?");
            ps.setInt(1, id);
            int i = ps.executeUpdate();
            if (i != 0) {
                System.out.println("deleted");
            } else {
                System.out.println("not deleted");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dispAll() {
        try {
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery("select * from users");
            while (res.next()) {
                System.out.print(res.getInt(1) + " ");
                System.out.print(res.getString(2) + " ");
                System.out.print(res.getString(3)+ " ");
                System.out.println(res.getString(4)+ " ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayUserOfID(int id) {
        try {
            ps = con.prepareStatement("select * from users where user_id=?");
            ps.setInt(1, id);
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                System.out.print(res.getInt(1) + " ");
                System.out.print(res.getString(2)+ " ");
                System.out.print(res.getString(3)+ " ");
                System.out.println(res.getString(4)+ " ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}