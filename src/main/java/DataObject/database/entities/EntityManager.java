package DataObject.database.entities;

import DataObject.database.entities.Entity;
import DataObject.database.session.ConnectionFactory;
import java.lang.reflect.*;
public class EntityManager {


    static Long entities= Entity.entitieCount;
    ConnectionFactory cf = null;
    EntityManager(ConnectionFactory cf){
        this.cf = cf;
    }

    void load(){

    };

}
