package com.tms.services;

import com.tms.data.AlcoholType;

import java.util.List;

public interface IAlcoholTypeService {
    AlcoholType getByName(String typeName) throws AlcoholTypeNotFoundException;

}
