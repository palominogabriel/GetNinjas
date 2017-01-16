package com.example.android.getninjas;

/**
 * Created by Gabriel Palomino on 1/15/2017.
 */

public class Lead {
    private String creationDate;
    private String city;
    private String street;
    private String neighborhood;
    private String uf;
    private String userName;
    private String userEmail;
    private String title;
    private String link;

    Lead(String creationDate, String city, String street, String neighborhood, String uf, String userName, String userEmail, String title, String link){
        setCreationDate(creationDate);
        setCity(city);
        setStreet(street);
        setNeighborhood(neighborhood);
        setUf(uf);
        setUserName(userName);
        setUserEmail(userEmail);
        setTitle(title);
        setLink(link);
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
