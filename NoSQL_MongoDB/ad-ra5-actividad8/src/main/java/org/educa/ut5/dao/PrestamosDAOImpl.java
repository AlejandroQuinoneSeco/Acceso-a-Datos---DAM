package org.educa.ut5.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.*;
import org.bson.Document;
import org.educa.ut5.adapter.LocalDateAdapter;
import org.educa.ut5.entity.PrestamoEntity;
import org.educa.ut5.settings.DatabaseSettings;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PrestamosDAOImpl implements PrestamosDAO {

    public static final String PRESTAMOS = "prestamos";

    private final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();

    @Override
    public List<PrestamoEntity> findAll() {
        List<PrestamoEntity> prestamos = new ArrayList<>();
        try(MongoClient mongoClient = MongoClients.create(DatabaseSettings.getURL())){
            MongoDatabase mongoDatabase = mongoClient.getDatabase(DatabaseSettings.getDB());
            MongoCollection<Document> mongoCollection =
                    mongoDatabase.getCollection(PRESTAMOS);
            FindIterable<Document> documents = mongoCollection.find();
            for(Document doc : documents){
                PrestamoEntity prestamo = gson.fromJson(doc.toJson(), PrestamoEntity.class);
                prestamos.add(prestamo);
            }

        }
        return prestamos;
    }
}
