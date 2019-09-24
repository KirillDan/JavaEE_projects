package Servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
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
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Request;

import EJB.CartSessionEJB;
import EJB.DataForPurchaseEJB;
import EJB.ManagerEJB;
import EJB.PagesEJB;
import EJB.SingletonEJB;
import EJB.Test;
import EJB.TestAdminEJB;
import Entitys.AddressEntity;
import Entitys.CustomerEntity;
import Entitys.ManagerEntity;
import Entitys.OrderEntity;
import Entitys.OrderProductEntity;
import Logic.ArrayListBuilder;
import Logic.CustomerEntityComparator;
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
        "/ServletTestJSP" ,"/Delivery","/AboutCompany","/Contacts","/Catalog","/Product","/Cart",
        "/Login","/Registration","/OrderForm","/Cabinet","/ProcessingOrder","/ToManagerOrder","/PayOrder",
        "/FinishedOrder","/FailedPayment","/SuccessfulPayment","/SuccessfulRegistration","/AdministratorAllUsers",
        "/Exit","/BankSite","/CheckOrder","/NonPayOrder","AdministratorAllOrders","/AdministratorAllNonPayOrders",
        "/AdministratorAllPayOrders","/AdministratorAllProcessingOrders","/AdministratorAllTransferedManagerOrders","/AdministratorAllClosedOrders",
        "/AdministratorCabinet","/AdministratorProduct","/AdministratorOrders","/AdministratorCustomers",
        "/AllOrders","/AdministratorManagers","/AdminstratorDeleteManager","/AdministratorInsertManager",
        "/AdministratorAllManagers","/ManagersData","/ManagerOrders","/ManagersClosedOrders","/LoginManager"})
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
  
EntityManagerFactory emf;
//////////////////////Entitys

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
	
	BlockEntity block8;
	ElementEntity element80;
	ElementEntity element81;
	ElementEntity element82;
	ElementEntity element83;
	ElementEntity element84;
	ElementEntity element85;
	ElementEntity element86;
	ElementEntity element87;
	ElementEntity element88;
	ElementEntity element89;
	TxtEntity text80;
	TxtEntity text81;
	TxtEntity text82;
	TxtEntity text83;
	TxtEntity text84;
	TxtEntity text85;
	TxtEntity text86;
	TxtEntity text87;
	TxtEntity text88;
	TxtEntity text89;
	
	BlockEntity block9;
	ElementEntity element90;
	ElementEntity element91;
	ElementEntity element92;
	ElementEntity element93;
	ElementEntity element94;
	TxtEntity text90;
	TxtEntity text91;
	TxtEntity text92;
	TxtEntity text93;
	TxtEntity text94;
	
	BlockEntity block10;
	ElementEntity element100;
	ElementEntity element101;
	ElementEntity element102;
	ElementEntity element103;
	ElementEntity element104;
	TxtEntity text100;
	TxtEntity text101;
	TxtEntity text102;
	TxtEntity text103;
	TxtEntity text104;
	
	BlockEntity block11;
	ElementEntity element111;
	TxtEntity text111;
	
	BlockEntity block12;
	ElementEntity element121;
	TxtEntity text121;
	
	BlockEntity block13;
	ElementEntity element131;
	TxtEntity text131;
	
	BlockEntity block14;
	ElementEntity element141;
	ElementEntity element142;
	ElementEntity element143;
	ElementEntity element144;
	ElementEntity element145;
	ElementEntity element146;
	ElementEntity element146a;
	ElementEntity element147;
	ElementEntity element147a;
	ElementEntity element148;
	TxtEntity text141;
	TxtEntity text142;
	TxtEntity text143;
	TxtEntity text144;
	TxtEntity text145;
	TxtEntity text146;
	TxtEntity text146a;
	TxtEntity text147;
	TxtEntity text147a;
	TxtEntity text148;

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
	
	///////////////////////////////////////
	List<ProductEntity> listProductEntity;
	Long productId;
	
	@EJB
	Test ejb;
	@EJB
	TestAdminEJB adminEJB;
	@EJB
	PagesEJB pagesEJB;
	@EJB
	CartSessionEJB cartSessionEJB;
	@EJB
	SingletonEJB singletonEJB;
	@EJB
	DataForPurchaseEJB dataForPurchaseEJB;
	@EJB
	ManagerEJB managerEJB;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	  public Servlet() {
	    	
	    }
	  
	public void init(ServletConfig config) throws ServletException {
		if(singletonEJB.page == false) {
			insertEntitys();
			creatingEntitys();
			singletonEJB.page = true;
		}
		//CustomerEntity ce;
		//Set<CustomerEntity> setCustomerEntity = new TreeSet(new CustomerEntityComparator());
		ManagerEntity me;
		OrderEntity oe;
		OrderProductEntity lop1;
		OrderProductEntity lop2;
		AddressEntity adr;
	/////////////////////////
		//me = new ManagerEntity("ИмяМенеджера","ФамилияМенеджера","Менеджер@mail.com","456789","Москва","Садовая",5,4,"9000000000");
		adminEJB.createManager("ИмяМенеджера","ФамилияМенеджера","Менеджер@mail.com","456789","Москва","Садовая",5,4,"9000000000");
		//oe = new OrderEntity("22.06.19",true,true,true,false,200.0, 0);
		//lop1 = new OrderProductEntity(100.0,5); 
		//lop2 = new OrderProductEntity(100.0,1);
		//adr = new AddressEntity("Moskow","Sadovaya",5,20,"900000000","111111","MyComment");
		
	////////////	
		//for(CustomerEntity ce : setCustomerEntity) {
		for(int i = 0 ; i < 10 ; i++) {
			String CustomerName = "Вася";
			String CustomerSecondName = "Пупкин";
			String email; String email1 = "VasyaPupkin"; String email2 ="@mail.com";
			String password = "123456";
			CustomerName = CustomerName + "[" + i + "]";
			CustomerSecondName = CustomerSecondName + "[" + i +"]";
			email = email1 + "[" + i + "]" + email2;
/*			ejb.createComplex(new CustomerEntity(CustomerName,CustomerSecondName,email,"123456","Москва","Садовая",5,4,"9000000000","111111"),
					 		new OrderEntity("22.06.19",true,true,true,false,200.0, 0),
					 		new ArrayListBuilder().adds(new OrderProductEntity(100.0,5)).adds(new OrderProductEntity(100.0,1)).buildArrayList(),
					 		new AddressEntity("Moskow","Sadovaya",5,20,"900000000","111111","MyComment"));
*/			ejb.createComplexTest(new CustomerEntity(CustomerName,CustomerSecondName,email,"123456","Москва","Садовая",5,4,"9000000000","111111"),
									new ArrayListBuilder().
										adds(new OrderEntity("22.06.19",false,false,false,false,200.0, 0)).
										adds(new OrderEntity("22.06.19",true,false,false,false,200.0, 0)).
										adds(new OrderEntity("22.06.19",true,true,false,false,200.0, 0)).
										adds(new OrderEntity("22.06.19",true,true,true,false,200.0, 0)).
										adds(new OrderEntity("22.06.19",true,true,true,true,200.0, 0)).
										buildArrayList()
								);
			CustomerName = "";
			CustomerSecondName = "";
			email1 = "";
			email2 = "";
			email = "";
		}
	}
		
		
	public void insertEntitys(){
////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////Create
	///////////////////////Entitys
		
		/*ce.addOrderEntity(oe);
		oe.addOrderProductEntity(lop1);
		oe.addOrderProductEntity(lop2);
		oe.setManagerEntity(null);
		oe.setCustomerEntity(ce);
		oe.setAddressEntity(adr);
		lop1.setProduct(null);
		lop2.setProduct(null);
		*/
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
		block8 = new BlockEntity();
		element80 = new ElementEntity();	text80 = new TxtEntity();
		element81 = new ElementEntity();	text81 = new TxtEntity();
		element82 = new ElementEntity();	text82 = new TxtEntity();
		element83 = new ElementEntity();	text83 = new TxtEntity();
		element84 = new ElementEntity();	text84 = new TxtEntity();
		element85 = new ElementEntity();	text85 = new TxtEntity();
		element86 = new ElementEntity();	text86 = new TxtEntity();
		element87 = new ElementEntity();	text87 = new TxtEntity();
		element88 = new ElementEntity();	text88 = new TxtEntity();
		element89 = new ElementEntity();	text89 = new TxtEntity();
		block9 = new BlockEntity();
		element90 = new ElementEntity();	text90 = new TxtEntity();
		element91 = new ElementEntity();	text91 = new TxtEntity();
		element92 = new ElementEntity();	text92 = new TxtEntity();
		element93 = new ElementEntity();	text93 = new TxtEntity();
		element94 = new ElementEntity();	text94 = new TxtEntity();
		block10 = new BlockEntity();
		element100 = new ElementEntity();	text100 = new TxtEntity();
		element101 = new ElementEntity();	text101 = new TxtEntity();
		element102 = new ElementEntity();	text102 = new TxtEntity();
		element103 = new ElementEntity();	text103 = new TxtEntity();
		element104 = new ElementEntity();	text104 = new TxtEntity();
		block11= new BlockEntity();
		element111 = new ElementEntity();	text111 = new TxtEntity();
		block12 = new BlockEntity();
		element121 = new ElementEntity();	text121 = new TxtEntity();
		block13 = new BlockEntity();
		element131 = new ElementEntity();	text131 = new TxtEntity();
		block14 = new BlockEntity();
		element141 = new ElementEntity();	text141 = new TxtEntity();
		element142 = new ElementEntity();	text142 = new TxtEntity();
		element143 = new ElementEntity();	text143 = new TxtEntity();
		element144 = new ElementEntity();	text144 = new TxtEntity();
		element145 = new ElementEntity();	text145 = new TxtEntity();
		element146 = new ElementEntity();	text146 = new TxtEntity();
		element146a = new ElementEntity();	text146a = new TxtEntity();
		element147 = new ElementEntity();	text147 = new TxtEntity();
		element147a = new ElementEntity();	text147a = new TxtEntity();
		element148 = new ElementEntity();	text148 = new TxtEntity();
		
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
		block8.setNumber("validator-firm");
		element80.setNumber("0");	text80.setText("Производители");
		element81.setNumber("1");	text81.setText("Beyerdynamic");
		element82.setNumber("2");	text82.setText("AKG");
		element83.setNumber("3");	text83.setText("Audio-technica");
		element84.setNumber("4");	text84.setText("Sennheiser");
		element85.setNumber("5");	text85.setText("Sony");
		element86.setNumber("6");	text86.setText("1MORE");
		element87.setNumber("7");	text87.setText("Pioneer");
		element88.setNumber("8");	text88.setText("HiFiMAN");
		element89.setNumber("9");	text89.setText("Koss");
		block9.setNumber("validator-type-headphones");
		element90.setNumber("0");	text90.setText("Тип наушников");
		element91.setNumber("1");	text91.setText("Мониторные");
		element92.setNumber("2");	text92.setText("Накладные");
		element93.setNumber("3");	text93.setText("Вкладыши");
		element94.setNumber("4");	text94.setText("Затычки");
		block10.setNumber("validator-tdh");
		element100.setNumber("0");	text100.setText("КНИ");
		element101.setNumber("1");	text101.setText("0,02 - 0,04 %");
		element102.setNumber("2");	text102.setText("0,05 - 0,07 %");
		element103.setNumber("3");	text103.setText("0,07 - 1 %");
		element104.setNumber("4");	text104.setText("> 1 %");
		block11.setNumber("text-see-more");
		element111.setNumber("1");	text111.setText("Показать еще");
		block12.setNumber("description");
		element121.setNumber("1");	text121.setText("Описание");
		block13.setNumber("characteristics");
		element131.setNumber("1");	text131.setText("Технические характеристики");
		block14.setNumber("media-object");
		element141.setNumber("1");		text141.setText("Профессиональные наушники");
		element142.setNumber("2");		text142.setText("Скидка 5% зарегестрированным покупателям");
		element143.setNumber("3");		text143.setText("Товар в наличии");
		element144.setNumber("4");		text144.setText("Товара нет в наличии");
		element145.setNumber("5");		text145.setText("Нашли дешевле?");
		element146.setNumber("6");		text146.setText("Положить");
		element146a.setNumber("6a");	text146a.setText("в корзину");
		element147.setNumber("7");		text147.setText("Купить");
		element147a.setNumber("7a");	text147a.setText("в один клик");
		element148.setNumber("8");		text148.setText("руб");
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
		page.addBlockEntity(block8);
		block8.addElementEntity(element80);	element80.setTxtEntity(text80);
		block8.addElementEntity(element81);	element81.setTxtEntity(text81);
		block8.addElementEntity(element82);	element82.setTxtEntity(text82);
		block8.addElementEntity(element83);	element83.setTxtEntity(text83);
		block8.addElementEntity(element84);	element84.setTxtEntity(text84);
		block8.addElementEntity(element85);	element85.setTxtEntity(text85);
		block8.addElementEntity(element86);	element86.setTxtEntity(text86);
		block8.addElementEntity(element87);	element87.setTxtEntity(text87);
		block8.addElementEntity(element88);	element88.setTxtEntity(text88);
		block8.addElementEntity(element89);	element89.setTxtEntity(text89);
		page.addBlockEntity(block9);
		block9.addElementEntity(element90);	element90.setTxtEntity(text90);
		block9.addElementEntity(element91);	element91.setTxtEntity(text91);
		block9.addElementEntity(element92);	element92.setTxtEntity(text92);
		block9.addElementEntity(element93);	element93.setTxtEntity(text93);
		block9.addElementEntity(element94);	element94.setTxtEntity(text94);
		page.addBlockEntity(block10);
		block10.addElementEntity(element100);	element100.setTxtEntity(text100);
		block10.addElementEntity(element101);	element101.setTxtEntity(text101);
		block10.addElementEntity(element102);	element102.setTxtEntity(text102);
		block10.addElementEntity(element103);	element103.setTxtEntity(text103);
		block10.addElementEntity(element104);	element104.setTxtEntity(text104);
		page.addBlockEntity(block11);
		block11.addElementEntity(element111);	element111.setTxtEntity(text111);
		page.addBlockEntity(block12);
		block12.addElementEntity(element121);	element121.setTxtEntity(text121);
		page.addBlockEntity(block13);
		block13.addElementEntity(element131);	element131.setTxtEntity(text131);
		page.addBlockEntity(block14);
		block14.addElementEntity(element141);	element141.setTxtEntity(text141);
		block14.addElementEntity(element142);	element142.setTxtEntity(text142);
		block14.addElementEntity(element143);	element143.setTxtEntity(text143);
		block14.addElementEntity(element144);	element144.setTxtEntity(text144);
		block14.addElementEntity(element145);	element145.setTxtEntity(text145);
		block14.addElementEntity(element146);	element146.setTxtEntity(text146);
		block14.addElementEntity(element146a);	element146a.setTxtEntity(text146a);
		block14.addElementEntity(element147);	element147.setTxtEntity(text147);
		block14.addElementEntity(element147a);	element147a.setTxtEntity(text147a);
		block14.addElementEntity(element148);	element148.setTxtEntity(text148);
		
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
		
	public void creatingEntitys() {
		//ejb.createCustomer(ce);
		//ejb.createOrder(oe);
		//ejb.createOrderProduct(lop1);
//////		ejb.createComplex(ce, oe, lop1, adr);
		
		//ejb.createAddress(adr);
		//ce/oe/lop1/lop2/adr
		//ce2 = ejb.getCustomerEntity("VasyaPupkin1mailcom","123456");
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
		/////////////////////////////////validator-firm
		adminEJB.createTxtEntity(text80);
		adminEJB.createTxtEntity(text81);
		adminEJB.createTxtEntity(text82);
		adminEJB.createTxtEntity(text83);
		adminEJB.createTxtEntity(text84);
		adminEJB.createTxtEntity(text85);
		adminEJB.createTxtEntity(text86);
		adminEJB.createTxtEntity(text87);
		adminEJB.createTxtEntity(text88);
		adminEJB.createTxtEntity(text89);
		adminEJB.createElementEntity(element80);
		adminEJB.createElementEntity(element81);
		adminEJB.createElementEntity(element82);
		adminEJB.createElementEntity(element83);
		adminEJB.createElementEntity(element84);
		adminEJB.createElementEntity(element85);
		adminEJB.createElementEntity(element86);
		adminEJB.createElementEntity(element87);
		adminEJB.createElementEntity(element88);
		adminEJB.createElementEntity(element89);
		adminEJB.createBlockEntity(block8);
		///////////////////////////////////validator-type-headphones
		adminEJB.createTxtEntity(text90);
		adminEJB.createTxtEntity(text91);
		adminEJB.createTxtEntity(text92);
		adminEJB.createTxtEntity(text93);
		adminEJB.createTxtEntity(text94);
		adminEJB.createElementEntity(element90);
		adminEJB.createElementEntity(element91);
		adminEJB.createElementEntity(element92);
		adminEJB.createElementEntity(element93);
		adminEJB.createElementEntity(element94);
		adminEJB.createBlockEntity(block9);
		///////////////////////////////////validator-tdh
		adminEJB.createTxtEntity(text100);
		adminEJB.createTxtEntity(text101);
		adminEJB.createTxtEntity(text102);
		adminEJB.createTxtEntity(text103);
		adminEJB.createTxtEntity(text104);
		adminEJB.createElementEntity(element100);
		adminEJB.createElementEntity(element101);
		adminEJB.createElementEntity(element102);
		adminEJB.createElementEntity(element103);
		adminEJB.createElementEntity(element104);
		adminEJB.createBlockEntity(block10);
		//////////////////////////////////////text-see-more
		adminEJB.createTxtEntity(text111);
		adminEJB.createElementEntity(element111);
		adminEJB.createBlockEntity(block11);
		////////////////////////////////////////description
		adminEJB.createTxtEntity(text121);
		adminEJB.createElementEntity(element121);
		adminEJB.createBlockEntity(block12);
		////////////////////////////////////////characteristic
		adminEJB.createTxtEntity(text131);
		adminEJB.createElementEntity(element131);
		adminEJB.createBlockEntity(block13);
		///////////////////////////////////////media-object
		adminEJB.createTxtEntity(text141);
		adminEJB.createTxtEntity(text142);
		adminEJB.createTxtEntity(text143);
		adminEJB.createTxtEntity(text144);
		adminEJB.createTxtEntity(text145);
		adminEJB.createTxtEntity(text146);
		adminEJB.createTxtEntity(text146a);
		adminEJB.createTxtEntity(text147);
		adminEJB.createTxtEntity(text147a);
		adminEJB.createTxtEntity(text148);
		adminEJB.createElementEntity(element141);
		adminEJB.createElementEntity(element142);
		adminEJB.createElementEntity(element143);
		adminEJB.createElementEntity(element144);
		adminEJB.createElementEntity(element145);
		adminEJB.createElementEntity(element146);
		adminEJB.createElementEntity(element146a);
		adminEJB.createElementEntity(element147);
		adminEJB.createElementEntity(element147a);
		adminEJB.createElementEntity(element148);
		adminEJB.createBlockEntity(block14);
		
		
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
	}
	public void insertingAttibute(HttpServletRequest request,
            HttpServletResponse response) {
		if(listProductEntity == null){listProductEntity = pagesEJB.allProductEntitys();}
		if(request.getAttribute("page") == null) {request.setAttribute("page", pageTest);}
		if(request.getAttribute("pagemain") == null) {request.setAttribute("pagemain", pagemainTest);}
		if(request.getAttribute("blockmain2") == null) {request.setAttribute("blockmain2", pagemain.getBlockEntity("media-card-container").getBlockEntity("media-card"));}
		if(request.getAttribute("blockmain4") == null) {request.setAttribute("blockmain4", pagemain.getBlockEntity("media-card-container_2").getBlockEntity("media-card"));}
		if(request.getAttribute("blockmainFirm") == null) {request.setAttribute("blockmainFirm", page.getBlockEntity("validator-firm"));}
		if(request.getAttribute("blockmainTypeH") == null) {request.setAttribute("blockmainTypeH", page.getBlockEntity("validator-type-headphones"));}
		if(request.getAttribute("blockmainTDH") == null) {request.setAttribute("blockmainTDH", page.getBlockEntity("validator-tdh"));}
		if(request.getAttribute("listProductEntity") == null) {request.setAttribute("listProductEntity", listProductEntity);}	
///////////////////////////////////////////////////////////////////////////////cartProducts
		String cartProductId = request.getParameter("cartproductId");
		if(cartProductId!=null) {cartSessionEJB.addProductEntityId(Long.valueOf(cartProductId));}
		if(request.getAttribute("cartSessionEJB")==null) {request.setAttribute("cartSessionEJB", cartSessionEJB);}/////////////////////////////////////////////111111111111111111111111
		System.out.println("Number of productId");
		System.out.println(cartProductId);
		String removeCartProductId = request.getParameter("removecartproductId");
		if(removeCartProductId != null) {cartSessionEJB.removeProductEntityId(Long.valueOf(removeCartProductId));}
		System.out.println(cartSessionEJB.sizeproductEntityIds());
/////////////////////////////////////////TestEJB  -   Customer
		if(request.getAttribute("test")==null) {request.setAttribute("test", ejb);}
		if(request.getAttribute("adminTest")==null) {request.setAttribute("adminTest", adminEJB);}
		if(request.getAttribute("managerEJB")==null) {request.setAttribute("managerEJB", managerEJB);}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(singletonEJB.page == false) {
			insertEntitys();
			creatingEntitys();
			singletonEJB.page = true;
		}
		insertingAttibute(request,response);
		
		
		
        response.setContentType("text/html;charset=Windows-1251");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		process(request, response);
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(singletonEJB.page == false) {
			insertEntitys();
			creatingEntitys();
			singletonEJB.page = true;
		}
		insertingAttibute(request,response);
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
		if("Login".equals(action)) {
			
				if(request.getSession().getAttribute("Login") != null) {
					request.getSession().removeAttribute("Login");
					request.getSession().removeAttribute("CustomerId");
				}
					String email = request.getParameter("email");
					String password = request.getParameter("password");
					CustomerEntity ceLog = ejb.getCustomerEntity(email, password);
					if(ceLog != null && email != null && password != null) {
						HttpSession session = request.getSession();
						if(session.getAttribute("Login") == null) {session.setAttribute("Login", "Login");}
						if(session.getAttribute("CustomerId") == null) {session.setAttribute("CustomerId", ceLog.getCustomerId());}
					//	ejb.getCustomerEntity((Long) session.getAttribute("CustomerId")).getCustomerId();
				}
			request.getRequestDispatcher("jsp/LoginPage.jsp").forward(request, response);
			
		}
		if("Registration".equals(action)) {
			String firstname = request.getParameter("firstname");
			String secondname = request.getParameter("secondname");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String sity = request.getParameter("sity");
			String street = request.getParameter("street");
			int house = Integer.parseInt(request.getParameter("house"));
			int apartment = Integer.parseInt(request.getParameter("apartment"));
			String phone = request.getParameter("phone");
			String zipIndex = request.getParameter("zipindex");
			if(firstname != null && secondname != null && email != null && password != null && sity != null && street != null && house > 0 && apartment > 0 && phone != null && zipIndex != null) {
				if(ejb.getCustomerEntity(email) == null) {
					CustomerEntity ceRegistration = new CustomerEntity(firstname, secondname, email, password, sity, street, house, apartment, phone, zipIndex);
					ejb.createCustomer(ceRegistration);
					request.getRequestDispatcher("jsp/SuccessfulRegistration.jsp").forward(request, response);
				}else{
					request.getRequestDispatcher("jsp/FailedRegistration.jsp").forward(request, response);
				}
			}
		}
		if("OrderForm".equals(action)) {
			if(cartSessionEJB.getProductEntityIds().size() > 0) {
				request.getRequestDispatcher("jsp/OrderForm.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("jsp/Cart.jsp").forward(request, response);
			}			
		}
		if("BankSite".equals(action)) {
			if(request.getSession().getAttribute("Login") != "Login") {request.getRequestDispatcher("jsp/LoginPage.jsp").forward(request, response);}
			if(cartSessionEJB.sizeproductEntityIds() > 0 && dataForPurchaseEJB.setAddress(request)) {
				List<Long> productEntityIds = cartSessionEJB.getProductEntityIds();
				dataForPurchaseEJB.setCustomer((Long) request.getSession().getAttribute("CustomerId"));
				dataForPurchaseEJB.setListOrderProductEntity(productEntityIds);
				Long orderId = dataForPurchaseEJB.newOrder(productEntityIds);
				dataForPurchaseEJB.recTransaction();
				request.getSession().setAttribute("orderId", orderId);
				request.getRequestDispatcher("/CheckOrder").forward(request, response);
			/*	String bankUrl = "http://localhost:8080/Minibank/BankServlet/Pay?jsonParams=" 
								+ cartSessionEJB.getTotalPriceJson() 
								+ "&returnUrl=http://localhost:8080/HeadphoneStore/SuccessfulPayment"
								+ "&failUrl=http://localhost:8080/HeadphoneStore/FailedPayment";
				response.sendRedirect(bankUrl);*/
			}else {
				request.getRequestDispatcher("jsp/OrderForm.jsp").forward(request, response);
			}

		}
		/*      POST                              */		
		if("CheckOrder".equals(action) && request.getSession().getAttribute("orderId") != null) {
			request.getRequestDispatcher("jsp/CheckOrder.jsp").forward(request, response);
		}
		//"/AdminstratorDeleteManager","/AdministratorInsertManager"
		if("AdminstratorDeleteManager".equals(action)) {
			String ManagerId;
			if((ManagerId = request.getParameter("ManagerId")) != null) {
				adminEJB.removeManager(Long.parseLong(ManagerId));
				request.getRequestDispatcher("jsp/AdministratorCabinet.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("jsp/AdminstratorDeleteManager.jsp").forward(request, response);
			}
		}
		if("AdministratorInsertManager".equals(action)) {
			String FirstName;
			String SecondName;
			String Email;
			String Password;
			String Sity;
			String Street;
			Integer House;
			Integer Apartment;
			String PhoneNumber;
			if((FirstName = request.getParameter("firstname")) != null && 
				(SecondName = request.getParameter("secondname")) != null && 
				(Email = request.getParameter("email")) != null && 
				(Password = request.getParameter("password")) != null && 
				(Sity = request.getParameter("sity")) != null && 
				(Street = request.getParameter("street")) != null && 
				(House = Integer.parseInt(request.getParameter("house"))) != null && 
				(Apartment = Integer.parseInt(request.getParameter("apartment"))) != null &&
				(PhoneNumber = request.getParameter("phone")) != null) {
					adminEJB.createManager(FirstName, SecondName, Email, Password, Sity, Street, House, Apartment, PhoneNumber);
					request.getRequestDispatcher("jsp/AdministratorCabinet.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("jsp/AdministratorInsertManager.jsp").forward(request, response);
			}
		}
		if("LoginManager".equals(action)) {
			String managerId;
			String email;
			String password;
			if((managerId = request.getParameter("id")) != null &&
				(email = request.getParameter("email")) != null &&
				(password = request.getParameter("password")) != null) {
				HttpSession session = request.getSession();
				session.setAttribute("LoginManager", "LoginManager");
				session.setAttribute("managerId", managerId);
			}
		}

		/*process(request, response);
		*/
	}
	
	private void process(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
		String dispatchUrl = null;

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////Session_Login_test
		//HttpSession session = request.getSession();
		//session.setAttribute("Login", "Login");
		
//////////////////////////////////////////////////////////////////////////////"/Delivery","/AboutCompany","/Contacts","/Catalog","/Product"
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
			request.setAttribute("product", null);
			this.productId = Long.parseLong(request.getParameter("productId"));
			
			request.setAttribute("product", pagesEJB.getProductEntityById(productId));
			request.setAttribute("productId", this.productId);
			dispatchUrl = "jsp/Product.jsp";
		}else if("Cart".equals(action)) {
			dispatchUrl = "jsp/Cart.jsp";
		}else if("Login".equals(action)) {
			dispatchUrl = "jsp/LoginPage.jsp";
		}else if("Registration".equals(action)) {
			dispatchUrl = "jsp/Registration.jsp";
		}else if("Cabinet".equals(action)) {
			dispatchUrl = "jsp/Cabinet.jsp";
		}else if("ProcessingOrder".equals(action)) {
			dispatchUrl = "jsp/ProcessingOrder.jsp";
		}else if("ToManagerOrder".equals(action)) {
			dispatchUrl = "jsp/ToManagerOrder.jsp";
		}else if("PayOrder".equals(action)) {
			dispatchUrl = "jsp/PayOrder.jsp";
		}else if("FinishedOrder".equals(action)) {
			dispatchUrl = "jsp/FinishedOrder.jsp";
		}else if("AdministratorAllUsers".equals(action)) {
			dispatchUrl = "jsp/AdministratorAllUsers.jsp";
		}else if("SuccessfulPayment".equals(action)) {
			Long PaymentId = Long.parseLong(request.getParameter("PaymentId"));
			System.out.println(" PaymentId ----------HS---------------------  " + PaymentId);
/*Error*/
			String POST_PARAMS = "PaymentId=" + String.valueOf(PaymentId);
			String stringURL= "http://localhost:8080/MiniBank/BankServlet/VerifyPayment";
			String VerifyJson = Logic.UrlHttpWebServer.producerPOST(stringURL, POST_PARAMS);
			Jsonb jsonb = JsonbBuilder.create();
			Logic.ResultPaymentJson rpj = rpj = jsonb.fromJson(VerifyJson, Logic.ResultPaymentJson.class);
			System.out.println("  verify ------------------------     " + rpj.errorCode + "    " + rpj.errorMessage + "      " + rpj.OrderNumber);
			OrderEntity orderEntity = ejb.getOrderEntityById(rpj.OrderNumber);
			System.out.println(" OrderId -------------------------------  " + orderEntity.getOrderId());	
			orderEntity.setPaymentId(PaymentId);
			orderEntity.setPaid(true);
			ejb.mergeOrder(orderEntity);
			dispatchUrl = "jsp/SuccessfulPayment.jsp";
		}else if("FailedPayment".equals(action)) {
			dispatchUrl = "jsp/FailedPayment.jsp";
		}else if("TestFile".equals(action)) {
			dispatchUrl = "jsp/TestFile.jsp";
		}else if("NonPayOrder".equals(action)) {
			dispatchUrl = "jsp/NonPayOrder.jsp";
		}else if("AdministratorAllOrders".equals(action)){
			dispatchUrl = "jsp/AdministratorAllOrders.jsp";
		}else if("AdministratorAllNonPayOrders".equals(action)){
			dispatchUrl = "jsp/AdministratorAllNonPayOrders.jsp";
		}else if("AdministratorAllPayOrders".equals(action)){
			dispatchUrl = "jsp/AdministratorAllPayOrders.jsp";
		}else if("AdministratorAllProcessingOrders".equals(action)){
			dispatchUrl = "jsp/AdministratorAllProcessingOrders.jsp";
		}else if("AdministratorAllTransferedManagerOrders".equals(action)){
			dispatchUrl = "jsp/AdministratorAllTransferedManagerOrders.jsp";
		}else if("AdministratorAllClosedOrders".equals(action)){
			dispatchUrl = "jsp/AdministratorAllClosedOrders.jsp";
		}else if("AdministratorCabinet".equals(action)){
			dispatchUrl = "jsp/AdministratorCabinet.jsp";
		}else if("AdministratorProduct".equals(action)){
			dispatchUrl = "jsp/AdministratorProduct.jsp";
		}else if("AdministratorOrders".equals(action)){
			dispatchUrl = "jsp/AdministratorOrders.jsp";
		}else if("AdministratorCustomers".equals(action)){
			dispatchUrl = "jsp/AdministratorCustomers.jsp";
		}else if("AllOrders".equals(action)){
			dispatchUrl = "jsp/AllOrders.jsp";
		}else if("AdministratorManagers".equals(action)){
			dispatchUrl = "jsp/AdministratorManagers.jsp";
		}else if("AdminstratorDeleteManager".equals(action)){
			dispatchUrl = "jsp/AdminstratorDeleteManager.jsp";
		}else if("AdministratorInsertManager".equals(action)){
			dispatchUrl = "jsp/AdministratorInsertManager.jsp";
		}else if("AdministratorAllManagers".equals(action)){
			dispatchUrl = "jsp/AdministratorAllManagers.jsp";
		}else if("ManagersData".equals(action)){
			dispatchUrl = "jsp/ManagersData.jsp";
		}else if("ManagerCabinet".equals(action)){
			dispatchUrl = "jsp/ManagerCabinet.jsp";
		}else if("ManagerOrders".equals(action)){
			dispatchUrl = "jsp/ManagerOrders.jsp";
		}else if("ManagersClosedOrders".equals(action)){
			dispatchUrl = "jsp/ManagersClosedOrders.jsp";
		}else if("LoginManager".equals(action)){
			dispatchUrl = "jsp/LoginManager.jsp";
		}else if("Exit".equals(action)) {
				request.getSession().removeAttribute("Login");
				request.getSession().removeAttribute("CustomerId");
				dispatchUrl = "jsp/Test_JSP.jsp";
		}else if("ExitManager".equals(action)) {
			request.getSession().removeAttribute("LoginManager");
			request.getSession().removeAttribute("managerId");
			dispatchUrl = "jsp/Test_JSP.jsp";
		}
          //"/ManagersData","/ManagerOrders","/ManagersClosedOrders"                            
		/*"/AdministratorManagers","/AdminstratorDeleteManager","/AdministratorInsertManager", AdministratorAllManagers*/
		//"/AdministratorCabinet","/AdministratorProduct","/AdministratorOrders","/AdministratorCustomers"
		//test.getCustomerEntity(session.getAttribute("CustomerId"))getListOrderEntity()
		RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
        rd.forward(request, response);
	}

}
