package com.example.springboot;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.springboot.quotes.QuotesRepository;
import com.example.springboot.quotes.QuotesService;

public class QuotesServiceTest {
    
    @Mock
    private QuotesRepository quotesRepository;
    private AutoCloseable autoCloseable;
    private QuotesService underTest;



    // fresh instance of a new service
    @BeforeEach
    void setUp(){
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new QuotesService(quotesRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void getQuotes (){
        // when
        underTest.getQuotes();
        //then
        verify(quotesRepository).findAll();

    }

    @Test
    @Disabled
    void oneQuote() {

    }

    @Test
    @Disabled
    void addNewQuote() {

    }

    @Test
    @Disabled
    void deleteQuotes() {

    }

    @Test
    @Disabled
    void updateQuotes(){

    }

    @Test
    @Disabled
    void randomQuotes() {

    }

    @Test
    @Disabled
    void getByString() {

    }


}
