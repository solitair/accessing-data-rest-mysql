package com.example.accessingdatarestmysql;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Agent extends BaseTimeEntity {

	@OneToMany(mappedBy = "agent")
	private final List<Schedule> scheduleList = new ArrayList<Schedule>();
	/*
		날짜 : 2022/02/10 4:30 오후
		작성자 : 원보라
		작성내용 : 앱 도메인 추가
	*/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "agent_id")
	private Long id;         //'primary_key'
	@NotBlank
	@Column(length = 100)
	private String a_name;                             //'현장 요원 이름'
	@NotBlank
	@Column(length = 100)
	private String a_ph;                               //'현장 요원 전화번호',
	@NotBlank
	@Column(length = 100)
	private String a_code;                             //'현장 요원 코드'
	@NotBlank
	@Column(length = 100)
	private String a_address;                          //'현장 요원 집 주소',
	@NotNull
	@Column(length = 100)
	private String a_equipment;                         //'장비 번호'
	@NotNull
	private Double a_latitude;                          //'현장 요원 위도',
	@NotNull
	private Double a_longitude;                         //'현장 요원 경도',
	@NotNull
	/*
		작성 날짜: 2022/02/16 4:20 오후
		작성자: 고준영
		작성 내용: 요원 권한 -> AGENT, 요원아이디&비번
	*/
	//    @NotBlank
	@Column(length = 100)
	private String a_nickname;              // "현장요원 id"
	//    @NotBlank
	@Column(length = 100)
	private String a_pwd;                   // '현장요원 비밀번호',
	private String a_picture;   //현장요원 사진

    /*
        날짜 : 2022/03/11 1:42 오후
        작성자 : 원보라
        작성내용 : 현장요원 현재 위치
    */

	private String a_cur_lat;                          //'현장 요원 현재 위도',
	private String a_cur_long;                         //'현장 요원 현재 경도',



	/*
		날짜 : 2022/02/16 10:35 오전
		작성자 : 원보라
		작성내용 : 현장요원 사진 업로드
	*/
	public void uploadPicture(String a_picture) {
		this.a_picture = a_picture;
	}

	/*
		날짜 : 2022/03/11 1:55 오후
		작성자 : 원보라
		작성내용 : 현장요원 현재 위치 저장
	*/
	public void saveCurLocation(String a_cur_lat, String a_cur_long) {
		this.a_cur_lat = a_cur_lat;
		this.a_cur_long = a_cur_long;
	}
}


