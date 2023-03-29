package application;

import java.io.IOException;
import java.time.LocalDate;

import Planner.Artist;
import Planner.Attendee;
import Planner.Concert;
import Planner.ConcertWatcher;
import Planner.Dates;
import Planner.EventPlanner;
import Planner.Transaction;
import Planner.User;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class GUI extends Application {
	
	
	Group root = new Group();
	Scene scene = new Scene(root,400,750,Color.MINTCREAM);
	Stage stage = new Stage();
	ConcertWatcher CW = new ConcertWatcher();
	String current = "guest";
	String name = null;
	TableView<String[]> table;
	
	Image logo = new Image("logo.png");
	ImageView logoIV = new ImageView(logo);
	
	Image code = new Image("code.png");
	ImageView codeIV = new ImageView(code);
	
	Button loginBT = new Button("Login");
	Button registerBT = new Button("Register");
	Button back = new Button("Back");
	Button backfromAC = new Button("Back");
	Button backfromShow = new Button("Back");
	Button createConcert = new Button("Create Concert");
	Button buyTicket = new Button("Buy Ticket");
	Button loginAsCG = new Button("Login as Concert-Goer");
	Button loginAsCO = new Button("Login as Concert Organiser");
	Button backBuy = new Button("Back");
	
	@Override
	public void start(Stage primaryStage) throws IOException {
			
		back.setLayoutX(150);
		back.setLayoutY(580);
		back.setPrefWidth(100);
		back.setPrefHeight(50);
		
		backfromAC.setLayoutX(150);
		backfromAC.setLayoutY(580);
		backfromAC.setPrefWidth(100);
		backfromAC.setPrefHeight(50);
		
		backfromShow.setLayoutX(150);
		backfromShow.setLayoutY(680);
		backfromShow.setPrefWidth(100);
		backfromShow.setPrefHeight(40);
		
		backBuy.setLayoutX(150);
		backBuy.setLayoutY(680);
		backBuy.setPrefWidth(100);
		backBuy.setPrefHeight(40);
		
		buyTicket.setLayoutX(125);
		buyTicket.setLayoutY(580);
		buyTicket.setPrefWidth(150);
		buyTicket.setPrefHeight(50);
		
		loginBT.setLayoutX(100);
		loginBT.setLayoutY(410);
		loginBT.setPrefWidth(200);
		loginBT.setPrefHeight(50);
		
		registerBT.setLayoutX(100);
		registerBT.setLayoutY(480);
		registerBT.setPrefWidth(200);
		registerBT.setPrefHeight(50);
		
		createConcert.setLayoutX(10);
		createConcert.setLayoutY(710);
		
		Text loginInfo = new Text("Hello, guest");
		loginInfo.setX(10);
		loginInfo.setY(135);
		loginInfo.setFont(new Font(17)); 
		
		loginAsCG.setLayoutX(10);
		loginAsCG.setLayoutY(150);
		loginAsCG.setPrefWidth(180);
		loginAsCG.setPrefHeight(35);
		
		loginAsCO.setLayoutX(210);
		loginAsCO.setLayoutY(150);
		loginAsCO.setPrefWidth(180);
		loginAsCO.setPrefHeight(35);
		
		logoIV.setX(0);
		logoIV.setY(15);
		logoIV.setFitWidth(400);
		logoIV.setFitHeight(80);
		
		Text info = new Text("");
		info.setX(100);
		info.setY(385);
		
	    table = new TableView<>();
		table.setLayoutX(10);
		table.setLayoutY(200);
		table.setPrefWidth(380);
		table.setPrefHeight(500);
		table.setStyle(".table-cell {-fx-text-fill: blue; -fx-font-size: 16px;}");
		
		TableColumn<String[], String> ConcertName = new TableColumn<>("Concert name");
		ConcertName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[0]));
		ConcertName.setStyle("-fx-alignment: CENTER;");
		ConcertName.setMinWidth(180);
		
		TableColumn<String[], String> Artist = new TableColumn<>("Artist");
		Artist.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[1]));
		Artist.setStyle("-fx-alignment: CENTER;");
		Artist.setMinWidth(130);
		
		TableColumn<String[], String> Price = new TableColumn<>("Price");
		Price.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[2]));
		Price.setStyle("-fx-alignment: CENTER;");
		Price.setMinWidth(68);
		
		
		table.getColumns().add(ConcertName);
		table.getColumns().add(Artist);
		table.getColumns().add(Price);
		
		CW.search(table);
		
		backfromAC.setOnAction(event->{
			root.getChildren().add(logoIV);
			stage.setScene(scene);
			stage.setTitle("TourMate");
			CW.search(table);
		});
		
		backfromShow.setOnAction(event->{
			root.getChildren().add(logoIV);
			stage.setScene(scene);
			stage.setTitle("TourMate");
			CW.search(table);
		});
		
		back.setOnAction(event->{
			stage.setScene(scene);
			stage.setTitle("TourMate");
			CW.search(table);
		});
		
		
		table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue != null && newValue.length > 0) {
				
			codeIV.setX(230);
			codeIV.setY(400);
			codeIV.setFitHeight(130);
			codeIV.setFitWidth(130);
			
			Group r = new Group();
			Scene s = new Scene(r,400,750,Color.MINTCREAM);
			String l = newValue[0];
			Rectangle rct = new Rectangle();
			
			int offset = 70;
			int top = 150;
			int left = 40;
			
			Font font = Font.font("Verdana", FontWeight.EXTRA_LIGHT, FontPosture.ITALIC, 20);
		
			rct.setX(25);
			rct.setY(110);
			rct.setWidth(350);
			rct.setHeight(440);
			rct.setStyle("-fx-fill: white; -fx-stroke: black; -fx-stroke-width: 2;");
			
			String[] values = CW.find(l);
			
			Text InfoName = new Text();
			InfoName.setX(left);
			InfoName.setY(top);
			InfoName.setFont(font);
			InfoName.setText("Name of Concert:\n  "+values[1]);
			
			Text InfoOrganizer = new Text();
			InfoOrganizer.setX(left);
			InfoOrganizer.setY(top+2*offset);
			InfoOrganizer.setFont(font);
			InfoOrganizer.setText("Organizer:\n  "+values[0]);
			
			Text InfoArtist = new Text();
			InfoArtist.setX(left);
			InfoArtist.setY(top+offset);
			InfoArtist.setFont(font);
			InfoArtist.setText("Artist:\n  "+values[2]);
			
			Text InfoDate = new Text();
			InfoDate.setX(left);
			InfoDate.setY(top+3*offset);
			InfoDate.setFont(font);
			InfoDate.setText("Date:\n  "+values[4]+". "+values[5]+". "+values[6]);
			
			Text InfoPrice = new Text();
			InfoPrice.setX(left);
			InfoPrice.setY(top+4*offset);
			InfoPrice.setFont(font);
			InfoPrice.setText("Price:\n  "+values[3]+" €");
			
			Text InfoLocation = new Text();
			InfoLocation.setX(left);
			InfoLocation.setY(top+5*offset);
			InfoLocation.setFont(font);
			InfoLocation.setText("Location:\n  "+values[7]);
			
			Text IsBuy = new Text();
			IsBuy.setX(110);
			IsBuy.setY(620);
			IsBuy.setFont(font);
			
			Transaction t = new Transaction();
			
			r.getChildren().add(rct);
			r.getChildren().add(IsBuy);
			r.getChildren().add(InfoLocation);
			r.getChildren().add(InfoPrice);
			r.getChildren().add(InfoDate);
			r.getChildren().add(InfoArtist);
			r.getChildren().add(InfoOrganizer);
			r.getChildren().add(InfoName);
			r.getChildren().add(backfromShow);
			r.getChildren().add(logoIV);
			r.getChildren().add(buyTicket);
			
			if(t.find(current, values[1])) {
				IsBuy.setText("Already Purchased");
				r.getChildren().add(codeIV);
				r.getChildren().remove(buyTicket);
			}
			
			buyTicket.setOnAction(e->{
				if(current.equals("guest") || current.equals("promoter")) {
					Alert a = new Alert(AlertType.INFORMATION);
					a.setTitle("Guest");
					a.setContentText("You have to login to buy ticket");
					
					Stage x = (Stage) a.getDialogPane().getScene().getWindow();
					x.getIcons().add(new Image("icon.png"));

					a.showAndWait();
				} else {
				
					Group buyRoot = new Group();
					Scene buyScene = new Scene(buyRoot,400,750,Color.MINTCREAM);
					
					Button Purchase = new Button("Purchase");
					Purchase.setLayoutX(125);
					Purchase.setLayoutY(580);
					Purchase.setPrefWidth(150);
					Purchase.setPrefHeight(50);
					
					TextField cardNum = new TextField();				
					cardNum.setLayoutX(50);
					cardNum.setLayoutY(200);
					cardNum.setMinWidth(300);
					cardNum.setMinHeight(50);
					
					TextField dateEx = new TextField();
					dateEx.setLayoutX(50);
					dateEx.setLayoutY(310);
					dateEx.setPrefWidth(100);
					dateEx.setMinHeight(50);
					
					TextField CVN = new TextField();
					CVN.setLayoutX(250);
					CVN.setLayoutY(310);
					CVN.setPrefWidth(100);
					CVN.setMinHeight(50);
					
					Text cardN = new Text("Enter card number:");
					cardN.setX(50);
					cardN.setY(190);
					
					Text cardD = new Text("Enter expiration date: ");
					cardD.setX(50);
					cardD.setY(300);
					
					Text cardC = new Text("Enter CV: ");
					cardC.setX(250);
					cardC.setY(300);
					
					Text infoPay = new Text("You will pay: "+values[3]+"€");
					infoPay.setY(500);
					infoPay.setX(80);
					infoPay.setStyle("-fx-font-size: 30px;");
										
					buyRoot.getChildren().add(infoPay);
					buyRoot.getChildren().add(cardD);
					buyRoot.getChildren().add(cardC);
					buyRoot.getChildren().add(Purchase);
					buyRoot.getChildren().add(CVN);
					buyRoot.getChildren().add(dateEx);
					buyRoot.getChildren().add(cardN);
					buyRoot.getChildren().add(cardNum);
					buyRoot.getChildren().add(backBuy);
					buyRoot.getChildren().add(logoIV);
					
					backBuy.setOnAction(e2 ->{
						r.getChildren().add(logoIV);
						stage.setScene(s);
					});
					
					Purchase.setOnAction(e2 ->{
					if(cardNum.getText().length()<16 && dateEx.getText().length() ==4 && CVN.getText().length() == 3) {
					
						infoPay.setText("Purchase succseful");
						new Transaction(current,values[1],cardNum.getText(),values[3]);
						loginInfo.setText("Ticket on ("+values[1] +") purchased");
						
						backfromShow.fire();
						
		
					}else {
						infoPay.setText("Incorrect Info");
					}});
					
					stage.setScene(buyScene);
				}
			});
			
			stage.setScene(s);
			}
		});
		

		table.setFixedCellSize(40);
		
		root.getChildren().add(loginAsCG);
		root.getChildren().add(loginAsCO);
		root.getChildren().add(loginInfo);
		root.getChildren().add(logoIV);
		root.getChildren().add(table);
		
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("TourMate");
        stage.getIcons().add(new Image("icon.png"));
		stage.show();
		
		loginAsCG.setOnAction(event ->{
			if(loginAsCG.getText().equals("Log out")) {
				System.out.println("Logging out");
				loginAsCG.setText("Login as Concert-Goer");
				loginInfo.setText("Goodbye, " + current);
				current = "guest";
			} else {
				Scene l = CGloginPage(logoIV,loginInfo);
				stage.setScene(l);
			}
		});
		
		loginAsCO.setOnAction(event ->{
			if(loginAsCO.getText().equals("Log out")) {
				System.out.println("Logging out");
				loginAsCO.setText("Login as Concert Organiser");
				loginInfo.setText("Goodbye, " + current);
				current="guest";
				root.getChildren().remove(createConcert);
			} else {
				Scene k = COloginPage(logoIV, loginInfo, stage);
				stage.setScene(k);
			}
		});
		
		createConcert.setOnAction(e ->{
			Scene j = ConcertMaker(back,name);
			stage.setScene(j);
		});
	}
		
		Scene ConcertMaker(Button back, String name) {
			
			Group CMroot = new Group();
			Scene CMs = new Scene(CMroot,400,750,Color.MINTCREAM);
			
			Text Name = new Text("Create a concert");
			Name.setX(100);
			Name.setY(135);
			Name.setFont(Font.font("Arial", 20));
			
			TextField NameInput = new TextField();
			NameInput.setPromptText("Concert Name");
			NameInput.setLayoutX(100);
			NameInput.setLayoutY(150);
			NameInput.setPrefWidth(200);
			NameInput.setPrefHeight(45);
			
			TextField ArtistInput = new TextField();
			ArtistInput.setPromptText("Artist");
			ArtistInput.setLayoutX(100);
			ArtistInput.setLayoutY(210);
			ArtistInput.setPrefWidth(200);
			ArtistInput.setPrefHeight(45);
			
			TextField PlaceInput = new TextField();
			PlaceInput.setPromptText("Place");
			PlaceInput.setLayoutX(100);
			PlaceInput.setLayoutY(270);
			PlaceInput.setPrefWidth(200);
			PlaceInput.setPrefHeight(45);
			
			DatePicker datePick = new DatePicker();
			datePick.setPromptText("Date");
			datePick.setLayoutX(100);
			datePick.setLayoutY(330);
			datePick.setPrefHeight(45);
			datePick.setPrefWidth(200);
			
			TextField PriceInput = new TextField();
			PriceInput.setPromptText("Price");
			PriceInput.setLayoutX(100);
			PriceInput.setLayoutY(390);
			PriceInput.setPrefWidth(200);
			PriceInput.setPrefHeight(45);
			
			Text info = new Text("");
			info.setX(100);
			info.setY(460);
			
			Button submit = new Button("Create Event");
				submit.setLayoutX(100);
				submit.setLayoutY(480);
				submit.setPrefWidth(200);
				submit.setPrefHeight(45);
				
				
			submit.setOnAction(e ->{
				if(!NameInput.getText().isEmpty() &&
						!ArtistInput.getText().isEmpty() && 
						datePick.getValue() != null && 
						!PriceInput.getText().isEmpty() && 
						!PlaceInput.getText().isEmpty()) {
					LocalDate ld = datePick.getValue();
					Dates d = new Dates(ld.getDayOfMonth(),ld.getMonthValue(),ld.getYear());
					Artist a = new Artist(ArtistInput.getText());
					
					new Concert(name,NameInput.getText(),a,Float.parseFloat(PriceInput.getText()),d,PlaceInput.getText());
					
					info.setStroke(Color.GREEN);
					info.setText("Concert was added");	
				} else {
					info.setStroke(Color.RED);
					info.setText("Fill all fields");
					Alert a = new Alert(AlertType.INFORMATION);
						a.setTitle("Fill all fields");
						a.setContentText("You have to fill all the fields to create a Concert");
					
					Stage x = (Stage) a.getDialogPane().getScene().getWindow();
						x.getIcons().add(new Image("icon.png"));

						a.showAndWait();
				}
			});
			
			CMroot.getChildren().add(NameInput);
			CMroot.getChildren().add(ArtistInput);
			CMroot.getChildren().add(back);
			CMroot.getChildren().add(submit);
			CMroot.getChildren().add(datePick);
			CMroot.getChildren().add(PriceInput);
			CMroot.getChildren().add(info);
			CMroot.getChildren().add(Name);
			CMroot.getChildren().add(PlaceInput);
			
			return CMs;
		}
		
		Scene CGloginPage(ImageView logo, Text i) {
			
			Group CGRoot = new Group();
			Scene CGlogin = new Scene(CGRoot,400,750,Color.MINTCREAM);
			
			Text nameInfo = new Text("Enter login name:");
			nameInfo.setX(100);
			nameInfo.setY(200);
			
			Text passInfo = new Text("Enter password:");
			passInfo.setX(100);
			passInfo.setY(290);
			
			Text loginInfo = new Text("");
			loginInfo.setX(100);
			loginInfo.setY(360);
			
			TextField namein = new TextField();
			namein.setTranslateX(100);
			namein.setTranslateY(210);
			namein.setPrefWidth(200);
			namein.setPrefHeight(45);
			namein.setPromptText("Enter name");
			
			PasswordField passin = new PasswordField();
			passin.setTranslateX(100);
			passin.setTranslateY(300);
			passin.setPrefWidth(200);
			passin.setPrefHeight(45);
			passin.setPromptText("Enter password");
			
			loginBT.setText("Login as Concert-Goer");
		
			registerBT.setText("Register new Concert-Goer");
			
			CGRoot.getChildren().add(loginBT);
			CGRoot.getChildren().add(registerBT);
			CGRoot.getChildren().add(backfromAC);
			CGRoot.getChildren().add(namein);
			CGRoot.getChildren().add(passin);
			CGRoot.getChildren().add(logo);
			CGRoot.getChildren().add(nameInfo);
			CGRoot.getChildren().add(passInfo);
			CGRoot.getChildren().add(loginInfo);
			
			registerBT.setOnAction(event -> {
				User a = new Attendee(namein.getText(),passin.getText());
				try {
				
					if(a.addToList()) {
						loginInfo.setStroke(Color.RED);
						loginInfo.setText("Registration Failed");
					} else {
						loginInfo.setStroke(Color.GREEN);
						loginInfo.setText("Registration Succesful");
					}
					
				} catch (IOException e) {
					e.printStackTrace();
					loginInfo.setStroke(Color.RED);
					loginInfo.setText("Registration Failed");
				}
				
			});		
			
			loginBT.setOnAction(event ->{
				User a = new Attendee();
				
				try {
					if(a.find(namein.getText(), passin.getText())) {
						i.setText("Hello, "+namein.getText());
						loginAsCG.setText("Log out");
						current = namein.getText();
						
						stage.setScene(scene);
						stage.setTitle("TourMate");
						root.getChildren().add(logoIV);
						
					} else {
						loginInfo.setStroke(Color.RED);
						loginInfo.setText("Login Failed");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			});
			
			return CGlogin;
		}

		Scene COloginPage(ImageView logo, Text i, Stage stage) {
			
			Group CORoot = new Group();
			Scene COlogin = new Scene(CORoot,400,750,Color.MINTCREAM);
			
			Text nameInfo = new Text("Enter login name:");
			nameInfo.setX(100);
			nameInfo.setY(200);
			
			Text passInfo = new Text("Enter password:");
			passInfo.setX(100);
			passInfo.setY(290);
			
			Text loginInfo = new Text("");
			loginInfo.setX(100);
			loginInfo.setY(360);
			
			
			TextField namein = new TextField();
			namein.setTranslateX(100);
			namein.setTranslateY(210);
			namein.setPrefWidth(200);
			namein.setPrefHeight(45);
			namein.setPromptText("Enter name");
			
			PasswordField passin = new PasswordField();
			passin.setTranslateX(100);
			passin.setTranslateY(300);
			passin.setPrefWidth(200);
			passin.setPrefHeight(45);
			passin.setPromptText("Enter password");
			
			loginBT.setText("Login as Concert Organizer");
		
			registerBT.setText("Register new Concert Organizer");
			
			CORoot.getChildren().add(loginBT);
			CORoot.getChildren().add(registerBT);
			CORoot.getChildren().add(backfromAC);
			CORoot.getChildren().add(namein);
			CORoot.getChildren().add(passin);
			CORoot.getChildren().add(logo);
			CORoot.getChildren().add(nameInfo);
			CORoot.getChildren().add(passInfo);
			CORoot.getChildren().add(loginInfo);
			
			registerBT.setOnAction(event -> {
				User ep = new EventPlanner(namein.getText(),passin.getText());
				try {
				
					if(ep.addToList()) {
						loginInfo.setStroke(Color.RED);
						loginInfo.setText("Registration Failed");
					}else {
						loginInfo.setStroke(Color.GREEN);
						loginInfo.setText("Registration Succesful");
					}
					
				} catch (IOException e) {
					e.printStackTrace();
					loginInfo.setStroke(Color.RED);
					loginInfo.setText("Registration Failed");
				}
				
			});		
			
			loginBT.setOnAction(event ->{
				User ep = new EventPlanner();
				
				try {
					if(ep.find(namein.getText(), passin.getText())) {	
						Scene temp = ConcertMaker(backfromAC,namein.getText());
						stage.setScene(temp);
						name = namein.getText();
						i.setText("Hello, "+namein.getText());
						loginAsCO.setText("Log out");
						root.getChildren().add(createConcert);
						
						current = "promoter";
					} else {
						loginInfo.setStroke(Color.RED);
						loginInfo.setText("Login Failed");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			});
			return COlogin;
		}
		
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
