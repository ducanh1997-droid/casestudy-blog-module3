package Service;

import DAO.AccountDAO;
import Model.Account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

public class AccountService {
    List<Account> listAccount;
    public AccountDAO accountDAO;
    public  AccountService () {
    listAccount=new ArrayList<>();
    accountDAO=new AccountDAO();
    }
    public Account login(String name,String password){
       return accountDAO.checkLoginAccount(name,password);

    }
    public boolean createAccount(HttpServletRequest request, HttpServletResponse response){
        String useName =request.getParameter("name");
        String email=request.getParameter("email");
        String passWord=request.getParameter("passWord");
        String fullName=request.getParameter("fullName");
        String phoneNumber=request.getParameter("phoneNumber");
        String address=request.getParameter("address");
        if (Regex.checkRegexUserName(useName)&&Regex.checkRegexEmail(email)&&Regex.checkRegexPassWord(passWord)
                &&Regex.checkRegexPhoneNumber(phoneNumber)&&Regex.checkRegexAddress(address)){
            Account account = new Account(useName,passWord,fullName,phoneNumber,email,address,false,true);
           accountDAO.create(account);
            if(accountDAO.create(account)){
                return true;
            }
        }
       return false;
    }
}
