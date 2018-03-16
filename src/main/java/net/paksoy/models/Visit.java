package net.paksoy.models;

import com.google.cloud.Timestamp;
import com.google.cloud.datastore.*;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * TODO
 */
public class Visit {
    public static final String KIND = "Visit";
    private static final String TIME = "TIME";

    public Long id;
    public Timestamp created;

    public List<Visit> all() {
        Datastore d = PDatastore.get();
        Query<Entity> query = Query.newEntityQueryBuilder().setKind(KIND).build();
        QueryResults<Entity> results = d.run(query);
        List<Visit> ret = Lists.newArrayList();
        while (results.hasNext()) {
            ret.add(Visit.fromEntity(results.next()));
        }
        return ret;
    }

    public static Visit fromEntity(Entity e) {
        Visit ret = new Visit();
        if (e.hasKey() && e.getKey().hasId()) {
            ret.id = e.getKey().getId();
        }
        ret.created = e.getTimestamp(TIME);
        return ret;
    }

    public static Visit make() {
        Visit ret = new Visit();
        ret.created = Timestamp.now();
        return ret;
    }

    public FullEntity toEntity() {
        return Entity
               .newBuilder(makeKey())
               .set(TIME, this.created)
               .build();
    }

    public IncompleteKey makeKey() {
        KeyFactory kf = PDatastore.get().newKeyFactory().setKind(KIND);
        if (this.id != null) {
            return kf.newKey(this.id);
        }
        return kf.newKey();
    }

    public Long save() {
        Datastore d = PDatastore.get();
        Entity e = d.put(this.toEntity());
        return e.getKey().getId();
    }
}
