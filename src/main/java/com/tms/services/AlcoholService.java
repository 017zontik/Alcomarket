package com.tms.services;

import com.tms.data.Alcohol;
import com.tms.repositories.AlcoholRepository;
import com.tms.repositories.IAlcoholRepository;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AlcoholService implements IAlcoholService {
    private int nextId;
    private IAlcoholTypeService alcoholTypeService;
    private IAlcoholRepository alcoholRepository;


    public AlcoholService(IAlcoholTypeService alcoholTypeService) {
        this.alcoholTypeService = alcoholTypeService;
        alcoholRepository = new AlcoholRepository();
    }


    @Override
    public List<Alcohol> getList() {
        return alcoholRepository.getAlcohols();
    }

    @Override
    public void addAlcohol(Alcohol newAlcohol) {
        alcoholRepository.createAlcohol(newAlcohol);
    }

    @Override
    public Alcohol getById(int id) throws AlcoholNotFoundException {
        try {
            Alcohol alcohol = alcoholRepository.getById(id);
            if (alcohol != null) {
                return alcohol;
            }
            throw new AlcoholNotFoundException();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void delAlcohol(Alcohol dellAlcohol) {
        alcoholRepository.delete(dellAlcohol);

    }

    @Override
    public void loadFromFile(String filePath) {
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(filePath);
            NodeList alcohols = document.getDocumentElement().getChildNodes();
            for (int i = 0; i < alcohols.getLength(); i++) {
                Node alcoholNode = alcohols.item(i);
                if (alcoholNode.getNodeType() != Node.TEXT_NODE) {
                    String name = alcoholNode.getAttributes().getNamedItem("name").getNodeValue();
                    Double price = Double.parseDouble(alcoholNode.getAttributes().getNamedItem("price").getNodeValue());
                    String type = alcoholNode.getAttributes().getNamedItem("type").getNodeValue();
                    try {
                        alcoholRepository.createAlcohol(new Alcohol(nextId, name, price, alcoholTypeService.getByName(type)));
                        nextId++;
                    } catch (AlcoholTypeNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Alcohol editAlcohol) {
        alcoholRepository.update(editAlcohol);
    }
}
