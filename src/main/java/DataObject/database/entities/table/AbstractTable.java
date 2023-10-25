package DataObject.database.entities.table;

import java.util.List;
import java.util.Map;


public abstract class AbstractTable<T> {
    private  String tableName;
    private List<T> element;

    public abstract void create();
    public abstract void drop();

    public abstract List<T>  findAll(Map<String,String> where);

    public abstract T findOne(String column,String value);

}
