package org.zetta1985.addressbook.domain;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2011-05-18 01:56:47")
/** */
public final class ClaimedContactNameMeta extends org.slim3.datastore.ModelMeta<org.zetta1985.addressbook.domain.ClaimedContactName> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<org.zetta1985.addressbook.domain.ClaimedContactName> contactName = new org.slim3.datastore.StringAttributeMeta<org.zetta1985.addressbook.domain.ClaimedContactName>(this, "contactName", "contactName");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<org.zetta1985.addressbook.domain.ClaimedContactName, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<org.zetta1985.addressbook.domain.ClaimedContactName, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    private static final ClaimedContactNameMeta slim3_singleton = new ClaimedContactNameMeta();

    /**
     * @return the singleton
     */
    public static ClaimedContactNameMeta get() {
       return slim3_singleton;
    }

    /** */
    public ClaimedContactNameMeta() {
        super("ClaimedContactName", org.zetta1985.addressbook.domain.ClaimedContactName.class);
    }

    @Override
    public org.zetta1985.addressbook.domain.ClaimedContactName entityToModel(com.google.appengine.api.datastore.Entity entity) {
        org.zetta1985.addressbook.domain.ClaimedContactName model = new org.zetta1985.addressbook.domain.ClaimedContactName();
        model.setContactName((java.lang.String) entity.getProperty("contactName"));
        model.setKey(entity.getKey());
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        org.zetta1985.addressbook.domain.ClaimedContactName m = (org.zetta1985.addressbook.domain.ClaimedContactName) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("contactName", m.getContactName());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        org.zetta1985.addressbook.domain.ClaimedContactName m = (org.zetta1985.addressbook.domain.ClaimedContactName) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        org.zetta1985.addressbook.domain.ClaimedContactName m = (org.zetta1985.addressbook.domain.ClaimedContactName) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        throw new IllegalStateException("The version property of the model(org.zetta1985.addressbook.domain.ClaimedContactName) is not defined.");
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
    }

    @Override
    protected void prePut(Object model) {
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

    @Override
    protected boolean isCipherProperty(String propertyName) {
        return false;
    }

    @Override
    protected void modelToJson(org.slim3.datastore.json.JsonWriter writer, java.lang.Object model, int maxDepth, int currentDepth) {
        org.zetta1985.addressbook.domain.ClaimedContactName m = (org.zetta1985.addressbook.domain.ClaimedContactName) model;
        writer.beginObject();
        org.slim3.datastore.json.JsonCoder encoder = null;
        if(m.getContactName() != null){
            writer.setNextPropertyName("contactName");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getContactName());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getKey());
        }
        writer.endObject();
    }

    @Override
    public org.zetta1985.addressbook.domain.ClaimedContactName jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        org.zetta1985.addressbook.domain.ClaimedContactName m = new org.zetta1985.addressbook.domain.ClaimedContactName();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.JsonCoder decoder = null;
        reader = rootReader.newObjectReader("contactName");
        decoder = new org.slim3.datastore.json.Default();
        m.setContactName(decoder.decode(reader, m.getContactName()));
        reader = rootReader.newObjectReader("key");
        decoder = new org.slim3.datastore.json.Default();
        m.setKey(decoder.decode(reader, m.getKey()));
    return m;
}
}