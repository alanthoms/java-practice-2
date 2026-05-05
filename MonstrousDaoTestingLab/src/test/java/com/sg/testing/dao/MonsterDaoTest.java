package com.sg.testing.dao;

import com.sg.testing.dao.implementations.AGoodMonsterDao;
import com.sg.testing.model.Monster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonsterDaoTest {

    private  MonsterDao dao;

    @BeforeEach
    public void setUp(){
        dao = new AGoodMonsterDao();
    }

    @Test
    public void testAddMultipleMonstersDifferentIds() {
        Monster m1 = new Monster("Dracula", null, 0, "Blood");
        Monster m2 = new Monster("Zombie", null, 0, "Brains");

        dao.addMonster(1, m1);
        dao.addMonster(2, m2);

        Monster fromDao1 = dao.getMonster(1);
        Monster fromDao2 = dao.getMonster(2);

        assertEquals(m1, fromDao1);
        assertEquals(m2, fromDao2);
    }

    


}