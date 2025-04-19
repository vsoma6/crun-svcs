package demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingsRepository extends JpaRepository<Rating, Integer> {
    Rating findOneByReviewId(String reviewId);
}