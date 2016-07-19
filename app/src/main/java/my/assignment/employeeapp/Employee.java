package my.assignment.employeeapp;

import android.graphics.Bitmap;

import java.sql.Blob;

/**
 * Created by root on 7/18/16.
 */

public class Employee {
    int id;
    String name;
    int age;
    Bitmap photo;

    public Employee(int id,String name,int age,Bitmap photo){
        this.id=id;
        this.name=name;
        this.age=age;
        this.photo=photo;

    }
    public Employee(String name,int age,Bitmap photo){
        this.name=name;
        this.age=age;
        this.photo=photo;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Bitmap getPhoto() {
        return photo;
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }
}
