package Tests.Suite_Login;

import Baseclass.BaseClass;
import Helpers.RetryAnalyzer;

import Pages.Login.Page_Login;
import Pages.Register.Page_Register;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login_Tests extends BaseClass {



    String ClassName = "[" + getClass().getName() + "]: "; //Se usa para ordenar el reporte.


    @Test(groups = { "Challenge" }, description = "Valido Login Correcto en Falabella.com",retryAnalyzer = RetryAnalyzer.class, priority = 1 )
    @Severity(SeverityLevel.CRITICAL)
    @Description("Login: LOGIN - Probar login con clave única correcta")
    public void test_SuccessfulLogin() {
        Page_Login page_login = new Page_Login(driver);
        Page_Register page_register = new Page_Register(driver);
        page_register.navigateToSiteFalabella();
        page_register.waitCloseModal();
        page_login.menuInicioSesion();
        page_login.makeLogin("userDefault1_MAIL","userDefault1_PASS");
        Assert.assertTrue(page_login.validacionLogin(),"No se puede validar inicio de sesion");
    }


}
