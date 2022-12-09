package Hillel.Tests;

import Config.BaseTest;
import Hillel_SitePages.JavaPage;
import org.junit.Assert;
import org.junit.Test;

public class JavaPageTest extends BaseTest {
    JavaPage javaPage = new JavaPage(driver);;

    @Test
    public void checkJavaPage(){

        driver.get("https://ithillel.ua/courses/java-basic");

        // перевіряємо Rating курсу
        Assert.assertEquals("5", javaPage.getCourseRate());
        System.out.println("Рейтинг курсу: " + javaPage.getCourseRate());

        // Якщо потрібно title курсу
        Assert.assertTrue(javaPage.getCourseTitle().contains("Java Basic"));
        System.out.println("Назва курсу: " + javaPage.getCourseTitle());

        // Якщо потрібно title сторінки
        System.out.println("Назва сторінки: " + javaPage.getTitleOfPage());

        // Description курсу
        System.out.println(javaPage.getCourseDescription());
    }

}
