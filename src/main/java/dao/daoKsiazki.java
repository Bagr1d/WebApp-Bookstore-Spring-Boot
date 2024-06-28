package dao;

import model.modelKsiazka;
import model.modelKategoria;
import model.modelWydawnictwo;

import java.sql.*;
import java.util.ArrayList;

public class daoKsiazki {
    private Connection dbcon = null;
    private Statement dbstat = null;

    private void otworzCon() {
        String login = "postgres";
        String haslo = "";
        String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=\"ksiazki\"";
        try {
            Class.forName("org.postgresql.Driver");
            dbcon = DriverManager.getConnection(url, login, haslo);
            dbstat = dbcon.createStatement();
            System.out.println("Połączenie otwarte");
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Błąd połączenia: " + ex.getMessage());
        }
    }

    private void zamknijCon() {
        if (dbcon == null) return;
        try {
            dbcon.close();
            System.out.println("Połączenie zamknięte");
        } catch (SQLException ex) {
            System.out.println("Problem z zamknięciem bazy");
        }
    }

    public ArrayList<modelKategoria> listaKategorii() {
        ArrayList<modelKategoria> lk = new ArrayList<>();
        String pyt = "SELECT idk, opis FROM ksiazki.kategoria";
        try {
            otworzCon();
            ResultSet wyniki = dbstat.executeQuery(pyt);
            while (wyniki.next()) {
                modelKategoria k = new modelKategoria();
                k.setIdk(wyniki.getInt("idk"));
                k.setOpis(wyniki.getString("opis"));
                lk.add(k);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            zamknijCon();
        }
        return lk;
    }

    public ArrayList<modelWydawnictwo> listaWydawnictw() {
        ArrayList<modelWydawnictwo> lw = new ArrayList<>();
        String pyt = "SELECT idw, nazwa, miasto, panstwo FROM ksiazki.wydawnictwo";
        try {
            otworzCon();
            ResultSet wyniki = dbstat.executeQuery(pyt);
            while (wyniki.next()) {
                modelWydawnictwo w = new modelWydawnictwo();
                w.setIdw(wyniki.getInt("idw"));
                w.setNazwa(wyniki.getString("nazwa"));
                w.setMiasto(wyniki.getString("miasto"));
                w.setPanstwo(wyniki.getString("panstwo"));
                lw.add(w);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            zamknijCon();
        }
        return lw;
    }

    public ArrayList<modelKsiazka> listaKsiazek() {
        ArrayList<modelKsiazka> lk = new ArrayList<>();
        String pyt = "SELECT k.idk, k.tytul, k.rokwydania, k.idwyd, k.idkat, w.nazwa as wydawnictwo, kat.opis as kategoria FROM ksiazki.ksiazka k JOIN ksiazki.wydawnictwo w ON k.idwyd = w.idw JOIN ksiazki.kategoria kat ON k.idkat = kat.idk";
        try {
            otworzCon();
            ResultSet wyniki = dbstat.executeQuery(pyt);
            while (wyniki.next()) {
                modelKsiazka k = new modelKsiazka();
                k.setIdk(wyniki.getInt("idk"));
                k.setTytul(wyniki.getString("tytul"));
                k.setRokWydania(wyniki.getInt("rokwydania"));

                modelWydawnictwo wyd = new modelWydawnictwo();
                wyd.setIdw(wyniki.getInt("idwyd"));
                wyd.setNazwa(wyniki.getString("wydawnictwo"));

                modelKategoria kat = new modelKategoria();
                kat.setIdk(wyniki.getInt("idkat"));
                kat.setOpis(wyniki.getString("kategoria"));

                k.setWyd(wyd);
                k.setKat(kat);

                lk.add(k);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            zamknijCon();
        }
        return lk;
    }

    public ArrayList<modelKsiazka> listaKsiazekKategorii(int id) {
        ArrayList<modelKsiazka> lk = new ArrayList<>();
        String pyt = "SELECT k.idk, k.tytul, k.rokwydania, k.idwyd, k.idkat, w.nazwa as wydawnictwo, kat.opis as kategoria FROM ksiazki.ksiazka k JOIN ksiazki.wydawnictwo w ON k.idwyd = w.idw JOIN ksiazki.kategoria kat ON k.idkat = kat.idk WHERE k.idkat = " + id;
        try {
            otworzCon();
            ResultSet wyniki = dbstat.executeQuery(pyt);
            while (wyniki.next()) {
                modelKsiazka k = new modelKsiazka();
                k.setIdk(wyniki.getInt("idk"));
                k.setTytul(wyniki.getString("tytul"));
                k.setRokWydania(wyniki.getInt("rokwydania"));

                modelWydawnictwo wyd = new modelWydawnictwo();
                wyd.setIdw(wyniki.getInt("idwyd"));
                wyd.setNazwa(wyniki.getString("wydawnictwo"));

                modelKategoria kat = new modelKategoria();
                kat.setIdk(wyniki.getInt("idkat"));
                kat.setOpis(wyniki.getString("kategoria"));

                k.setWyd(wyd);
                k.setKat(kat);

                lk.add(k);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            zamknijCon();
        }
        return lk;
    }

    public void dodajKsiazke(modelKsiazka ksiazka) {
        String pyt = "INSERT INTO ksiazki.ksiazka (tytul, rokwydania, idwyd, idkat) VALUES (?, ?, ?, ?)";
        try {
            otworzCon();
            PreparedStatement ps = dbcon.prepareStatement(pyt);
            ps.setString(1, ksiazka.getTytul());
            ps.setInt(2, ksiazka.getRokWydania());
            ps.setInt(3, ksiazka.getWyd().getIdw());
            ps.setInt(4, ksiazka.getKat().getIdk());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            zamknijCon();
        }
    }

    public void usunKsiazke(int idk) {
        String pyt = "DELETE FROM ksiazki.ksiazka WHERE idk = ?";
        try {
            otworzCon();
            PreparedStatement ps = dbcon.prepareStatement(pyt);
            ps.setInt(1, idk);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            zamknijCon();
        }
    }
}
