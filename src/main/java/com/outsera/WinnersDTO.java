package com.outsera;

import lombok.Data;

@Data
public class WinnersDTO {

    private String producer;
    private int interval;
    private int previousWin;
    private int followingWin;

    public WinnersDTO(String producer, int interval, int previousWin, int followingWin) {
        this.producer = producer;
        this.interval = interval;
        this.previousWin = previousWin;
        this.followingWin = followingWin;
    }

}
