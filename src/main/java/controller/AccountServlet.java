package controller;

import Service.AccountService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AccountServlet", value = "/AccountServlet")
public class AccountServlet extends HttpServlet {
    private AccountService accountService = new AccountService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("name");
        if(action==null){
            action="";
        }
        RequestDispatcher rd= request.getRequestDispatcher("WEB-LOGIN/login_register.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action =request.getParameter("action");
//        if(action==null) {
//            action = "";
//        }
//        switch (action){
//            case "login":
//                accountService.login(request,response);
//             break;
//            case "register":
//                accountService.createAccount(request,response);
//                break;
//        }
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullName");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        request.setAttribute("password",password);
        request.setAttribute("fullName",fullName);
        request.setAttribute("phoneNumber",phoneNumber);
        request.setAttribute("address",address);
        request.setAttribute("condition","register");
            request.setAttribute("status","success");
            RequestDispatcher rd= request.getRequestDispatcher("WEB-LOGIN/login_register.jsp");
            rd.forward(request,response);
        }
    }

