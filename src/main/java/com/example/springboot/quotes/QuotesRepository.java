package com.example.springboot.quotes;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuotesRepository 
        extends JpaRepository<Quotes,Long>{

    Optional<Quotes>findById(Long id);

    Optional<Quotes>findQuotesByAuthor(String author);
        
    long count(); 
    Page<Quotes> findAll(Pageable pageable);
    
    List<Quotes> findByTextContains(String text);
}
