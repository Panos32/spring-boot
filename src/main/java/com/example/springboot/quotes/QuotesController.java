package com.example.springboot.quotes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/quotes")
public class QuotesController {


    private final QuotesService quotesService;


    @Autowired
    public QuotesController(QuotesService quotesService) {
        this.quotesService = quotesService;
    }

    @GetMapping(path = "/getall")
	public List<Quotes> getQuotes() {
        return quotesService.getQuotes();
	}

    @GetMapping(path = "/get/{quotesId}") 
    public Optional<Quotes> oneQuote(@PathVariable("quotesId") Long quotesId) {
        return quotesService.oneQuote(quotesId);
    }

    @GetMapping(path = "/getrandom")
    public Quotes randomQuotes() {
      return quotesService.randomQuotes();
    }

    //@GetMapping(path = "/getrandom")
    //public List<Quotes> findRandomQuotes() {
    //     return quotesService.findRandomQuotes();
    // }

    @GetMapping(path ="/getByString")
    public List<Quotes> getByString(){
        return quotesService.getByString();
    }

    @PostMapping
    public void registerNewQuote (@RequestBody Quotes quotes) {
        quotesService.addNewQuote(quotes);  
    }

    @DeleteMapping(path = "{quotesId}")
    public void deleteQuotes (@PathVariable("quotesId") Long quotesId){
        quotesService.deleteQuotes(quotesId);
    }

    @PutMapping(path = "{quotesId}")
    public void updateQuotes(
        @PathVariable("quotesId")Long quotesId,
        @RequestParam(required = false)String author,
        @RequestParam(required = false)String text ){
            quotesService.updateQuotes(quotesId, author, text);
        }

}
