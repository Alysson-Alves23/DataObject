package DataObject.database;

import DataObject.database.column.Column;
import DataObject.database.datatype.Type;

public class Main {
    public static void main(String[] args){
        Column coluna = new Column("id", new Type(),true,true,true,false,false,true);

        System.out.println(coluna.getName());

    }
}


