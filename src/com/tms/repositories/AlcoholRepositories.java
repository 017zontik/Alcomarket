package com.tms.repositories;

import com.tms.data.Alcohol;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlcoholRepositories implements IAlcoholRepositories {
    Connection conn;

    public AlcoholRepositories() {
        try {
            this.conn = DataSourceUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createAlcohol(Alcohol newAlcohol) {
        String sql = "INSERT INTO alcohols (name,price,typeId) VALUES (?, ?,?)";
        PreparedStatement prst = null;
        try {
            prst = conn.prepareStatement(sql);
            prst.setString(1, newAlcohol.getName());
            prst.setDouble(2, newAlcohol.getPrice());
            prst.setInt(3, newAlcohol.getType().getId());
            prst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
