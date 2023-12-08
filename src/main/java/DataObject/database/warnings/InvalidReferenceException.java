package DataObject.database.warnings;

import java.sql.SQLException;

public class InvalidReferenceException extends SQLException {

    public InvalidReferenceException(String reference){
        super("Not found valid reference to " + reference);
    }
}
