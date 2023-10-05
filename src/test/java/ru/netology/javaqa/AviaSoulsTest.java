package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class AviaSoulsTest {
    @Test
    public void testSortTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "NN", 30000, 12,14);
        Ticket ticket2 = new Ticket("MSK", "NN", 3000, 18,20);
        Ticket ticket3 = new Ticket("NN", "MSK", 2000, 14,16);
        Ticket ticket4 = new Ticket("MSK", "NN", 15000, 13,15);
        Ticket ticket5 = new Ticket("NN", "LA", 25000, 12,24);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

       Ticket [] actual = manager.search("MSK", "NN");
        Ticket [] expected ={ticket2, ticket4, ticket1};
        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void testSortTickets_zero_tickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "NN", 30000, 12,14);
        Ticket ticket2 = new Ticket("MSK", "NN", 3000, 18,20);
        Ticket ticket3 = new Ticket("NN", "MSK", 2000, 14,16);
        Ticket ticket4 = new Ticket("MSK", "NN", 15000, 13,15);
        Ticket ticket5 = new Ticket("NN", "LA", 25000, 12,24);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket [] actual = manager.search("MSK", "NY");
        Ticket [] expected ={};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSortTickets_one_tickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "NN", 30000, 12,14);
        Ticket ticket2 = new Ticket("MSK", "NN", 3000, 18,20);
        Ticket ticket3 = new Ticket("NN", "MSK", 2000, 14,16);
        Ticket ticket4 = new Ticket("MSK", "NN", 15000, 13,15);
        Ticket ticket5 = new Ticket("NN", "LA", 25000, 12,24);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket [] actual = manager.search("NN", "LA");
        Ticket [] expected ={ticket5};
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testSortTickets_same_time() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "NN", 3000, 12,14);
        Ticket ticket2 = new Ticket("MSK", "NN", 3000, 18,20);
        Ticket ticket3 = new Ticket("NN", "MSK", 2000, 14,16);
        Ticket ticket4 = new Ticket("MSK", "NN", 15000, 13,15);
        Ticket ticket5 = new Ticket("NN", "LA", 25000, 12,24);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket [] actual = manager.search("MSK", "NN");
        Ticket [] expected ={ticket1,ticket2,ticket4};
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testTimeTicket(){
    AviaSouls manager = new AviaSouls();
    Ticket ticket1 = new Ticket("MSK", "NN", 30000, 11,14); //3
    Ticket ticket2 = new Ticket("MSK", "NN", 3000, 18,20); //2
    Ticket ticket3 = new Ticket("NN", "MSK", 2000, 14,16);
    Ticket ticket4 = new Ticket("MSK", "NN", 15000, 13,14);//1
    Ticket ticket5 = new Ticket("NN", "LA", 25000, 12,24);
    manager.add(ticket1);
    manager.add(ticket2);
    manager.add(ticket3);
    manager.add(ticket4);
    manager.add(ticket5);

    Comparator <Ticket> comparator = new TicketTimeComparator();
    Ticket [] actual = manager.searchAndSortBy("MSK", "NN", comparator);
    Ticket [] expected = {ticket4, ticket2, ticket1};
    Assertions.assertArrayEquals(expected, actual);

}
@Test
public void testTimeTicket_zero_tickets() {
    AviaSouls manager = new AviaSouls();
    Ticket ticket1 = new Ticket("MSK", "NN", 30000, 11, 14); //3
    Ticket ticket2 = new Ticket("MSK", "NN", 3000, 18, 20); //2
    Ticket ticket3 = new Ticket("NN", "MSK", 2000, 14, 16);
    Ticket ticket4 = new Ticket("MSK", "NN", 15000, 13, 14);//1
    Ticket ticket5 = new Ticket("NN", "LA", 25000, 12, 24);
    manager.add(ticket1);
    manager.add(ticket2);
    manager.add(ticket3);
    manager.add(ticket4);
    manager.add(ticket5);

    Comparator<Ticket> comparator = new TicketTimeComparator();
    Ticket[] actual = manager.searchAndSortBy("MSK", "NY", comparator);
    Ticket[] expected = {};
    Assertions.assertArrayEquals(expected, actual);
}
    @Test
    public void testTimeTicket_same_time() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "NN", 30000, 12, 14); //2
        Ticket ticket2 = new Ticket("MSK", "NN", 3000, 18, 20); //2
        Ticket ticket3 = new Ticket("NN", "MSK", 2000, 14, 16);
        Ticket ticket4 = new Ticket("MSK", "NN", 15000, 13, 14);//1
        Ticket ticket5 = new Ticket("NN", "LA", 25000, 12, 24);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] actual = manager.searchAndSortBy("MSK", "NN", comparator);
        Ticket[] expected = {ticket4,ticket1, ticket2};
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testTimeTicket_one_ticket(){
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "NN", 30000, 12, 14);
        Ticket ticket2 = new Ticket("MSK", "NN", 3000, 18, 20);
        Ticket ticket3 = new Ticket("NN", "MSK", 2000, 14, 16);
        Ticket ticket4 = new Ticket("MSK", "NN", 15000, 13, 14);
        Ticket ticket5 = new Ticket("NN", "LA", 25000, 12, 24);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] actual = manager.searchAndSortBy("NN", "LA", comparator);
        Ticket[] expected = {ticket5};
        Assertions.assertArrayEquals(expected, actual);
    }

}