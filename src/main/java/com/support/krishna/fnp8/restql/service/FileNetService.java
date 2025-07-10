package com.support.krishna.fnp8.restql.service;

import com.filenet.api.core.*;
import com.filenet.api.util.UserContext;
import com.filenet.api.collection.DocumentSet;
import com.filenet.api.property.Properties;
import com.support.krishna.fnp8.restql.model.DocumentWrapper;
import org.springframework.stereotype.Service;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileNetService {

    private final String uri = "https://localhost:9080/wsi/FNCEWS40MTOM";
    private final String username = "your-ldap-username";
    private final String password = "your-ldap-password";
    private final String objectStoreName = "SampleOS";

    private Connection getConnection() {
        return Factory.Connection.getConnection(uri);
    }

    private ObjectStore getObjectStore() {
        Subject subject = UserContext.createSubject(getConnection(), username, password, "FileNetP8WSI");
        UserContext.get().pushSubject(subject);
        Domain domain = Factory.Domain.fetchInstance(getConnection(), null, null);
        return Factory.ObjectStore.fetchInstance(domain, objectStoreName, null);
    }

    public DocumentWrapper getDocumentById(String id) {
        ObjectStore store = getObjectStore();
        Document doc = Factory.Document.fetchInstance(store, id, null);
        return mapDocument(doc);
    }

    public List<DocumentWrapper> searchDocuments(String folderPath) {
        ObjectStore store = getObjectStore();
        Folder folder = Factory.Folder.fetchInstance(store, folderPath, null);
        DocumentSet docs = folder.get_ContainedDocuments();

        List<DocumentWrapper> result = new ArrayList<>();
        docs.iterator().forEachRemaining(itr -> {
            Document doc = (Document) itr;
            result.add(mapDocument(doc));
        });
        return result;
    }

    private DocumentWrapper mapDocument(Document doc) {
        Properties props = doc.getProperties();
        DocumentWrapper document = new DocumentWrapper();
        document.setId(doc.get_Id().toString());
        document.setName(props.getStringValue("DocumentTitle"));
        document.setClassName(doc.get_ClassDescription().get_DisplayName());
        document.setCreatedBy(props.getStringValue("Creator"));
        document.setCreationDate(props.getDateTimeValue("DateCreated").toString());
        document.setMimeType(props.getStringValue("MimeType"));
        return document;
    }
}
