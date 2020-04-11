package com.tms.services;

import com.tms.data.Alcohol;
import com.tms.data.AlcoholType;

import java.util.ArrayList;
import java.util.List;

public class AlcoholService implements IAlcoholService {
    @Override
    public List<Alcohol> getList() {
        List<Alcohol> alcoList = new ArrayList<>();
        alcoList.add(new Alcohol("Alivaria",5,new AlcoholType("beer",1)));
        alcoList.add(new Alcohol("Finliandia",10,new AlcoholType("vodka",2)));
        alcoList.add(new Alcohol("Tequila",15,new AlcoholType("tequila",3)));
        return alcoList;
    }
}
