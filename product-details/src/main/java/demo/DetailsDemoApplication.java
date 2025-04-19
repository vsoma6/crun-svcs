package demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SpringBootApplication
@RestController
public class DetailsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DetailsDemoApplication.class, args);
    }

    @GetMapping("/")
    String index() {
        return "hello, world! product-details - v1.0";
    }

    @GetMapping("/details")
    List<Map<String, Object>> details() {
        List<Map<String, Object>> products = new ArrayList<>();
        Map<String, Object> product1 = new HashMap<>();
        product1.put("productId", "P1001");
        Map<String, Object> details1 = new HashMap<>();
        details1.put("description", "Awesome Gadget X");
        details1.put("mfg", "Acme Corp");
        product1.put("productDetails", details1);
        products.add(product1);

        Map<String, Object> product2 = new HashMap<>();
        product2.put("productId", "P1002");
        Map<String, Object> details2 = new HashMap<>();
        details2.put("description", "Standard Widget Y");
        details2.put("mfg", "Beta Industries");
        product2.put("productDetails", details2);
        products.add(product2);

        return products;
    }

}
