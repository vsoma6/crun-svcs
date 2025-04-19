package demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SpringBootApplication
@RestController
public class ReviewsDemoApplication {

    @Value("${product.ratings.url}")
    private String productRatingsUrl;

    RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        SpringApplication.run(ReviewsDemoApplication.class, args);
    }

    @GetMapping("/")
    String index() {
        return "hello, world! product-reviews - v1.0";
    }

    @GetMapping("/{productId}/reviews")
    List<Object> reviews(@PathVariable String productId) {
        List<Object> reviews = new ArrayList<>();
        Map<String, Object> review = new HashMap<>();
        String ratings = "";
        
        if(productId.equals("P1001")){ 
            String reviewId = "R1001";
            ratings = restTemplate.getForObject(productRatingsUrl + "/" + reviewId + "/ratings", String.class);

            review.put("review", "Great product!");
            review.put("rating", ratings);
            reviews.add(review);
        }
        else if(productId.equals("P1002")){
            String reviewId = "R1002";
            ratings = restTemplate.getForObject(productRatingsUrl + "/" + reviewId + "/ratings", String.class);

            review.put("review", "Could be better.");
            review.put("rating", ratings);
            reviews.add(review);
        }

        return reviews;
    }

}
