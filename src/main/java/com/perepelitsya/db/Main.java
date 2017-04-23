package com.perepelitsya.db;

/**
 * Created by Andriu on 23.04.2017.
 */
public class Main {
    public static void main(String[] args) {
        CRUD data = new CRUD();
        data.dispAll();
        //data.insertUser(5, "Andriup", "afaf", "fdsdgzdf");
        data.dispAll();
        data.deleteUser(5);
        data.displayUserOfID(2);
    }
}
