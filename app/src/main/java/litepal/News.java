package litepal;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duan on 2017/5/5.
 */

public class News extends DataSupport{
    private long id;

    private String name;

    private int age;

    private int isMale;

//    private List<Album> albums = new ArrayList<Album>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int isMale() {
        return isMale;
    }

    public void setMale(int isMale) {
        this.isMale = isMale;
    }

 /*   public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }*/
}
