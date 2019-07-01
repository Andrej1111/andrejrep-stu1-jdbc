package lt.bit.aje.jdbc.entity;

import java.util.List;

public class Studentas {

    private String id;

    private String vardas;

    private String pavarde;

    private String el_pastas;

    private List<Studentas> stPazymiai;

    public Studentas() {
    }

    public Studentas(String id, String vardas) {
        this.id = id;
        this.vardas = vardas;
    }

    public Studentas(String id, String vardas, String pavarde) {
        this.id = id;
        this.vardas = vardas;
        this.pavarde = pavarde;
    }

    public Studentas(String vardas, String pavarde, String el_pastas, List<Studentas> stPazymiai) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.el_pastas = el_pastas;
        this.stPazymiai = stPazymiai;
    }

    public Studentas(String id, String vardas, String pavarde, String el_pastas) {
        this.id = id;
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.el_pastas = el_pastas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public String getEl_pastas() {
        return el_pastas;
    }

    public void setEl_pastas(String el_pastas) {
        this.el_pastas = el_pastas;
    }


    @Override
    public String toString() {
        return "Studentas{" +
                "id='" + id + '\'' +
                ", vardas='" + vardas + '\'' +
                ", pavarde='" + pavarde + '\'' +
                ", el_pastas='" + el_pastas + '\'' +
                '}';
    }
}
