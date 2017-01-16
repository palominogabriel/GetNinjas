package com.example.android.getninjas;

/**
 * Created by Gabriel Palomino on 1/15/2017.
 */

public class Offer {
    private boolean read;
    private String creationDate;
    private String title;
    private String userName;
    private String city;
    private String neighborhood;
    private String uf;
    private String link;

    Offer(boolean read, String creationDate, String title, String userName, String city, String neighborhood, String uf, String link){
        setRead(read);
        setCreationDate(creationDate);
        setTitle(title);
        setUserName(userName);
        setCity(city);
        setNeighborhood(neighborhood);
        setUf(uf);
        setLink(link);
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
