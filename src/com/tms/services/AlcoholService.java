package com.tms.services;

import com.tms.data.Alcohol;
import com.tms.data.AlcoholType;

import java.util.ArrayList;
import java.util.List;

public class AlcoholService implements IAlcoholService {
    private List<Alcohol> alcoList;
    public int nextId;



    public AlcoholService() {
        this.alcoList = new ArrayList<>();
        alcoList.add(new Alcohol(nextId++,"Alivaria",5,new AlcoholType("beer",1)));
        alcoList.add(new Alcohol(nextId++,"Finliandia",10,new AlcoholType("vodka",2)));
        alcoList.add(new Alcohol(nextId++,"Tequila",15,new AlcoholType("tequila",3)));
    }


    @Override
    public List<Alcohol> getList() {
        return alcoList;
    }

    @Override
    public void addAlcohol(Alcohol newAlcohol) {
        newAlcohol.setId(nextId++);
        this.alcoList.add(newAlcohol);

    }

    @Override
    public Alcohol getById(int id) throws AlcoholNotFoundException {
       for(Alcohol alcohol: alcoList){
           if(id==alcohol.getId()){
               return alcohol;
           }
       }
       throw new AlcoholNotFoundException();
    }

    @Override
    public void dellAlcohol(Alcohol dellAlcohol) {
        this.alcoList.remove(dellAlcohol);
    }
}
