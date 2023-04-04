package com.company.gamestore.controller;

import com.company.gamestore.controllers.ConsoleController;
import com.company.gamestore.models.Console;
import com.company.gamestore.models.Invoice;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ConsoleController.class)
public class InvoiceControllerTest {
    // Wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    // A list of records for testing purposes
    private List<Invoice> invoiceList;

    @Before
    public void setUp() {
        // Standard set up method, for instantiating test objects
        // Don't have to do anything special for mockMvc since it's Autowired
    }
    @Test
    public void shouldReturnAllInvoicesInCollection() throws Exception {

        // ARRANGE
        // Convert Java object to JSON
        String outputJson = mapper.writeValueAsString(invoiceList);

        // ACT
        mockMvc.perform(get("/invoices"))        // Perform the GET request
                .andDo(print())              // Print results to console
                .andExpect(status().isOk());        // ASSERT (status code is 200)
    }

    @Test
    public void shouldReturnInvoiceById() throws Exception {
        Invoice invoice = new Invoice();

        invoice.setItem_id(54321);
        invoice.setItem_type("TShirt");
        invoice.setName("John Doe");
        invoice.setStreet("200 Ferry Street");
        invoice.setCity("Newark");
        invoice.setState("NJ");
        invoice.setZipcode("07105");
        invoice.setQuantity(1);
        invoice.setUnit_price(BigDecimal.valueOf(15.99));
        invoice.setSubtotal(BigDecimal.valueOf(15.99));
        invoice.setTax(BigDecimal.valueOf(0.05));
        invoice.setProcessing_fee(BigDecimal.valueOf(1.98));
        invoice.setTotal(BigDecimal.valueOf(18.77));
        invoice.setId(2);


        String outputJson = mapper.writeValueAsString(invoice);

        mockMvc.perform(get("/invoice/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }


    @Test
    public void shouldReturn404StatusCodeIfInvoiceNotFound() throws Exception {
        mockMvc.perform(get("/consoles/567"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldReturnConsoleByCustomerName() throws Exception {
        Invoice invoice = new Invoice();

        invoice.setItem_id(54321);
        invoice.setItem_type("TShirt");
        invoice.setName("John Doe");
        invoice.setStreet("200 Ferry Street");
        invoice.setCity("Newark");
        invoice.setState("NJ");
        invoice.setZipcode("07105");
        invoice.setQuantity(1);
        invoice.setUnit_price(BigDecimal.valueOf(15.99));
        invoice.setSubtotal(BigDecimal.valueOf(15.99));
        invoice.setTax(BigDecimal.valueOf(0.05));
        invoice.setProcessing_fee(BigDecimal.valueOf(1.98));
        invoice.setTotal(BigDecimal.valueOf(18.77));
        invoice.setId(2);

        String outputJson = mapper.writeValueAsString(invoice);

        mockMvc.perform(get("/invoices/John Doe"))   //should there be a space here
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }
}
