package org.zetta1985.addressbook.query;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2011-05-18 01:56:47")
/** */
public final class AddressEntryMeta extends org.slim3.datastore.ModelMeta<org.zetta1985.addressbook.query.AddressEntry> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<org.zetta1985.addressbook.query.AddressEntry, org.zetta1985.addressbook.api.AddressType> addressType = new org.slim3.datastore.CoreAttributeMeta<org.zetta1985.addressbook.query.AddressEntry, org.zetta1985.addressbook.api.AddressType>(this, "addressType", "addressType", org.zetta1985.addressbook.api.AddressType.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<org.zetta1985.addressbook.query.AddressEntry> city = new org.slim3.datastore.StringAttributeMeta<org.zetta1985.addressbook.query.AddressEntry>(this, "city", "city");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<org.zetta1985.addressbook.query.AddressEntry> identifier = new org.slim3.datastore.StringAttributeMeta<org.zetta1985.addressbook.query.AddressEntry>(this, "identifier", "identifier");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<org.zetta1985.addressbook.query.AddressEntry, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<org.zetta1985.addressbook.query.AddressEntry, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<org.zetta1985.addressbook.query.AddressEntry> name = new org.slim3.datastore.StringAttributeMeta<org.zetta1985.addressbook.query.AddressEntry>(this, "name", "name");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<org.zetta1985.addressbook.query.AddressEntry> streetAndNumber = new org.slim3.datastore.StringAttributeMeta<org.zetta1985.addressbook.query.AddressEntry>(this, "streetAndNumber", "streetAndNumber");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<org.zetta1985.addressbook.query.AddressEntry> zipCode = new org.slim3.datastore.StringAttributeMeta<org.zetta1985.addressbook.query.AddressEntry>(this, "zipCode", "zipCode");

    private static final AddressEntryMeta slim3_singleton = new AddressEntryMeta();

    /**
     * @return the singleton
     */
    public static AddressEntryMeta get() {
       return slim3_singleton;
    }

    /** */
    public AddressEntryMeta() {
        super("AddressEntry", org.zetta1985.addressbook.query.AddressEntry.class);
    }

    @Override
    public org.zetta1985.addressbook.query.AddressEntry entityToModel(com.google.appengine.api.datastore.Entity entity) {
        org.zetta1985.addressbook.query.AddressEntry model = new org.zetta1985.addressbook.query.AddressEntry();
        model.setAddressType(stringToEnum(org.zetta1985.addressbook.api.AddressType.class, (java.lang.String) entity.getProperty("addressType")));
        model.setCity((java.lang.String) entity.getProperty("city"));
        model.setIdentifier((java.lang.String) entity.getProperty("identifier"));
        model.setKey(entity.getKey());
        model.setName((java.lang.String) entity.getProperty("name"));
        model.setStreetAndNumber((java.lang.String) entity.getProperty("streetAndNumber"));
        model.setZipCode((java.lang.String) entity.getProperty("zipCode"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        org.zetta1985.addressbook.query.AddressEntry m = (org.zetta1985.addressbook.query.AddressEntry) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("addressType", enumToString(m.getAddressType()));
        entity.setProperty("city", m.getCity());
        entity.setProperty("identifier", m.getIdentifier());
        entity.setProperty("name", m.getName());
        entity.setProperty("streetAndNumber", m.getStreetAndNumber());
        entity.setProperty("zipCode", m.getZipCode());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        org.zetta1985.addressbook.query.AddressEntry m = (org.zetta1985.addressbook.query.AddressEntry) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        org.zetta1985.addressbook.query.AddressEntry m = (org.zetta1985.addressbook.query.AddressEntry) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        throw new IllegalStateException("The version property of the model(org.zetta1985.addressbook.query.AddressEntry) is not defined.");
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
        org.zetta1985.addressbook.query.AddressEntry m = (org.zetta1985.addressbook.query.AddressEntry) model;
        writer.beginObject();
        org.slim3.datastore.json.JsonCoder encoder = null;
        if(m.getAddressType() != null){
            writer.setNextPropertyName("addressType");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getAddressType());
        }
        if(m.getCity() != null){
            writer.setNextPropertyName("city");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getCity());
        }
        if(m.getIdentifier() != null){
            writer.setNextPropertyName("identifier");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getIdentifier());
        }
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
        if(m.getStreetAndNumber() != null){
            writer.setNextPropertyName("streetAndNumber");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getStreetAndNumber());
        }
        if(m.getZipCode() != null){
            writer.setNextPropertyName("zipCode");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getZipCode());
        }
        writer.endObject();
    }

    @Override
    public org.zetta1985.addressbook.query.AddressEntry jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        org.zetta1985.addressbook.query.AddressEntry m = new org.zetta1985.addressbook.query.AddressEntry();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.JsonCoder decoder = null;
        reader = rootReader.newObjectReader("addressType");
        decoder = new org.slim3.datastore.json.Default();
        m.setAddressType(decoder.decode(reader, m.getAddressType(), org.zetta1985.addressbook.api.AddressType.class));
        reader = rootReader.newObjectReader("city");
        decoder = new org.slim3.datastore.json.Default();
        m.setCity(decoder.decode(reader, m.getCity()));
        reader = rootReader.newObjectReader("identifier");
        decoder = new org.slim3.datastore.json.Default();
        m.setIdentifier(decoder.decode(reader, m.getIdentifier()));
        reader = rootReader.newObjectReader("key");
        decoder = new org.slim3.datastore.json.Default();
        m.setKey(decoder.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("name");
        decoder = new org.slim3.datastore.json.Default();
        m.setName(decoder.decode(reader, m.getName()));
        reader = rootReader.newObjectReader("streetAndNumber");
        decoder = new org.slim3.datastore.json.Default();
        m.setStreetAndNumber(decoder.decode(reader, m.getStreetAndNumber()));
        reader = rootReader.newObjectReader("zipCode");
        decoder = new org.slim3.datastore.json.Default();
        m.setZipCode(decoder.decode(reader, m.getZipCode()));
    return m;
}
}