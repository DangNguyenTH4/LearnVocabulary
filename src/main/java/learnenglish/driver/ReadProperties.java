package learnenglish.driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.util.StringUtils;

public class ReadProperties {

	private static Properties props;
	private static String currentDir = System.getProperty("user.dir");
	private static String filePropertiesName = "\\props.properties";

	private ReadProperties() {

		try (InputStream fis = new FileInputStream(new File(currentDir + filePropertiesName))) {
			props = new Properties();
			props.load(fis);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Properties getInstance() {
		try (InputStream fis = new FileInputStream(new File(currentDir + filePropertiesName))) {
			props = new Properties();
			props.load(fis);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return props;
	}

	public static String getProperty(String propertyName) {
		String result = getInstance().getProperty(propertyName);
		return StringUtils.trimAllWhitespace(result);
	}

	public static String setProperty(String propertyName, String value) throws IOException {
		props = getInstance();
		FileOutputStream out = new FileOutputStream("props.properties");
		props.replace(propertyName, value);
		props.store(out, null);
		out.close();
		return getProperty(propertyName);
	}

}
