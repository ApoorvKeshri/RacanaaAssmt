package com.racana.testscript;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	
	public class uploadFile {

	    public static void main(String[] args) {
	        // Set the path to the ChromeDriver executable
	        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver.exe");

	        // Create a new instance of the ChromeDriver
	        WebDriver driver = new ChromeDriver();

	        // Navigate to the URL
	        driver.get("http://the-internet.herokuapp.com/upload");

	        // Locate the file upload input field
	        WebElement fileUploadInput = driver.findElement(By.id("file-upload"));

	        // Provide the path of the file to be uploaded
	        String filePath = "path_to_file/file.txt";
	        fileUploadInput.sendKeys(filePath);

	        // Click the Upload button
	        WebElement uploadButton = driver.findElement(By.id("file-submit"));
	        uploadButton.click();

	        // Wait for the upload process to complete (you may need to add explicit wait here)

	        // Verify if the file is uploaded successfully
	        WebElement uploadedFilesElement = driver.findElement(By.id("uploaded-files"));
	        String uploadedFileName = uploadedFilesElement.getText();
	        if (uploadedFileName.equals("file.txt")) {
	            System.out.println("File uploaded successfully.");
	        } else {
	            System.out.println("File upload failed.");
	        }

	        // Close the browser
	        driver.quit();
	    }
	}

