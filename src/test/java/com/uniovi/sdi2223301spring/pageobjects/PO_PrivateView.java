package com.uniovi.sdi2223301spring.pageobjects;

import com.uniovi.sdi2223301spring.util.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PO_PrivateView extends PO_NavView {

    static public void fillFormAddMark(WebDriver driver, int userOrder, String descriptionp, String scorep)
    {
        //Esperamos 5 segundo a que carge el DOM porque en algunos equipos falla
        SeleniumUtils.waitSeconds(driver, 5);
        //Seleccionamos el alumnos userOrder
        new Select(driver.findElement(By.id("user"))).selectByIndex(userOrder);
        //Rellenemos el campo de descripción
        WebElement description = driver.findElement(By.name("description"));
        description.clear();
        description.sendKeys(descriptionp);
        WebElement score = driver.findElement(By.name("score"));
        score.click();
        score.clear();
        score.sendKeys(scorep);
        By boton = By.className("btn");
        driver.findElement(boton).click();
    }

    static public void loginAndCheck(WebDriver driver, String dnip, String passwordp){
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        PO_LoginView.fillLoginForm(driver, dnip, passwordp);
        PO_View.checkElementBy(driver, "text", dnip);
    }

    static public void logout(WebDriver driver){
        String loginText = PO_HomeView.getP().getString("signup.message", PO_Properties.getSPANISH());
        PO_PrivateView.clickOption(driver, "logout", "text", loginText);
    }

    static public void click(WebDriver driver, String path, int click) {
        List<WebElement> elements = PO_View.checkElementBy(driver, "free", path);
        elements.get(click).click();
    }

}
