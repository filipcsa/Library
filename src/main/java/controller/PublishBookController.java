package controller;

import entity.Author;

import javax.enterprise.inject.Model;
import java.util.List;

@Model
public class PublishBookController {

    private String selectedAuthor;

    private List<String> authors;

    private String selectedPublisher;

    private List<String> publishers;

    private String date;


    public void publishBook(){

    }
}
