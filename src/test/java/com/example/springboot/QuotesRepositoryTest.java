package com.example.springboot;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.*;
import com.example.springboot.quotes.Quotes;
import com.example.springboot.quotes.QuotesRepository;

@DataJpaTest
class QuotesRepositoryTest {

    @Autowired
    private QuotesRepository underTest;


    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }


    @Test
    void itShouldFindByAuthor(){
        //given
        String author = "Einstein";
        Quotes quotes = new Quotes (
            author,
            "Everything should be made as simple as possible, but not simpler."
        );
        underTest.save(quotes);

        //when
       boolean expected = underTest.selectExistsAuthor(author);

       //then 
       assertThat(expected).isTrue();
    }

    @Test
    void itShouldNotFindByAuthor(){
        //given
        String author = "Einstein";
        Quotes quotes = new Quotes (
            author,
            "Everything should be made as simple as possible, but not simpler."
        );
        underTest.save(quotes);

        //when
       boolean expected = underTest.selectExistsAuthor(author);

       //then 
       assertThat(expected).isFalse();
    }




}
