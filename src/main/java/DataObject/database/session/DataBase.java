package DataObject.database.session;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;

public class DataBase implements ConnectionFactory {

    private String user;
    private String password;
    private String url;
    private Connection connection;

    public DataBase(String user, String password, String url) {
        this.user = user;
        this.password = password;
        this.url = url;

    }
    public void createConnection(){

        try {
            this.connection = DriverManager.getConnection(url, user,password);
            System.out.println("Conectado!");
        }catch (SQLException err) {
            err.printStackTrace();
        }
    }
    public  void closeConnection(){
        try {
            this.connection.close();
        }catch (SQLException err){
            err.printStackTrace();
        }
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

}
