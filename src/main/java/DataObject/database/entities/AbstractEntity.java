package DataObject.database.entities;


import java.sql.Connection;

public abstract class AbstractEntity {
    static Connection con;
    public static  Long entitieCount = 0L;
    AbstractEntity(){
        entitieCount++;
    }

}
