package in.aman.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CO_NOTICES")
@Setter
@Getter
public class CoNoticeEntity {
	
	@Id
	@GeneratedValue
	private Integer noticeId;
	
	private Long caseNum;
	
	private String noticeStatus;
	
	private String noticeUrl;
	
	private Integer edgTraceId;
	
	private LocalDate noticePrintDate;

}
