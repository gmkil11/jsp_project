package controllers.member;

import static commons.ScriptUtil.*;

import commons.ScriptUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
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
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/templates/member/login.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            LoginService service = ServiceManager.getInstance().loginService();
            service.login(req);
            /* 아이디 저장 처리 시작 */
            String userId = req.getParameter("userId");
            String saveId = req.getParameter("saveId");
            Cookie cookie = new Cookie("saveId", userId);
            if (saveId == null) {// 미체크 상태일 때 - 쿠키 제거
                cookie.setMaxAge(0);
            } else {// 체크 상태 - 쿠키 저장
                cookie.setMaxAge(60 * 60 * 24 * 365);
            }

            resp.addCookie(cookie);
            /* 아이디 저장 처리 끝 */

            go(resp, req.getContextPath() + "/", "parent");
        }catch (RuntimeException e){
            alertError(resp, e);
        }
    }
}
