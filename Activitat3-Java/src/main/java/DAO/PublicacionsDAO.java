package DAO;

import models.Publicacions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import models.Usuaris;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

public class PublicacionsDAO {
    private MongoCollection<Document> collection;
    private MongoCollection<Document> collectionUsuaris;

    public PublicacionsDAO(MongoDatabase database) {
        this.collection = database.getCollection("Publicacions");
        this.collectionUsuaris = database.getCollection("Usuaris");
    }

    public List<Publicacions> obtenirTots() {
        List<Publicacions> publicaciones = new ArrayList<>();
        for (Document doc : collection.find()) {
            Publicacions p = fromDocument(doc);
            Document doc_user = collectionUsuaris.find(new Document("_id", p.getUsuari_id())).first();
            Usuaris u = new UsuarisDAO().fromDocument(doc_user);
            p.setUsuari(u);
            publicaciones.add(p);
        }
        return publicaciones;
    }

    public boolean addPublicacio(Publicacions p){
        Document doc = p.toDocument();
        collection.insertOne(doc);
        return true;
    }

    public String getLastId(){
        Document doc = collection.find().sort(new Document("_id", -1)).first();
        String idStr =  doc.getString("_id");
        int id = Integer.parseInt(idStr);
        id++;
        return Integer.toString(id);
    }

    public List<Publicacions> filtrarData(String desde, String hasta){
        //formato de las dates: 2024-01-30T12:00:00Z
        List<Publicacions> publicaciones = new ArrayList<>();
        for (Document doc : collection.find(new Document("data_hora", new Document("$gte", desde).append("$lte", hasta)))){
            Publicacions p = fromDocument(doc);
            Document doc_user = collectionUsuaris.find(new Document("_id", p.getUsuari_id())).first();
            Usuaris u = new UsuarisDAO().fromDocument(doc_user);
            p.setUsuari(u);
            publicaciones.add(p);
        }
        return publicaciones;

    }


    // Metodo para convertir el objecto que llega del MongoDB (llega como Document) a un objecto java de tipo Publicacions
    private Publicacions fromDocument(Document doc) {

        return new Publicacions(
                doc.getString("_id"),
                doc.getString("text"),
                doc.getList("hastags", String.class),
                doc.getList("mencions", String.class),
                doc.getList("paraules_clau", String.class),
                doc.getString("data_hora"),
                doc.getInteger("likes", 0),
                doc.getInteger("retuits", 0),
                doc.getString("ubicacio"),
                doc.getString("sentiment"),
                doc.getString("usuari_id")
        );
    }
}
