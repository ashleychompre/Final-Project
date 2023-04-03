package com.company.gamestore.service;

import com.company.gamestore.repository.ConsoleRepository;
import com.company.gamestore.repository.GameRepository;
import com.company.gamestore.repository.InvoiceRepository;
import com.company.gamestore.repository.TShirtRepository;
import com.company.gamestore.models.Console;
import com.company.gamestore.models.Game;
import com.company.gamestore.models.Invoice;
import com.company.gamestore.models.Tax;
import com.company.gamestore.models.TShirt;
import com.company.gamestore.models.Fee;
import com.company.gamestore.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

@Component
public class ServiceLayer {

    private ConsoleRepository consoleRepository;
    private GameRepository gameRepository;
    private TShirtRepository tshirtRepository;

    private InvoiceRepository invoiceRepository;

    @Autowired
    public ServiceLayer(ConsoleRepository consoleRepository, GameRepository gameRepository,
                        TShirtRepository tshirtRepository, InvoiceRepository invoiceRepository) {
        this.consoleRepository = consoleRepository;
        this.gameRepository = gameRepository;
        this.tshirtRepository = tshirtRepository;
        this.invoiceRepository = invoiceRepository;
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

    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {
        InvoiceViewModel ivm = new InvoiceViewModel();
        ivm.setId(invoice.getId());
        ivm.setName(invoice.getName());
        ivm.setCity(invoice.getCity());
        ivm.setStreet(invoice.getStreet());
        ivm.setState(invoice.getState());
        ivm.setZipcode(invoice.getZipcode());
        ivm.setItem_type(invoice.getItem_type());
        ivm.setItem_id(invoice.getItem_id());
        ivm.setQuantity(invoice.getQuantity());

        return null;
        
    }


}
