package controller_view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import model.AccountsCollection;

// KIANNY CALVO

public class LoginCreateAccountPane extends GridPane {

	private Label instructions = new Label("Login or Create Account");
	private Label userLabel = new Label("Username:");
	private Label passLabel = new Label("Password:");
	private TextField userText = new TextField();
	private PasswordField passText = new PasswordField();
	private Button loginButton = new Button("Login");
	private Button createButton = new Button("Create Account");
	private Text message = new Text("");
	private AccountsCollection accounts = new AccountsCollection();

	public LoginCreateAccountPane() {
		accounts.load();
		this.setAlignment(Pos.CENTER);
		this.setHgap(10);
		this.setVgap(10);
		this.setPadding(new Insets(25, 25, 25, 25));

		this.add(instructions, 0, 0, 4, 1);
		this.add(message, 0, 1);
		this.add(userLabel, 0, 2);
		this.add(userText, 1, 2);
		this.add(passText, 1, 3);
		this.add(passLabel, 0, 3);
		this.add(loginButton, 0, 4);
		this.add(createButton, 1, 4);

		message.setFont(Font.font("Verdana", FontPosture.ITALIC, 8));
		// set color to red after further project modification

		registarEventHandlers();
	}

	private void registarEventHandlers() {
		loginButton.setOnAction((event) -> {
			String userId = userText.getText();
			String password = passText.getText();
			String loginMessage = accounts.login(userId, password);
			if (userId.equals("") || password.equals("")) {
				message.setText(isEmpty(userId, password));
				message.setFill(Color.RED);
			} else if (!(loginMessage.equals("success"))) {
				message.setText(loginMessage);
				message.setFill(Color.RED);
			} else {
				// after merge and creation of other panels will return an Account
				message.setText(loginMessage);
				message.setFill(Color.GREEN);
			}
		});

		createButton.setOnAction((event) -> {
			String userId = userText.getText();
			String password = passText.getText();
			String createMessage = accounts.createAccount(userId, password);
			if (userId.equals("") || password.equals("")) {
				message.setText(isEmpty(userId, password));
				message.setFill(Color.RED);
			} else if (!(createMessage.equals("success"))) {
				message.setText(createMessage);
				message.setFill(Color.RED);
			} else {
				// after merge and creation of other panels will return an Account
				accounts.save(true);
				message.setText(createMessage);
				message.setFill(Color.GREEN);
			}
		});

	}

	private String isEmpty(String userId, String password) {
		if (userId.equals("")) {
			return "please provide a username";
		} else {
			return "please provide a password";
		}
	}

}