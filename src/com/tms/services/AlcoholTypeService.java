package com.tms.services;

import com.tms.data.AlcoholType;
import com.tms.repositories.AlcoholTypeRepositories;
import com.tms.repositories.IAlcoholTypesRepositories;

import java.sql.SQLException;

public class AlcoholTypeService implements IAlcoholTypeService {

    private IAlcoholTypesRepositories alcoholTypesRepositories = new AlcoholTypeRepositories();

    public AlcoholTypeService() throws SQLException {
        if (alcoholTypesRepositories.getByName("Beer") == null) {
            alcoholTypesRepositories.createAlcoholType(new AlcoholType("Beer", 1));
        }
        if (alcoholTypesRepositories.getByName("Vodka") == null) {
            alcoholTypesRepositories.createAlcoholType(new AlcoholType("Vodka", 2));
        }
        if (alcoholTypesRepositories.getByName("Vine") == null) {
            alcoholTypesRepositories.createAlcoholType(new AlcoholType("Vine", 3));
        }
        if (alcoholTypesRepositories.getByName("Hard alcohol") == null) {
            alcoholTypesRepositories.createAlcoholType(new AlcoholType("Hard alcohol", 4));
        }

    }

    @Override
    public AlcoholType getByName(String typeName) throws AlcoholTypeNotFoundException {
        try {
            AlcoholType alcoholType = alcoholTypesRepositories.getByName(typeName);
            if (alcoholType != null) {
                return alcoholType;
            }
            throw new AlcoholTypeNotFoundException();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}
