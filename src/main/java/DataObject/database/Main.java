package DataObject.database;
import DataObject.database.datatype.Type;
import DataObject.database.entities.EntityManager;
import DataObject.database.entities.Schema;
import DataObject.database.entities.table.Table;
import DataObject.database.notations.Entity;
import DataObject.database.notations.relationship.ManyToMany;
import DataObject.database.session.ConnectionFactory;
import DataObject.database.session.DataBase;
import DataObject.database.notations.Column;
import DataObject.database.entities.table.ViewTable;
import DataObject.database.User;
import java.sql.SQLException;
import java.util.List;


public class Main{

    public static void main(String[] args)  {

        try {
            ConnectionFactory db = new DataBase("root", "", "jdbc:mysql://localhost/DataObject");
            db.createConnection();
            Schema sc = new Schema(db.getConnection());
            EntityManager em = new EntityManager(sc, "DataObject.database");
            em.load();

            Table<User> table = new Table();


            table.insert(db.getConnection(), new User(3L, "teste3", "teste3@gmail.com"));
            db.closeConnection();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}

@Entity(type = "Table")
class Personagem {
    @Column(type = Type.BIGINT,primaryKey = true,notNull = true)
    Long id;
    @Column(type = Type.VARCHAR, notNull = true)
    String name;

    @ManyToMany(ref = "User")
    @Column(type = Type.BIGINT)
    List<User> users;
}
