package org.educa.dao;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.educa.entity.Generos;
import org.educa.settings.DatabaseSettings;

public class GenerosDAOImpl implements GenerosDAO{

    private final static String COLECCION = "generos";
    @Override
    public Generos findGeneroById(Integer generoId) {
        try (MongoClient mongoClient = MongoClients.create(DatabaseSettings.getURL())) {
            MongoDatabase db = mongoClient.getDatabase(DatabaseSettings.getDB());
            MongoCollection<Document> col = db.getCollection(COLECCION);

            Document doc = col.find(Filters.eq("_id", generoId)).first();
            if (doc != null) {
                return new Generos(
                        doc.getInteger("_id"),
                        doc.getString("name")
                );
            }
            return null;
        }
    }

    @Override
    public Generos findGeneroByName(String nombre) {
        try (MongoClient mongoClient = MongoClients.create(DatabaseSettings.getURL())) {
            MongoDatabase db = mongoClient.getDatabase(DatabaseSettings.getDB());
            MongoCollection<Document> col = db.getCollection(COLECCION);

            Document doc = col.find(Filters.eq("name", nombre)).first();
            if (doc != null) {
                return new Generos(
                        doc.getInteger("_id"),
                        doc.getString("name")
                );
            }
            return null;
        }
    }
}
