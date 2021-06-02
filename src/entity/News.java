package entity;

import Logic.INews;

import java.util.ArrayList;

public class News implements INews {
    public int id;
    public String title;
    public String publishdate;
    public String author;
    public String content;
    float averagerate;
    ArrayList arr = new ArrayList();

    public News() {

    }

    public News(String title, String publishdate, String author, String content){
        this.title = title;
        this.publishdate = publishdate;
        this.author = author;
        this.content= content;
    }


    @Override
    public void insertNews(String title, String publishdate, String author, String content){
        News nw = new News();
        nw.title = title;
        nw.publishdate = publishdate;
        nw.author = author;
        nw.content = content;
        arr.add(nw);
    }
    @Override
    public void display() {
        for (int i = 0; i<arr.size();i++){
            System.out.println(arr.get(i));
        }
    }




    public float getAveragerate() {
        return averagerate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(String publishdate) {
        this.publishdate = publishdate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
