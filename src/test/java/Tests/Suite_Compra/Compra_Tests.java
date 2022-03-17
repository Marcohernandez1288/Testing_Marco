package Tests.Suite_Compra;

import Baseclass.BaseClass;
import Helpers.RetryAnalyzer;
import Pages.Compra.Page_Compra;
import Pages.Login.Page_Login;
import Pages.Register.Page_Register;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Compra_Tests extends BaseClass {



    String ClassName = "[" + getClass().getName() + "]: "; //Se usa para ordenar el reporte.


    @Test(groups = { "Challenge" }, description = "Ingreso a categoria de celulares",retryAnalyzer = RetryAnalyzer.class, priority = 1 )
    @Severity(SeverityLevel.CRITICAL)
    @Description("Compra: Ingreso a categoria")
    public void test_IngresoCategoria() {
        Page_Compra page_compra = new Page_Compra(driver);
        Page_Register page_login = new Page_Register(driver);
        page_login.navigateToSiteFalabella();
        page_login.waitCloseModal();
        Assert.assertTrue(page_compra.ModuloTec(),"No se lográ ingresar al modulo de celulares");
    }

    @Test(groups = { "Challenge" }, description = "Validacion del precio",retryAnalyzer = RetryAnalyzer.class, priority = 1 )
    @Severity(SeverityLevel.CRITICAL)
    @Description("Compra: Validacion del precio")
    public void test_AgregarMiCarrito() {
        Page_Compra page_compra = new Page_Compra(driver);
        Page_Register page_login = new Page_Register(driver);
        page_login.navigateToSiteFalabella();
        page_login.waitCloseModal();
        Assert.assertTrue(page_compra.ModuloTec(), "No se lográ ingresar al modulo de celulares");
        page_compra.seleccionArticulo();
        Assert.assertTrue(page_compra.agregarAlCarrito(),"Valores del producto no es igual al del carrito de compras");
    }



}
