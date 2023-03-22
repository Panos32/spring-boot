package com.example.springboot.quotes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Quotes{
    
    @Id
    @SequenceGenerator (
        name = "quotes_sequence",
        sequenceName = "quotes_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "quotes_sequence"
    )
    private Long id;
    private String author;
    private String text;

    
    public Quotes (Long id, String author, String text){
        this.id = id;
        this.author = author;
        this.text = text;      
    }

    
    public Quotes(){}

    public Quotes (String author, String text){
        this.author = author;
        this.text = text;      
    }



    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}
    public String getAuthor(){ return author;}
    public void setAuthor (String author) {this.author = author;}
    public String getText(){return text;}
    public void setText(String text) {this.text = text;}


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", author='" + getAuthor() + "'" +
            ", text='" + getText() + "'" +
            "}";
    }



}