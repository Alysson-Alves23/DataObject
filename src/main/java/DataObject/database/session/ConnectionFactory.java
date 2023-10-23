package DataObject.database.session;

import java.sql.Connection;

public interface ConnectionFactory {

    void createConnection();
    void closeConnection();
    Connection getConnection();


}
