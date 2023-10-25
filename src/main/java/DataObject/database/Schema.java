package DataObject.database;
import DataObject.database.session.DataBase;
import DataObject.database.table.Table;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Schema{
    private String Name;
    private List<Table> tables;

    public String getSchemaName() {
        return Name;
    }

    public void setSchemaName(String schemaName) {
        this.Name = schemaName;
    }

    public Schema() {
        this.tables = new ArrayList<>();
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public void addTable(Table table) {
        this.tables.add(table);
    }

    public void removeTable(String tableName) {
        this.tables.removeIf(table -> table.getTableName().equals(tableName));
    }

    public Table getTable(String tableName){
        for(Table table : tables) {
            if(table.getTableName().equals(tableName)) {
                return table;
            }
        }
        return null; //Depois pode ser substituido por uma exceção
    }
    public void clearSchema() {
        this.tables.clear();

    }
    public List<Table> getAllTables() {
        return tables;
    }

    public void createSchemaInDatabase(String schemaName, DataBase dataBase) throws SQLException {
        this.Name = schemaName;
        Connection connectionDataBase = dataBase.getConnection();
        Statement statement = connectionDataBase.createStatement();
        String createSchemaQuery = "CREATE SCHEMA IF NOT EXISTS " + schemaName;
        statement.executeUpdate(createSchemaQuery);
        dataBase.closeConnection();
    }
}