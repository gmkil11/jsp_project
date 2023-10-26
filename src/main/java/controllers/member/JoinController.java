package controllers.member;

import static commons.ScriptUtil.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import member.JoinService;
import member.ServiceManager;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/member/join")
public class JoinController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/templates/member/join.jsp");
        rd.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String userNm = req.getParameter("userNm");
            req.setAttribute("userNm", userNm);
            System.out.println(userNm);
            JoinService service = ServiceManager.getInstance().joinService();
            service.join(req);
            String url = req.getContextPath()+"/member/joinSuccess" + "?userNm="+userNm;
            go(resp, url, "parent");
        } catch (RuntimeException e) {
            alertError(resp, e);
        }

    }
}
