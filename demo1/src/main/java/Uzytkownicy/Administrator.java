package Uzytkownicy;

public class Administrator extends Uzytkownik{
    private static final long serialVersionUID = 12L;
    public Administrator(String imie, String drugie_imie, String nazwisko, String email, String login, String haslo) {
        super(imie, drugie_imie, nazwisko, email, login, haslo);
    }
}
