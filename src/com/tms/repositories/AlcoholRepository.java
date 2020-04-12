package com.tms.repositories;

import com.tms.data.Alcohol;
import com.tms.data.AlcoholType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlcoholRepository implements IAlcoholRepository {
    Connection conn;
    IAlcoholTypesRepository alcoholTypesRepository = new AlcoholTypeRepository();

    public AlcoholRepository() {
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

    @Override
    public List<Alcohol> getAlcohols() {
        String sql = "select * from `alcohols` ";
        Statement statement = null;
        List<Alcohol> alcohols = new ArrayList<>();
        try {
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()){
                int alcoholTypeId = rs.getInt(4);
                AlcoholType alcoholType = alcoholTypesRepository.getById(alcoholTypeId);
                Alcohol alcohol = new Alcohol(rs.getInt(1),rs.getString(2),rs.getDouble(3),
                        alcoholType);
                alcohols.add(alcohol);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return alcohols;
    }

    @Override
    public Alcohol getById(int id) throws SQLException {

        String sql = "select * from `alcohols` where `id`=?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1,id);
        ResultSet rs = statement.executeQuery();
        if(rs.first()){
            int alcoholTypeId = rs.getInt(4);
            AlcoholType alcoholType = alcoholTypesRepository.getById(alcoholTypeId);

            return new Alcohol(rs.getInt(1),rs.getString(2),rs.getDouble(3),
                    alcoholType);
        }
        return null;
    }

    @Override
    public void delete(Alcohol dellAlcohol) {
        String sql = "DELETE FROM alcohols where id=? ";
        PreparedStatement prst = null;
        try {
            prst = conn.prepareStatement(sql);
            prst.setInt(1, dellAlcohol.getId());
            prst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Alcohol editAlcohol) {
        String sql = "update alcohols set name=?,price=?,typeId=? where id=? ";
        PreparedStatement prst = null;
        try {
            prst = conn.prepareStatement(sql);
            prst.setString(1, editAlcohol.getName());
            prst.setDouble(2, editAlcohol.getPrice());
            prst.setInt(3, editAlcohol.getType().getId());
            prst.setInt(4, editAlcohol.getId());
            prst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
