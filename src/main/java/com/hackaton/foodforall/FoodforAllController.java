package com.hackaton.foodforall;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.*;
import com.hackaton.foodforall.dao.*;
import com.hackaton.foodforall.dto.*;

@RestController
public class FoodforAllController {
	
	FeedDAO feed;
	BeneficiariesDAO bene;
	DonorDAO donor;
	CommunityDAO comm;

	@RequestMapping("/showFeed")
	public ArrayList<Feed> feedConsult() {
		feed = new FeedDAO();
		return feed.feedConsult();
	}

	@RequestMapping("/createBeneficed")
	public String InsertBeneficiare(Beneficiaries ben) {
		bene = new BeneficiariesDAO();
		bene.createBeneficiaries(ben);
		return "Microservice has insert a beneficiary";
	}

	@RequestMapping("/createDonation")
	public String InsertDonor(Donation don) {
		donor = new DonorDAO();
		feed = new FeedDAO();
		donor.createDonationF(don);
		feed.createFeed(don);
		return "Microservice has insert a donation";
	}

	@RequestMapping("/showCommunity")
	public ArrayList<Community> SearchCommunity() {
		comm = new CommunityDAO();
		System.out.println(comm.searchCommunity());
		return comm.searchCommunity();
	}
}
