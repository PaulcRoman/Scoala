package ro.school.repository;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection implements RepoData{
    String JdbcURl = "jdbc:mysql://localhost:3306/scoaladb?"+"autoReconnect=true&useSSL=false";
    String username = "root";
    String password = "123456";
    java.sql.Connection connection = null;
    Statement statement = null;

    public  Connection(){

        connect();
    }

    @Override
    public void connect() {
        try {

            connection = DriverManager.getConnection(JdbcURl, username, password);
            statement = connection.createStatement();

        }catch (SQLException e){
            System.out.println("Erroare connectare la baza de date");
        }
    }

    @Override
    public void exacuteStatement(String execute) {
        try {
            statement.execute(execute);
        }catch (SQLException exc){
            System.out.println("Nu am reusit "+execute);
        }
    }


}
