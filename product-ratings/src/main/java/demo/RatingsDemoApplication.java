package demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@SpringBootApplication
@RestController
public class RatingsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RatingsDemoApplication.class, args);
    }

    @GetMapping("/")
    String index() {
        return "hello, world! product-ratings - v1.0";
    }

    @GetMapping("/{reviewId}/ratings")
    int ratingByreviewId(@PathVariable String reviewId) {
        int rating = -1;
        if(reviewId.equals("R1001")){      
            rating = 5;
        }
        else if(reviewId.equals("R1002")){
            rating = 3;
        }
        return rating;
    }

}
