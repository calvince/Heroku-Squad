package models;
import java.util.ArrayList;
import java.util.List;

public class Squad {
    private String mName;
    private String mCause;
    private String mMaximum;
    private static List<Squad> instances = new ArrayList<>();
    private int mId;
    private List<Hero> mHeroes;

    public Squad(String name,String cause,String maximum){
        this.mName =name;
        this.mCause=cause;
        this.mMaximum = maximum;
        instances.add(this);
        this.mId = instances.size();
        mHeroes = new ArrayList<>();

    }
    public String getName(){
        return mName;
    }

    public String getCause(){
        return mCause;
    }

    public String getMax(){
        return mMaximum;
    }
    public static void clearAllSquad() {
        instances.clear();
    }
    public static List<Squad> getAll() {
        return instances;
    }
    public int getId() {
        return mId;
    }
    public static Squad findById(int id){
        return instances.get(id-1);
    }
    public List<Hero> getHeroes() {
        return mHeroes;
    }
    public void addHero(Hero hero){
        mHeroes.add(hero);
    }





}
