package DataObject.database;
import DataObject.database.datatype.Type;
import DataObject.database.session.DataBase;
import DataObject.database.notations.Column;
import DataObject.database.table.Table;
import DataObject.database.table.ViewTable;
import DataObject.database.Schema;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Main{

    public static void main(String[] args) {
        DataBase db = new DataBase("root", "", "");
        db.createConnection();
        Schema s = new Schema();
        try {
            s.createSchemaInDatabase("SchemaTest", db);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(s.getSchemaName());
        db.closeConnection();
    }
}

class User {
    @Column(type= Type.BIGINT,primaryKey = true,notNull = true)
    Long id;
    @Column(type = Type.VARCHAR,notNull = true,size = 21)
    String name;
    @Column(type = Type.VARCHAR,size = 20)
    String email;
}
class Personagem extends ViewTable {
    @Column(type = Type.BIGINT,primaryKey = true,notNull = true)
    Long id;
    @Column(type = Type.VARCHAR, notNull = true)
    String name;
}
