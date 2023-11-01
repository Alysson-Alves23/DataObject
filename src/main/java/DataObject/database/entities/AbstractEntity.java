package DataObject.database.entities;


import java.sql.Connection;

public abstract class Entity {
    static Connection con;
    public static  Long entitieCount = 0L;
    Entity(){
        entitieCount++;
    }

}
