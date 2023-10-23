package DataObject.database.warnings;

public class SQLException extends SQLWarning{

    SQLException(){
        super();
    }
    SQLException(String message){
        super(message);
    }
}
