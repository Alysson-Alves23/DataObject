package DataObject.database;

import DataObject.database.datatype.Type;
import DataObject.database.notations.Column;
import DataObject.database.notations.Entity;
import DataObject.database.notations.relationship.ManyToMany;

import java.util.List;

@Entity(type = "Table")
public class User {
    @Column(type= Type.BIGINT,primaryKey = true,notNull = true)
    Long id;
    @Column(type = Type.VARCHAR,notNull = true,size = 21)
    String name;
    @Column(type = Type.VARCHAR,size = 20)
    String email;
    @ManyToMany(ref = "Personagem")
    @Column(type = Type.BIGINT, foreignKey = true)
    List<Personagem> personagens;

    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}