package vn.cloud.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jcraft.jsch.JSchException;

import vn.cloud.dao.HomeDao;
import vn.cloud.model.LoginModel;

@WebServlet(urlPatterns = { "/stopC" })
public class StopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HomeDao hd = new HomeDao();
		String cid = req.getParameter("cid");
		HttpSession session = req.getSession();
		LoginModel info = (LoginModel) session.getAttribute("info");
		try {
			hd.stopContainer(cid);
		} catch (JSchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(info.getRole() == 0)
		{
		resp.sendRedirect("home");
		}
		else
		{
			resp.sendRedirect("admincontainer");
		}
	}
	

}