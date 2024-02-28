package in.aman.bindings;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EdResponse {

	private Long caseNum;
	
	private String planName;

	private String planStatus;

	private Double benifitAmt;

	private LocalDate eligStartDate;

	private LocalDate eligEndDate;

	private String deialRsn;

}
