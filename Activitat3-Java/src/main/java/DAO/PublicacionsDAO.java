package DAO;

import models.Publicacions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

public class PublicacionsDAO {
    private MongoCollection<Document> collection;

    public PublicacionsDAO(MongoDatabase database) {
        this.collection = database.getCollection("Publicacions");

    }

    public List<Publicacions> obtenirTots() {
        List<Publicacions> publicaciones = new ArrayList<>();
        for (Document doc : collection.find()) {
            publicaciones.add(fromDocument(doc));
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
