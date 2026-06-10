package org.educa.ut5.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.educa.ut5.entity.PrestamoEntity;
import org.educa.ut5.settings.DatabaseSettings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Aggregates.*;

public class PrestamoDAOImpl implements PrestamoDAO {

    public static final String COLECCION = "prestamos";
    private final Gson gson = new GsonBuilder().create();

    @Override
    public PrestamoEntity findById(int id) {
        try(MongoClient mongoClient = MongoClients.create(DatabaseSettings.getURL())){
            MongoDatabase mongoDatabase = mongoClient.getDatabase(DatabaseSettings.getDB());
            MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(COLECCION);
            Bson filter = Filters.eq("_id", id);

            List<Bson> pipeline = Arrays.asList(
                    match(filter),
                    lookup("usuarios", "usuario_id", "_id", "usuario"),
                    unwind("$usuario")
            );

            Document doc = mongoCollection.aggregate(pipeline).first();
            if (doc != null) {
                return gson.fromJson(doc.toJson(), PrestamoEntity.class);
            } else {
                return null;
            }
        }
    }
}
