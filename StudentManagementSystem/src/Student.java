import java.io.*;
public class Student implements Serializable {
    static final long serialVersionUID = 42L;

    private String name;
    private int ID;
    private int age;

    Student(String name,int ID,int age){
        this.name=name;
        this.ID=ID;
        this.age=age;
    }

    public String getName(){
        return name;
    }


    public int getID(){
        return ID;
    }

    public int getAge(){
        return age;
    }

     public void setName(String name){
        this.name=name;
    }


    public void setID(int ID){
        this.ID=ID;
    }

    public void setAge(int age){
        this.age=age;
    }

    public String toString(){
        return "name: "+name+"\nID:  "+ID+"\nage: "+age;
    }


    
}
