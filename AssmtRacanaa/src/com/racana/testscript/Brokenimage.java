package com.racana.testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Brokenimage {

    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver.exe");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the URL
        driver.get("http://the-internet.herokuapp.com/broken_images");

        // Find all the images on the page
        List<WebElement> images = driver.findElements(By.tagName("img"));

        // Loop through each image and check if it is broken
        for (WebElement image : images) {
            String imageUrl = image.getAttribute("src");
            if (isImageBroken(imageUrl)) {
                System.out.println("Broken image found: " + imageUrl);
            }
        }

        // Close the browser
        driver.quit();
    }

    // Method to check if an image is broken
    public static boolean isImageBroken(String imageUrl) {
        WebDriver driver = new ChromeDriver();
        driver.get(imageUrl);
        String currentUrl = driver.getCurrentUrl();
        driver.quit();
        return currentUrl.contains("data:");
    }
}
