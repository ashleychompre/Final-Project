package com.company.gamestore.repository;

import com.company.gamestore.models.TShirt;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Optional;


import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TshirtRepositoryTests {


    @Autowired
    TShirtRepository tshirtRepo;

    @Before
    public void setUp() throws Exception {
        tshirtRepo.deleteAll();
    }

    @Test
    public void createTshirt() {

        TShirt tshirt = new TShirt();
         tshirt.setColor("black");
         tshirt.setPrice(BigDecimal.valueOf(15.99));
         tshirt.setSize("Medium");
         tshirt.setQuantity(300);
          tshirt.setDescription("Leopard print graphics");



        tshirt = tshirtRepo.save(tshirt);

        //Assert...
        Optional<TShirt> tshirt2 = tshirtRepo.findById(tshirt.getId());

        assertEquals(tshirt2.get(), tshirt);
    }

    @Test
    public void updateTShirt() {

        TShirt tshirt = new TShirt();
        tshirt.setColor("black");
        tshirt.setPrice(BigDecimal.valueOf(15.99));
        tshirt.setSize("Medium");
        tshirt.setQuantity(300);
        tshirt.setDescription("Leopard print graphics");

        tshirtRepo.save(tshirt);

        //Act...
        tshirt.setColor("White");

        tshirt.setQuantity(203);


        tshirtRepo.save(tshirt);


        //Assert...
        Optional<TShirt> tshirt2 = tshirtRepo.findById(tshirt.getId());

        assertEquals(tshirt2.get(), tshirt);
    }

    @Test
    public void deleteNote() {

        TShirt tshirt = new TShirt();
        tshirt.setColor("black");
        tshirt.setPrice(BigDecimal.valueOf(15.99));
        tshirt.setSize("Medium");
        tshirt.setQuantity(300);
        tshirt.setDescription("Leopard print graphics");
        tshirtRepo.save(tshirt);

        tshirtRepo.deleteById(tshirt.getId());

        Optional<TShirt> tshirt2 = tshirtRepo.findById(tshirt.getId());
        assertFalse(tshirt2.isPresent());
    }


    @Test
    public void getTshirtByID() {

    }

    @Test
    public void getAllTShirts(){

    }

    @Test
    public void getTShirtsByColor(){

    }


    @Test
    public void getTShirtsBySize(){

    }

}
