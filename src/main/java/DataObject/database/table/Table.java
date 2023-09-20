package DataObject.database.table;

import DataObject.database.column.Column;
import DataObject.database.session.DataBase;
import com.google.protobuf.Value;

import java.sql.SQLException;


public class Table {
    Long _id;
    private String _name;
    private  Column[] _columns;
    private Column _primaryKey;

    public Table( String _name, Column[] _columns, Column _primaryKey) {
        this._name = _name;
        this._columns = _columns;
        this._primaryKey = _primaryKey;
    }

    public void createTable(DataBase dataBase){
        dataBase.createConnection();
        try {
            String sql = "CREATE TABLE "+_name+"(";

            for (Column column : _columns) {
                    sql+="`"+column.getName()+"`"+column.getType()+",";
            }
            if(_primaryKey != null){
                sql+="PRIMARY KEY(`"+_primaryKey.getName()+"`)";
            }
            sql+=");";
            dataBase.getConnection().createStatement().execute(sql);
            dataBase.closeConnection();
        } catch (SQLException err) {
            System.out.println(err);
        }finally {
            dataBase.closeConnection();
        }
    }
    void  drop(){

    }
    int find(String column, String value){
            int result = 0;
        return  result;
    }


}
