package com.company.gamestore.controllers;

import com.company.gamestore.models.Invoice;
import com.company.gamestore.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvoiceController {

    @Autowired
    ServiceLayer serviceLayer;

    @GetMapping("/invoices")
    public List<Invoice> getInvoices() {
        return serviceLayer.findAllInvoices();
    }

    @GetMapping("/invoices/{id}")
    public Invoice getInvoiceById(@PathVariable int id) {
        return serviceLayer.findInvoice(id);
    }

    @GetMapping("/invoices/{name}")
    public Invoice getInvoiceByName(@PathVariable String name) {
        return serviceLayer.findInvoicebyName(name);
    }

    @PostMapping("/invoices")
    @ResponseStatus(HttpStatus.CREATED)
    public Invoice addInvoice(@RequestBody Invoice invoice) {
        return serviceLayer.saveInvoice(invoice);
    }

}
