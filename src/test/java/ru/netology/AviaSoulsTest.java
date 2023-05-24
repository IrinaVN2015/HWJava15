package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;


public class AviaSoulsTest {

    Ticket ticket1 = new Ticket("Самара", "Санкт-Петербург", 3000, 8, 10);
    Ticket ticket2 = new Ticket("Самара", "Санкт-Петербург", 2000, 12, 15);
    Ticket ticket3 = new Ticket("Самара", "Санкт-Петербург", 9000, 15, 20);
    Ticket ticket4 = new Ticket("Омск", "Москва", 11000, 14, 19);
    Ticket ticket5 = new Ticket("Самара", "Санкт-Петербург", 5000, 6, 7);
    Ticket ticket6 = new Ticket("Самара", "Санкт-Петербург", 5000, 4, 5);
    Ticket ticket7 = new Ticket("Омск", "Москва", 5000, 4, 10);

    AviaSouls aviaSouls = new AviaSouls();

    @BeforeEach
    public void setup() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
    }


    @Test
    public void testCompareToIfFirstLess() {

        int expected = 1;
        int actual = ticket1.compareTo(ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCompareToFirstMore() {

        int expected = -1;
        int actual = ticket2.compareTo(ticket1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCompareToFirstMore1() {

        int expected = 0;
        int actual = ticket5.compareTo(ticket6);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCompareToIfArray() {

        Ticket[] expected = {ticket2, ticket1, ticket5, ticket6, ticket3};
        Ticket[] actual = aviaSouls.search("Самара", "Санкт-Петербург");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchAndSortBy1() {

        Ticket[] expected = {ticket7, ticket4};
        Ticket[] actual = aviaSouls.search("Омск", "Москва");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearch2() {

        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.search("Омск", "Санкт-Петербург");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testTicketTimeComparator() {

        TicketTimeComparator comparator = new TicketTimeComparator();

        int expected = -1;
        int actual = comparator.compare(ticket1, ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testTicketTimeComparator2() {

        TicketTimeComparator comparator = new TicketTimeComparator();

        int expected = 1;
        int actual = comparator.compare(ticket3, ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testTicketTimeComparator3() {

        TicketTimeComparator comparator = new TicketTimeComparator();

        int expected = 0;
        int actual = comparator.compare(ticket5, ticket6);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSearchAndSortBy() {

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket5, ticket6, ticket1, ticket2, ticket3};
        Ticket[] actual = aviaSouls.searchAndSortBy("Самара", "Санкт-Петербург", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchAndSortBy2() {

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.searchAndSortBy("Самара", "Омск", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchAndSortBy3() {

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket4, ticket7};
        Ticket[] actual = aviaSouls.searchAndSortBy("Омск", "Москва", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

}
