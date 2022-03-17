package Pages.Login;

import Helpers.Helpers;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class Page_Login {

    public WebDriver driver; //Declaro Objeto Driver.
    public Helpers helpers;

    public Page_Login(WebDriver driver) {  //Metodo Constructor de la Clase.
        this.driver = driver;
        helpers = new Helpers(driver);
    }

    /**
     * ---------------------------------------------------------------------------------------------------------
     * WebElements // WebElements // WebElements // WebElements // WebElements // WebElements // WebElements //
     * ---------------------------------------------------------------------------------------------------------
     */

    public By HolaInicioSesion = By.xpath("//div[@class='Popover-module_popover-container__3qpkj Popover-module_bottom-caret-notlogin__19OPO']");
    public By Btn_InicioSesion = By.xpath("//a[contains(@id,'testId-loggedout-item-0')]");
    public By Mail = By.xpath("//input[contains(@id,'testId-cc-login-form-email-input')]");
    public By Pass = By.xpath("//input[contains(@id,'testId-cc-login-form-password-input')]");
    public By Ingresar_Button = By.xpath("//button[contains(@id,'testId-cc-login-form-submit')]");
    public By HolaUser = By.xpath("//p[@class='UserInfo-module_display1__1TD_E'][contains(.,'Hola, Marco')]");


    /**
     * -----------------------------------------------------------------------------------------------------------
     * Funciones // Funciones //  Funciones //  Funciones //  Funciones //  Funciones //  Funciones //  Funciones
     * -----------------------------------------------------------------------------------------------------------
     */

    @Step("Ingresar al menu para iniciar sesión")
    public void menuInicioSesion(){
        helpers.ActionsMoveToAndClick(HolaInicioSesion, Btn_InicioSesion);
        driver.switchTo().activeElement();
    }

    @Step("Genero el Login")
    public void makeLogin(String user, String password) {
        helpers.explicitWait_visibilityOfElementLocated(Mail);
        helpers.sendText(Mail, helpers.readConfigUsersParameters(user));
        helpers.sendText(Pass, helpers.readConfigUsersParameters(password));
        helpers.click(Ingresar_Button);
    }

    @Step("Validar inicio de sesion")
    public boolean validacionLogin(){
        return helpers.explicitWait_textToBePresentInElementLocated(HolaUser,"Hola, Marco");
    }
}
