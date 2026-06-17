package org.educa.ut5.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.educa.ut5.entity.AutorEntity;
import org.educa.ut5.settings.DatabaseSettings;

import java.util.ArrayList;
import java.util.List;

public class AutoresDAOImpl implements AutoresDAO {

    public static final String COLECCION = "autores";
    private final Gson gson = new GsonBuilder().create();

    @Override
    public List<AutorEntity> findByNationality(String nacionalidad) {
        List<AutorEntity> autores = new ArrayList<>();
        try(MongoClient mongoClient = MongoClients.create(DatabaseSettings.getURL())){
            MongoDatabase mongoDatabase = mongoClient.getDatabase(DatabaseSettings.getDB());
            MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(COLECCION);
            FindIterable<Document> findIterable = mongoCollection
                    .find(Filters.eq("nacionalidad", nacionalidad));
            for (Document doc : findIterable) {
                AutorEntity autor = gson.fromJson(doc.toJson(), AutorEntity.class);
                autores.add(autor);
            }
        }
        return autores;
    }
}
