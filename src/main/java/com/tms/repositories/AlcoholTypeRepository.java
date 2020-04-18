package com.tms.repositories;

import com.tms.data.AlcoholType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlcoholTypeRepository implements IAlcoholTypesRepository {
    Connection conn;
    public AlcoholTypeRepository() {
        try {
            this.conn = DataSourceUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createAlcoholType(AlcoholType newType) throws SQLException {
        String sql = "INSERT INTO alcoholtypes (id,type) VALUES (?, ?)";
        PreparedStatement prst = conn.prepareStatement(sql);

        prst.setInt(1, newType.getId());
        prst.setString(2, newType.getTypeName());
        prst.execute();
    }



    @Override
    public AlcoholType getByName(String typeName) throws SQLException {
        String sql = "select * from `alcoholTypes` where `type`=?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,typeName);
        ResultSet rs = statement.executeQuery();
        if(rs.first()){
            return new AlcoholType(rs.getString(2),rs.getInt(1));
        }
        return null;

    }

    @Override
    public AlcoholType getById(int alcoholTypeId) throws SQLException {
        String sql = "select * from `alcoholTypes` where `id`=?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1,alcoholTypeId);
        ResultSet rs = statement.executeQuery();
        if(rs.first()){
            return new AlcoholType(rs.getString(2),rs.getInt(1));
        }
        return null;


    }
}
