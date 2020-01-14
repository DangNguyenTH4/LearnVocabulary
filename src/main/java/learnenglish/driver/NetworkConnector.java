package learnenglish.driver;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import learnenglish.model.ListWord;
import learnenglish.model.Subject;

@Component
public class NetworkConnector {
	String domain = "https://dangnguyenth4.github.io/vendor/vocabularyEnglish/";
	private Logger logger = LoggerFactory.getLogger(NetworkConnector.class);

	public boolean isHostReady(String host) {
		boolean result = false;

		return result;
	}

	public boolean isConnectSuccess(CloseableHttpResponse response) {
		return response.getStatusLine().getStatusCode() == 200;
	}

	public ListWord getDataFromFile(String fileName) throws ClientProtocolException, IOException {
		String api = domain + fileName;
		Gson gson = new Gson();
		ListWord lst = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			logger.info("Connect to network...");
			HttpGet request = new HttpGet(api);
			request.addHeader("Accept", "application/json, text/plain, */*");
			request.addHeader(HttpHeaders.USER_AGENT, "Mozilla/5.0");
			CloseableHttpResponse response = httpClient.execute(request);
			try {
				if (isConnectSuccess(response)) {
					logger.info("Connect Success");
					HttpEntity entity = response.getEntity();
					if (entity != null) {
						logger.info("Get list word from file response..");
						lst = gson.fromJson(EntityUtils.toString(entity), ListWord.class);
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				response.close();
			}
		} catch (HttpHostConnectException e) {
		}

		finally {
			httpClient.close();
		}
		return lst;
	}

	public List<Subject> getListSubject() throws ClientProtocolException, IOException {
		String api = domain + "1thesubject.json";
		List<Subject> lst = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			logger.info("Connect to network...");
			HttpGet request = new HttpGet(api);
			request.addHeader("Accept", "application/json, text/plain, */*");
			request.addHeader(HttpHeaders.USER_AGENT, "Mozilla/5.0");
			CloseableHttpResponse response = httpClient.execute(request);
			try {
				if (isConnectSuccess(response)) {
					logger.info("Connect Success");
					HttpEntity entity = response.getEntity();
					if (entity != null) {
						logger.info("get list subject from file ...");
						ObjectMapper om = new ObjectMapper();
						lst = om.readValue(EntityUtils.toByteArray(entity), new TypeReference<List<Subject>>() {
						});
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				response.close();
			}
		} catch (HttpHostConnectException e) {
		}

		finally {
			httpClient.close();
		}
		return lst;
	}

	public String googleConnector(String word) throws IOException {
		logger.info("get pronunciation from web laban.vn .....");
		word = word.replaceAll(" ", "%20");
		Document doc = Jsoup.connect("https://dict.laban.vn/find?type=1&query=" + word).get();
		String result ="";
		logger.info(word);
		if(doc!=null) {
			Elements pronunElement = doc.getElementsByClass("color-black");
			if(pronunElement!=null && pronunElement.size()!=0) {
				String pronun = pronunElement.get(0).text();
				logger.info(pronun);
				if (!StringUtils.isEmpty(pronun)) {
					if (pronun.startsWith("/") && pronun.endsWith("/"))
						result = pronun;
				}
			}
			
		}
		
		return result;
	}

}
