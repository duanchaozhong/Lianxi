package litepal;

import org.litepal.crud.DataSupport;

/**
 * Created by duan on 2017/5/5.
 */

public class News extends DataSupport{
    private int id;
    private String author;
    private double price;
    private int pages;
    private String name;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPages() {
        return pages;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
