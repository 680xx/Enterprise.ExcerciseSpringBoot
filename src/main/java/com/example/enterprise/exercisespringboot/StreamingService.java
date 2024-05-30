package com.example.enterprise.exercisespringboot;

import org.springframework.stereotype.Component;

@Component
public class StreamingService {

    private int id;
    private String name;
    private String quality;
    private int prize;

    // Constructor
    public StreamingService() {
    }

    public StreamingService(int id, String name, String quality, int prize) {
        this.id = id;
        this.name = name;
        this.quality = quality;
        this.prize = prize;
    }


    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }
}
