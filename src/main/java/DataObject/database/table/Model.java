package DataObject.database.table;
import DataObject.database.notations.Column;
import DataObject.database.session.DataBase;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.SQLException;

public abstract class Model{

    static DataBase _dataBase;
    public void create(DataBase dataBase){
        dataBase.createConnection();

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
            dataBase.getConnection().createStatement().execute(sql.toString());
            dataBase.closeConnection();
        } catch (SQLException err) {
            System.out.println(sql);
            System.out.println(err);
        }finally {
            dataBase.closeConnection();
        }
    }

    static public void create(){
        DataBase dataBase = _dataBase;
        dataBase.createConnection();
        Class clasRef = Thread.currentThread().getClass();
        Field _primaryKey = null;
        try {
            StringBuilder sql = new StringBuilder("CREATE TABLE " +clasRef.getName() + "(");

            for (Field column: clasRef.getClass().getDeclaredFields()) {
                Column notation = column.getAnnotation(Column.class);
                Integer size = notation.size();

                sql.append("`" + (notation.name().equals("") ? column.getName() : notation.name() )+ "`" + notation.type().name());
                if(notation.size() < 0)
                    sql.append("("+notation.size()+")");
                sql.append(",");
                if(column.getAnnotation(Column.class).primaryKey()){

                }
            }
            if(_primaryKey != null){
                sql.append("PRIMARY KEY(`").append(_primaryKey.getName()).append("`)");
            }
            sql.append(");");
            dataBase.getConnection().createStatement().execute(sql.toString());
            dataBase.closeConnection();
        } catch (SQLException err) {
            System.out.println(err);
        }finally {
            dataBase.closeConnection();
        }
    };
    public void drop(){

    };



}
