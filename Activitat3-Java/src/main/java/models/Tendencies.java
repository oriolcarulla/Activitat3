package models;

import org.bson.Document;

public class Tendencies {
    private String paraula_clau;
    private int mencions_count;
    private String data_hora;

    public Tendencies(String paraula_clau, int mencions_count, String data_hora) {
        this.paraula_clau = paraula_clau;
        this.mencions_count = mencions_count;
        this.data_hora = data_hora;
    }

    // Getters and Setters
    public String getParaula_clau() {
        return paraula_clau;
    }
    public int getMencions_count() {
        return mencions_count;
    }
    public String getData_hora() {
        return data_hora;
    }

    public void setParaula_clau(String paraula_clau) {
        this.paraula_clau = paraula_clau;
    }
    public void setMencions_count(int mencions_count) {
        this.mencions_count = mencions_count;
    }
    public void setData_hora(String data_hora) {
        this.data_hora = data_hora;
    }

    public Document toDocument(){
        Document document = new Document();
        document.append("paraula_clau", this.paraula_clau)
                .append("mencions_count", this.mencions_count)
                .append("data_hora", this.data_hora);
        return document;
    }

    @Override
    public String toString() {
        return "Tendencies{" + "paraula_clau=" + paraula_clau + ", mencions_count=" + mencions_count + ", data_hora=" + data_hora + '}';
    }
}
