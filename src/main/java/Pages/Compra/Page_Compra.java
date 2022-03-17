package Pages.Compra;

import Helpers.Helpers;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Page_Compra {

    public WebDriver driver; //Declaro Objeto Driver.
    public Helpers helpers;

    public Page_Compra(WebDriver driver) {  //Metodo Constructor de la Clase.
        this.driver = driver;
        helpers = new Helpers(driver);
    }

    /**
     * ---------------------------------------------------------------------------------------------------------
     * WebElements // WebElements // WebElements // WebElements // WebElements // WebElements // WebElements //
     * ---------------------------------------------------------------------------------------------------------
     */

    public By Input = By.xpath("//input[contains(@id,'testId-SearchBar-Input')]");
    public By Tecnologia = By.xpath("//h2[contains(.,'Categoría')]");
    public By precioAntesDeCompra = By.xpath("//span[contains(.,'$  129.990')]");
    public By NombreArticulo = By.xpath("//div[@data-name='Smartphone Galaxy A12 128GB']");
    public By Btn_Movistar = By.xpath("//button[@type='button'][contains(.,'Movistar')]");
    public By Btn_AgregarCarrito = By.xpath("//button[@type='button'][contains(.,'Agregar al Carro')]");
    public By LoQueLlevasCarrito = By.xpath("//span[@class='copy10 primary  jsx-3548557188 normal      '][contains(.,'Lo que llevas en tu Carro')]");
    public By irAlCarrito = By.xpath("//a[contains(@id,'linkButton')]");
    public By validacionCarrito = By.xpath("//h1[contains(.,'Carro')]");
    public By NombreArticuloEnCarrito = By.xpath("//span[@data-testid='name']");
    public By precioEnCarrito = By.xpath("(//span[contains(@data-testid,'total-amount')])[2]");



    /**
     * -----------------------------------------------------------------------------------------------------------
     * Funciones // Funciones //  Funciones //  Funciones //  Funciones //  Funciones //  Funciones //  Funciones
     * -----------------------------------------------------------------------------------------------------------
     */

    @Step("Ingresar al modulo de tecnologia")
    public boolean ModuloTec(){
        helpers.sendText( Input,"Smartphone Galaxy A12 128GB");
        helpers.sendText( Input, String.valueOf(Keys.ENTER));
        try{
            helpers.explicitWait_textToBePresentInElementLocated(Tecnologia, "Categoría");
            return true;
        } catch (Exception e){
            System.err.println(e);
            return false;
        }
    }

    @Step("Seleccionar articulo")
    public void seleccionArticulo(){
        helpers.clickOnHiddenElement("testId-pod-image-https://falabella.scene7.com/is/image/Falabella/15693809_1");
        helpers.explicitWait_visibilityOfElementLocated(NombreArticulo);
        String NombreProducto = helpers.getText(NombreArticulo);
        String PrecioCel = helpers.getText(precioAntesDeCompra);
        System.out.println("Nombre del Articulo: " + NombreProducto + " |" + " Precio Producto: " + PrecioCel);
        helpers.SleepSeconds(3);
    }

    @Step("Agregar al carrito")
    public boolean agregarAlCarrito(){
        helpers.click(Btn_Movistar);
        helpers.click(Btn_AgregarCarrito);
        String PrecioCel = helpers.getText(precioAntesDeCompra);
        driver.switchTo().activeElement();
        helpers.explicitWait_textToBePresentInElementLocated(LoQueLlevasCarrito, "Lo que llevas en tu Carro");
        helpers.click(irAlCarrito);
        helpers.explicitWait_textToBePresentInElementLocated(validacionCarrito, "Carro");
        String PrecioCelEnCarrito = helpers.getText(precioEnCarrito);
        System.out.println("Precio antes de agg al carrito: " + PrecioCel + "\n" + "Precio despues de agg al carrito: " + PrecioCelEnCarrito);
        if(PrecioCel.equals(PrecioCelEnCarrito)){
            System.out.println("Valores Iguales");
            return true;
        }else{
            System.out.println("Valores no son iguales");
            return false;
        }
    }

}
