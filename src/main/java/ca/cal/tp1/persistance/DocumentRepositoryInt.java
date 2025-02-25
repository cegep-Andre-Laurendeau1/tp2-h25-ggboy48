package ca.cal.tp1.persistance;

import ca.cal.tp1.modele.document.Document;

public interface DocumentRepositoryInt{
    public void save(Document document);
    public Document get(long id);
    public void delete(long id);
    public void update(long id);
}