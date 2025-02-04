import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class Connection {
    private static final String URL = "mongodb+srv://oriolcarulla:6177@tasques.vpyz0.mongodb.net/?retryWrites=true&w=majority&appName=Activitat3";
    private static MongoClient mongoClient;
    private static MongoDatabase database;

    // Constructor que inicializa la conexión
    public Connection(String databaseName) {
        if (mongoClient == null) {
            mongoClient = MongoClients.create(URL);
        }
        database = mongoClient.getDatabase(databaseName);
    }

    public MongoDatabase getDatabase() {
        return database;
    }
}
