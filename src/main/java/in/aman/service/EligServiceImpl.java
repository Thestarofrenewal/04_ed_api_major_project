package in.aman.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.aman.bindings.EdResponse;
import in.aman.entities.EducationEntity;
import in.aman.entities.EligEntity;
import in.aman.entities.IncomeEntity;
import in.aman.entities.KidEntity;
import in.aman.entities.PlanEntity;
import in.aman.entities.PlanSelEntity;
import in.aman.repositories.EducationRepo;
import in.aman.repositories.EligRepo;
import in.aman.repositories.IncomeRepo;
import in.aman.repositories.KidRepo;
import in.aman.repositories.PlanRepo;
import in.aman.repositories.PlanSelRepo;

@Service
public class EligServiceImpl implements EligService {

	@Autowired
	private PlanSelRepo planSelRepo;

	@Autowired
	private PlanRepo planRepo;

	@Autowired
	private IncomeRepo incomeRepo;

	@Autowired
	private EducationRepo educationRepo;

	@Autowired
	private KidRepo kidRepo;
	
	@Autowired
	private EligRepo eligRepo;

	@Override
	public EdResponse determineEligibility(Long caseNum) {

		EdResponse response = new EdResponse();

		PlanSelEntity planSel = planSelRepo.findByCaseNum(caseNum);

		Integer planId = planSel.getPlanId();

		PlanEntity planEntity = planRepo.findById(planId).get();

		String planName = planEntity.getPlanName();

		IncomeEntity incomeEntity = incomeRepo.findBycaseNum(caseNum);

		EducationEntity educationEntity = educationRepo.findByCaseNum(caseNum);

		List<KidEntity> kidsEntities = kidRepo.findByCaseNum(caseNum);

		response.setPlanName(planName);
		response.setCaseNum(caseNum);

		if ("SNAP".equals(planName)) {

			Double salaryIncome = incomeEntity.getSalaryIncome();
			if (salaryIncome > 300) {

				response.setPlanStatus("DN");
				response.setDeialRsn("High Salary Income");
			} else {
				
				response.setPlanStatus("AP");
				response.setBenifitAmt(350.00);
				response.setEligStartDate(LocalDate.now());
				response.setEligEndDate(LocalDate.now().plusMonths(6));
			}
		}else if ("CCAP".equals(planName)) {
			
		}else if ("Medicaid".equals(planName)) {
			
		}else if ("Medicare".equals(planName)) {
			
		}else if ("RIW".equals(planName)) {
			
		}
		
		EligEntity entity = new EligEntity();
		BeanUtils.copyProperties(response, entity);
		
		eligRepo.save(entity);

		return response;
	}

	@Override
	public boolean generateCo(Long caseNum) {

		return false;
	}

}
