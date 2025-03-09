package ca.cal.tp2.repository;

import ca.cal.tp2.modele.Document;
import java.util.List;

public interface DocumentRepositoryInterface {
    void saveDocument(Document document);
    List<Document> getAllDocuments();
    void updateDocument(Document document);
    void deleteDocument(int documentID);
    Document getDocumentById(int id);
}
