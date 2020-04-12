package com.tms;

import com.tms.data.Alcohol;
import com.tms.services.*;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static IAlcoholTypeService alcoholTypeservice;

    static {
        try {
            alcoholTypeservice = new AlcoholTypeService();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static IAlcoholService alcoholservice = new AlcoholService(alcoholTypeservice);


    public static void main(String[] args) {
        System.out.println("Вас приветствует алкомаркет \"Настя и ko\"! ");

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Для получения списка продукции введите команду list ");
            System.out.println("Для выхода из программы введите команду exit ");
            System.out.println("Для добавления нового продукта введите команду add ");
            System.out.println("Для редактирования описания продукта введите команду edit ");
            System.out.println("Для удаления продукта введите команду del ");
            System.out.println("Для загрузки списка из внешнего файла введите команду load ");
            String request = sc.nextLine();
            if (request.equals("list")) {
                for (Alcohol alcohol : alcoholservice.getList()) {
                    printAlcohol(alcohol);
                }
                System.out.println();

            }
            if (request.equals("add")) {
                System.out.println("Введите имя: ");
                String name = sc.nextLine();
                System.out.println("Введите цену: ");
                double price = Double.parseDouble(sc.nextLine());
                System.out.println("Введите тип: ");
                String type = sc.nextLine();
                Alcohol newAlcohol = null;
                try {
                    newAlcohol = new Alcohol(0, name, price, alcoholTypeservice.getByName(type));
                    alcoholservice.addAlcohol(newAlcohol);
                } catch (AlcoholTypeNotFoundException e) {
                    System.out.println("Не найден указанный тип алкоголя");
                }


            }
            if (request.equals("edit")) {
                System.out.println("Введите № продукта: ");
                int id = Integer.parseInt(sc.nextLine());
                try {
                    Alcohol editAlcohol = alcoholservice.getById(id);
                    printAlcohol(editAlcohol);

                    System.out.println("Измените название:");
                    String newName = sc.nextLine();
                    System.out.println("Измените цену:");
                    double newPrice = Double.parseDouble(sc.nextLine());
                    System.out.println("Измените вид алкоголя:");
                    String newType = sc.nextLine();
                    editAlcohol.setName(newName);
                    editAlcohol.setPrice(newPrice);
                    try {
                        editAlcohol.setType(alcoholTypeservice.getByName(newType));
                    } catch (AlcoholTypeNotFoundException e) {
                        System.out.println("Не найден указанный тип алкоголя");
                    }
                    alcoholservice.save(editAlcohol);

                } catch (AlcoholNotFoundException e) {
                    System.out.println("Такого индекса не существует!");
                }
            }
            if (request.equals("del")) {
                System.out.println("Введите № продукта: ");
                int id = Integer.parseInt(sc.nextLine());
                try {
                    Alcohol delAlcohol = alcoholservice.getById(id);
                    alcoholservice.delAlcohol(delAlcohol);

                } catch (AlcoholNotFoundException e) {
                    System.out.println("Такого индекса не существует!");
                }
            }
            if (request.equals("load")) {
                System.out.println("Ведите путь к файлу с данными: ");
                String filePath = sc.nextLine();
                alcoholservice.loadFromFile(filePath);


            }

            if (request.equals("exit")) {
                break;
            }
        }


    }

    private static void printAlcohol(Alcohol alcohol) {
        System.out.println("№ " + alcohol.getId() + " " + "Название: " + alcohol.getName() + " цена: " + alcohol.getPrice() +
                " вид алкоголя: " + alcohol.getType().getTypeName());
    }

}

