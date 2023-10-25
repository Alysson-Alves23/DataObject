package DataObject.database.entities;
import DataObject.database.notations.Column;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.Connection;

public class Schema extends Entity{

        String name;
        Connection con;
        Schema(){
            super();
            this.con = Entity.con;
        }
        Schema(Connection con){
            super();
            this.con = con;
        };
        void createTable(){
            Field _primaryKey = null;
            StringBuilder sql = null;
            try {
                String className = this.getClass().getName().substring(this.getClass().getName().lastIndexOf('.')+1,this.getClass().getName().length());

                sql = new StringBuilder("CREATE TABLE " +className + "(");

                for (Field column: this.getClass().getDeclaredFields()) {
                    if (!Modifier.isStatic(column.getModifiers()) && !column.isSynthetic()) {
                        System.out.println(column.getName());
                    }
                    Column notation = column.getAnnotation(Column.class);
                    if(notation !=null){

                        Integer size = notation.size();

                        sql.append("`" + (notation.name().equals("") ? column.getName() : notation.name() )+ "`" + notation.type().name());
                        if(notation.size() > 0)
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
