package com.example.accessingdatarestmysql;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicInsert;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
@DynamicInsert
public class Schedule extends BaseTimeEntity {

	@Id
	@GeneratedValue
	@Column(name = "schedule_id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "agent_id")
	private Agent agent;

	@Column
	private LocalDate receipt_date;         // 접수일

	@Column
	private LocalDate visit_date;           // 방문날짜

	@Column
	private LocalTime visit_time;           // 방문시간

	@Column(name = "estimated_cnt")         // TODO: 도메인 리팩토링 하면서 한 번에 estimated_cnt로 적용하기
	private Integer estimate_num;           // 참여 예상 인원

	@Column
	private Integer new_cnt;                // 신규 예상 인원

	@Column
	@Lob
	private String center_etc;               // 시설 특이사항

	@Column
	@Lob
	private String agent_etc;                // 현장요원 특이사항

	@Column
	@Lob
	private String total_etc;               // 스케쥴 특이사항

	@Column(length = 20)
	private String call_check;              // 최근 통화 상태

	@Column(length = 100)
	private String call_check_info;         // 최근 통화 상태 설명

	@Column
	@Lob
	private String modified_info;           // 변경 사항

	@NotNull
	@Column
	private boolean valid;                 // 스케줄 유효한지

	/*
		날짜 : 2022/02/10 4:08 오후
		작성자 : 원보라
		작성내용 : 앱 도메인 추가
	*/

	private String late_comment;    //늦는 사유 멘트 현장요원이 선택하면 시설에 띄워주기

	private String cancel_comment; 			// 일정 취소 사유


	/*
		날짜 : 2022/02/11 3:46 오후
		작성자 : 원보라
		작성내용 : updateLateComment, updateAccept
	*/
	public void updateLateComment(String late_comment) {
		this.late_comment = late_comment;
	}


	public void mappingAgent(Agent agent) {
		this.agent = agent;
		agent.getScheduleList().add(this);
	}
}
