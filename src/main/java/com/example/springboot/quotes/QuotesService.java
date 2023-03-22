package com.example.springboot.quotes;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QuotesService {

    private final QuotesRepository quotesRepository;

    @Autowired
    public QuotesService(QuotesRepository quotesRepository) {
        this.quotesRepository = quotesRepository;
    }


    public List<Quotes> getQuotes() {
        return quotesRepository.findAll();
    }


    public Optional<Quotes> oneQuote(Long quotesId) {
       return quotesRepository.findById(quotesId);
    }

    public void addNewQuote(Quotes quotes){
        Optional<Quotes> quotesOptional = quotesRepository.
        findQuotesByAuthor(quotes.getAuthor());
        if (quotesOptional.isPresent()) {
            throw new IllegalStateException("Author exists");
        }
        quotesRepository.save(quotes);
    }


    public void deleteQuotes(Long quotesId) {
            boolean exists = quotesRepository.existsById(quotesId);
            if (!exists){
                throw new IllegalStateException("Quote with id " + quotesId + "does not exist");
            }
            quotesRepository.deleteById(quotesId);
    }

    @Transactional
    public void updateQuotes (Long quotesId, String author, String text){
        Quotes quotes = quotesRepository.findById(quotesId).orElseThrow(() -> new IllegalStateException(
            "Quote with id " + quotesId + " does not exist" ));
    
        if (author != null && author.length() > 0 && !Objects.equals(quotes.getAuthor(), author)){
            quotes.setAuthor(author);
        }
        if (text != null && text.length() > 0 && !Objects.equals(quotes.getText(), text)){
            quotes.setText(text);
        }
    }

    public Quotes randomQuotes(){
        Long qty = quotesRepository.count();
        int idx = (int)(Math.random() * qty);
        Page<Quotes> quotesPage = quotesRepository.findAll(PageRequest.of(idx,1));
        Quotes q = null;
        if (quotesPage.hasContent()) {
            q = quotesPage.getContent().get(0);
        }
        return q;
     }
    
    public List<Quotes> getByString(){
     return quotesRepository.findByTextContains("discover");  

    }



}