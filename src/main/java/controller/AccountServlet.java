package controller;

import Model.Account;
import Model.Blog;
import Model.Category;
import Service.AccountService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "AccountServlet", value = "/AccountServlet")
public class AccountServlet extends HttpServlet {
    private AccountService accountService = new AccountService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        Account service test
        String action=request.getParameter("action");
        if (action==null){
            action="";
        }
        Account account= new Account(1,"linhtran","167641176Po","Trần Linh","1234567890","linhtrantb@gmaill.com","Bồ Xuyên-Thái Bình",false,true);
        Category category= new Category("sport","");
        ArrayList<Blog> blogs = new ArrayList<>();
        blogs.add(new Blog(1,"thể thao","thể thao là gì?", LocalDate.of(2022,1,12),"",category,account,"",""));
        blogs.add(new Blog(2,"tennis","tennis là một môn thể thao nhiều...", LocalDate.of(2022,1,12),"",category,account,"",""));
switch (action) {
    case "loadBlog":
        int blogId=Integer.parseInt(request.getParameter("blogId"));
        request.setAttribute("accountDisplay", "none");
        request.setAttribute("blogDisplay", "block");
        request.setAttribute("blogReq", blogs.get(blogId-1));
        request.setAttribute("blogs", blogs);
        request.setAttribute("account", account);
        RequestDispatcher rd = request.getRequestDispatcher("WEB-LOGIN/accountService.jsp");
        rd.forward(request, response);
        break;
    default:
        request.setAttribute("accountDisplay", "block");
        request.setAttribute("blogs", blogs);
        request.setAttribute("account", account);
        RequestDispatcher rd1 = request.getRequestDispatcher("WEB-LOGIN/accountService.jsp");
        rd1.forward(request, response);
}
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =request.getParameter("action");
        if(action==null) {
            action = "";
        }
        switch (action){
            case "login":
                accountService.login(request,response);
             break;
            case "register":
                accountService.createAccount(request,response);
                break;
        }

        }
    }

