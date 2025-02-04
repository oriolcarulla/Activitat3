package models;

import org.bson.Document;

import java.util.List;

public class Publicacions {
    private String _id;
    private String text;
    private List<String> hastags;
    private List<String> mencions;
    private List<String> paraules_clau;
    private String data_hora;
    private int likes;
    private int retuits;
    private String ubicacio;
    private String sentiment;
    private String usuari_id;

    public Publicacions (String _id, String text, List<String> hastags, List<String> mencions, List<String> paraules_clau, String data_hora, int likes, int retuits, String ubicacio, String sentiment, String usuari_id){
        this._id = _id;
        this.text = text;
        this.hastags = hastags;
        this.mencions = mencions;
        this.paraules_clau = paraules_clau;
        this.data_hora = data_hora;
        this.likes = likes;
        this.retuits = retuits;
        this.ubicacio = ubicacio;
        this.sentiment = sentiment;
        this.usuari_id = usuari_id;
    }

    //Getters and Setters
    public String get_Id() {
        return _id;
    }
    public String getText() {
        return text;
    }
    public List<String> getHastags() {
        return hastags;
    }
    public List<String> getMencions() {
        return mencions;
    }
    public List<String> getParaules_clau() {
        return paraules_clau;
    }
    public String getData_hora() {
        return data_hora;
    }
    public int getLikes() {
        return likes;
    }
    public int getRetuits() {
        return retuits;
    }
    public String getUbicacio() {
        return ubicacio;
    }
    public String getSentiment() {
        return sentiment;
    }
    public String getUsuari_id() {
        return usuari_id;
    }

    public void set_Id(String _id) {
        this._id = _id;
    }
    public void setText(String text) {
        this.text = text;
    }
    public void setHastags(List<String> hastags) {
        this.hastags = hastags;
    }
    public void setMencions(List<String> mencions) {
        this.mencions = mencions;
    }
    public void setParaules_clau(List<String> paraules_clau) {
        this.paraules_clau = paraules_clau;
    }
    public void setData_hora(String data_hora) {
        this.data_hora = data_hora;
    }
    public void setLikes(int likes) {
        this.likes = likes;
    }
    public void setRetuits(int retuits) {
        this.retuits = retuits;
    }
    public void setUbicacio(String ubicacio) {
        this.ubicacio = ubicacio;
    }
    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }
    public void setUsuari_id(String usuari_id) {
        this.usuari_id = usuari_id;
    }

    public Document toDocument(){
        Document document = new Document();
        document.append("_id", _id)
                .append("text", text)
                .append("hastags", hastags)
                .append("mencions", mencions)
                .append("paraules_clau", paraules_clau)
                .append("data_hora", data_hora)
                .append("likes", likes)
                .append("retuits", retuits)
                .append("ubicacio", ubicacio)
                .append("sentiment", sentiment)
                .append("usuari_id", usuari_id);
        return document;
    }

    @Override
    public String toString() {
        return "_id=" + _id + ", text=" + text + ", hastags=" + hastags + ", mencions=" + mencions + ", paraules_clau=" + paraules_clau + ", data_hora=" + data_hora + ", likes=" + likes + ", retuits=" + retuits + ", ubicacio=" + ubicacio + ", sentiment=" + sentiment + ", usuari_id=" + usuari_id;
    }
}
