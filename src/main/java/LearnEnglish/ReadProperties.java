package LearnEnglish;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

	private static Properties props;
	private static String currentDir = System.getProperty("user.dir");
	private static String filePropertiesName = "\\props.properties";

	private ReadProperties() {

		System.out.println("Init props");
		try (InputStream fis = new FileInputStream(new File(currentDir + filePropertiesName))) {
			props = new Properties();
			props.load(fis);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Properties getInstance() {
		if (props == null) {
			System.out.println("Init props");
			try (InputStream fis = new FileInputStream(new File(currentDir + filePropertiesName))) {
				props = new Properties();
				props.load(fis);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return props;
	}

	public static String getProperty(String propertyName) {
		try (InputStream fis = new FileInputStream(new File(currentDir + filePropertiesName))) {
			props = new Properties();
			props.load(fis);

		} catch (IOException e) {
			e.printStackTrace();
		}
		String result = getInstance().getProperty(propertyName);
		getInstance().clear();
		return result;
	}

	public static String setProperty(String propertyName, String value) {
		getInstance().setProperty(propertyName, value);
		return getProperty(propertyName);
	}

}