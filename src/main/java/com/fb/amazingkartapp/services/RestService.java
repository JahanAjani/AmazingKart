package com.fb.amazingkartapp.services;

import com.fb.amazingkartapp.contants.AmazingKartConstants;
import com.fb.amazingkartapp.exceptions.PromotionException;
import com.fb.amazingkartapp.utils.ContentParser;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 */
public class RestService {

	public static Object getProductsInformation(ContentParser contentParser) throws PromotionException {

		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(AmazingKartConstants.PRODUCT_INFO_URL);

			HttpResponse httpResponse = null;
			httpResponse = client.execute(request);

			return getContent(httpResponse, contentParser);
		} catch (IOException e) {
			throw new PromotionException(e.getMessage(), e.getCause());
		}
	}

	private static Object getContent(HttpResponse response, ContentParser contentParser) throws IllegalStateException, IOException {
		String result = getContent(response);
		return contentParser.parse(result);
	}

	private static String getContent(HttpResponse response) throws IOException {
		BufferedReader rd = new BufferedReader(
				new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		return result.toString();
	}

	public static Double getRateFromExchange(String currency, ContentParser contentParser) throws IOException {

		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(AmazingKartConstants.RATE_EXCHANGE_URL + "?base="+AmazingKartConstants.SYSTEM_BASE_CURRENCY+";symbols="+currency);

		HttpResponse httpResponse = client.execute(request);

		return contentParser.parseExchangeRate(getContent(httpResponse), currency);
	}
}
