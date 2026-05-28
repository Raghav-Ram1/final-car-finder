package org.example;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
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
    public static void main(String[] args) {
      CarFinder car = new CarFinder();
      try {
          ArrayList<Car> cars = car.loadData();
          for(Car i:cars)
          {
              System.out.println(i.toString());
          }



      }
      catch (Exception e) {
        e.printStackTrace();
      }



    }

    public ArrayList<Car> loadData() throws Exception
    {
        ArrayList<Car> carList = new ArrayList<>();
        ClassLoader classLoader = Main.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("data.txt");
        Scanner carData = new Scanner(inputStream);
        carData.useDelimiter(System.lineSeparator());
        carData.next();
        while(carData.hasNextLine())
        {
           String data = carData.next();
           String dataArr[] = data.split(",");
           Car car = new Car();
           car.setMake(dataArr[0]);
           car.setModel(dataArr[1]);
           car.setYear(Integer.valueOf(dataArr[2]));
           car.setMileage(Integer.valueOf(dataArr[3]));
           car.setIsUsed(Boolean.valueOf(dataArr[4]));
           car.setBodyType(dataArr[5]);
           car.setColor(dataArr[6]);
           car.setDrive(dataArr[7]);
           car.setClasss(dataArr[8]);
           car.setPrice(Integer.valueOf(dataArr[9]));
           carList.add(car);
        }

        return carList;
    }
    public ArrayList<Car> userSelection(String input) {
        ArrayList<Car> matchingCars = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a brand, model, color, etc: ");
        input = scanner.nextLine().trim();

        try {
            ArrayList<Car> cars = loadData();
            for (int i = 0; i < cars.size(); i++) {
                Car car = cars.get(i);
                if (car.getMake().equalsIgnoreCase(input) ||
                        car.getModel().equalsIgnoreCase(input) ||
                        car.getColor().equalsIgnoreCase(input) ||
                        car.getBodyType().equalsIgnoreCase(input) ||
                        car.getDrive().equalsIgnoreCase(input) ||
                        car.getClasss().equalsIgnoreCase(input)) {
                    matchingCars.add(car);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return matchingCars;
    }

}
