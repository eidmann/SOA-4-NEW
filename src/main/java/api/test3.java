package main.java.api;

import java.net.URI;

import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

import java.net.http.HttpResponse;

import java.nio.charset.StandardCharsets;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class test3 {
	private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();
public static void main (String []args) throws Exception {
	 test3 obj = new test3();

     System.out.println("Testing 2 - Send Http POST request");
     //obj.sendCanvas();
}
	 public void sendCanvas(String title, String start, String end, String date, String descr, String loc) throws Exception {

	        Map<Object, Object> data = new HashMap<>();
	        Scanner input = new Scanner(System.in);

	        data.put("calendar_event[context_code]","user_65760");
	        data.put("calendar_event[title]", title);
	        data.put("calendar_event[start_at]", date+"T"+start+":00+1:00");
	        data.put("calendar_event[end_at]", date+"T"+end+":00+1:00");
	        data.put("calendar_event[description]", descr);
	        data.put("calendar_event[location_name]", loc);

	        HttpRequest request = HttpRequest.newBuilder()
	                .POST(buildFormDataFromMap(data))
	                .uri(URI.create("https://ltu.instructure.com/api/v1/calendar_events.json"))
	                //.setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
	                .headers("Authorization", "Bearer 3755~79Vhe6oKEUKNCCJYVxZnydeNlqWtXGITPVKVukYeEtfvHeBquk5yLge9wwe23cyk", "Content-Type", "application/x-www-form-urlencoded")
	                .build();

	        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

	        // print status code
	        System.out.println(response.statusCode());

	        // print response body
	        System.out.println(response.body());

	    }

	    private static HttpRequest.BodyPublisher buildFormDataFromMap(Map<Object, Object> data) {
	        var builder = new StringBuilder();
	        for (Map.Entry<Object, Object> entry : data.entrySet()) {
	            if (builder.length() > 0) {
	                builder.append("&");
	            }
	            builder.append(URLEncoder.encode(entry.getKey().toString(), StandardCharsets.UTF_8));
	            builder.append("=");
	            builder.append(URLEncoder.encode(entry.getValue().toString(), StandardCharsets.UTF_8));
	        }
	        System.out.println(builder.toString());
	        return HttpRequest.BodyPublishers.ofString(builder.toString());
	    }
}
//	try {
//		URL url = new URL("https://ltu.instructure.com/api/v1/calendar_events.json");
//		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//
//        conn.setDoOutput(true);
//		conn.setRequestMethod("POST");
//		//conn.setRequestProperty("Authorization", "Bearer 3755~KhY3fNQ6QapGhkdh0pkg0sGlMneR8ORxXHupWVTkvhLiC0uVgbXymklz6Dwkbv6N");
//
//
//		DataOutputStream os = new DataOutputStream(conn.getOutputStream());
//		OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");    
//		osw.write("Just Some Text");
//        os.flush();
//        os.close();
//		
//		int responseCode = conn.getResponseCode();
//		
//		System.out.println("Response code is: " + responseCode);
//		
//		BufferedReader in = new BufferedReader(
//                new InputStreamReader(conn.getInputStream()));
//        String inputLine;
//        StringBuffer response = new StringBuffer();
//
//        while ((inputLine = in.readLine()) != null) {
//            response.append(inputLine);
//        }
//        System.out.println(response);
//        in.close();
//        conn.connect();
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
	
	
	
//	 try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
//
//         var request = new HttpPost("https://ltu.instructure.com/api/v1/calendar_events.json");
//         request.setHeader("Authorization", "Bearer 3755~KhY3fNQ6QapGhkdh0pkg0sGlMneR8ORxXHupWVTkvhLiC0uVgbXymklz6Dwkbv6N");
//         request.setEntity(new StringEntity("calendar_event[context_code]"));
//
//         HttpResponse response = (HttpResponse) client.execute(request);
//
//         var bufReader = new BufferedReader(new InputStreamReader(
//                 ((HttpEntityEnclosingRequestBase) response).getEntity().getContent()));
//
//         var builder = new StringBuilder();
//
//         String line;
//
//         while ((line = bufReader.readLine()) != null) {
//
//             builder.append(line);
//             builder.append(System.lineSeparator());
//         }
//
//         System.out.println(builder);
//     }
			
//	var values = new HashMap<String, String>() {{
//		put("calendar_event[context_code]", "user_64603");
//		put("calendar_event[title]", "Hej");
//		put("calendar_event[start_at]", "2018-11-16T06:00:00Z");
//		put("calendar_event[end_at]", "2018-11-16T7:00:00Z");
//	}};
//	var objectMapper = new ObjectMapper();
//	String requestBody;
//	try {
//		requestBody = objectMapper
//		        .writeValueAsString(values);
//	
//	String token = "3755~KhY3fNQ6QapGhkdh0pkg0sGlMneR8ORxXHupWVTkvhLiC0uVgbXymklz6Dwkbv6N";
//	HttpClient client = HttpClient.newBuilder().build();
//    HttpRequest request = HttpRequest.newBuilder()
//    		.uri(URI.create("https://ltu.instructure.com/api/v1/calendar_events.json"))
//            .headers("Authorization", "Bearer 3755~KhY3fNQ6QapGhkdh0pkg0sGlMneR8ORxXHupWVTkvhLiC0uVgbXymklz6Dwkbv6N", "Content-Type", "multipart/form-data")
//            .POST(BodyPublishers.ofString(requestBody))
//            .build();
//    System.out.println(requestBody);
//	System.out.println(request.headers());
//    HttpResponse<?> response = client.send(request, BodyHandlers.ofString());
//
//    System.out.println(response.body());
//    System.out.println(response);
//
//	} catch (IllegalArgumentException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}catch (JsonProcessingException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}

