package servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;
import db.DB;
import sun.security.util.Password;

public class MainServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // �����������
        request.setCharacterEncoding("gb2312");
        // ������Ӧ����
        response.setContentType("gb2312");
        // ���JSPҳ��������û�����ֵ
        String username=request.getParameter("username");
        // ���JSPҳ������������ֵ
        String pwd=request.getParameter("pwd");
        // ����DB�����ʹ�����еķ���������ж�
        DB db=new DB();
        // ���session��������������Ϣ
        HttpSession session=request.getSession();
        // �Ȼ��user��������ǵ�һ�η��ʸ�Servlet���û�����϶�Ϊ�գ�������ǵ�
        // ���������ǵ����Σ��Ͳ�Ӧ�����жϸ��û�����Ϣ
        User user=(User) session.getAttribute("user");
        // ��������жϣ�����û��ǵ�һ�ν��룬����DB���еķ����ж�
        if(user==null){
            user=db.checkUser(username, pwd);
        }
        // ��user�������session��
        session.setAttribute("user", user);
        if(user!=null){
            // ������ݲ�ѯ���û���Ϊ�գ���ʾ�û�����������ȷ��Ӧ��ȥ��һ����
            // ������ȥ�����棬�������а���������������Ϣ������Ҫ�����Ա��в����
            ArrayList al=db.findLyInfo();
            // �Ѳ�ѯ����Ϣ������session��
            session.setAttribute("al", al);
            // Ȼ����ת������Ҫȥ��������
            response.sendRedirect("main.jsp");
        }else{
            // ����û�����������󣬻ص���¼����
            response.sendRedirect("Login.jsp");
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}
