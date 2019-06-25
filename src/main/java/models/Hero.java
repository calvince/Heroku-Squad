package models;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String name;
    private int age;
    private String power;
    private String weakness;
    private static ArrayList<Hero> instances = new ArrayList<>();
    private int mId;
    private LocalDateTime createdAt;

    public Hero(String name,int age, String power, String weakness){
        this.name = name;
        this.age = age;
        this.power = power;
        this.weakness = weakness;
        this.createdAt = LocalDateTime.now();
        instances.add(this);
        this.mId = instances.size();
    }
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public String getPower(){
        return this.power;
    }
    public String getWeakness(){
        return this.weakness;
    }
    public static ArrayList<Hero> getAll(){
        return instances;
    }
    public static void clearAllHero(){
        instances.clear();
    }
    public int getmId(){
        return mId;
    }
    public static Hero findById(int id){
        return instances.get(id-1);
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
