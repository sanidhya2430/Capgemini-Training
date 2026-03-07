package com.capgi.entity;

public class Player {
    private int playerid;
    private String playername;
    private String playercountry;

    public Player(int playerid, String playername, String playercountry) {
        this.playerid = playerid;
        this.playername = playername;
        this.playercountry = playercountry;
    }

    public int getPlayerid() {
        return playerid;
    }

    public void setPlayerid(int playerid) {
        this.playerid = playerid;
    }

    public String getPlayername() {
        return playername;
    }

    public void setPlayername(String playername) {
        this.playername = playername;
    }

    public String getPlayercountry() {
        return playercountry;
    }

    public void setPlayercountry(String playercountry) {
        this.playercountry = playercountry;
    }
    @Override
    public String toString() {
        return "Player{" +
                "playerid=" + playerid +
                ", playername='" + playername + '\'' +
                ", playercountry='" + playercountry + '\'' +
                '}';
    }
}
