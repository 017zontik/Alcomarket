package com.tms.repositories;

import com.tms.data.AlcoholType;
import com.tms.services.AlcoholTypeNotFoundException;

import java.sql.SQLException;
import java.util.List;

public interface IAlcoholTypesRepositories {
    void createAlcoholType(AlcoholType newType) throws SQLException;
    List<AlcoholType> getListType();
    AlcoholType getByName(String typeName) throws SQLException;

}
