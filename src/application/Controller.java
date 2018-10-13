package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.util.Random;

public class Controller {
	@FXML private Button arigatou;
	private Main main;
	@FXML private TextField seedField;
	private Enigma enigma;
	@FXML private TextArea textArea;
	private Random random;
	
	public void openEnigma() {
		arigatou.getScene().getWindow().hide();
		main = new Main();
		main.enigma();
	}
	//aa
	public void decryptMessage() {
		try {
			enigma = new Enigma(Long.parseLong(seedField.getText()), textArea.getText());
			textArea.setText(enigma.decrypter());
		}
		catch (Exception e) {
		}
	}
	
	public void encryptMessage() {
		try {
			enigma = new Enigma(Long.parseLong(seedField.getText()), textArea.getText());
			textArea.setText(enigma.encrypter());
		}
		catch (Exception e) {
		}
	}
	
	public void generateSeed() {
		random = new Random();
		seedField.setText(Long.toString(random.nextLong()));
	}
}