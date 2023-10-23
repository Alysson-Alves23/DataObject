package DataObject.database.table;

import DataObject.database.column.Column;
import DataObject.database.session.DataBase;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ViewTable<T> extends Table<T> {

    List<Column> columns;

    public ViewTable() {
        super();
        this.columns = new ArrayList<>();

    }


    public void create() {
        for (Field column : this.getClass().getDeclaredFields()) {
            if (!Modifier.isStatic(column.getModifiers()) && !column.isSynthetic()) {
                columns.add(new Column(column.getName(),column.getAnnotation(DataObject.database.notations.Column.class).type()));
            }
        }
    }

    @Override
    public void drop() {

    }

    @Override
    public T findOne(String column, String value) {
        return null;
    }

    @Override
    public List<T> findAll(Map where) {
        return null;
    }

}
