package net.paksoy.models;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;

/**
 * TODO
 */
public class PDatastore {
    private static Datastore INSTANCE = DatastoreOptions.getDefaultInstance().getService();

    public static Datastore get() {
        return INSTANCE;
    }
}
