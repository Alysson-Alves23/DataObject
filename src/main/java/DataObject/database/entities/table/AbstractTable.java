package DataObject.database.entities.table;

import java.util.List;
import java.util.Map;


public abstract class AbstractTable<T> {
    private String tableName;
    private List<T> element;

    public abstract void insert(T element);
    public abstract void update(T element);
    public abstract void drop();
    public abstract T select(String field ,Long value);
    public abstract T select(String field ,String value);
    public abstract T select(String field,Double value);

    public abstract void delete(String where);

}