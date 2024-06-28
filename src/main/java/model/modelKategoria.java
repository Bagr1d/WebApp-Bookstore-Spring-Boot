package model;

import java.io.Serializable;

public class modelKategoria implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idk;
    private String opis;

    public int getIdk() {
        return idk;
    }

    public void setIdk(int idk) {
        this.idk = idk;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
