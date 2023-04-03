package com.itwill.my_real_korea.service.tour;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import com.itwill.my_real_korea.dto.tour.TourReview;
import com.itwill.my_real_korea.util.PageMakerDto;
@SpringBootTest
@ComponentScan(basePackages = {"com.itwill.my_real_korea"})
class TourReviewServiceImplTest {
	@Autowired
	private TourReviewService tourReviewService;

	void testInsertTourReview() throws Exception{
		int rowCount=tourReviewService.insertTourReview(new TourReview(0, null, "후기", "후기남겨용","review.jpg", 4, 3, "user1"));
		assertEquals(rowCount, 1);
	}

	void testUpdateTourReview() throws Exception{
		int rowCount=tourReviewService.updateTourReview(new TourReview(4, null, "큰일났다", "컨트롤러언제해요", "controller.jpg", 5, 5, "user1"));
		assertEquals(rowCount, 1);
	}

	void testDeleteTourReview() throws Exception{
		int rowCount=tourReviewService.deleteTourReview(2);
		assertEquals(rowCount, 1);
	}

	void testFindByUserId() throws Exception{
		PageMakerDto<TourReview> tourReviewList=tourReviewService.findByUserId(1, "desc", "user1");
		System.out.println(tourReviewList);
	}

	@Test
	void testFindByToNo() throws Exception{
		PageMakerDto<TourReview> tourReviewList=tourReviewService.findByToNo(1, "desc", 5);
		System.out.println(tourReviewList);
	}

}
