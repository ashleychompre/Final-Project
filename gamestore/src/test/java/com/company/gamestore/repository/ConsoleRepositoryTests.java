package com.company.gamestore.repository;

import com.company.gamestore.models.Console;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ConsoleRepositoryTests {

    @Autowired
    ConsoleRepository consoleRepository;

    @Before
    public void setUp() throws Exception {

        consoleRepository.deleteAll();
    }

    @Test
    public void shouldAddConsole() {

        Console console = new Console();
        console.setModel("2023");
        console.setManufacturer("Microsoft");
        console.setMemoryAmount("64GB");
        console.setProcessor("Intel");
        console.setPrice(BigDecimal.valueOf(1000.11));
        console.setQuantity(123);

        console = consoleRepository.save(console);

        Optional<Console> console1 = consoleRepository.findById(console.getId());

        assertEquals(console1.get(), console);
    }

    @Test
    public void shouldGetConsoleById() {

        Console console = new Console();
        console.setModel("2023");
        console.setManufacturer("Microsoft");
        console.setMemoryAmount("64GB");
        console.setProcessor("Intel");
        console.setPrice(BigDecimal.valueOf(1000.11));
        console.setQuantity(123);
        console = consoleRepository.save(console);

        Console console2 = new Console();
        console2.setModel("2022");
        console2.setManufacturer("Google");
        console2.setMemoryAmount("64GB");
        console2.setProcessor("Intel");
        console2.setPrice(BigDecimal.valueOf(1111));
        console2.setQuantity(15);
        console2 = consoleRepository.save(console2);

        Optional<Console> foundConsole = consoleRepository.findById(console.getId());

        assertEquals(foundConsole.get(), console);
    }

}