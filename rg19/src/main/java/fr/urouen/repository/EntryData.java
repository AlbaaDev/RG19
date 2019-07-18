package fr.urouen.repository;

import fr.urouen.exceptions.XMLEntryNotFoundException;
import fr.urouen.models.Entry;

import java.util.LinkedList;
import java.util.List;

public class EntryData {
    private int id;
    private final String _id;
    private String _rev;
    private List<Entry> entries;

    public EntryData() {
        entries = new LinkedList<>();
        _id = null;
    }

    /**
     *
     * @return List<Entry>
     */
    List<Entry> getEntries() {
        return new LinkedList<>(entries);
    }

    /**
     *
     * @param id
     * @return Entry
     * @throws XMLEntryNotFoundException
     */
    Entry getEntryById(final int id) throws XMLEntryNotFoundException {
        return entries.stream()
                .filter(feed -> feed.getNum() == id)
                .findFirst()
                .orElseThrow(() -> new XMLEntryNotFoundException("l'article avec id " + id + " n'existe pas"));
    }

    /**
     *
     * @param term
     * @return List<Entry>
     */
    List<Entry> findByTerm(String term) {
        List<Entry> result = new LinkedList<>();
        for (Entry entry : entries) {
            if (
                    entry.getCategories()
                    .stream()
                            .anyMatch(
                                    cat ->
                                            cat.toLowerCase().equals(term.toLowerCase())
                            )
            )
                result.add(entry);
        }
        return result;
    }

    /**
     *
     * @param entry Entry
     */
    void addEntry(Entry entry) {
        entry.setNum(id++);
        entries.add(entry);
    }

    /**
     *
     * @param id int
     * @throws XMLEntryNotFoundException
     */
    void deleteEntryById(final int id) throws XMLEntryNotFoundException {
        Entry entry = getEntryById(id);
        entries.remove(entry);
    }

    /**
     *
     * @param entry Entry
     * @throws XMLEntryNotFoundException
     */
    void updateEntry(Entry entry) throws XMLEntryNotFoundException {
        deleteEntryById(entry.getNum());
        entries.add(entry);
    }

    /**
     *
     * @param rev String
     */
    void setRev(String rev) {
        this._rev = rev;
    }
}
