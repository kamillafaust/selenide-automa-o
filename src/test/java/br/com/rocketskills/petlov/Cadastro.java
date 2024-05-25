
package br.com.rocketskills.petlov;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class Cadastro {

	// WebDriver driver;

	// @BeforeEach
	// void start() {
	//   driver = new ChromeDriver();
	// 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	// }

	// @AfterEach
	// void finish() {
	// 	driver.close();
	// }

	@Test
	@DisplayName("Deve poder cadastrar um ponto de doação")
	void createPoint() {

		open("https://petlov.vercel.app/signup");
		$("h1").shouldHave(text("Cadastro de ponto de doação"));
    $("input[name='name']").setValue("Kamilla Point");
    $("input[name='email']").setValue("kamilla@email.com");
    $("input[name='cep']").setValue("88111380");
    $("input[value='Buscar CEP']").click();
    $("input[name='addressNumber']").setValue("1234");
    $("input[name='addressDetails']").setValue("Ao lado da padaria");
    $(By.xpath("//span[text()=\"Cachorros\"]/..")).click();
    $(".button-register").click();
    String target = "Seu ponto de doação foi adicionado com sucesso. Juntos, podemos criar um mundo onde todos os animais recebam o amor e cuidado que merecem.";
    $("#success-page p").shouldHave(text(target));
	}
}
