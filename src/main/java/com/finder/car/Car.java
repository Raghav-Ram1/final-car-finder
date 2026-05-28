package com.finder.car;

public class Car {
    private String make;
    private String model;
    private Boolean used;
    private int price;
    private String bodyType;
    private String color;
    private String drive;
    private String Classs;
    private int year;
    private int mileage;


    public Car() {
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setIsUsed(Boolean used) {
        this.used = used;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public void setBodyType(String bodyType)
    {
        this.bodyType = bodyType;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public void setDrive(String drive)
    {
        this.drive = drive;
    }

    public void setClasss(String Classs)
    {
        this.Classs = Classs;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public void setMileage(int mileage)
    {
        this.mileage = mileage;
    }



    public int getPrice()
    {
        return price;
    }

    public String getMake()
    {
        return make;
    }

    public String getModel()
    {
        return model;
    }

    public Boolean ifUsed()
    {
        return used;
    }

    public String getBodyType()
    {
        return bodyType;
    }

    public String getDrive()
    {
        return drive;
    }

    public String getClasss()
    {
        return Classs;
    }

    public String getColor()
    {
        return color;
    }


    public int getYear()
    {
        return year;
    }

    public int getMileage()
    {
        return mileage;
    }

    public String toString()
    {
        return(make + "," + model +"," + year +"," + mileage + "," + used + "," + bodyType + "," + color + "," + drive + "," + Classs + "," + price);
    }
}








