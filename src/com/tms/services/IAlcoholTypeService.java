package com.tms.services;

import com.tms.data.AlcoholType;

import java.util.List;

public interface IAlcoholTypeService {
    List<AlcoholType> getListType();
    AlcoholType getByName(String typeName) throws AlcoholTypeNotFoundException;

}
