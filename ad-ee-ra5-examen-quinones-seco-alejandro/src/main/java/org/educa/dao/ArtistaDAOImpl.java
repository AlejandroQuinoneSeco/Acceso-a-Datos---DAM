package org.educa.dao;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.educa.entity.Artista;
import org.educa.entity.Generos;
import org.educa.settings.DatabaseSettings;

public class ArtistaDAOImpl implements ArtistaDAO{

    private final static String COLECCION = "artistas";
    @Override
    public Artista findArtistaById(Integer artistaId) {
        try (MongoClient mongoClient = MongoClients.create(DatabaseSettings.getURL())) {
            MongoDatabase db = mongoClient.getDatabase(DatabaseSettings.getDB());
            MongoCollection<Document> col = db.getCollection(COLECCION);

            Document doc = col.find(Filters.eq("_id", artistaId)).first();
            if (doc != null) {
                return new Artista(
                        doc.getInteger("_id"),
                        doc.getString("name"),
                        doc.getString("country")
                );
            }
            return null;
        }
    }
}
