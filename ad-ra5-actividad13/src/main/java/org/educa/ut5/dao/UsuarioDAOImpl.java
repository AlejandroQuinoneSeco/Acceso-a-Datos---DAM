package org.educa.ut5.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.educa.ut5.entity.UsuarioEntity;
import org.educa.ut5.settings.DatabaseSettings;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;

public class UsuarioDAOImpl implements UsuarioDAO {

    public static final String COLECCION = "usuarios";
    private final Gson gson = new GsonBuilder().create();

    @Override
    public Long delete(int id) {
        try(MongoClient mongoClient = MongoClients.create(DatabaseSettings.getURL())){
            MongoDatabase mongoDatabase = mongoClient.getDatabase(DatabaseSettings.getDB());
            MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(COLECCION);
            Bson filter = Filters.eq("_id", id);
            DeleteResult deleteResult = mongoCollection.deleteOne(filter);
            return deleteResult.getDeletedCount();
        }
    }
}
