package TestBank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.List;

import javax.ejb.EJB;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TestBank.Files.ObjectRequestJsonPay;
import TestBank.Files.ObjectRequestJsonVerifyPayment;



/**
 * Servlet implementation class BankServlet
 */
@WebServlet(name="BankServlet", urlPatterns = {"/BankServlet/*","/BankServlet"})
public class BankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
	BankEJB bankEJB;
    
	Jsonb jsonb = JsonbBuilder.create();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig servletConfig) {
    	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	/*	ResultPaymentJson responseMessage = new ResultPaymentJson();
		responseMessage.errorCode = "0";
		responseMessage.errorMessage = "Успешно";
		String message = jsonb.toJson(responseMessage);
	*/	
		//String stringURL = "http://localhost:8080/IS_test_EJB/SuccessfulPayment";
	/*	URL url = new URL(stringURL);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setRequestMethod("GET");
		httpURLConnection.setRequestProperty("User-Agent", "Bank");
		httpURLConnection.setDoOutput(true);
		int responseCode = httpURLConnection.getResponseCode();
		String responseMessageIS = httpURLConnection.getResponseMessage();
		System.out.println("GET Response Code : : " + responseCode);
		System.out.println("GET Response Message : : " + responseMessageIS);*/
		
		bankEJB.createBankPaymentEntity((Double) 20000.0, "0",new Long(0));
		//response.setContentType("text/html;charset=Windows-1251");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		List<BankPaymentEntity> lbpe= bankEJB.findAllBankPaymentEntity();
		for(int i = 0; i < lbpe.size(); i++) {
			
			out.println(lbpe.get(i).getPaymentId());
			out.println();
		}
		
		//ServletInputStream servletInputStream = request.getInputStream();
		//InputStreamReader inputStreamReader = new InputStreamReader(servletInputStream);
		//BufferedReader in = new BufferedReader();
		//response.sendRedirect(stringURL);
		//request.getRequestDispatcher(stringURL);
	//	doPost(request,response);
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//getRequestInformation(request);
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
		String dispatchUrl = null;
		if("VerifyPayment".equals(action)) {
			//String jsonRequest = StreamRequestJson(request);
			//ObjectRequestJsonVerifyPayment objectRequest = jsonb.fromJson(jsonRequest, ObjectRequestJsonVerifyPayment.class);
			//String jsonResponse = bankEJB.getResultPaymentJsonById(Long.parseLong(objectRequest.paymentId));
			Long PaymentId = Long.parseLong(request.getParameter("PaymentId"));
			String jsonResponse = bankEJB.getResultPaymentJsonById(PaymentId);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().append(jsonResponse);
		}else if("Pay".equals(action)) {
			String jsonParams = (String) request.getParameter("jsonParams");
			String returnUrl = (String) request.getParameter("returnUrl");
			String failUrl = (String) request.getParameter("failUrl");
			Long orderNumber = Long.parseLong(request.getParameter("orderNumber"));
			System.out.println("orderNumber ----1------------------------------------------     " + orderNumber);
			System.out.println("returnUrl ----1------------------------------------------     " + returnUrl);
			System.out.println("failUrl -------1---------------------------------------       " + failUrl);
			if(request.getParameter("cost") == null) {
			//String jsonRequest = StreamRequestJson(request);
				ObjectRequestJsonPay objectRequest = jsonb.fromJson(jsonParams, ObjectRequestJsonPay.class);
				Double costDouble = objectRequest.cost;
				String costString = String.valueOf(costDouble);
				
				response.setContentType("text/html");
				response.setCharacterEncoding("UTF-8");
			
				PrintWriter out = response.getWriter();
				out.print("<HTML>"
					+ "<HEADER>"
					+ "</HEADER>"
					+ "<BODY>" + "<BR>"
					+ "Страница Банка" + "<BR>"
					//+ request.getParameter("returnUrl") + "<BR>"
					//+ request.getParameter("failUrl") + "<BR>"
					+ "Сумма вашего заказа  -  "
					+ costString + " руб" + "<BR>"
					+ "<FORM method=\"POST\" action=\"BankServlet/Pay\">"
					+ "<INPUT type=\"HIDDEN\" name=\"cost\" value=\"" + costString + "\" >"
					+ "<INPUT type=\"HIDDEN\" name=\"returnUrl\" value=\"" + returnUrl + "\" >"
					+ "<INPUT type=\"HIDDEN\" name=\"failUrl\" value=\"" + failUrl + "\" >"
					+ "<INPUT type=\"HIDDEN\" name=\"orderNumber\" value=\"" + orderNumber + "\" >"
					+ "<BUTTON type=\"SUBMIT\">"
					+ " Оплатить    " + costString + " RUB "
					+ "</BUTTON>"
					+ "</BODY>"
					+ "</HTML>");
			}else {
				System.out.println("cost -------------------------------------------       " + request.getParameter("cost"));
				Long Id = bankEJB.createBankPaymentEntity(Double.valueOf(request.getParameter("cost")) , "0", orderNumber);
				System.out.println("Id ----------------------------------------------       " + Id);
				System.out.println("orderNumber ----////////------------------------------------------     " + orderNumber);
				System.out.println("returnUrl ----////////------------------------------------------     " + returnUrl);
				System.out.println("failUrl -------/////////---------------------------------------       " + failUrl);

				if("0".equals(bankEJB.findBankPaymentEntityById(Id).getErrorCode())) {
					returnUrl = returnUrl + "?PaymentId=" + Id;
					response.sendRedirect(returnUrl);
				}else {
					response.sendRedirect(failUrl);
				}

			}
		}
	}

	
	
	
	
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////	
	 String StreamRequestJson(HttpServletRequest request) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream())); 
		StringBuffer stringBuffer = new StringBuffer();
		String line;		
		while((line = bufferedReader.readLine()) != null) {
			stringBuffer.append(line);
		}
		bufferedReader.close();
		String jsonRequest = stringBuffer.toString();
		System.out.println(jsonRequest);
		return jsonRequest;
	}
	/* void getRequestInformation(HttpServletRequest request) {
		 //System.out.println();
		 
		 System.out.println(request.getRequestURL());
		 System.out.println("-------------Header-----------------------------------");
		 Enumeration headersEnum = request.getHeaderNames();
		 while(headersEnum.hasMoreElements()) {
			 String header = (String) headersEnum.nextElement();
			 System.out.println(header + "  :  " + request.getHeader(header) + "  ---------" );
			 Enumeration hE = request.getHeaders(header);
			 while(hE.hasMoreElements()) {
				 String h = (String) hE.nextElement();
				System.out.println("   :   " + h);

			 }
		 }
		 System.out.println("-----------------Attribute--------------------------------");
		 Enumeration attributeEnum = request.getAttributeNames();
		 while(attributeEnum.hasMoreElements()) {
			 String attribute = (String) attributeEnum.nextElement();
			 System.out.println(attribute + "  :  " + request.getAttribute(attribute));

		 }
		 System.out.println("-----------------Parameter--------------------------------");
		 Enumeration parameterEnum = request.getParameterNames();
		 while(parameterEnum.hasMoreElements()) {
			 String parameter = (String) parameterEnum.nextElement();
			 System.out.println(parameter + "  :  " + request.getParameter(parameter).toString() + "  :    values     :" + request.getParameterValues(parameter).toString());

		 }

		 System.out.println("-------------------------------------------------");
		System.out.println(request.getAuthType());
		System.out.println(request.getMethod());
		System.out.println(request.getQueryString());
		System.out.println(request.toString());
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

	 }
	*/

}
