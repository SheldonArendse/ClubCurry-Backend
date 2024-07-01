package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Chef;
import za.ac.cput.domain.enums.ExpertLevel;

import static org.junit.jupiter.api.Assertions.*;

class ChefFactoryTest {

    @Test
    void buildChef() {
        Chef c1 = ChefFactory.buildChef("2547856932145","logan","coghill", "LCoghill", "PassW0rd#");
        assertNotNull(c1);
        System.out.println(c1);
    }

    @Test
    void buildChefWithExpert() {
        Chef c1 = ChefFactory.buildChef("2547856932145","logan","coghill", "LCoghill", "PassW0rd#", ExpertLevel.MEDIUM);
        assertNotNull(c1);
        System.out.println(c1);
    }

    @Test
    void buildChefWithFail(){
        Chef c1 = ChefFactory.buildChef("254785693214w","logan","coghill", "LCoghill", "PassW0rd#");
        assertNull(c1);
    }
}