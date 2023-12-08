package DataObject.database.entities.table;


import DataObject.database.entities.EntityManager;
import DataObject.database.notations.Column;
import DataObject.database.notations.Entity;
import DataObject.database.notations.relationship.ManyToMany;
import DataObject.database.utils.RelationalMap;
import DataObject.database.warnings.InvalidReferenceException;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Table<T> extends AbstractTable<T>{

    List<T> cache;
    public void insert(Connection connection, Object object) throws InvalidReferenceException {

        Class<?> clazz = object.getClass();
        String tableName = clazz.getSimpleName(); // Use the class name as the table name

        StringBuilder columns = new StringBuilder();
        StringBuilder values = new StringBuilder();
        boolean firstColumn = true;

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Column.class)) {

                String columnName = field.getAnnotation(Column.class).name();
                if (columnName.isEmpty()) {
                    columnName = field.getName();
                }

                if (!firstColumn) {
                    columns.append(", ");
                    values.append(", ");
                }

                columns.append(columnName);
                values.append("?");
                firstColumn = false;
            }
        }

        String sql = "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + values + ")";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            int parameterIndex = 1;

            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Column.class)) {
                    field.setAccessible(true);
                    Object value = field.get(object);
                    statement.setObject(parameterIndex, value);
                    parameterIndex++;
                }
            }

            statement.executeUpdate();
        } catch (IllegalAccessException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(T element) {

    }

    @Override
    public void update(T element) {

    }

    public List<T> select(){return null;}

    public void update(){

    }
    public void drop(){

    }

    @Override
    public T select(String field, Long value) {

        return null;
    }

    @Override
    public T select(String field, String value) {

        return null;
    }

    @Override
    public T select(String field, Double value) {

        return null;
    }


    public void delete(String where){}



}