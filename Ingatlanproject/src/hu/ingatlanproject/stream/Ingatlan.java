package hu.ingatlanproject.stream;

	

import java.time.LocalDateTime;

public class Ingatlan {

    private String utca;
    private String varos;
    private int iranyitoSzam;
    private String allam;
    private int haloSzobaSzam;
    private int furdoSzobaSzam;
    private int negyzetMeter;
    private String tipus;
    private LocalDateTime eladasIdopontja;
    private int ar;
    private double szelessegiFok;
    private double hosszusagiFok;

    public Ingatlan(String s){
        String[] adatok = s.split(",");

        this.utca = adatok[0];
        this.varos = adatok[1];
        this.allam = adatok[3];
        this.haloSzobaSzam= Integer.parseInt(adatok[4]);
        this.furdoSzobaSzam= Integer.parseInt(adatok[5]);
        this.negyzetMeter = Integer.parseInt(adatok[6]);
        this.tipus= adatok[7];
        this.ar = Integer.parseInt(adatok[9]);
    }

    public String getUtca() {
        return utca;
    }

    public String getVaros() {
        return varos;
    }

    public int getIranyitoSzam() {
        return iranyitoSzam;
    }

    public String getAllam() {
        return allam;
    }

    public int getHaloSzobaSzam() {
        return haloSzobaSzam;
    }

    public int getFurdoSzobaSzam() {
        return furdoSzobaSzam;
    }

    public int getNegyzetMeter() {
        return negyzetMeter;
    }

    public String getTipus() {
        return tipus;
    }

    public LocalDateTime getEladasIdopontja() {
        return eladasIdopontja;
    }

    public int getAr() {
        return ar;
    }

    public double getSzelessegiFok() {
        return szelessegiFok;
    }

    public double getHosszusagiFok() {
        return hosszusagiFok;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %d dollar %d nm", this.varos, this.utca, this.ar, this.negyzetMeter);
    }
}


