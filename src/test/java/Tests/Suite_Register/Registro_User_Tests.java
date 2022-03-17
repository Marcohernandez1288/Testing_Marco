package Tests.Suite_Register;

import Baseclass.BaseClass;
import Helpers.RetryAnalyzer;
import Pages.Register.Page_Register;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Registro_User_Tests extends BaseClass {



    String ClassName = "[" + getClass().getName() + "]: "; //Se usa para ordenar el reporte.


    //Descripcion: Tests para reto en falabella
    @Test(groups = { "Challenge" }, description = "Ingreso correcto a Falabella.com",retryAnalyzer = RetryAnalyzer.class, priority = 1 )
    @Severity(SeverityLevel.CRITICAL)
    @Description("Register: Ingreso a portal falabella.com")
    public void test_SuccessfullToFalabella() {
        Page_Register page_login = new Page_Register(driver);
        page_login.navigateToSiteFalabella();
        page_login.waitCloseModal();
        Assert.assertTrue(page_login.IngresoCorrectoFalabella(), "No se pudo ingresar correctamente a Falabella.com");
    }

    @Test(groups = { "Challenge" }, description = "Ingreso correcto a Modulo para registro",retryAnalyzer = RetryAnalyzer.class, priority = 1 )
    @Severity(SeverityLevel.CRITICAL)
    @Description("Register: Ingreso a Modulo para Registro de Usuarios")
    public void test_SuccessfullToRegister() {
        Page_Register page_login = new Page_Register(driver);
        page_login.navigateToSiteFalabella();
        page_login.waitCloseModal();
        page_login.EnterToRegister();
        Assert.assertTrue(page_login.EnterToRegister(), "No se pudo ingresar al modulo de registro");
    }


    @Test(groups = { "Challenge" }, description = "Llenar Formulario",retryAnalyzer = RetryAnalyzer.class, priority = 1 )
    @Severity(SeverityLevel.CRITICAL)
    @Description("Register: Llenar Formulario")
    public void test_LlenarFormulario() {
        Page_Register page_login = new Page_Register(driver);
        page_login.navigateToSiteFalabella();
        page_login.waitCloseModal();
        page_login.EnterToRegister();
        Assert.assertTrue(page_login.EnterToRegister(), "No se pudo ingresar al modulo de registro");
        Assert.assertTrue(page_login.LLenarFormulario(), "No se pudo llenar el formulario");
        page_login.SeleccionarCheckBox();
        page_login.clickForRegister();
        Assert.assertTrue(page_login.validation(),"La cuenta no se pudo crear correctamente");
    }

}
