package com.hackaton.foodforall;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hackaton.foodforall.dao.FeedDAO;
import com.hackaton.foodforall.dto.Beneficiaries;
import com.hackaton.foodforall.dto.Feed;

@RestController
public class FoodforAllController {
	
	@RequestMapping("/showFeed")
	public ArrayList<Feed> feedConsult(){
		FeedDAO dao = new FeedDAO();
		return dao.feedConsult();
	}
	
	@RequestMapping("/createBeneficed")
	public String InsertarUsuario(Beneficiaries ben) {
		BeneficiariesDAO dao = new BeneficiariesDAO();
		dao.createBeneficiaries(ben);
		return "Microservice of insert a beneficiary";
	}
	
}

