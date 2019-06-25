package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDateTime;
import static org.junit.Assert.*;

public class HeroTest {

    @Before
    public void setUp(){
    }
    @After
    public void tearDown()  {
        Hero.clearAllHero();
    }
    @Test
    //constructor test
    public void Hero_instantiateCorrectly_true(){
        Hero hero = new Hero("baba",23,"might","short");
        assertTrue( hero instanceof Hero);
    }
    @Test
    public void Hero_instantiatesWith_Name_String(){
        Hero hero = new Hero("Omosh",24,"might","short");
        assertEquals("Omosh",hero.getName());
    }
    @Test
    public void Hero_instantiatesWith_Age_int(){
        Hero hero = new Hero("Omosh",24,"might","short");
        assertEquals(24,hero.getAge());
    }
    @Test
    public void Hero_instantiatesCorrectlyWithPower() {
        Hero hero = new Hero("Omosh",24,"might","short");
        assertEquals("might", hero.getPower());
    }
    @Test
    public void Hero_instantiatesCorrectlyWithWeakness_String() {
        Hero hero = new Hero("Omosh",24,"might","short");
        assertEquals("short", hero.getWeakness());
    }

    @Test
    public void AllHeroAreCorrectlyReturned_true() {
        Hero hero = new Hero("Omosh",24,"might","short");
        Hero otherHero = new Hero ("Omosh",24,"might","short");
        assertEquals(2, Hero.getAll().size());
    }
    @Test
    public void AllHeroReturnAllInstances_ofHero_true() {
        Hero hero = new Hero("Omosh",24,"might","short");
        Hero otherHero = new Hero ("Omosh",24,"might","short");
        assertTrue(Hero.getAll().contains(hero));
        assertTrue(Hero.getAll().contains(otherHero));
    }
    @Test
    public void getCreatedAt_instantiatesWithCurrentTime_today() throws Exception{
        Hero myHero = setupNewPost();
        assertEquals(LocalDateTime.now().getDayOfWeek(), myHero.getCreatedAt().getDayOfWeek());
    }
    private Hero setupNewPost(){
        return new Hero("Omosh",24,"might","short");
    }
    @Test
    public void findReturnsCorrectHero() throws Exception {
        Hero hero = setupNewPost();
        assertEquals(1, Hero.findById(hero.getmId()).getmId());
    }

    @Test
    public void getId_heroesInitiateWithAnID_1(){
        Hero hero = new Hero("Omosh",24,"might","short");
        assertEquals(1, hero.getmId());
    }
    @Test
    public void findReturnsCorrectHeroWhenMoreThanOneHeroExists() throws Exception {
        Hero post = setupNewPost();
        Hero otherPost = new Hero("Omosh",24,"might","short");
        assertEquals(2, Hero.findById(otherPost.getmId()).getmId());
    }
}


