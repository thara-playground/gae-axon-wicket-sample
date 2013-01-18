package org.zetta1985.addressbook.query;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2011-05-18 01:56:47")
/** */
public final class ContactEntryMeta extends org.slim3.datastore.ModelMeta<org.zetta1985.addressbook.query.ContactEntry> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<org.zetta1985.addressbook.query.ContactEntry, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<org.zetta1985.addressbook.query.ContactEntry, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<org.zetta1985.addressbook.query.ContactEntry> name = new org.slim3.datastore.StringAttributeMeta<org.zetta1985.addressbook.query.ContactEntry>(this, "name", "name");

    private static final ContactEntryMeta slim3_singleton = new ContactEntryMeta();

    /**
     * @return the singleton
     */
    public static ContactEntryMeta get() {
       return slim3_singleton;
    }

    /** */
    public ContactEntryMeta() {
        super("ContactEntry", org.zetta1985.addressbook.query.ContactEntry.class);
    }

    @Override
    public org.zetta1985.addressbook.query.ContactEntry entityToModel(com.google.appengine.api.datastore.Entity entity) {
        org.zetta1985.addressbook.query.ContactEntry model = new org.zetta1985.addressbook.query.ContactEntry();
        model.setKey(entity.getKey());
        model.setName((java.lang.String) entity.getProperty("name"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        org.zetta1985.addressbook.query.ContactEntry m = (org.zetta1985.addressbook.query.ContactEntry) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("name", m.getName());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        org.zetta1985.addressbook.query.ContactEntry m = (org.zetta1985.addressbook.query.ContactEntry) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        org.zetta1985.addressbook.query.ContactEntry m = (org.zetta1985.addressbook.query.ContactEntry) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        throw new IllegalStateException("The version property of the model(org.zetta1985.addressbook.query.ContactEntry) is not defined.");
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
        org.zetta1985.addressbook.query.ContactEntry m = (org.zetta1985.addressbook.query.ContactEntry) model;
        writer.beginObject();
        org.slim3.datastore.json.JsonCoder encoder = null;
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getKey());
        }
        if(m.getName() != null){
            writer.setNextPropertyName("name");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getName());
        }
        writer.endObject();
    }

    @Override
    public org.zetta1985.addressbook.query.ContactEntry jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        org.zetta1985.addressbook.query.ContactEntry m = new org.zetta1985.addressbook.query.ContactEntry();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.JsonCoder decoder = null;
        reader = rootReader.newObjectReader("key");
        decoder = new org.slim3.datastore.json.Default();
        m.setKey(decoder.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("name");
        decoder = new org.slim3.datastore.json.Default();
        m.setName(decoder.decode(reader, m.getName()));
    return m;
}
}