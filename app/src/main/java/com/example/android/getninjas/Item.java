package com.example.android.getninjas;

import java.util.ArrayList;

/**
 * Created by Gabriel Palomino on 1/15/2017.
 */

public class Item {
    private long distance;
    private int lead_price;
    private String title;
    private ArrayList<String> questions;
    private ArrayList<String> answers;
    private String user_name;
    private String user_email;
    private ArrayList<String> phones;
    private String city;
    private String neighborhood;
    private String uf;
    private Double latitude;
    private Double longitude;
    private String accept_link;
    private String reject_link;

    public Item(long distance, int lead_price, String title, ArrayList<String> questions, ArrayList<String> answers, String user_name, String user_email, ArrayList<String> phones, String city, String neighborhood, String uf, Double latitude, Double longitude, String accept_link, String reject_link) {
        this.distance = distance;
        this.lead_price = lead_price;
        this.title = title;
        this.questions = questions;
        this.answers = answers;
        this.user_name = user_name;
        this.user_email = user_email;
        this.phones = phones;
        this.city = city;
        this.neighborhood = neighborhood;
        this.uf = uf;
        this.latitude = latitude;
        this.longitude = longitude;
        this.accept_link = accept_link;
        this.reject_link = reject_link;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    public int getLead_price() {
        return lead_price;
    }

    public void setLead_price(int lead_price) {
        this.lead_price = lead_price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<String> questions) {
        this.questions = questions;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public ArrayList<String> getPhones() {
        return phones;
    }

    public void setPhones(ArrayList<String> phones) {
        this.phones = phones;
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

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getAccept_link() {
        return accept_link;
    }

    public void setAccept_link(String accept_link) {
        this.accept_link = accept_link;
    }

    public String getReject_link() {
        return reject_link;
    }

    public void setReject_link(String reject_link) {
        this.reject_link = reject_link;
    }
}
