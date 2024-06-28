package model;

import java.io.Serializable;

public class modelWydawnictwo implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idw;
    private String nazwa;
    private String miasto;
    private String panstwo;

    public int getIdw() {
        return idw;
    }

    public void setIdw(int idw) {
        this.idw = idw;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getPanstwo() {
        return panstwo;
    }

    public void setPanstwo(String panstwo) {
        this.panstwo = panstwo;
    }
}
