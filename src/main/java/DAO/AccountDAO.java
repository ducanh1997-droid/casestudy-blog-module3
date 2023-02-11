package DAO;

import Model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {
    private final Connection connection;
    private final String CHECK_LOGIN_ACCOUNT = "select * from account where userName = ? or email= ? and passWord = ?";

    public AccountDAO()   {
        connection = MyConnection.getConnection();
    }
public Account checkLoginAccount(String name,String passWord){
        Account account = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(CHECK_LOGIN_ACCOUNT)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, passWord);
    ResultSet resultSet = preparedStatement.executeQuery();
    while (resultSet.next()) {
        account = new Account(resultSet.getInt(1),
                resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)
                ,resultSet.getString(5),resultSet.getString(6),resultSet.getString(7), resultSet.getBoolean(8), resultSet.getBoolean(9));
}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }
    public boolean create(Account account){
        try(PreparedStatement preparedStatement = connection.prepareStatement("select * from account where username =? or email =? and password=?;")) {
            preparedStatement.setString(1,account.getUserName());
            preparedStatement.setString(2,account.getEmail());
            preparedStatement.setString(3,account.getPassWord());
            ResultSet resultSet = preparedStatement.executeQuery();
            int size = 0;
            while (resultSet.next()){
                size++;
            }
            if(size == 0){
                try(PreparedStatement preparedStatement1 = connection.prepareStatement("insert into account(username, password, fullname, phoneNumber, email, address, role, status) values (?,?,?,?,?,?,?,?)")){
                    preparedStatement1.setString(1,account.getUserName());
                    preparedStatement1.setString(2,account.getPassWord());
                    preparedStatement1.setString(3,account.getFullName());
                    preparedStatement1.setString(4,account.getPhoneNumber());
                    preparedStatement1.setString(5,account.getEmail());
                    preparedStatement1.setString(6,account.getAddress());
                    preparedStatement1.setBoolean(7,account.isRole());
                    preparedStatement1.setBoolean(8,account.isStatus());
                    return true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

}

