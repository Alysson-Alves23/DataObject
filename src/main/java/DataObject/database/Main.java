package DataObject.database;

import DataObject.database.column.Column;
import DataObject.database.datatype.Type;
import DataObject.database.session.DataBase;
import DataObject.database.table.Table;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DataBase db = new DataBase("root", "", "jdbc:mysql://localhost:3306/dataobject");
        Column coluna = new Column("Name","VARCHAR(16)");
        Column[] colunas = new Column[1];
        colunas[0] = coluna;
        Table table = new Table("Teste",colunas,coluna);
        table.createTable(db);


    }
}