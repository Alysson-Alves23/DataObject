package DataObject.database.warnings;

public class SQLError extends SQLWarning{

    SQLError(){
        super();
    }

    SQLError(String message){
        super(message);
    }
}
