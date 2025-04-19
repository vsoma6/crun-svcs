package demo;

import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;


import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SpringBootApplication
@RestController
public class CatalogDemoApplication {

    @Value("${product.details.url}")
    private String productDetailsUrl;

    @Value("${product.reviews.url}")
    private String productReviewsUrl;

    RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        SpringApplication.run(CatalogDemoApplication.class, args);
    }

    @GetMapping("/")
    String index() {
        return "hello, world! product-catalog - v1.0";
    }

    @GetMapping("/catalog")
    List<Map<String, Object>> catalog() {
        List<Map<String, Object>> products = new ArrayList<>();
        List<Map<String, Object>> productDetails = restTemplate.getForObject(productDetailsUrl + "/details", List.class);
        for (Map<String, Object> productDetail : productDetails) {
            String productId = (String) productDetail.get("productId");
            Map<String, Object> product = productDetail;
            // product.put("productId", productId);
            // product.put("productDetails", productDetail);
            ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity(productReviewsUrl + "/" + productId + "/reviews", Object[].class);
            product.put("reviews", responseEntity.getBody());
            products.add(product);
        }

        return products;
    }

}
