import java.util.*;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class ImaggaTestAppl {
static RestTemplate restTemplate=new RestTemplate();
static HttpHeaders headers=new HttpHeaders();
static HttpEntity<String> requestEntity=new HttpEntity<>(headers);

static String url="https://api.imagga.com/v1/colors?url=";
static String image=null;
	public static void main(String[] args) {
		if(args.length!=1){
			System.out.println("<usage>:url of an image");
			return;
		}
		image=args[0];
		headers.add("Authorization",
				"Basic YWNjXzg3ZjU0MDAzYWI3OGM3NTphYzRmM2Y1ZDkyODNhYzE4ZTQxMGI0ZjczZjZmZmVhNA==");
		requestEntity=new HttpEntity<>(headers);

		ResponseEntity<ColorsServiceResponse> response=
		restTemplate.exchange
		(url+image, HttpMethod.GET, requestEntity, ColorsServiceResponse.class);
		printColorsResult(response.getBody());

	}
	private static void printColorsResult(ColorsServiceResponse body) {
		if(body.results.length>0)
			printColors(body.results);
		else
			printErrorMessage(body.unsuccessful[0]);
		
	}
	private static void printErrorMessage(UnsuccessfulMessage unsuccessful) {
		System.out.println("image "+unsuccessful.image);
		System.out.println(unsuccessful.info);
		
	}
	private static void printColors(ColorsResult[] results) {
		Arrays.stream(results[0].info.image_colors)
		.sorted((x,y)->Float.compare(y.percent, x.percent))
		.forEach(System.out::println);
		
	}
	

}
