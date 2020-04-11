package com.tms.repositories;

import com.tms.data.AlcoholType;
import com.tms.services.AlcoholTypeNotFoundException;

import java.sql.*;
import java.util.List;

public class AlcoholTypeRepositories implements IAlcoholTypesRepositories{
    Connection conn;
    public AlcoholTypeRepositories(Connection conn) {

        this.conn = conn;
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
    public List<AlcoholType> getListType() {
        return null;
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
}
