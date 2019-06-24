package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {
    @Test
    public void squad_instantiates_Correctly_true(){
        Squad squad = new Squad("Omosh","Commit the short",12);
        assertTrue(squad instanceof Squad);
    }
    @Test
    public void squad_instantiates_withName_String() {
        Squad squad = new Squad("Omosh", "Commit the short", 2);
        assertEquals("Omosh",squad.getName());
    }
    @Test
    public void squad_instantiates_withCause_String(){
        Squad squad = new Squad("Omosh","Commit the short",2);
        assertEquals("Commit the short",squad.getCause());
    }
    @Test
    public void squad_instatiates_WithMaximum_int(){
        Squad squad = new Squad("Omosh","Commit the short",2);
        assertEquals(2,squad.getmMaximum());
    }
    @Test
    //use of static getAll method
    public void squad_ReturnAll_instantesOfSquad_true(){
        Squad squad = new Squad("Omosh","Commit the short",2);
        Squad mSquad = new Squad("Kenya","Commit the short",2);
        assertEquals(true,Squad.getAll().contains(squad));
        assertEquals(true,Squad.getAll().contains(mSquad));
    }
    //Clear all the instantes in Squad List
    @Test
    public void squad_clearAllSquadList_instances_0(){
        Squad squad = new Squad("Omosh","Commit the short",2);
        Squad.clearAllSquad();
        assertEquals(Squad.getAll().size(),0);
    }
    //instantiates squad with an id
    @Test
    public void squad_squadInstantiates_withId_1(){
        Squad squad = new Squad("Omosh","Commit the Short",2);
        assertEquals(1,squad.getId());
    }
    @Test
    public void squad_getsSquadWithSameId_2ndSquard(){
        Squad squad = new Squad("Omosh","Commit the short",2);
        Squad sndSquad = new Squad("Alefo","Noma",5);
        assertEquals(Squad.findById(sndSquad.getId()),sndSquad);
    }
    @Test
    public void squad_getTasks_initiallyReturnsEmptyList_ArrayList(){
        Squad squad = new Squad("Omosh","Commit the short",2);
        assertEquals(0,squad.getHeroes().size());
    }
    //add hero to the squadList
    @Test
    public void squad_able_toAddTaskToTheList_true(){
        Squad mSquad = new Squad("Omosh","Commit the short",2);
        Hero mHero = new Hero("Omosh",24,"might","short");
        mSquad.addHero(mHero);
        assertEquals(true,mSquad.getHeroes().contains(mHero));
    }


}