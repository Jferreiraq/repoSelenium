package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class SearchPage extends BaseClass{
    By verInputBuscar = By.xpath("//input[@placeholder='¿Qué te apetece escuchar?']");
    By verMixGenero = By.xpath("//*[@id=\"searchPage\"]/div/div/section[10]/div[2]/div[1]/div/div[2]/a/div");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void escribirBuscador(String aBuscar){agregarTexto(esperarAElementoWeb(verInputBuscar), aBuscar);}
    public String obtenerGenero(){return obtenerTexto(esperarAElementoWeb(verMixGenero));}
}
