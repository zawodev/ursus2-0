package PakietWydarzenie;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Wydarzenie implements Serializable {


    String nazwa_wydarzenia;
    LocalDateTime data_wydarzenia;
    String dodajacy_wydarzenie;
    String opis_wydarzenia;

    public Wydarzenie(String nazwa_wydarzenia, LocalDateTime data_wydarzenia, String dodajacy_wydarzenie, String opis_wydarzenia) {
        this.nazwa_wydarzenia = nazwa_wydarzenia;
        this.data_wydarzenia = data_wydarzenia;
        this.dodajacy_wydarzenie = dodajacy_wydarzenie;
        this.opis_wydarzenia = opis_wydarzenia;
    }

    public String getNazwa_wydarzenia() {
        return nazwa_wydarzenia;
    }

    public void setNazwa_wydarzenia(String nazwa_wydarzenia) {
        this.nazwa_wydarzenia = nazwa_wydarzenia;
    }

    public LocalDateTime getData_wydarzenia() {
        return data_wydarzenia;
    }

    public void setData_wydarzenia(LocalDateTime data_wydarzenia) {
        this.data_wydarzenia = data_wydarzenia;
    }

    public String getDodajacy_wydarzenie() {
        return dodajacy_wydarzenie;
    }

    public void setDodajacy_wydarzenie(String dodajacy_wydarzenie) {
        this.dodajacy_wydarzenie = dodajacy_wydarzenie;
    }

    public String getOpis_wydarzenia() {
        return opis_wydarzenia;
    }

    public void setOpis_wydarzenia(String opis_wydarzenia) {
        this.opis_wydarzenia = opis_wydarzenia;
    }

//    public String toString(){
//        String temp = dodajacy_wydarzenie.getDrugie_imie();
//        if(dodajacy_wydarzenie.getDrugie_imie() != ""){
//            temp = dodajacy_wydarzenie.getDrugie_imie()+" ";
//        }
//        return nazwa_wydarzenia + "\n"+data_wydarzenia.toLocalDate().toString()+" "+
//                data_wydarzenia.toLocalTime().toString()+"\n\n"+opis_wydarzenia+"\n\ndodane przez: "+
//                dodajacy_wydarzenie.getImie()+" "+temp+
//                dodajacy_wydarzenie.getNazwisko()+"\n\n";
//    }

    public String getGodzina(){
        return data_wydarzenia.toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm"));
    }
}
