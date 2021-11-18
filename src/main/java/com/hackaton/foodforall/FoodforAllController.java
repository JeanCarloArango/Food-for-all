package com.hackaton.foodforall;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.*;
import com.hackaton.foodforall.dao.*;
import com.hackaton.foodforall.dto.*;

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

