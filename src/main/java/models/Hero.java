package models;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String mName;
    private int mAge;
    private String mPower;
    private String mWeakness;
    private static List<Hero> instances = new ArrayList<>();
    private int mId;
    private LocalDateTime createdAt;



    public Hero(String name,int age, String power, String weakness){
        this.mName = name;
        this.mAge = age;
        this.mPower = power;
        this.mWeakness = weakness;
        this.createdAt = LocalDateTime.now();
        instances.add(this);
        this.mId = instances.size();

    }

    public String getName(){
        return this.mName;
    }
    public int getmAge(){
        return this.mAge;
    }
    public String getmPower(){
        return mPower;
    }
    public String getmWeakness(){
        return mWeakness;
    }
    public static List<Hero> getAll(){
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
