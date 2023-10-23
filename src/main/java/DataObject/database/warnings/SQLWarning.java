package DataObject.database.warnings;

public class SQLWarning extends Exception{

    SQLWarning(){
        super();
    }

    SQLWarning(String message){
        super(message);
    }

}
