package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
        assertEquals(true, hero instanceof Hero);
    }
}