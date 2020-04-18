package com.tms.repositories;

import com.tms.data.Alcohol;

import java.sql.SQLException;
import java.util.List;

public interface IAlcoholRepository {
    void createAlcohol(Alcohol newAlcohol);
    List<Alcohol> getAlcohols();
    Alcohol getById(int id) throws SQLException;
    void delete(Alcohol dellAlcohol);
    void update(Alcohol editAlcohol);
}
