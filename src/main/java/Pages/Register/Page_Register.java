package Pages.Register;

import Helpers.Helpers;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Helpers.DataRandom;

public class Page_Register {

    public WebDriver driver; //Declaro Objeto Driver.
    public Helpers helpers;
    public DataRandom data;

    public Page_Register(WebDriver driver) {  //Metodo Constructor de la Clase.
        this.driver = driver;
        helpers = new Helpers(driver);
    }

    /**
     * ---------------------------------------------------------------------------------------------------------
     * WebElements // WebElements // WebElements // WebElements // WebElements // WebElements // WebElements //
     * ---------------------------------------------------------------------------------------------------------
     */

    public By CloseModalInicio = By.xpath("//div[contains(@class,'dy-lb-close')]");
    public By Btn_Register = By.xpath("//a[@id='testId-loggedout-item-1']");
    public By LogoFalabella = By.xpath("//button[@id='testId-Button-submit']");
    public By HolaInicioSesion = By.xpath("//div[@class='Popover-module_popover-container__3qpkj Popover-module_bottom-caret-notlogin__19OPO']");
    public By RegisterH1 = By.xpath("(//h1[contains(.,'Regístrate')])[2]");
    public By Nombre = By.xpath("//input[@id='testId-Input-firstName']");
    public By PrimerApellido = By.xpath("//input[@id='testId-Input-lastName']");
    public By Rut = By.xpath("//input[@id='testId-Input-document']");
    public By Celular = By.xpath("//input[@id='testId-Input-phoneNumber']");
    public By CorreoElectronico = By.xpath("//input[@id='testId-Input-email']");
    public By Pass = By.xpath("//input[@id='testId-Input-password']");
    public By BarraBus = By.xpath("//input[@class='SearchBar-module_searchBar__Input__1kPKS']");
    public By YaTienesUnaCuenta = By.xpath("//span[@class='copy3 primary  jsx-3743296357 normal  '][contains(.,'Ya tienes una cuenta Falabella')]");
    public By Registrarme = By.xpath("//button[@id='testId-Button-submit']");



    /**
     * -----------------------------------------------------------------------------------------------------------
     * Funciones // Funciones //  Funciones //  Funciones //  Funciones //  Funciones //  Funciones //  Funciones
     * -----------------------------------------------------------------------------------------------------------
     */
    @Step("Navego al sitio de Falabella")
    public void navigateToSiteFalabella() {
        helpers.navigateTOUrl(helpers.GetSelectedenvironment());
    }

    @Step("Registrarse en el sitio de Falabella")
    public boolean waitCloseModal() {
        helpers.WaitForPageLoadOfElements();
        if(helpers.isDisplayed(CloseModalInicio)) {
            System.out.println("Modal de Bienvenida desplegado");
            helpers.click(CloseModalInicio);
            return true;
        } else if (!helpers.isDisplayed(CloseModalInicio)){
            System.out.println("Modal de Bienvenida no se encuentra desplegado");
        }return false;
    }

    @Step("Validar ingreso correcto falabella.com")
    public boolean IngresoCorrectoFalabella(){
        return helpers.explicitWait_visibilityOfElementLocated(LogoFalabella);
    }

    @Step("Ingreso a Registrar usuario")
    public boolean EnterToRegister(){
        helpers.ActionsMoveToAndClick(HolaInicioSesion, Btn_Register);
        if (helpers.isDisplayed(RegisterH1)){
            System.out.println("Ingreso correcto para registrar usuario");
          return true;
        }else if(!helpers.isDisplayed(RegisterH1)){
            System.out.println("No se pudo ingresar para registrar usuario");
        }
        return false;
    }

    @Step("Llenar formulario")
    public boolean LLenarFormulario() {
        try {
            helpers.sendText(Nombre, data.generateRandomName());
            helpers.sendText(PrimerApellido, data.generateRandomLastNames());
            helpers.sendText(Rut, data.generateRuts());
            helpers.waitEnable(Celular);
            helpers.sendText(Celular, "69166317");
            helpers.sendText(CorreoElectronico, data.generateRandomName()+data.generateRandomLastNames()+"0000@gmail.com");
            helpers.waitEnable(Pass);
            helpers.sendText(Pass, "Prueba1234*");
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Step("Seleccionar los CheckBox")
    public void SeleccionarCheckBox(){
        helpers.scrollDownToElement(driver.findElement(Pass));
        helpers.clickOnHiddenElement("testId-consent-consentTemplateRegistroTyC_FAL_CL-input");
        helpers.clickOnHiddenElement("testId-consent-consentTemplateRegistroPdP_FAL_CL-input");
    }

    @Step("Click para registrar")
    public void clickForRegister(){
        helpers.ClickForJS(Registrarme);
    }

    @Step("Validar que la cuenta se creó")
    public boolean validation(){
        helpers.scrollDownToElement(driver.findElement(BarraBus));
        try {
            helpers.explicitWait_PresenceOfElementDisplayed(YaTienesUnaCuenta);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

}
