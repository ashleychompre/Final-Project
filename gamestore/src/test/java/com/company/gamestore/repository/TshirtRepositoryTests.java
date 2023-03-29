package com.company.gamestore.repository;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.company.gamestore.models.TShirt;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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
    public void addTshirt() {
        //Arrange...
        TShirt tshirt = new TShirt();
         tshirt.setColor("black");
         tshirt.setPrice(BigDecimal.valueOf(15.99));
         tshirt.setSize("Medium");
         tshirt.setQuantity(300);
          tshirt.setDescription("Leopard print graphics");



        tshirt = tshirtRepo.save(tshirt);

        //Assert...
        Optional<TShirt> customer1 = tshirtRepo.findById(tshirt.getId());

        assertEquals(customer1.get(), tshirt);
    }





}
