package DataObject.database.entities;
import DataObject.database.datatype.Type;
import DataObject.database.notations.Column;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.Connection;

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
        void createTable(Class<?> c){
            Field _primaryKey = null;
            StringBuilder sql = null;
            try {
                String className = c.getSimpleName();

                sql = new StringBuilder("CREATE TABLE " +className + "(");

                for (Field column: c.getDeclaredFields()) {
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
                        if(column.getAnnotation(Column.class).primaryKey()){
                            _primaryKey = column;
                        }
                    }
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
