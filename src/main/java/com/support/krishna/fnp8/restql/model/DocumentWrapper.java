package com.support.krishna.fnp8.restql.model;

public class DocumentWrapper {
    private String id;
    private String name;
    private String className;
    private String createdBy;
    private String creationDate;
    private String mimeType;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }

    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }

    public String getCreationDate() { return creationDate; }
    public void setCreationDate(String creationDate) { this.creationDate = creationDate; }

    public String getMimeType() { return mimeType; }
    public void setMimeType(String mimeType) { this.mimeType = mimeType; }
}
