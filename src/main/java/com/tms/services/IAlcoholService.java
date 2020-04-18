package com.tms.services;

import com.tms.data.Alcohol;

import java.util.List;

public interface IAlcoholService {
    List<Alcohol> getList();
    void addAlcohol(Alcohol newAlcohol);
    Alcohol getById(int id) throws AlcoholNotFoundException;
    void delAlcohol(Alcohol dellAlcohol);
    void loadFromFile(String filePath);
    void save(Alcohol editAlcohol);
}
