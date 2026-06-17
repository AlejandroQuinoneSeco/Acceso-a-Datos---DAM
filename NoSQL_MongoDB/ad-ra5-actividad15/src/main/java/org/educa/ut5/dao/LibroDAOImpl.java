package org.educa.ut5.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.*;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.TextSearchOptions;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.educa.ut5.entity.LibroEntity;
import org.educa.ut5.settings.DatabaseSettings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LibroDAOImpl implements LibroDAO {

    private static final String COLLECTION = "libros";
    private final Gson gson = new GsonBuilder().create();

    @Override
    public List<LibroEntity> findByTitle(String titulo) {
        List<LibroEntity> libros = new ArrayList<>();
        try(MongoClient mongoClient = MongoClients.create(DatabaseSettings.getURL())){
            MongoDatabase mongoDatabase = mongoClient.getDatabase(DatabaseSettings.getDB());
            MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(COLLECTION);
            TextSearchOptions textSearchOptions = new TextSearchOptions().caseSensitive(true);
            List<Bson> pipeline = Arrays.asList(
                    Aggregates.match(Filters.text(titulo, textSearchOptions)),
                    Aggregates.lookup("autores","autor_id","_id","autor"),
                    Aggregates.unwind("$autor")
            );

            AggregateIterable<Document> docs = mongoCollection.aggregate(pipeline);
            for(Document doc: docs){
                LibroEntity libro = gson.fromJson(doc.toJson(), LibroEntity.class);
                libros.add(libro);
            }
        }
        return libros;
    }
}
