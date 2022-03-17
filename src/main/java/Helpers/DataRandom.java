package Helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;


public class DataRandom {

    private static WebDriver driver; // Instancio un Objeto Driver para usar.
    private static WebDriverWait wait;

    public DataRandom(WebDriver driver) // Metodo Constructor
    {
        this.driver = driver; //Mi Webdriver
    }

    public DataRandom() // Metodo Constructor
    {

    }


    public static String generateRandomName() {
        int quantity = 1;
        String[] name = {"Andrea", "David", "Baldomero", "Balduino", "Baldwin", "Baltasar", "Barry", "Bartolo",
                "Bartolomé", "Baruc", "Luis", "Candelaria", "Cándida", "Canela", "Caridad", "Carina", "Miguel",
                "Jose", "Carlota", "Baltazar"};

        String nameRandom = null;
        for (int i = 0; i < quantity; i++) {
            nameRandom = name[(int) (Math.floor(Math.random() * ((name.length - 1) - 0 + 1) + 0))];
        }
        return nameRandom;
    }

    public static String generateRandomLastNames() {
        int amount = 1;
        String[] lastName = { "Gomez", "Guerrero", "Cardenas", "Mendez", "Cardona", "Cardozo", "Arriaga", "Carillo",
                "Carrion", "Castillo", "Herrera", "Castro", "Molina", "Moncada", "Rosales", "Moreno", "Marquina",
                "Gutierrez" };

        String randomLastNames = null;
        for (int i = 0; i < amount; i++) {
            randomLastNames = lastName[(int) (Math.floor(Math.random() * ((lastName.length - 1) - 0 + 1) + 0))];
        }
        return randomLastNames;
    }

    public static String generateNumberPhone() {
        Random ran = new Random();
        int min = 000000001;
        int max = 99999999;
        int phoneNumber = 0;
        for (int i = 0; i < min; i++) {
            phoneNumber = ran.nextInt((max - min) + 1) + min;
        }
        return String.valueOf(phoneNumber);
    }

    public static String generateRuts() {
        int amount = 1;
        String[] lastName = { "20545260-5", "23485127-6", "23966511-k", "26546765-2", "14248386-6",
                "24068628-7", "22888371-9", "28885919-1", "25437016-9", "23217383-1", "10408457-5",
                "21103875-6" };

        String randomLastNames = null;
        for (int i = 0; i < amount; i++) {
            randomLastNames = lastName[(int) (Math.floor(Math.random() * ((lastName.length - 1) - 0 + 1) + 0))];
        }
        return randomLastNames;
    }


}
