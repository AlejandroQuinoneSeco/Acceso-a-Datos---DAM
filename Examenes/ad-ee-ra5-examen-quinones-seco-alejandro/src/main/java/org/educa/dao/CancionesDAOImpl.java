package org.educa.dao;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.educa.entity.Canciones;
import org.educa.settings.DatabaseSettings;

import java.util.ArrayList;
import java.util.List;

public class CancionesDAOImpl implements CancionesDAO{

    private static final String COLECCION = "canciones";

    @Override
    public List<Canciones> findAvailable() {
        try (MongoClient mongoClient = MongoClients.create(DatabaseSettings.getURL())) {
            MongoDatabase db = mongoClient.getDatabase(DatabaseSettings.getDB());
            MongoCollection<Document> col = db.getCollection(COLECCION);


            List<Canciones> canciones = new ArrayList<>();
            FindIterable<Document> iterable = col.find(Filters.eq("available", true));

            for (Document doc : iterable) {
                canciones.add(new Canciones(
                        doc.getInteger("_id"),
                        doc.getString("title"),
                        doc.getInteger("artist_id"),
                        doc.getList("genres_ids", Integer.class)
                ));
            }
            return canciones;
        }
    }


    @Override
    public List<Canciones> findAvailableByGenero(String genero) {
        try (MongoClient mongoClient = MongoClients.create(DatabaseSettings.getURL())) {
            MongoDatabase db = mongoClient.getDatabase(DatabaseSettings.getDB());
            MongoCollection<Document> col = db.getCollection(COLECCION);

            List<Canciones> canciones = new ArrayList<>();
            FindIterable<Document> iterable = col.find(Filters.and(
                    Filters.eq("available", true),
                    Filters.eq("genres_ids", genero)

            ));

            for (Document doc : iterable) {
                canciones.add(new Canciones(
                        doc.getInteger("_id"),
                        doc.getString("title"),
                        doc.getInteger("artist_id"),
                        doc.getList("genres_ids", Integer.class)
                ));
            }
            return canciones;
        }
    }


    @Override
    public Long removeCancion(String titulo, Integer artistaId) {
        try (MongoClient mongoClient = MongoClients.create(DatabaseSettings.getURL())) {
            MongoDatabase db = mongoClient.getDatabase(DatabaseSettings.getDB());
            MongoCollection<Document> col = db.getCollection(COLECCION);

            DeleteResult deleteResult = col.deleteOne(Filters.and(
                    Filters.eq("title", titulo),
                    Filters.eq("artist_id", artistaId)));

            return deleteResult.getDeletedCount();
        }
    }
}
