package Servlet;

import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.jms.JMSException;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import EJB.RecOrderEJB;
import EJB.ScheduleOrderEJB;
import Entitys.OrderEntity;
import MDB.BigManagerConsumer;
import MDB.MiddleManagerConsumer;

@WebServlet(urlPatterns = {"/ControllerServlet","/ControllerServlet/*"})
public class ControllerServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	RecOrderEJB recOrderEJB;
	@EJB
	BigManagerConsumer bigManagerConsumer;
	@EJB
	MiddleManagerConsumer middleManagerConsumer;

	public void init(ServletConfig servletConfig) throws ServletException {
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String uri = request.getRequestURI();
		int index = uri.lastIndexOf("/");
		String action = uri.substring(index+1);
		String dispatchUrl = null;
		if("GetPaydOrders".equals(action)) {
			for(int i=0; i<7; i++) {
				recOrderEJB.createOrder(new OrderEntity(new Date().toString(), true, false, false, false, new Double((100 - i)*1020), 0));
			}
		}else if("bigManager".equals(action)) {
			try {
				Long OrderId = bigManagerConsumer.getBigOrder();
				System.out.println("    ///////////////////////////// -------------------- ////////////////  " + OrderId);
			} catch (NamingException | JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("middleManager".equals(action)) {
			try {
				Long OrderId = middleManagerConsumer.getMiddleOrder();
				System.out.println("    ///////////////////////////// -------------------- ////////////////  " + OrderId);
			} catch (NamingException | JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
