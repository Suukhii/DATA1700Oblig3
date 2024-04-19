package org.example.oblig3;


import org.example.oblig3.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/tickets") // Base mapping for all endpoints in this controller
public class TicketController {

    @Autowired
    private TicketRepository rep;

    @PostMapping("/buy") // Endpoint for buying a ticket
    public void buyTicket(@RequestBody Ticket ticket) {
        // Add logic to process the ticket (e.g., save it to a database)
        rep.saveTicket(ticket);
    }

    @GetMapping("/all") // Endpoint to retrieve all tickets
    public List<Ticket> getAllTickets() {
        return rep.getAllTickets();
    }

    @DeleteMapping("/deleteAll") // Endpoint to delete all tickets
    public void deleteAllTickets() {
        rep.deleteAllTickets();
    }


    @PostMapping("/deleteOne/{id}") // Endpoint to delete one ticket by ID
    public void deleteOneTicket(@PathVariable int id) {
        rep.deleteTicketById(id);
    }


}
