package fr.urouen.repository;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.Response;
import fr.urouen.exceptions.XMLEntryNotFoundException;
import fr.urouen.models.Entry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DatabaseManager {
    private static EntryData entryData;
    @Value("${db.account}")
    private String accountId = null;
    @Value("${db.username}")
    private String username = null;
    @Value("${db.password}")
    private String password = null;
    @Value("${db.name}")
    private String dataBaseName = null;
    @Value("${db.create.new:false}")
    private boolean isNewDocument;
    private Database db;

    @Value("${db.document.id}")
    private String documentId ;
    private Database getDb(){
        if (db == null){
            CloudantClient client = ClientBuilder.account(accountId)
                    .username(username)
                    .password(password)
                    .build();
            db = client.database(dataBaseName, isNewDocument);
        }
        return db;
    }
    private EntryData getData(boolean reload){
        if (entryData == null || reload){
            entryData = getDb().find(EntryData.class,documentId);
        }
        return entryData;
    }
    private EntryData getData(){
        return getData(false);
    }
    public List<Entry> getEntries(){
        return getData().getEntries();
    }
    public Entry getEntryById(int id) throws XMLEntryNotFoundException {
        return getData().getEntryById(id);
    }
    public void addEntry(Entry entry){
        getData(true).addEntry(entry);
        Response rs = getDb().update(getData());
        getData().setRev(rs.getRev());
    }
    public void updateEntry(Entry entry) throws XMLEntryNotFoundException {
        getData(true).updateEntry(entry);
        Response rs = getDb().update(getData());
        getData().setRev(rs.getRev());
    }
    public void deleteEntry(int id) throws XMLEntryNotFoundException {
        getData(true).deleteEntryById(id);
        Response rs = getDb().update(getData());
        getData().setRev(rs.getRev());
    }
    public List<Entry> findByTerm(String term){
        return getData().findByTerm(term);
    }
}
