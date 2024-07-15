package UtilityLayer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import BaseLayer.BaseClass;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ScreenShot extends BaseClass {

	public static String takesScreenShot(String foldername, String screenshotname) {
		String destinationpath = System.getProperty(("user.dir") + "//" + foldername + "//" + DateAndTime.captureYear()
				+ "//" + DateAndTime.captureMonthAndYear() + "//" + screenshotname
				+ DateAndTime.caputreCurrentDatehAndTime() + ".png");
		try {
			FileUtils.copyFile(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE),
					new File(destinationpath));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return destinationpath;
	}

	public static String fullScreenShot(String foldername, String screenshotname) throws IOException {

		String destinationpath = System.getProperty("user.dir") + "//" + foldername + "//" + DateAndTime.captureYear()
				+ "//" + DateAndTime.captureMonthAndYear() + "//" + screenshotname
				+ DateAndTime.caputreCurrentDatehAndTime() + ".png";
		ImageIO.write(new AShot().shootingStrategy(ShootingStrategies.viewportPasting(2000)).takeScreenshot(getDriver())
				.getImage(), "png", new File(destinationpath));
		return destinationpath;
	}
}
