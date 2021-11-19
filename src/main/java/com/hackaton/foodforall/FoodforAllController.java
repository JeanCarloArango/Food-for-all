package com.hackaton.foodforall;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.*;
import com.hackaton.foodforall.dao.*;
import com.hackaton.foodforall.dto.*;

@RestController
public class FoodforAllController {

	@RequestMapping("/showFood")
	public ArrayList<Food> foodConsult() {
		FoodDAO dao = new FoodDAO();
		return dao.foodConsult();
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

	@RequestMapping("/createFood")
	public String InsertFood(Food foo) {
		FoodDAO dao = new FoodDAO();
		dao.createFood(foo);
		return "Microservice has insert the food";
	}

}
