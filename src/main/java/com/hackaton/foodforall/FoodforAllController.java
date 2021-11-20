package com.hackaton.foodforall;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.*;
import com.hackaton.foodforall.dao.*;
import com.hackaton.foodforall.dto.*;

/*
 * This is the principal class and it have all microservices.
 */
@RestController
public class FoodforAllController {

	FeedDAO feed;
	BeneficiariesDAO bene;
	DonorDAO donor;
	CommunityDAO comm;

	/*
	 * This microservice show the list of feed donated that are into database, for
	 * the beneficiaries can will choose.
	 */
	@RequestMapping("/showFeed")
	public ArrayList<Feed> feedConsult() {
		feed = new FeedDAO();
		return feed.feedConsult();
	}

	/*
	 * This microservice insert into database the beneficiaries for that they can
	 * receive the donations.
	 */
	@RequestMapping("/createBeneficed")
	public String InsertBeneficiare(Beneficiaries ben) {
		bene = new BeneficiariesDAO();
		bene.createBeneficiaries(ben);
		return "Microservice has insert a beneficiary";
	}

	/*
	 * This microservice insert into database the donations made of the donors for
	 * that the beneficiaries will can receive them, and too insert into database
	 * the donors that can will be a person or a organitazion.
	 */
	@RequestMapping("/createDonation")
	public String InsertDonor(Donation don) {
		donor = new DonorDAO();
		feed = new FeedDAO();
		donor.createDonationF(don);
		feed.createFeed(don);
		return "Microservice has insert a donation";
	}

	/*
	 * This microservice show the list of communities that are into database, for
	 * that the beneficiaries can will choose your community.
	 */
	@RequestMapping("/showCommunity")
	public ArrayList<Community> SearchCommunity() {
		comm = new CommunityDAO();
		// System.out.println(comm.searchCommunity());
		return comm.searchCommunity();
	}

	/*
	 * This microservice show the list of beneficiaries that are into database, for
	 * that the beneficiary can will know if are into database and receive
	 * donations.
	 */
	@RequestMapping("/ShowBeneficiaries")
	public ArrayList<Beneficiaries> BeneficiariesConsult(String dni) {
		bene = new BeneficiariesDAO();
		System.out.println(bene.BeneficiariesConsult(dni));
		return bene.BeneficiariesConsult(dni);
	}

}
