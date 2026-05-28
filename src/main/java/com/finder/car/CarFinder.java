package com.finder.car;

import java.io.InputStream;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * make a scanner to collect user input
 * then make a scanner to go through the text files and check if the user query is in the files
 * if user query is found, add the vehicles with the user query in it to an array list
 * in the array list of type Car the user can view all  the car options in the array list
 * <p>
 * the Car CLASS will be used to store atributes of cars in the arrayList
 **/
public class CarFinder {

    ArrayList<Car> carList = new ArrayList<>();

    public static void main(String[] args) {

        CarFinder car = new CarFinder();
        try {
            car.loadData();
            car.selectCar();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Car> loadData() throws Exception {
        ClassLoader classLoader = CarFinder.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("data.txt");
        assert inputStream != null;
        Scanner carData = new Scanner(inputStream);
        carData.useDelimiter(System.lineSeparator());
        carData.next();
        while (carData.hasNextLine()) {
            String data = carData.next();
            String dataArr[] = data.split(",");
            Car car = new Car();
            car.setMake(dataArr[0]);
            car.setModel(dataArr[1]);
            car.setYear(Integer.parseInt(dataArr[2]));
            car.setMileage(Integer.parseInt(dataArr[3]));
            car.setIsUsed(Boolean.valueOf(dataArr[4]));
            car.setBodyType(dataArr[5]);
            car.setColor(dataArr[6]);
            car.setDrive(dataArr[7]);
            car.setClasss(dataArr[8]);
            car.setPrice(Integer.parseInt(dataArr[9]));
            carList.add(car);
        }

        return carList;
    }

    public void selectCar() {
        ArrayList<Car> matchingCars = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a brand, model, color, etc: ");
        String input = scanner.next().trim();
        for (Car car : carList) {
            if (car.getMake().equalsIgnoreCase(input) ||
                    car.getModel().equalsIgnoreCase(input) ||
                    car.getColor().equalsIgnoreCase(input) ||
                    car.getBodyType().equalsIgnoreCase(input) ||
                    car.getDrive().equalsIgnoreCase(input) ||
                    car.getClasss().equalsIgnoreCase(input)) {
                matchingCars.add(car);
            }
        }

        for (Car matchingCar : matchingCars) {
            System.out.println(matchingCar.toString());
        }
    }
}
