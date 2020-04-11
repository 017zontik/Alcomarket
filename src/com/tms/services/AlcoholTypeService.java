package com.tms.services;

import com.tms.data.Alcohol;
import com.tms.data.AlcoholType;

import java.util.ArrayList;
import java.util.List;

public class AlcoholTypeService implements IAlcoholTypeService {
    private List<AlcoholType> alcoTypeList;
    public AlcoholTypeService() {
        this.alcoTypeList = new ArrayList<>();
        alcoTypeList.add(new AlcoholType("Beer",1  ));
        alcoTypeList.add(new AlcoholType("Vodka",2  ));
        alcoTypeList.add(new AlcoholType("Vine",3  ));
        alcoTypeList.add(new AlcoholType("Hard alcohol",4 ));
    }

    @Override
    public List<AlcoholType> getListType() {
        return alcoTypeList;
    }

    @Override
    public AlcoholType getByName(String typeName) throws AlcoholTypeNotFoundException{
        for(AlcoholType alcoholType: alcoTypeList){
            if(typeName.equals(alcoholType.getTypeName())){
                return alcoholType;
            }
        }
        throw new AlcoholTypeNotFoundException();
    }
}
