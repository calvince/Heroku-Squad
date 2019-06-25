package models;
import java.util.ArrayList;
import java.util.List;

public class Squad {

    private String name;
    private String cause;
    private int maximum;
    private static ArrayList<Squad> instances = new ArrayList<>();
    private int mId;
    private List<Hero> mHeroes;

    public Squad(String name,String cause,int maximum){
        this.name =name;
        this.cause=cause;
        this.maximum = maximum;
        instances.add(this);
        this.mId = instances.size();
        mHeroes = new ArrayList<>();

    }
    public String getName(){
        return this.name;
    }

    public String getCause(){
        return this.cause;
    }

    public int getMaximum(){
        return maximum;
    }
    public static void clearAllSquad() {
        instances.clear();
    }
    public static ArrayList<Squad> getAll() {
        return instances;
    }
    public int getId() {
        return this.mId;
    }
    public static Squad findById(int id){
        return instances.get(id-1);
    }
    public List<Hero> getHeroes() {
        return mHeroes;
    }
    //method to add hero to the squad
    public void addHero(Hero hero){
        mHeroes.add(hero);
    }





}
