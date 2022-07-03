package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    private TicketsManager manager = new TicketsManager();
    private Ticket first = new Ticket(1, 1000, "ESB", "ODO",10);
    private Ticket second = new Ticket(2, 1500, "ESB", "ODO",10);
    private Ticket third = new Ticket(3, 2000, "NBC", "KRO",10);
    private Ticket forth = new Ticket(4, 2000, "NBC", "KRO",10);
    private Ticket fifth = new Ticket(5, 2500, "NBC", "KRO",10);
    private Ticket sixth = new Ticket(6, 2500, "ESB", "ODO",10);

    @BeforeEach
    public void set() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
        manager.add(sixth);
    }

    @Test
    public void shouldSortByCost() {
        Ticket[] actual = manager.findAll("ESB", "ODO");
        Ticket[] expected = new Ticket[]{first, second, sixth};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSortByEqualCost() {
        Ticket[] actual = manager.findAll("NBC", "KRO");
        Ticket[] expected = new Ticket[]{third, forth, fifth};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSortByCostWithDifferent() {
        Ticket[] actual = manager.findAll("ESB", "NBC");
        Ticket[] expected = new Ticket[]{};

        assertArrayEquals(expected, actual);
    }



}

