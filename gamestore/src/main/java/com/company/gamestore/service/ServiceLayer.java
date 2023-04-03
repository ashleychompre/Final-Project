package com.company.gamestore.service;

import com.company.gamestore.repository.ConsoleRepository;
import com.company.gamestore.repository.GameRepository;
import com.company.gamestore.repository.TShirtRepository;
import com.company.gamestore.models.Console;
import com.company.gamestore.models.Game;
import com.company.gamestore.models.Invoice;
import com.company.gamestore.models.Tax;
import com.company.gamestore.models.TShirt;
import com.company.gamestore.models.Fee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

@Component
public class ServiceLayer {

    private ConsoleRepository consoleRepository;
    private GameRepository gameRepository;
    private TShirtRepository tshirtRepository;

    @Autowired
    public ServiceLayer(ConsoleRepository consoleRepository, GameRepository gameRepository,
                        TShirtRepository tshirtRepository) {
        this.consoleRepository = consoleRepository;
        this.gameRepository = gameRepository;
        this.tshirtRepository = tshirtRepository;
    }

    public Invoice findInvoice(int id) {
        return null;
    }

    public List<Invoice> findAllInvoices() {
        return null;
    }

    public Invoice findInvoicebyName(String name) {
        return null;
    }

    public Invoice saveInvoice(Invoice invoice) {

        return null;
    }



}
