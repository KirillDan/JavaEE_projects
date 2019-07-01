package Servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import EJB.Test;
import EJB.TestAdminEJB;
import Entitys.CustomerEntity;
import Entitys.ManagerEntity;
import Entitys.OrderEntity;
import Entitys.OrderProductEntity;
import PagesEntitys.BlockEntity;
import PagesEntitys.ElementEntity;
import PagesEntitys.ImgEntity;
import PagesEntitys.PageEntity;
import PagesEntitys.PagesEntity;
import PagesEntitys.TxtEntity;
import ProductEntitys.ProductCharacteristicsEntity;
import ProductEntitys.ProductDescriptionEntity;
import ProductEntitys.ProductEntity;

/**
 * Servlet implementation class Servlet
 */
@WebServlet(name = "ServletTestJSP", urlPatterns = {
        "/ServletTestJSP" ,"/Delivery","/AboutCompany","/Contacts","/Catalog","/Product"})
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Servlet() {
        // TODO Auto-generated constructor stub
    }

EntityManagerFactory emf;
//////////////////////Entitys
	CustomerEntity ce;
	CustomerEntity ce2;
	ManagerEntity me;
	OrderEntity oe;
	OrderProductEntity lop1;
	OrderProductEntity lop2;
///////////////////////////////PagesEntitys
	PagesEntity pages;
	PageEntity page;
	PageEntity pageTest;
	BlockEntity block;
	ElementEntity element;
	ElementEntity element2;
	ElementEntity element3;
	ElementEntity element4;
	ElementEntity element5;
	ElementEntity element6;
	ElementEntity element7;
	TxtEntity text;
	TxtEntity text2;
	TxtEntity text3;
	TxtEntity text4;
	TxtEntity text5;
	ImgEntity img;
	ImgEntity img2;
	
	BlockEntity block2;
	ElementEntity element21;
	ElementEntity element22;
	ElementEntity element23;
	ElementEntity element24;
	ElementEntity element25;
	TxtEntity text21;
	TxtEntity text22;
	TxtEntity text23;
	TxtEntity text24;
	TxtEntity text25;
	
	BlockEntity block3;
	ElementEntity element31;
	ImgEntity img31;
	
	BlockEntity block4;
	ElementEntity element41;
	ElementEntity element42;
	ElementEntity element43;
	TxtEntity text41;
	ImgEntity img41;
	ImgEntity img42;
	
	BlockEntity block5;
	ElementEntity element51;
	ElementEntity element52;
	ElementEntity element53;
	TxtEntity text51;
	TxtEntity text52;
	TxtEntity text53;
	
	BlockEntity block6;
	ElementEntity element61;
	ElementEntity element62;
	ElementEntity element63;
	ElementEntity element64;
	ElementEntity element65;
	ElementEntity element66;
	ElementEntity element67;
	ElementEntity element68;
	ElementEntity element69;
	ImgEntity img61;
	TxtEntity text62;
	TxtEntity text63;
	TxtEntity text64;
	TxtEntity text65;
	TxtEntity text66;
	TxtEntity text67;
	TxtEntity text68;
	TxtEntity text69;
	
	BlockEntity block7;
	ElementEntity element71;
	ElementEntity element72;
	ElementEntity element73;
	TxtEntity text71;
	TxtEntity text72;
	TxtEntity text73;

	/////////////////////////////ProductEntitys
	ProductEntity product;
	ProductEntity product2;
	ProductEntity product3;
	ProductEntity product4;
	
	/////////////////////////////////mainpage
	PageEntity pagemain;
	PageEntity pagemainTest;
	BlockEntity blockmain;
	ElementEntity elementmain;
	TxtEntity textmain;
	BlockEntity blockmain2;
	ElementEntity elementmain21;
	ElementEntity elementmain22;
	ElementEntity elementmain23;
	ElementEntity elementmain24;
	
	BlockEntity blockmain3;
	ElementEntity elementmain31;
	TxtEntity textmain31;
	
	BlockEntity blockmain4;
	ElementEntity elementmain41;
	ElementEntity elementmain42;
	ElementEntity elementmain43;
	ElementEntity elementmain44;

	
	BlockEntity blockmain5;
	ElementEntity elementmain51;
	ElementEntity elementmain52;
	TxtEntity textmain51;
	ImgEntity imgmain52;
	
	@EJB
	Test ejb;
	@EJB
	TestAdminEJB adminEJB;


	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {}
		
		
		public void insertEntitys(){
////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////Create
	///////////////////////Entitys
		ce = new CustomerEntity("Вася","Пупкин","ВасяПупкин@mail.com","123456","Москва","Садовая",5,4,"9000000000");
		me = new ManagerEntity("ИмяМенеджера","ФамилияМенеджера","Менеджер@mail.com","456789","Москва","Садовая",5,4,"9000000000");
		oe = new OrderEntity("22.06.19",true,true,false,false,200.0, 0);
		lop1 = new OrderProductEntity(100.0,5); 
		lop2 = new OrderProductEntity(100.0,1); 
	///////////////////////////////PagesEntitys
		pages = new  PagesEntity(); 
		page = new  PageEntity();
		block = new BlockEntity();
		element = new ElementEntity();	text = new TxtEntity();
		element2 = new ElementEntity();	text2 = new TxtEntity();
		element3 = new ElementEntity();	text3 = new TxtEntity();
		element4 = new ElementEntity();	text4 = new TxtEntity();
		element5 = new ElementEntity();	text5 = new TxtEntity();
		element6 = new ElementEntity();	img = new ImgEntity();
		element7 = new ElementEntity();	img2 = new ImgEntity();
		block2 = new BlockEntity();
		element21 = new ElementEntity();	text21 = new TxtEntity();
		element22 = new ElementEntity();	text22 = new TxtEntity();
		element23 = new ElementEntity();	text23 = new TxtEntity();
		element24 = new ElementEntity();	text24 = new TxtEntity();
		element25 = new ElementEntity();	text25 = new TxtEntity();
		block3 = new BlockEntity();
		element31 = new ElementEntity();	img31 = new ImgEntity();
			////////////////////////////////////ProductEntitys
			product = new ProductEntity("Beyerdynamic","DT1990",true,(byte) 0,(byte) 0,(Double) 40000.00);
			product.addSrcImg("img/dt1990.jpg");
			product.addSrcImg("img/dt1990-2.jpg");
			product.addSrcImg("img/dt1990-3.jpg");
			product.addSrcImg("img/dt1990-4.jpg");
			product2 = new ProductEntity("AKG","K812",true,(byte) 0,(byte) 0,(Double) 55000.00);
			product2.addSrcImg("img/K812.jpg");
			product2.addSrcImg("img/K812-2.jpeg");
			product2.addSrcImg("img/K812-3.jpg");
			product2.addSrcImg("img/K812-4.jpg");
			product3 = new ProductEntity("Audio-technica","W5000",true,(byte) 0,(byte) 0,(Double) 50000.00);
			product3.addSrcImg("img/W5000-1.jpg");
			product3.addSrcImg("img/W5000-2.jpg");
			product3.addSrcImg("img/W5000-3.jpg");
			product3.addSrcImg("img/W5000-4.jpg");
			product4 = new ProductEntity("AKG","K712",true,(byte) 0,(byte) 0,(Double) 27000.00);
			product4.addSrcImg("img/K712.jpg");
			product4.addSrcImg("img/K712-2.jpg");
			product4.addSrcImg("img/K712-3.jpg");
			product4.addSrcImg("img/K712-4.jpg");
			////////////////////////////////////////
		block4 = new BlockEntity();
		element41 = new ElementEntity();	text41 = new TxtEntity();
		element42 = new ElementEntity();	img41 = new ImgEntity();
		element43 = new ElementEntity();	img42 = new ImgEntity();
		block5 = new BlockEntity();
		element51 = new ElementEntity();	text51 = new TxtEntity();
		element52 = new ElementEntity();	text52 = new TxtEntity();
		element53 = new ElementEntity();	text53 = new TxtEntity();
		block6 = new BlockEntity();
		element61 = new ElementEntity();	img61 = new ImgEntity();
		element62 = new ElementEntity();	text62 = new TxtEntity();
		element63 = new ElementEntity();	text63 = new TxtEntity();
		element64 = new ElementEntity();	text64 = new TxtEntity();
		element65 = new ElementEntity();	text65 = new TxtEntity();
		element66 = new ElementEntity();	text66 = new TxtEntity();
		element67 = new ElementEntity();	text67 = new TxtEntity();
		element68 = new ElementEntity();	text68 = new TxtEntity();
		element69 = new ElementEntity();	text69 = new TxtEntity();
		block7 = new BlockEntity();
		element71 = new ElementEntity();	text71 = new TxtEntity();
		element72 = new ElementEntity();	text72 = new TxtEntity();
		element73 = new ElementEntity();	text73 = new TxtEntity();
		/////////////////////////////////////////mainPageEntitys
		pagemain = new  PageEntity();
		blockmain = new BlockEntity();
		elementmain  = new ElementEntity();	textmain = new TxtEntity();
		blockmain2 = new BlockEntity();
		elementmain21  = new ElementEntity();	
		elementmain22  = new ElementEntity();	
		elementmain23  = new ElementEntity();	
		elementmain24  = new ElementEntity();
		blockmain3 = new BlockEntity();
		elementmain31  = new ElementEntity();	textmain31 = new TxtEntity();
		blockmain4 = new BlockEntity();
		elementmain41  = new ElementEntity();	
		elementmain42  = new ElementEntity();	
		elementmain43  = new ElementEntity();	
		elementmain44  = new ElementEntity();
		blockmain5 = new BlockEntity();;
		elementmain51 = new ElementEntity();	textmain51 = new TxtEntity();
		elementmain52 = new ElementEntity();	imgmain52 = new ImgEntity();
		
		
		//Double ii = 10.00;   ii.intValue();  ii.toString();
		
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////Input Values
		///////////////////////////////////templates
		page.setName("templates");
		block.setNumber("top-header");
		element.setNumber("1");		img.setSrc("img/Lable.png");
		element2.setNumber("2");	text.setText("Личный кабинет");
		element3.setNumber("3");	text2.setText("Вход");
		element4.setNumber("4");	text3.setText("Регистрация");
		element5.setNumber("5");	img2.setSrc("img/shopping-cart.svg");
		element6.setNumber("6");	text4.setText("Корзина");
		element7.setNumber("7");	text5.setText("Товаров");
		block2.setNumber("header");
		element21.setNumber("1");	text21.setText("На главную");
		element22.setNumber("2");	text22.setText("Каталог");
		element23.setNumber("3");	text23.setText("О компании");
		element24.setNumber("4");	text24.setText("Доставка");
		element25.setNumber("5");	text25.setText("Контакты");
		block3.setNumber("banner");
		element31.setNumber("1");		img31.setSrc("img/Main1.png");
		block4.setNumber("media-card-container");
		element41.setNumber("1");	text41.setText("default");
		element42.setNumber("2");	img41.setSrc("img/left-arrow-angle.svg");
		element43.setNumber("3");	img42.setSrc("img/keyboard-right-arrow-button.svg");
		block5.setNumber("media-card");
		element51.setNumber("1");	text51.setText("Подробнее");
		element52.setNumber("2");	text52.setText("Купить");
		element53.setNumber("3");	text53.setText("руб");
		block6.setNumber("footer");
		element61.setNumber("1");	img61.setSrc("img/Lable.png");
		element62.setNumber("2");	text62.setText("Главная");
		element63.setNumber("3");	text63.setText("Каталог");
		element64.setNumber("4");	text64.setText("Доставка");
		element65.setNumber("5");	text65.setText("О компании");
		element66.setNumber("6");	text66.setText("Контакты");
		element67.setNumber("7");	text67.setText("Вход");
		element68.setNumber("8");	text68.setText("Регистрация");
		element69.setNumber("9");	text69.setText("Корзина");
		block7.setNumber("subfooter");
		element71.setNumber("1");	text71.setText("Все права защищены");
		element72.setNumber("2");	text72.setText("Super&audio");
		element73.setNumber("3");	text73.setText("2018");
		///////////////////////////////////////mainpage
		pagemain.setName("main");
		blockmain.setNumber("media-card-container");	
		elementmain.setNumber("1");	textmain.setText("Для повседневной жизни");
		blockmain2.setNumber("media-card");
		elementmain21.setNumber("1");
		elementmain22.setNumber("2");
		elementmain23.setNumber("3");
		elementmain24.setNumber("4");
		blockmain3.setNumber("media-card-container_2");	
		elementmain31.setNumber("1");	textmain31.setText("Для профессионалов");
		blockmain4.setNumber("media-card");
		elementmain41.setNumber("1");
		elementmain42.setNumber("2");
		elementmain43.setNumber("3");
		elementmain44.setNumber("4");
		blockmain5.setNumber("preference");
		elementmain51.setNumber("1");	textmain51.setText("Наши преимущества");
		elementmain52.setNumber("2");	imgmain52.setSrc("img/Преимущества.png");
		
		
		
		
		
/////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////Joining
		pages.addPageEntity(page);
		pages.addPageEntity(pagemain);
		///////////////////////////////////////////templates
		page.addBlockEntity(block);
		block.addElementEntity(element);	element.setImgEntity(img);
		block.addElementEntity(element2);	element2.setTxtEntity(text);
		block.addElementEntity(element3);	element3.setTxtEntity(text2);
		block.addElementEntity(element4);	element4.setTxtEntity(text3);
		block.addElementEntity(element5);	element5.setImgEntity(img2);
		block.addElementEntity(element6);	element6.setTxtEntity(text4);
		block.addElementEntity(element7);	element7.setTxtEntity(text5);
		page.addBlockEntity(block2);
		block2.addElementEntity(element21);	element21.setTxtEntity(text21);
		block2.addElementEntity(element22);	element22.setTxtEntity(text22);
		block2.addElementEntity(element23);	element23.setTxtEntity(text23);
		block2.addElementEntity(element24);	element24.setTxtEntity(text24);
		block2.addElementEntity(element25);	element25.setTxtEntity(text25);
		page.addBlockEntity(block3);
		block3.addElementEntity(element31);	element31.setImgEntity(img31);
		page.addBlockEntity(block4);
		block4.addElementEntity(element41);	element41.setTxtEntity(text41);
		block4.addElementEntity(element42);	element42.setImgEntity(img41);
		block4.addElementEntity(element43);	element43.setImgEntity(img42);
		page.addBlockEntity(block5);
		block5.addElementEntity(element51);	element51.setTxtEntity(text51);
		block5.addElementEntity(element52);	element52.setTxtEntity(text52);
		block5.addElementEntity(element53);	element53.setTxtEntity(text53);
		page.addBlockEntity(block6);
		block6.addElementEntity(element61);	element61.setImgEntity(img61);
		block6.addElementEntity(element62);	element62.setTxtEntity(text62);
		block6.addElementEntity(element63);	element63.setTxtEntity(text63);
		block6.addElementEntity(element64);	element64.setTxtEntity(text64);
		block6.addElementEntity(element65);	element65.setTxtEntity(text65);
		block6.addElementEntity(element66);	element66.setTxtEntity(text66);
		block6.addElementEntity(element67);	element67.setTxtEntity(text67);
		block6.addElementEntity(element68);	element68.setTxtEntity(text68);
		block6.addElementEntity(element69);	element69.setTxtEntity(text69);
		page.addBlockEntity(block7);
		block7.addElementEntity(element71);	element71.setTxtEntity(text71);
		block7.addElementEntity(element72);	element72.setTxtEntity(text72);
		block7.addElementEntity(element73);	element73.setTxtEntity(text73);
		/////////////////////////////////////////main
		pagemain.addBlockEntity(blockmain);
		blockmain.addElementEntity(elementmain);	elementmain.setTxtEntity(textmain);
		blockmain.addBlockEntity(blockmain2);
		blockmain2.addElementEntity(elementmain21);	elementmain21.setProductEntity(product);
		blockmain2.addElementEntity(elementmain22);	elementmain22.setProductEntity(product2);
		blockmain2.addElementEntity(elementmain23);	elementmain23.setProductEntity(product3);
		blockmain2.addElementEntity(elementmain24);	elementmain24.setProductEntity(product4);
		pagemain.addBlockEntity(blockmain3);
		blockmain3.addElementEntity(elementmain31);	elementmain31.setTxtEntity(textmain31);
		blockmain3.addBlockEntity(blockmain4);
		blockmain4.addElementEntity(elementmain41);	elementmain41.setProductEntity(product);
		blockmain4.addElementEntity(elementmain42);	elementmain42.setProductEntity(product2);
		blockmain4.addElementEntity(elementmain43);	elementmain43.setProductEntity(product3);
		blockmain4.addElementEntity(elementmain44);	elementmain44.setProductEntity(product4);
		pagemain.addBlockEntity(blockmain5);
		blockmain5.addElementEntity(elementmain51);	elementmain51.setTxtEntity(textmain51);
		blockmain5.addElementEntity(elementmain52);	elementmain52.setImgEntity(imgmain52);
		
		
//page.getBlockEntity("media-card").getElementEntity("1").getTxtEntity().getText();
		//pagemain.getBlockEntity("preference").getElementEntity("2").getImgEntity().getSrc();
//pagemain.getBlockEntity("media-card-container").getBlockEntity("media-card").getElementEntitySet();	
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getAttribute("page") == null) {
			insertEntitys();
		}
		ejb.createCustomer(ce);
		ce2 = ejb.getCustomerEntity();
		////////////////////////Product
		adminEJB.createProductEntity(product);
		adminEJB.createProductEntity(product2);
		adminEJB.createProductEntity(product3);
		adminEJB.createProductEntity(product4);
		//////////////////////TopHeader
		adminEJB.createTxtEntity(text);
		adminEJB.createTxtEntity(text2);
		adminEJB.createTxtEntity(text3);
		adminEJB.createTxtEntity(text4);
		adminEJB.createTxtEntity(text5);
		adminEJB.createImgEntity(img);
		adminEJB.createImgEntity(img2);
		adminEJB.createElementEntity(element);
		adminEJB.createElementEntity(element2);
		adminEJB.createElementEntity(element3);
		adminEJB.createElementEntity(element4);
		adminEJB.createElementEntity(element5);
		adminEJB.createElementEntity(element6);
		adminEJB.createElementEntity(element7);
		adminEJB.createBlockEntity(block);
		/////////////////////////////Header
		adminEJB.createTxtEntity(text21);
		adminEJB.createTxtEntity(text22);
		adminEJB.createTxtEntity(text23);
		adminEJB.createTxtEntity(text24);
		adminEJB.createTxtEntity(text25);
		adminEJB.createElementEntity(element21);
		adminEJB.createElementEntity(element22);
		adminEJB.createElementEntity(element23);
		adminEJB.createElementEntity(element24);
		adminEJB.createElementEntity(element25);
		adminEJB.createBlockEntity(block2);
		////////////////////////////////Banner_picture
		adminEJB.createImgEntity(img31);
		adminEJB.createElementEntity(element31);
		adminEJB.createBlockEntity(block3);
		/////////////////////////////////MediaCardContainer
		adminEJB.createTxtEntity(text41);
		adminEJB.createImgEntity(img41);
		adminEJB.createImgEntity(img42);
		adminEJB.createElementEntity(element41);
		adminEJB.createElementEntity(element42);
		adminEJB.createElementEntity(element43);
		adminEJB.createBlockEntity(block4);
		//////////////////////////////////////MediaCard
		adminEJB.createTxtEntity(text51);
		adminEJB.createTxtEntity(text52);
		adminEJB.createTxtEntity(text53);
		adminEJB.createElementEntity(element51);
		adminEJB.createElementEntity(element52);
		adminEJB.createElementEntity(element53);
		adminEJB.createBlockEntity(block5);
		/////////////////////////////////////Footer
		adminEJB.createImgEntity(img61);
		adminEJB.createTxtEntity(text62);
		adminEJB.createTxtEntity(text63);
		adminEJB.createTxtEntity(text64);
		adminEJB.createTxtEntity(text65);
		adminEJB.createTxtEntity(text66);
		adminEJB.createTxtEntity(text67);
		adminEJB.createTxtEntity(text68);
		adminEJB.createTxtEntity(text69);
		adminEJB.createElementEntity(element61);
		adminEJB.createElementEntity(element62);
		adminEJB.createElementEntity(element63);
		adminEJB.createElementEntity(element64);
		adminEJB.createElementEntity(element65);
		adminEJB.createElementEntity(element66);
		adminEJB.createElementEntity(element67);
		adminEJB.createElementEntity(element68);
		adminEJB.createElementEntity(element69);
		adminEJB.createBlockEntity(block6);
		////////////////////////////////////SubFooter
		adminEJB.createTxtEntity(text71);
		adminEJB.createTxtEntity(text72);
		adminEJB.createTxtEntity(text73);
		adminEJB.createElementEntity(element71);
		adminEJB.createElementEntity(element72);
		adminEJB.createElementEntity(element73);
		adminEJB.createBlockEntity(block7);
		
		///////////////////////////////////////////mainpage____MediaCardContainer
		adminEJB.createTxtEntity(textmain);
		adminEJB.createElementEntity(elementmain);
		adminEJB.createElementEntity(elementmain21);
		adminEJB.createElementEntity(elementmain22);
		adminEJB.createElementEntity(elementmain23);
		adminEJB.createElementEntity(elementmain24);
		adminEJB.createBlockEntity(blockmain2);
		adminEJB.createBlockEntity(blockmain);
		adminEJB.createTxtEntity(textmain31);
		adminEJB.createElementEntity(elementmain31);
		adminEJB.createElementEntity(elementmain41);
		adminEJB.createElementEntity(elementmain42);
		adminEJB.createElementEntity(elementmain43);
		adminEJB.createElementEntity(elementmain44);
		adminEJB.createBlockEntity(blockmain4);
		adminEJB.createBlockEntity(blockmain3);
		adminEJB.createTxtEntity(textmain51);
		adminEJB.createImgEntity(imgmain52);
		adminEJB.createElementEntity(elementmain51);
		adminEJB.createElementEntity(elementmain52);
		adminEJB.createBlockEntity(blockmain5);
		
		pagemainTest=adminEJB.createPageEntity(pagemain);
		pageTest = adminEJB.createPageEntity(page);
		adminEJB.createPagesEntity(pages);
		
		
		
        response.setContentType("text/html;charset=Windows-1251");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append(ce2.getFirstname());
		if(request.getAttribute("page") == null) {request.setAttribute("page", pageTest);}
		if(request.getAttribute("pagemain") == null) {request.setAttribute("pagemain", pagemainTest);}
		if(request.getAttribute("blockmain2") == null) {request.setAttribute("blockmain2", pagemain.getBlockEntity("media-card-container").getBlockEntity("media-card"));}
		if(request.getAttribute("blockmain4") == null) {request.setAttribute("blockmain4", pagemain.getBlockEntity("media-card-container_2").getBlockEntity("media-card"));}
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}
	
	private void process(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
		String dispatchUrl = null;
//"/Delivery","/AboutCompany","/Contacts","/Catalog","/Product"
		if("ServletTestJSP".equals(action)) {
			dispatchUrl = "jsp/Test_JSP.jsp";
		}else if("Delivery".equals(action)) {
			dispatchUrl = "jsp/Delivery.jsp";
		}else if("AboutCompany".equals(action)) {
			dispatchUrl = "jsp/AboutCompany.jsp";
		}else if("Contacts".equals(action)) {
			dispatchUrl = "jsp/Contacts.jsp";
		}else if("Catalog".equals(action)) {
			dispatchUrl = "jsp/Catalog.jsp";
		}else if("Product".equals(action)) {
			dispatchUrl = "jsp/Product.jsp";
		}
		RequestDispatcher rd =
                request.getRequestDispatcher(dispatchUrl);
        rd.forward(request, response);
	}

}
