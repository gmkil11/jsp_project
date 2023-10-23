package controllers.member;

import static commons.ScriptUtil.*;

import commons.ScriptUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import member.LoginService;
import member.ServiceManager;

import java.io.IOException;

@WebServlet("/member/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/templates/member/join.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            LoginService service = ServiceManager.getInstance().loginService();
            service.login(req);

            go(resp, req.getContextPath() + "/", "parent");
        }catch (RuntimeException e){
            alertError(resp, e);
        }
    }
}
