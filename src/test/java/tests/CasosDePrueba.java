package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


import java.util.concurrent.TimeUnit;

public class CasosDePrueba {
    //Atributos
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    private String rutaDriver= System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver.exe";
    private String propertyDriver = "webdriver.chrome.driver";

    @AfterMethod
    public void posCondicion(){
        driver.close();
    }

    @BeforeMethod
    public void preCondiciones(){
        System.setProperty(propertyDriver,rutaDriver);
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(40, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,10);
        js = (JavascriptExecutor) driver;
        driver.navigate().to("https://open.spotify.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void CP001_Buscar_Genero() throws InterruptedException {
        By verBtnBuscar = By.xpath("//*[@id=\"main\"]/div/div[2]/nav/div[1]/ul/li[2]/a/span");
        wait.until(ExpectedConditions.presenceOfElementLocated(verBtnBuscar));
        WebElement btnBuscar = driver.findElement(verBtnBuscar);
        btnBuscar.click();
        Thread.sleep(3000);
        By verInputBuscar = By.xpath("//input[@placeholder='¿Qué te apetece escuchar?']");
        driver.findElement(verInputBuscar).sendKeys("Hip-Hop");
        By verMixGenero = By.xpath("//*[@id=\"searchPage\"]/div/div/section[5]/div[2]/div[1]/div/div[2]/a/div");
        wait.until(ExpectedConditions.presenceOfElementLocated(verMixGenero));
        WebElement mixGenero = driver.findElement(verMixGenero);
        Assert.assertEquals(mixGenero.getText(),"Mix Hip Hop");
    }

    @Test
    public void CP002_Iniciar_Sesion_Fb(){

        By iniciarBtn = By.xpath("//button[@data-testid='login-button']");
        WebElement btnIniciarFb = driver.findElement(iniciarBtn);
        btnIniciarFb.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-testid='facebook-login']"))).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("juan.ferreira@tsoftglobal.com");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("a1b2c3d4");
        driver.findElement(By.xpath("//*[@id=\"loginbutton\"]")).click();
        By alertaIS = By.xpath("//*[@id=\"globalContainer\"]/div[3]/div/div/div");
        wait.until(ExpectedConditions.presenceOfElementLocated(alertaIS));
        WebElement alerta = driver.findElement(alertaIS);
        Assert.assertEquals(alerta.getText(), "El correo electrónico que has introducido no está conectado a una cuenta. Encuentra tu cuenta e inicia sesión.");
    }

    @Test
    public void CP003_btnISFallidoApple() throws InterruptedException {
        By verBtnIniciarSesion = By.xpath("//button[@data-testid='login-button']");
        WebElement btnIniciarSesion = driver.findElement(verBtnIniciarSesion);
        btnIniciarSesion.click();
        Thread.sleep(1000);
        By verBtnLogConApple = By.xpath("//button[@data-testid='apple-login']");
        WebElement btnlogdeapple = driver.findElement(verBtnLogConApple);
        btnlogdeapple.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='account_name_text_field']")).sendKeys("juan.ferreira@tsoftglobal.com");
        Thread.sleep(1000);
        By localizadorBtnSignIn = By.xpath("//button[@id='sign-in']");
        WebElement btnsignin = driver.findElement(localizadorBtnSignIn);
        btnsignin.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='password_text_field']")).sendKeys("1a2b3c4d");
        Thread.sleep(1000);
        By verBtnConfirmaContraseña = By.xpath("//button[@id='sign-in']");
        WebElement btnconfirmarcontraseña = driver.findElement(verBtnConfirmaContraseña);
        btnsignin.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='errMsg']")).getText(),"Contraseña o ID de Apple incorrectos.");
        Thread.sleep(1000);
    }

    @Test
    public void CP004_IS_Google(){
        By iniciarGG = By.xpath("//button[@data-testid='login-button']");
        WebElement btnIniciar = driver.findElement(iniciarGG);
        btnIniciar.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath ("//button[@data-testid='google-login']"))).click();
        Assert.assertEquals(driver.getTitle(),"Inicia sesión: Cuentas de Google");

    }

    @Test
    public void CP005_IS_fono() throws InterruptedException {
        By iniciarFono = By.xpath("//button[@data-testid='login-button'] ");
        WebElement btnInicNum = driver.findElement(iniciarFono);
        btnInicNum.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-testid='phone-login']"))).click();
        driver.findElement(By.xpath("//input[@id='phonelogin-phonenumber']")).sendKeys("123454321");
        By siguienteBtn = By.xpath("//*[@id=\"phonelogin-button\"]/div[1]/p");
        WebElement btnSiguiente = driver.findElement(siguienteBtn);
        btnSiguiente.click();
        By alerta = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[1]/span");
        WebElement msjeAlerta = driver.findElement(alerta);
        wait.until(ExpectedConditions.presenceOfElementLocated(alerta));
        Assert.assertEquals(driver.findElement(alerta).getText(),"Comprueba el número de teléfono.");
        Thread.sleep(2000);
    }
}



    /*
    @Test
    public void CP001_Registro_Fallido_Captcha_en_blanco() {
        By localizadorBtnRegistrase = By.xpath("//button[contains(text(),'Registrarte')]");
        WebElement btnRegistrarse = driver.findElement(localizadorBtnRegistrase);
        btnRegistrarse.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).sendKeys("domingo.saavedra@tsoftglobal.com");
        driver.findElement(By.name("confirm")).sendKeys("domingo.saavedra@tsoftglobal.com");
        driver.findElement(By.name("password")).sendKeys("123454321");
        driver.findElement(By.name("displayname")).sendKeys("Pobre Domingo :D");
        driver.findElement(By.id("day")).sendKeys("28");
        Select cmbMes = new Select(driver.findElement(By.id("month")));
        cmbMes.selectByValue("02");
        driver.findElement(By.name("year")).sendKeys("1991");
        WebElement genero = driver.findElement(By.xpath("//label[@for='gender_option_male']"));
        js.executeScript("arguments[0].scrollIntoView();", genero);
        genero.click();
        driver.findElement(By.xpath("//label[@for='marketing-opt-checkbox']")).click();
        driver.findElement(By.xpath("//label[@for='third-party-checkbox']")).click();
        WebElement btnRegistro  = driver.findElement(By.xpath("//button[@type='submit']"));
        js.executeScript("arguments[0].scrollIntoView();", btnRegistro);
        btnRegistro.click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Confirma que no eres un robot.')]")).getText(),"Confirma que no eres un robot.");
    }

    @Test
    public void CP002_Registro_Fallido_Captcha_en_blanco() {
        By localizadorBtnRegistrase = By.xpath("//button[contains(text(),'Registrarte')]");
        WebElement btnRegistrarse = driver.findElement(localizadorBtnRegistrase);
        btnRegistrarse.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).sendKeys("domingo.saavedra@tsoftglobal.com");
        driver.findElement(By.name("confirm")).sendKeys("domingo.saedra@tsoftglobal.com");
        driver.findElement(By.name("password")).sendKeys("123454321");
        driver.findElement(By.name("displayname")).sendKeys("Pobre Domingo :D");
        driver.findElement(By.id("day")).sendKeys("28");
        Select cmbMes = new Select(driver.findElement(By.id("month")));
        cmbMes.selectByValue("02");
        driver.findElement(By.name("year")).sendKeys("1991");
        WebElement optionMale = driver.findElement(By.xpath("//label[@for='gender_option_male']"));
        js.executeScript("arguments[0].scrollIntoView();", optionMale);
        optionMale.click();
        driver.findElement(By.xpath("//label[@for='marketing-opt-checkbox']")).click();
        driver.findElement(By.xpath("//label[@for='third-party-checkbox']")).click();
        WebElement btnRegistro  = driver.findElement(By.xpath("//button[@type='submit']"));
        js.executeScript("arguments[0].scrollIntoView();", btnRegistro);
        btnRegistro.click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Las direcciones de correo')]")).getText(),"Las direcciones de correo electrónico no coinciden.");
    }
}

     */
