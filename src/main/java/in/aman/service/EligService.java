package in.aman.service;

import in.aman.bindings.EdResponse;

public interface EligService {

	public EdResponse determineEligibility(Long caseNum);

	public boolean generateCo(Long caseNum);

	
}
