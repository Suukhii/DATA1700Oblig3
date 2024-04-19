package org.example.oblig3;

import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class TicketRepository {

    @Autowired
    private JdbcTemplate db;

    public void saveTicket(Ticket inTicket){
        String sql = "INSERT INTO TICKET (film, quantity, first_name, last_name, telephone, email) VALUES (?, ?, ?, ?, ?, ?)";

        db.update(sql, inTicket.getFilm(), inTicket.getQuantity(),inTicket.getFirstName(), inTicket.getLastName(), inTicket.getTelephone(), inTicket.getEmail());
    }

    public List getAllTickets(){
        String sql = "SELECT * FROM TICKET ORDER BY last_name";
        return db.query(sql, new BeanPropertyRowMapper(Ticket.class));
    }

    public void deleteAllTickets(){
        String sql = "DELETE FROM TICKET";
        db.update(sql);
    }

    public void deleteTicketById(int id){
        String sql = "DELETE FROM TICKET WHERE ID = ?";
        db.update(sql, id);
    }


}



