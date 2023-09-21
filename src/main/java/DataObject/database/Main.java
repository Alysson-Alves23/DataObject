package DataObject.database;
import DataObject.database.datatype.Type;
import DataObject.database.session.DataBase;
import DataObject.database.table.Model;
import DataObject.database.notations.Column;

public class Main {
    public static void main(String[] args) {
        DataBase db = new DataBase("root", "", "jdbc:mysql://localhost:3306/dataobject");

        new User().create(db);

    }
}
class User extends Model {
    @Column(type= Type.BIGINT,primaryKey = true,notNull = true)
    Long id;
    @Column(type = Type.VARCHAR,primaryKey = true,notNull = true,size = 21)
    String name;
    @Column(type = Type.VARCHAR,primaryKey = true,size = 20)
    String email;
}