package DAO;

import com.mongodb.client.MongoCollection;
import models.Usuaris;
import org.bson.Document;

public class UsuarisDAO {
    private MongoCollection<Document> collection;

    public UsuarisDAO() {
    }


    Usuaris fromDocument(Document doc) {
        return new Usuaris(
            doc.getString("nom_usuari"),
            doc.getInteger("seguidors"),
            doc.getBoolean("verificat")
        );
    }
}
