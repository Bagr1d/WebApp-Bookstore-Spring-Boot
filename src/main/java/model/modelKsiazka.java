package model;

import java.io.Serializable;

public class modelKsiazka implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idk;
    private String tytul;
    private int rokWydania;
    private modelWydawnictwo wyd;
    private modelKategoria kat;

    public int getIdk() {
        return idk;
    }

    public void setIdk(int idk) {
        this.idk = idk;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public int getRokWydania() {
        return rokWydania;
    }

    public void setRokWydania(int rokWydania) {
        this.rokWydania = rokWydania;
    }

    public modelWydawnictwo getWyd() {
        return wyd;
    }

    public void setWyd(modelWydawnictwo wyd) {
        this.wyd = wyd;
    }

    public modelKategoria getKat() {
        return kat;
    }

    public void setKat(modelKategoria kat) {
        this.kat = kat;
    }
}
