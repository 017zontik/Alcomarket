package com.tms.repositories;

import com.tms.data.AlcoholType;

import java.sql.SQLException;

public interface IAlcoholTypesRepository {
    void createAlcoholType(AlcoholType newType) throws SQLException;
    AlcoholType getByName(String typeName) throws SQLException;

    AlcoholType getById(int alcoholTypeId) throws SQLException;
}
