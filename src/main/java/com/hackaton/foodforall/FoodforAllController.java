package com.hackaton.foodforall;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.*;
import com.hackaton.foodforall.dao.*;
import com.hackaton.foodforall.dto.*;

@RestController
public class FoodforAllController {

	@RequestMapping("/showFeed")
	public ArrayList<Feed> feedConsult() {
		FeedDAO dao = new FeedDAO();
		return dao.feedConsult();
	}

	@RequestMapping("/createBeneficed")
	public String InsertBeneficiare(Beneficiaries ben) {
		BeneficiariesDAO dao = new BeneficiariesDAO();
		dao.createBeneficiaries(ben);
		return "Microservice has insert a beneficiary";
	}

	@RequestMapping("/createDonor")
	public String InsertDonor(Donor don) {
		DonorDAO dao = new DonorDAO();
		dao.createDonor(don);
		return "Microservice has insert a donor";
	}

	@RequestMapping("/createFeed")
	public String InsertFood(Feed fee) {
		FeedDAO dao = new FeedDAO();
		dao.createFeed(fee);
		return "Microservice has insert the food";
	}

}
