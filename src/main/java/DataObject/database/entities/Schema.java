package DataObject.database.entities;
import DataObject.database.datatype.Type;
import DataObject.database.notations.Column;
import DataObject.database.notations.relationship.ManyToMany;
import DataObject.database.utils.RelationalMap;
import DataObject.database.warnings.InvalidReferenceException;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Schema extends AbstractEntity {

        String name;
        Connection con;
        public Schema(){
            super();
            this.con = AbstractEntity.con;
        }
        public Schema(Connection con){
            super();
            this.con = con;
        };
        void createTable(Class<?> c) throws  InvalidReferenceException{
            Field _primaryKey = null;
            StringBuilder sql = null;
            try {
                String className = c.getSimpleName();

                sql = new StringBuilder("CREATE TABLE " +className + "(");

                for (Field column: c.getDeclaredFields()) {
                    if(column.isAnnotationPresent(Column.class)){
                    if(column.getAnnotation(Column.class).primaryKey()){
                        _primaryKey = column;
                    }
                    if(column.isAnnotationPresent(ManyToMany.class)){
                        List<Class<?>> entities  = EntityManager.getEntities();
                        String refName =  column.getAnnotation(ManyToMany.class).ref();
                        Class<?> ref = RelationalMap.findRef(entities,refName);
                        String fk=null;
                        for(Field field: ref.getDeclaredFields()){
                            if(field.getAnnotation(Column.class).primaryKey()){
                                fk = field.getName();
                            }
                        }
                        try {
                            if(_primaryKey != null){
                                String createTableQuery = "CREATE TABLE " + className + "_" + refName + " (\n" +
                                        "    id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                                        "    " + className + "_id BIGINT,\n" +
                                        "    " + refName + "_id BIGINT,\n" +
                                        "    FOREIGN KEY (" + className + "_id) REFERENCES " + className + "(" + _primaryKey.getName() + "),\n" +
                                        "    FOREIGN KEY (" + refName + "_id) REFERENCES " + refName + "(" + fk + ")\n" +
                                        ");";

                                System.out.println(createTableQuery);
                                con.prepareStatement(createTableQuery).execute();

                            }
                            else
                            {
                                throw  new InvalidReferenceException(refName);

                            }
                        }catch (SQLException e){
                            System.out.println(e.getMessage());
                        }

                    }
                    if (!Modifier.isStatic(column.getModifiers()) && !column.isSynthetic()) {
                        System.out.println(column.getName());
                    }
                    Column notation = column.getAnnotation(Column.class);
                    if(notation != null){

                        Integer size = notation.size();

                        sql.append("`" + (notation.name().equals("") ? column.getName() : notation.name() )+ "`" + notation.type().name());
                        if(notation.type().equals(Type.VARCHAR))
                            sql.append("("+notation.size()+")");
                        sql.append(",");

                    }}
                }
                if(_primaryKey != null){
                    sql.append("PRIMARY KEY(`").append(_primaryKey.getName()).append("`)");
                }
                sql.append(");");
                this.con.createStatement().execute(sql.toString());

            } catch (java.sql.SQLException err) {
                System.out.println(sql);
                System.out.println(err);
            }finally {

            }
        }
        void dropTable(String name){
            String sql = "drop table";
        }

}
