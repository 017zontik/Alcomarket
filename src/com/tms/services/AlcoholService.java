package com.tms.services;

import com.tms.data.Alcohol;
import com.tms.data.AlcoholType;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AlcoholService implements IAlcoholService {
    private List<Alcohol> alcoList;
    private int nextId;
    private IAlcoholTypeService alcoholTypeService;


    public AlcoholService(IAlcoholTypeService alcoholTypeService) {
        this.alcoholTypeService = alcoholTypeService;
        this.alcoList = new ArrayList<>();
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
        for (Alcohol alcohol : alcoList) {
            if (id == alcohol.getId()) {
                return alcohol;
            }
        }
        throw new AlcoholNotFoundException();
    }

    @Override
    public void dellAlcohol(Alcohol dellAlcohol) {
        this.alcoList.remove(dellAlcohol);
    }

    @Override
    public void loadFromFile(String filePath) {
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(filePath);
            NodeList alcohols = document.getDocumentElement().getChildNodes();
            for (int i = 0; i <alcohols.getLength() ; i++) {
                Node alcoholNode = alcohols.item(i);
                if (alcoholNode.getNodeType() != Node.TEXT_NODE) {
                    String name = alcoholNode.getAttributes().getNamedItem("name").getNodeValue();
                    Double price = Double.parseDouble(alcoholNode.getAttributes().getNamedItem("price").getNodeValue());
                    String type = alcoholNode.getAttributes().getNamedItem("type").getNodeValue();
                    try {
                        alcoList.add(new Alcohol(nextId, name, price, alcoholTypeService.getByName(type)));
                        nextId++;
                    } catch (AlcoholTypeNotFoundException e) {
                        e.printStackTrace();
                    }
                }

            }



        } catch (ParserConfigurationException | SAXException  | IOException e) {
            e.printStackTrace();
        }


    }
}
