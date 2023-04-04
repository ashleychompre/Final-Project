package com.company.gamestore.service;

import com.company.gamestore.repository.*;
import com.company.gamestore.models.Console;
import com.company.gamestore.models.Game;
import com.company.gamestore.models.Invoice;
import com.company.gamestore.models.Tax;
import com.company.gamestore.models.TShirt;
import com.company.gamestore.models.Fee;
import com.company.gamestore.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

@Component
public class ServiceLayer {

    private ConsoleRepository consoleRepository;
    private GameRepository gameRepository;
    private TShirtRepository tshirtRepository;
    private InvoiceRepository invoiceRepository;

    private FeeRepository feeRepository;

    private TaxRepository taxRepository;


    @Autowired
    public ServiceLayer(ConsoleRepository consoleRepository, GameRepository gameRepository,
                        TShirtRepository tshirtRepository, InvoiceRepository invoiceRepository,
                        TaxRepository taxRepository, FeeRepository feeRepository) {
        this.consoleRepository = consoleRepository;
        this.gameRepository = gameRepository;
        this.tshirtRepository = tshirtRepository;
        this.invoiceRepository = invoiceRepository;
        this.feeRepository = feeRepository;
        this.taxRepository = taxRepository;
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

        Tax tax = taxRepository.findByState(ivm.getState());
        ivm.setTax(tax.getRate());

        Fee fee = feeRepository.findByProductType(ivm.getItem_type());
        if(ivm.getQuantity() > 10) {
            BigDecimal d = BigDecimal.valueOf(15.49);
            fee.setFee(fee.getFee().add(d));
        }
        ivm.setProcessing_fee(fee.getFee());
        BigDecimal price = BigDecimal.valueOf(0);

        if(ivm.getItem_type() == "Game") {
            Optional<Game> game = gameRepository.findById(ivm.getItem_id());
            Game g = game.get();
            price = g.getPrice();

        }
        else if(ivm.getItem_type() == "Console") {
            Optional<Console> console = consoleRepository.findById(ivm.getItem_id());
            Console c = console.get();
            price = c.getPrice();
        }
        else if (ivm.getItem_type() == "TShirt") {
            Optional<TShirt> tshirt = tshirtRepository.findById(ivm.getItem_id());
            TShirt t = tshirt.get();
            price = t.getPrice();
        }

        BigDecimal subtotal = price.multiply(BigDecimal.valueOf(ivm.getQuantity()));
        ivm.setSubtotal(subtotal);
        BigDecimal total = tax.getRate().multiply(subtotal).add(subtotal).add(fee.getFee());
        ivm.setTotal(total);

        return ivm;


    }


}
