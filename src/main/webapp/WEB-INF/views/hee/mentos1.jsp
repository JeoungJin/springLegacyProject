<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cpath" value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멘토스 전체조회</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/mentos/mentos1Style.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/mentos/mentos1Vars.css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

	<div class="full">
		<div class="nav-bar">
			<img class="image-18" src="image-180.png" /> <img class="me-mento-2"
				src="me-mento-20.png" />
			<div class="frame-49">
				<div class="div2">매치업</div>
				<div class="div2">멘토스</div>
				<div class="div2">킵고잉</div>
				<div class="div2">어부바</div>
				<div class="div2">큐알코딩</div>
			</div>
			<div class="searchbar">
				<div class="div3">나의 성장을 도와줄 멘토를 찾아보세요</div>
				<div class="icon-search-01">
					<img class="interface-search-magnifying-glass"
						src="interface-search-magnifying-glass0.svg" />
				</div>
			</div>
			<div class="frame-11">
				<div class="div4">로그인</div>
			</div>
			<img class="vuesax-linear-textalign-justifycenter"
				src="vuesax-linear-textalign-justifycenter0.svg" /> <img
				class="vuesax-linear-coin" src="vuesax-linear-coin0.svg" /> <img
				class="icon-alert-notification-bell-new"
				src="icon-alert-notification-bell-new0.svg" />
			<div class="vuesax-linear-profile-circle">
				<img class="profile-circle" src="profile-circle0.svg" />
			</div>
		</div>
		<div class="full-detail-select">
			<div class="detail-select">
				<div class="detail-select-li">
					<div class="detail-select-li-text ">
						<div class="detail-select-li-text">멘토스오픈 순</div>
						<img class="vector" src="vector0.svg" />
					</div>
				</div>
				<div class="detail-select-li">
					<div class="detail-select-li-text">
						<div class="detail-select-li-text">내 지역</div>
						<img class="vector" src="vector0.svg" />
					</div>
				</div>
				<div class="detail-select-li">
					<div class="detail-select-li-text ">
						<div class="detail-select-li-text">학습유형</div>
						<img class="vector" src="vector0.svg" />
					</div>
				</div>
				<div class="detail-select-li">
					<div class="detail-select-li-text ">
						<div class="detail-select-li-text">요일</div>
						<img class="vector" src="vector0.svg" />
					</div>
				</div>
				<div class="detail-select-li">
					<div class="detail-select-li-text ">
						<div class="detail-select-li-text">시간</div>
						<img class="vector" src="vector0.svg" />
					</div>
				</div>
				<div class="detail-select-li">
					<div class="detail-select-li-text ">
						<div class="detail-select-li-text">카테고리</div>
						<img class="vector" src="vector0.svg" />
					</div>
				</div>
				<div class="detail-select-li">
					<div class="detail-select-li-text ">
						<div class="detail-select-li-text">언어</div>
						<img class="vector" src="vector0.svg" />
					</div>
				</div>
			</div>
			<button class="mentos-create-button"
				onclick="location.href='${cpath}/mentos/mentosdetail.do'">멘토스
				생성하기</button>
		</div>
		<div class="mentos-all-class">
			<div class="mentos-all-class-row">
				<div class="advertisement-frame">
					<img class="advertisement-image-2025"
						src="${pageContext.request.contextPath}/resources/images/watch.jpg" />
				</div>
				<div class="scroll-container">
					<div class="mentos-class-cardview">
						<div class="memtos-class-cardview-top">
							<div class="memtos-class-cardview-top-left">
								<div class="memtos-class-cardview-top-left-text">
									<div class="top-text">D</div>
									<div class="top-text">-</div>
									<div class="top-text">1</div>
								</div>
							</div>
							<div class="memtos-class-cardview-top-right">
								<div class="memtos-class-cardview-top-right-text">
									<img class="person-image"
										src="${pageContext.request.contextPath}/resources/images/mentos1/person.svg" />
									<div class="top-text">1</div>
									<div class="top-text">/</div>
									<div class="top-text">3</div>
								</div>
							</div>
						</div>
						<div class="mentos-class-cardview-before">
							<img class="image"
								src="${pageContext.request.contextPath}/resources/images/mentos1/class1.png" />
							<div class="class-title">파이썬으로 나만의 블로그 자동화 프로그램 만들기</div>
							<div class="class-detail-text-full">
								<div class="class-detail-icon-text">
									<img class="icon"
										src="${pageContext.request.contextPath}/resources/images/mentos1/mento.svg" />
									<div class="class-detail-text">김코딩</div>
									<div class="pre-mento-full">
										<div class="pre-mento-circle"></div>
										<div class="pre-mento">pre-mento</div>
									</div>
								</div>
								<div class="class-detail-icon-text">
									<div class="icon">
										<img class="icon-time-calendar"
											src="${pageContext.request.contextPath}/resources/images/mentos1/day.svg" />
									</div>
									<div class="class-detail-text">2025/06/02</div>
									<div class="class-detail-text">-</div>
									<div class="class-detail-text">2025/06/02</div>
								</div>
								<div class="class-detail-icon-text">
									<img class="icon"
										src="${pageContext.request.contextPath}/resources/images/mentos1/time.svg" />
									<div class="class-detail-text">13시</div>
									<div class="class-detail-text">-</div>
									<div class="class-detail-text">15시</div>
									<div class="class-detail-text">(화)</div>
								</div>
								<div class="class-detail-icon-text">
									<img class="icon"
										src="${pageContext.request.contextPath}/resources/images/mentos1/maps.svg" />
									<div class="class-detail-text">여의도</div>
								</div>
								<div class="class-detail-text-fee-full">
									<div class="class-detail-text-fee">무료</div>
								</div>
							</div>
						</div>
					</div>
					<div class="mentos-class-cardview">
						<div class="memtos-class-cardview-top">
							<div class="memtos-class-cardview-top-left">
								<div class="memtos-class-cardview-top-left-text">
									<div class="top-text">D</div>
									<div class="top-text">-</div>
									<div class="top-text">2</div>
								</div>
							</div>
							<div class="memtos-class-cardview-top-right">
								<div class="memtos-class-cardview-top-right-text">
									<img class="person-image"
										src="/memento/resources/images/mentos1/person.svg">
									<div class="top-text">1</div>
									<div class="top-text">/</div>
									<div class="top-text">3</div>
								</div>
							</div>
						</div>

						<div class="mentos-class-cardview-before">
							<img class="image"
								src="/memento/resources/images/mentos1/class2.png" />
							<div class="class-title">C# 프로그래밍 기초부터 실전 활용까지</div>

							<div class="class-detail-text-full">
								<div class="class-detail-icon-text">
									<img class="icon"
										src="/memento/resources/images/mentos1/mento.svg" />
									<div class="class-detail-text">이코딩</div>
									<div class="pre-mento-full">
										<div class="pre-mento-circle"></div>
										<div class="pre-mento">pre-mento</div>
									</div>
								</div>

								<div class="class-detail-icon-text">
									<div class="icon">
										<img class="icon-time-calendar"
											src="/memento/resources/images/mentos1/day.svg" />
									</div>
									<div class="class-detail-text">2025/06/10</div>
									<div class="class-detail-text">-</div>
									<div class="class-detail-text">2025/06/10</div>
								</div>

								<div class="class-detail-icon-text">
									<img class="icon"
										src="/memento/resources/images/mentos1/time.svg" />
									<div class="class-detail-text">14시</div>
									<div class="class-detail-text">-</div>
									<div class="class-detail-text">16시</div>
									<div class="class-detail-text">(월)</div>
								</div>

								<div class="class-detail-icon-text">
									<img class="icon"
										src="/memento/resources/images/mentos1/maps.svg" />
									<div class="class-detail-text">서울역</div>
								</div>

								<div class="class-detail-text-fee-full">
									<div class="class-detail-text-fee">무료</div>
								</div>
							</div>
						</div>
					</div>

					<div class="mentos-class-cardview">
						<div class="memtos-class-cardview-top">
							<div class="memtos-class-cardview-top-left">
								<div class="memtos-class-cardview-top-left-text">
									<div class="top-text">D</div>
									<div class="top-text">-</div>
									<div class="top-text">2</div>
								</div>
							</div>
							<div class="memtos-class-cardview-top-right">
								<div class="memtos-class-cardview-top-right-text">
									<img class="person-image"
										src="/memento/resources/images/mentos1/person.svg">
									<div class="top-text">1</div>
									<div class="top-text">/</div>
									<div class="top-text">3</div>
								</div>
							</div>
						</div>

						<div class="mentos-class-cardview-before">
							<img class="image"
								src="/memento/resources/images/mentos1/class.png" />
							<div class="class-title">초초보도 할 수 있다! 파이썬으로 만드는 스페이스 인베이더</div>

							<div class="class-detail-text-full">
								<div class="class-detail-icon-text">
									<img class="icon"
										src="/memento/resources/images/mentos1/mento.svg" />
									<div class="class-detail-text">박코딩</div>
									<div class="pre-mento-full">
										<div class="pre-mento-circle"></div>
										<div class="pre-mento">pre-mento</div>
									</div>
								</div>

								<div class="class-detail-icon-text">
									<div class="icon">
										<img class="icon-time-calendar"
											src="/memento/resources/images/mentos1/day.svg" />
									</div>
									<div class="class-detail-text">2025/06/07</div>
									<div class="class-detail-text">-</div>
									<div class="class-detail-text">2025/06/07</div>
								</div>

								<div class="class-detail-icon-text">
									<img class="icon"
										src="/memento/resources/images/mentos1/time.svg" />
									<div class="class-detail-text">10시</div>
									<div class="class-detail-text">-</div>
									<div class="class-detail-text">12시</div>
									<div class="class-detail-text">(토)</div>
								</div>

								<div class="class-detail-icon-text">
									<img class="icon"
										src="/memento/resources/images/mentos1/maps.svg" />
									<div class="class-detail-text">왕십리</div>
								</div>

								<div class="class-detail-text-fee-full">
									<div class="class-detail-text-fee">무료</div>
								</div>
							</div>
						</div>
					</div>

					<div class="mentos-class-cardview">
						<div class="memtos-class-cardview-top">
							<div class="memtos-class-cardview-top-left">
								<div class="memtos-class-cardview-top-left-text">
									<div class="top-text">D</div>
									<div class="top-text">-</div>
									<div class="top-text">2</div>
								</div>
							</div>
							<div class="memtos-class-cardview-top-right">
								<div class="memtos-class-cardview-top-right-text">
									<img class="person-image"
										src="/memento/resources/images/mentos1/person.svg">
									<div class="top-text">1</div>
									<div class="top-text">/</div>
									<div class="top-text">3</div>
								</div>
							</div>
						</div>

						<div class="mentos-class-cardview-before">
							<img class="image"
								src="/memento/resources/images/mentos1/class4.png" />
							<div class="class-title">독하게 C를 배운 사람을 위한 선형 자료구조</div>

							<div class="class-detail-text-full">
								<div class="class-detail-icon-text">
									<img class="icon"
										src="/memento/resources/images/mentos1/mento.svg" />
									<div class="class-detail-text">최코딩</div>
									<div class="pre-mento-full">
										<div class="pre-mento-circle"></div>
										<div class="pre-mento">pre-mento</div>
									</div>
								</div>

								<div class="class-detail-icon-text">
									<div class="icon">
										<img class="icon-time-calendar"
											src="/memento/resources/images/mentos1/day.svg" />
									</div>
									<div class="class-detail-text">2025/06/12</div>
									<div class="class-detail-text">-</div>
									<div class="class-detail-text">2025/06/12</div>
								</div>

								<div class="class-detail-icon-text">
									<img class="icon"
										src="/memento/resources/images/mentos1/time.svg" />
									<div class="class-detail-text">13시</div>
									<div class="class-detail-text">-</div>
									<div class="class-detail-text">15시</div>
									<div class="class-detail-text">(목)</div>
								</div>

								<div class="class-detail-icon-text">
									<img class="icon"
										src="/memento/resources/images/mentos1/maps.svg" />
									<div class="class-detail-text">압구정</div>
								</div>

								<div class="class-detail-text-fee-full">
									<div class="class-detail-text-fee">무료</div>
								</div>
							</div>
						</div>
					</div>

					<div class="mentos-class-cardview">
						<div class="memtos-class-cardview-top">
							<div class="memtos-class-cardview-top-left">
								<div class="memtos-class-cardview-top-left-text">
									<div class="top-text">D</div>
									<div class="top-text">-</div>
									<div class="top-text">2</div>
								</div>
							</div>
							<div class="memtos-class-cardview-top-right">
								<div class="memtos-class-cardview-top-right-text">
									<img class="person-image"
										src="/memento/resources/images/mentos1/person.svg">
									<div class="top-text">1</div>
									<div class="top-text">/</div>
									<div class="top-text">3</div>
								</div>
							</div>
						</div>

						<div class="mentos-class-cardview-before">
							<img class="image"
								src="/memento/resources/images/mentos1/class4.png" />
							<div class="class-title">독하게 C를 배운 사람을 위한 선형 자료구조</div>

							<div class="class-detail-text-full">
								<div class="class-detail-icon-text">
									<img class="icon"
										src="/memento/resources/images/mentos1/mento.svg" />
									<div class="class-detail-text">최코딩</div>
									<div class="pre-mento-full">
										<div class="pre-mento-circle"></div>
										<div class="pre-mento">pre-mento</div>
									</div>
								</div>

								<div class="class-detail-icon-text">
									<div class="icon">
										<img class="icon-time-calendar"
											src="/memento/resources/images/mentos1/day.svg" />
									</div>
									<div class="class-detail-text">2025/06/12</div>
									<div class="class-detail-text">-</div>
									<div class="class-detail-text">2025/06/12</div>
								</div>

								<div class="class-detail-icon-text">
									<img class="icon"
										src="/memento/resources/images/mentos1/time.svg" />
									<div class="class-detail-text">13시</div>
									<div class="class-detail-text">-</div>
									<div class="class-detail-text">15시</div>
									<div class="class-detail-text">(목)</div>
								</div>

								<div class="class-detail-icon-text">
									<img class="icon"
										src="/memento/resources/images/mentos1/maps.svg" />
									<div class="class-detail-text">압구정</div>
								</div>

								<div class="class-detail-text-fee-full">
									<div class="class-detail-text-fee">무료</div>
								</div>
							</div>
						</div>
					</div>


				</div>
			</div>
			<div class="mentos-all-class-row">
				<div class="frame-3532">
					<div class="cardview-memtos-before">
						<div class="frame-3656">
							<div class="frame-3772">
								<div class="d">D</div>
								<div class="div6">-</div>
								<div class="_2">2</div>
							</div>
						</div>
						<div class="frame-3657">
							<img class="vuesax-linear-user-tick"
								src="${pageContext.request.contextPath}/resources/images/mentos1/person.svg" />
							<div class="_1">1</div>
							<div class="div7">/</div>
							<div class="_3">3</div>
						</div>
					</div>
					<div class="mentos-class-22">
						<img class="image"
							src="${pageContext.request.contextPath}/resources/images/mentos1/class5.png" />
						<div class="aws2">비전공자도 이해할 수 있는 AWS 입문/실전</div>
						<div class="frame-4062">
							<div class="frame-407">
								<img class="user-user"
									src="${pageContext.request.contextPath}/resources/images/mentos1/mento.svg" />
								<div class="div8">정진</div>
								<div class="group-371">
									<div class="rectangle-2792"></div>
									<div class="mento">mento</div>
								</div>
							</div>
							<div class="frame-408">
								<div class="icon-time-02">
									<img class="icon-time-calendar"
										src="${pageContext.request.contextPath}/resources/images/mentos1/day.svg" />
								</div>
								<div class="_2025-06-232">
									<span> <span class="_2025-06-232-span">2025/06/23</span>
										<span class="_2025-06-232-span2"></span>
									</span>
								</div>
								<div class="div8">-</div>
								<div class="_2025-06-30">2025/06/30</div>
							</div>
							<div class="frame-409">
								<div class="icon-time-04">
									<img class="icon-time-clock-outlined"
										src="${pageContext.request.contextPath}/resources/images/mentos1/time.svg" />
								</div>
								<div class="_15">15시</div>
								<div class="div10">
									<span> <span class="div-10-span">-</span> <span
										class="div-10-span2"></span>
									</span>
								</div>
								<div class="_172">
									<span> <span class="_172-span">17시</span> <span
										class="_172-span2"></span>
									</span>
								</div>
								<div class="div10">
									<span> <span class="div-10-span">(화)</span> <span
										class="div-10-span2"></span>
									</span>
								</div>
							</div>
							<div class="frame-410">
								<div class="icon-maps-04">
									<img class="icon-maps-map-pin"
										src="${pageContext.request.contextPath}/resources/images/mentos1/maps.svg" />
								</div>
								<div class="div8">홍대</div>
							</div>
							<div class="frame-3659">
								<div class="_45-000">₩45,000</div>
							</div>
						</div>
					</div>
				</div>
				<div class="frame-3532">
					<div class="cardview-memtos-before">
						<div class="frame-3656">
							<div class="frame-3772">
								<div class="d">D</div>
								<div class="div6">-</div>
								<div class="_2">2</div>
							</div>
						</div>
						<div class="frame-3657">
							<img class="vuesax-linear-user-tick"
								src="${pageContext.request.contextPath}/resources/images/mentos1/person.svg" />
							<div class="_1">1</div>
							<div class="div7">/</div>
							<div class="_3">3</div>
						</div>
					</div>
					<div class="mentos-class-22">
						<img class="image"
							src="${pageContext.request.contextPath}/resources/images/mentos1/class6.png" />
						<div class="aws2">비전공자도 이해할 수 있는 AWS 입문/실전</div>
						<div class="frame-4062">
							<div class="frame-407">
								<img class="user-user"
									src="${pageContext.request.contextPath}/resources/images/mentos1/mento.svg" />
								<div class="div8">정진</div>
								<div class="group-371">
									<div class="rectangle-2792"></div>
									<div class="mento">mento</div>
								</div>
							</div>
							<div class="frame-408">
								<div class="icon-time-02">
									<img class="icon-time-calendar"
										src="${pageContext.request.contextPath}/resources/images/mentos1/day.svg" />
								</div>
								<div class="_2025-06-232">
									<span> <span class="_2025-06-232-span">2025/06/23</span>
										<span class="_2025-06-232-span2"></span>
									</span>
								</div>
								<div class="div8">-</div>
								<div class="_2025-06-30">2025/06/30</div>
							</div>
							<div class="frame-409">
								<div class="icon-time-04">
									<img class="icon-time-clock-outlined"
										src="${pageContext.request.contextPath}/resources/images/mentos1/time.svg" />
								</div>
								<div class="_15">15시</div>
								<div class="div10">
									<span> <span class="div-10-span">-</span> <span
										class="div-10-span2"></span>
									</span>
								</div>
								<div class="_172">
									<span> <span class="_172-span">17시</span> <span
										class="_172-span2"></span>
									</span>
								</div>
								<div class="div10">
									<span> <span class="div-10-span">(화)</span> <span
										class="div-10-span2"></span>
									</span>
								</div>
							</div>
							<div class="frame-410">
								<div class="icon-maps-04">
									<img class="icon-maps-map-pin"
										src="${pageContext.request.contextPath}/resources/images/mentos1/maps.svg" />
								</div>
								<div class="div8">홍대</div>
							</div>
							<div class="frame-3659">
								<div class="_45-000">₩45,000</div>
							</div>
						</div>
					</div>
				</div>
				<div class="frame-3543">
					<div class="cardview-memtos-before">
						<div class="frame-3656">
							<div class="frame-3772">
								<div class="d">D</div>
								<div class="div6">-</div>
								<div class="_2">2</div>
							</div>
						</div>
						<div class="frame-3657">
							<img class="vuesax-linear-user-tick"
								src="${pageContext.request.contextPath}/resources/images/mentos1/person.svg" />
							<div class="_1">1</div>
							<div class="div7">/</div>
							<div class="_3">3</div>
						</div>
					</div>
					<div class="mentos-class-22">
						<img class="image"
							src="${pageContext.request.contextPath}/resources/images/mentos1/class7.png" />
						<div class="aws2">비전공자도 이해할 수 있는 AWS 입문/실전</div>
						<div class="frame-4062">
							<div class="frame-407">
								<img class="user-user"
									src="${pageContext.request.contextPath}/resources/images/mentos1/mento.svg" />
								<div class="div8">정진</div>
								<div class="group-371">
									<div class="rectangle-2792"></div>
									<div class="mento">mento</div>
								</div>
							</div>
							<div class="frame-408">
								<div class="icon-time-02">
									<img class="icon-time-calendar"
										src="${pageContext.request.contextPath}/resources/images/mentos1/day.svg" />
								</div>
								<div class="_2025-06-232">
									<span> <span class="_2025-06-232-span">2025/06/23</span>
										<span class="_2025-06-232-span2"></span>
									</span>
								</div>
								<div class="div8">-</div>
								<div class="_2025-06-30">2025/06/30</div>
							</div>
							<div class="frame-409">
								<div class="icon-time-04">
									<img class="icon-time-clock-outlined"
										src="${pageContext.request.contextPath}/resources/images/mentos1/time.svg" />
								</div>
								<div class="_15">15시</div>
								<div class="div10">
									<span> <span class="div-10-span">-</span> <span
										class="div-10-span2"></span>
									</span>
								</div>
								<div class="_172">
									<span> <span class="_172-span">17시</span> <span
										class="_172-span2"></span>
									</span>
								</div>
								<div class="div10">
									<span> <span class="div-10-span">(화)</span> <span
										class="div-10-span2"></span>
									</span>
								</div>
							</div>
							<div class="frame-410">
								<div class="icon-maps-04">
									<img class="icon-maps-map-pin"
										src="${pageContext.request.contextPath}/resources/images/mentos1/maps.svg" />
								</div>
								<div class="div8">홍대</div>
							</div>
							<div class="frame-3659">
								<div class="_45-000">₩45,000</div>
							</div>
						</div>
					</div>
				</div>
				<div class="frame-355">
					<div class="cardview-memtos-before">
						<div class="frame-3656">
							<div class="frame-3772">
								<div class="d">D</div>
								<div class="div6">-</div>
								<div class="_2">2</div>
							</div>
						</div>
						<div class="frame-3657">
							<img class="vuesax-linear-user-tick"
								src="${pageContext.request.contextPath}/resources/images/mentos1/person.svg" />
							<div class="_1">1</div>
							<div class="div7">/</div>
							<div class="_3">3</div>
						</div>
					</div>
					<div class="mentos-class-22">
						<img class="image"
							src="${pageContext.request.contextPath}/resources/images/mentos1/class8.png" />
						<div class="aws2">비전공자도 이해할 수 있는 AWS 입문/실전</div>
						<div class="frame-4062">
							<div class="frame-407">
								<img class="user-user"
									src="${pageContext.request.contextPath}/resources/images/mentos1/mento.svg" />
								<div class="div8">정진</div>
								<div class="group-371">
									<div class="rectangle-2792"></div>
									<div class="mento">mento</div>
								</div>
							</div>
							<div class="frame-408">
								<div class="icon-time-02">
									<img class="icon-time-calendar"
										src="${pageContext.request.contextPath}/resources/images/mentos1/day.svg" />
								</div>
								<div class="_2025-06-232">
									<span> <span class="_2025-06-232-span">2025/06/23</span>
										<span class="_2025-06-232-span2"></span>
									</span>
								</div>
								<div class="div8">-</div>
								<div class="_2025-06-30">2025/06/30</div>
							</div>
							<div class="frame-409">
								<div class="icon-time-04">
									<img class="icon-time-clock-outlined"
										src="${pageContext.request.contextPath}/resources/images/mentos1/time.svg" />
								</div>
								<div class="_15">15시</div>
								<div class="div10">
									<span> <span class="div-10-span">-</span> <span
										class="div-10-span2"></span>
									</span>
								</div>
								<div class="_172">
									<span> <span class="_172-span">17시</span> <span
										class="_172-span2"></span>
									</span>
								</div>
								<div class="div10">
									<span> <span class="div-10-span">(화)</span> <span
										class="div-10-span2"></span>
									</span>
								</div>
							</div>
							<div class="frame-410">
								<div class="icon-maps-04">
									<img class="icon-maps-map-pin"
										src="${pageContext.request.contextPath}/resources/images/mentos1/maps.svg" />
								</div>
								<div class="div8">홍대</div>
							</div>
							<div class="frame-3659">
								<div class="_45-000">₩45,000</div>
							</div>
						</div>
					</div>
				</div>
				<div class="frame-356">
					<div class="cardview-memtos-before">
						<div class="frame-3656">
							<div class="frame-3772">
								<div class="d">D</div>
								<div class="div6">-</div>
								<div class="_2">2</div>
							</div>
						</div>
						<div class="frame-3657">
							<img class="vuesax-linear-user-tick"
								src="${pageContext.request.contextPath}/resources/images/mentos1/person.svg" />
							<div class="_1">1</div>
							<div class="div7">/</div>
							<div class="_3">3</div>
						</div>
					</div>
					<div class="mentos-class-22">
						<img class="image"
							src="${pageContext.request.contextPath}/resources/images/mentos1/class9.png" />
						<div class="aws2">비전공자도 이해할 수 있는 AWS 입문/실전</div>
						<div class="frame-4062">
							<div class="frame-407">
								<img class="user-user"
									src="${pageContext.request.contextPath}/resources/images/mentos1/mento.svg" />
								<div class="div8">정진</div>
								<div class="group-371">
									<div class="rectangle-2792"></div>
									<div class="mento">mento</div>
								</div>
							</div>
							<div class="frame-408">
								<div class="icon-time-02">
									<img class="icon-time-calendar"
										src="${pageContext.request.contextPath}/resources/images/mentos1/day.svg" />
								</div>
								<div class="_2025-06-232">
									<span> <span class="_2025-06-232-span">2025/06/23</span>
										<span class="_2025-06-232-span2"></span>
									</span>
								</div>
								<div class="div8">-</div>
								<div class="_2025-06-30">2025/06/30</div>
							</div>
							<div class="frame-409">
								<div class="icon-time-04">
									<img class="icon-time-clock-outlined"
										src="${pageContext.request.contextPath}/resources/images/mentos1/time.svg" />
								</div>
								<div class="_15">15시</div>
								<div class="div10">
									<span> <span class="div-10-span">-</span> <span
										class="div-10-span2"></span>
									</span>
								</div>
								<div class="_172">
									<span> <span class="_172-span">17시</span> <span
										class="_172-span2"></span>
									</span>
								</div>
								<div class="div10">
									<span> <span class="div-10-span">(화)</span> <span
										class="div-10-span2"></span>
									</span>
								</div>
							</div>
							<div class="frame-410">
								<div class="icon-maps-04">
									<img class="icon-maps-map-pin"
										src="${pageContext.request.contextPath}/resources/images/mentos1/maps.svg" />
								</div>
								<div class="div8">홍대</div>
							</div>
							<div class="frame-3659">
								<div class="_45-000">₩45,000</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="mentos-all-class-row">
				<div class="frame-3532">
					<div class="cardview-memtos-before">
						<div class="frame-3656">
							<div class="frame-3772">
								<div class="d">D</div>
								<div class="div6">-</div>
								<div class="_2">2</div>
							</div>
						</div>
						<div class="frame-3657">
							<img class="vuesax-linear-user-tick"
								src="${pageContext.request.contextPath}/resources/images/mentos1/person.svg" />
							<div class="_1">1</div>
							<div class="div7">/</div>
							<div class="_3">3</div>
						</div>
					</div>
					<div class="mentos-class-22">
						<img class="image"
							src="${pageContext.request.contextPath}/resources/images/mentos1/class10.png" />
						<div class="aws2">비전공자도 이해할 수 있는 AWS 입문/실전</div>
						<div class="frame-4062">
							<div class="frame-407">
								<img class="user-user"
									src="${pageContext.request.contextPath}/resources/images/mentos1/mento.svg" />
								<div class="div8">정진</div>
								<div class="group-371">
									<div class="rectangle-2792"></div>
									<div class="mento">mento</div>
								</div>
							</div>
							<div class="frame-408">
								<div class="icon-time-02">
									<img class="icon-time-calendar"
										src="${pageContext.request.contextPath}/resources/images/mentos1/day.svg" />
								</div>
								<div class="_2025-06-232">
									<span> <span class="_2025-06-232-span">2025/06/23</span>
										<span class="_2025-06-232-span2"></span>
									</span>
								</div>
								<div class="div8">-</div>
								<div class="_2025-06-30">2025/06/30</div>
							</div>
							<div class="frame-409">
								<div class="icon-time-04">
									<img class="icon-time-clock-outlined"
										src="${pageContext.request.contextPath}/resources/images/mentos1/time.svg" />
								</div>
								<div class="_15">15시</div>
								<div class="div10">
									<span> <span class="div-10-span">-</span> <span
										class="div-10-span2"></span>
									</span>
								</div>
								<div class="_172">
									<span> <span class="_172-span">17시</span> <span
										class="_172-span2"></span>
									</span>
								</div>
								<div class="div10">
									<span> <span class="div-10-span">(화)</span> <span
										class="div-10-span2"></span>
									</span>
								</div>
							</div>
							<div class="frame-410">
								<div class="icon-maps-04">
									<img class="icon-maps-map-pin"
										src="${pageContext.request.contextPath}/resources/images/mentos1/maps.svg" />
								</div>
								<div class="div8">홍대</div>
							</div>
							<div class="frame-3659">
								<div class="_45-000">₩45,000</div>
							</div>
						</div>
					</div>
				</div>
				<div class="frame-3532">
					<div class="cardview-memtos-before">
						<div class="frame-3656">
							<div class="frame-3772">
								<div class="d">D</div>
								<div class="div6">-</div>
								<div class="_2">2</div>
							</div>
						</div>
						<div class="frame-3657">
							<img class="vuesax-linear-user-tick"
								src="${pageContext.request.contextPath}/resources/images/mentos1/person.svg" />
							<div class="_1">1</div>
							<div class="div7">/</div>
							<div class="_3">3</div>
						</div>
					</div>
					<div class="mentos-class-22">
						<img class="image"
							src="${pageContext.request.contextPath}/resources/images/mentos1/class11.png" />
						<div class="aws2">비전공자도 이해할 수 있는 AWS 입문/실전</div>
						<div class="frame-4062">
							<div class="frame-407">
								<img class="user-user"
									src="${pageContext.request.contextPath}/resources/images/mentos1/mento.svg" />
								<div class="div8">정진</div>
								<div class="group-371">
									<div class="rectangle-2792"></div>
									<div class="mento">mento</div>
								</div>
							</div>
							<div class="frame-408">
								<div class="icon-time-02">
									<img class="icon-time-calendar"
										src="${pageContext.request.contextPath}/resources/images/mentos1/day.svg" />
								</div>
								<div class="_2025-06-232">
									<span> <span class="_2025-06-232-span">2025/06/23</span>
										<span class="_2025-06-232-span2"></span>
									</span>
								</div>
								<div class="div8">-</div>
								<div class="_2025-06-30">2025/06/30</div>
							</div>
							<div class="frame-409">
								<div class="icon-time-04">
									<img class="icon-time-clock-outlined"
										src="${pageContext.request.contextPath}/resources/images/mentos1/time.svg" />
								</div>
								<div class="_15">15시</div>
								<div class="div10">
									<span> <span class="div-10-span">-</span> <span
										class="div-10-span2"></span>
									</span>
								</div>
								<div class="_172">
									<span> <span class="_172-span">17시</span> <span
										class="_172-span2"></span>
									</span>
								</div>
								<div class="div10">
									<span> <span class="div-10-span">(화)</span> <span
										class="div-10-span2"></span>
									</span>
								</div>
							</div>
							<div class="frame-410">
								<div class="icon-maps-04">
									<img class="icon-maps-map-pin"
										src="${pageContext.request.contextPath}/resources/images/mentos1/maps.svg" />
								</div>
								<div class="div8">홍대</div>
							</div>
							<div class="frame-3659">
								<div class="_45-000">₩45,000</div>
							</div>
						</div>
					</div>
				</div>
				<div class="frame-3543">
					<div class="cardview-memtos-before">
						<div class="frame-3656">
							<div class="frame-3772">
								<div class="d">D</div>
								<div class="div6">-</div>
								<div class="_2">2</div>
							</div>
						</div>
						<div class="frame-3657">
							<img class="vuesax-linear-user-tick"
								src="${pageContext.request.contextPath}/resources/images/mentos1/person.svg" />
							<div class="_1">1</div>
							<div class="div7">/</div>
							<div class="_3">3</div>
						</div>
					</div>
					<div class="mentos-class-22">
						<img class="image"
							src="${pageContext.request.contextPath}/resources/images/mentos1/class12.png" />
						<div class="aws2">비전공자도 이해할 수 있는 AWS 입문/실전</div>
						<div class="frame-4062">
							<div class="frame-407">
								<img class="user-user"
									src="${pageContext.request.contextPath}/resources/images/mentos1/mento.svg" />
								<div class="div8">정진</div>
								<div class="group-371">
									<div class="rectangle-2792"></div>
									<div class="mento">mento</div>
								</div>
							</div>
							<div class="frame-408">
								<div class="icon-time-02">
									<img class="icon-time-calendar"
										src="${pageContext.request.contextPath}/resources/images/mentos1/day.svg" />
								</div>
								<div class="_2025-06-232">
									<span> <span class="_2025-06-232-span">2025/06/23</span>
										<span class="_2025-06-232-span2"></span>
									</span>
								</div>
								<div class="div8">-</div>
								<div class="_2025-06-30">2025/06/30</div>
							</div>
							<div class="frame-409">
								<div class="icon-time-04">
									<img class="icon-time-clock-outlined"
										src="${pageContext.request.contextPath}/resources/images/mentos1/time.svg" />
								</div>
								<div class="_15">15시</div>
								<div class="div10">
									<span> <span class="div-10-span">-</span> <span
										class="div-10-span2"></span>
									</span>
								</div>
								<div class="_172">
									<span> <span class="_172-span">17시</span> <span
										class="_172-span2"></span>
									</span>
								</div>
								<div class="div10">
									<span> <span class="div-10-span">(화)</span> <span
										class="div-10-span2"></span>
									</span>
								</div>
							</div>
							<div class="frame-410">
								<div class="icon-maps-04">
									<img class="icon-maps-map-pin"
										src="${pageContext.request.contextPath}/resources/images/mentos1/maps.svg" />
								</div>
								<div class="div8">홍대</div>
							</div>
							<div class="frame-3659">
								<div class="_45-000">₩45,000</div>
							</div>
						</div>
					</div>
				</div>
				<div class="frame-355">
					<div class="cardview-memtos-before">
						<div class="frame-3656">
							<div class="frame-3772">
								<div class="d">D</div>
								<div class="div6">-</div>
								<div class="_2">2</div>
							</div>
						</div>
						<div class="frame-3657">
							<img class="vuesax-linear-user-tick"
								src="${pageContext.request.contextPath}/resources/images/mentos1/person.svg" />
							<div class="_1">1</div>
							<div class="div7">/</div>
							<div class="_3">3</div>
						</div>
					</div>
					<div class="mentos-class-22">
						<img class="image"
							src="${pageContext.request.contextPath}/resources/images/mentos1/class13.png" />
						<div class="aws2">비전공자도 이해할 수 있는 AWS 입문/실전</div>
						<div class="frame-4062">
							<div class="frame-407">
								<img class="user-user"
									src="${pageContext.request.contextPath}/resources/images/mentos1/mento.svg" />
								<div class="div8">정진</div>
								<div class="group-371">
									<div class="rectangle-2792"></div>
									<div class="mento">mento</div>
								</div>
							</div>
							<div class="frame-408">
								<div class="icon-time-02">
									<img class="icon-time-calendar"
										src="${pageContext.request.contextPath}/resources/images/mentos1/day.svg" />
								</div>
								<div class="_2025-06-232">
									<span> <span class="_2025-06-232-span">2025/06/23</span>
										<span class="_2025-06-232-span2"></span>
									</span>
								</div>
								<div class="div8">-</div>
								<div class="_2025-06-30">2025/06/30</div>
							</div>
							<div class="frame-409">
								<div class="icon-time-04">
									<img class="icon-time-clock-outlined"
										src="${pageContext.request.contextPath}/resources/images/mentos1/time.svg" />
								</div>
								<div class="_15">15시</div>
								<div class="div10">
									<span> <span class="div-10-span">-</span> <span
										class="div-10-span2"></span>
									</span>
								</div>
								<div class="_172">
									<span> <span class="_172-span">17시</span> <span
										class="_172-span2"></span>
									</span>
								</div>
								<div class="div10">
									<span> <span class="div-10-span">(화)</span> <span
										class="div-10-span2"></span>
									</span>
								</div>
							</div>
							<div class="frame-410">
								<div class="icon-maps-04">
									<img class="icon-maps-map-pin"
										src="${pageContext.request.contextPath}/resources/images/mentos1/maps.svg" />
								</div>
								<div class="div8">홍대</div>
							</div>
							<div class="frame-3659">
								<div class="_45-000">₩45,000</div>
							</div>
						</div>
					</div>
				</div>
				<div class="frame-356">
					<div class="cardview-memtos-before">
						<div class="frame-3656">
							<div class="frame-3772">
								<div class="d">D</div>
								<div class="div6">-</div>
								<div class="_2">2</div>
							</div>
						</div>
						<div class="frame-3657">
							<img class="vuesax-linear-user-tick"
								src="${pageContext.request.contextPath}/resources/images/mentos1/person.svg" />
							<div class="_1">1</div>
							<div class="div7">/</div>
							<div class="_3">3</div>
						</div>
					</div>
					<div class="mentos-class-22">
						<img class="image"
							src="${pageContext.request.contextPath}/resources/images/mentos1/class14.png" />
						<div class="aws2">비전공자도 이해할 수 있는 AWS 입문/실전</div>
						<div class="frame-4062">
							<div class="frame-407">
								<img class="user-user"
									src="${pageContext.request.contextPath}/resources/images/mentos1/mento.svg" />
								<div class="div8">정진</div>
								<div class="group-371">
									<div class="rectangle-2792"></div>
									<div class="mento">mento</div>
								</div>
							</div>
							<div class="frame-408">
								<div class="icon-time-02">
									<img class="icon-time-calendar"
										src="${pageContext.request.contextPath}/resources/images/mentos1/day.svg" />
								</div>
								<div class="_2025-06-232">
									<span> <span class="_2025-06-232-span">2025/06/23</span>
										<span class="_2025-06-232-span2"></span>
									</span>
								</div>
								<div class="div8">-</div>
								<div class="_2025-06-30">2025/06/30</div>
							</div>
							<div class="frame-409">
								<div class="icon-time-04">
									<img class="icon-time-clock-outlined"
										src="${pageContext.request.contextPath}/resources/images/mentos1/time.svg" />
								</div>
								<div class="_15">15시</div>
								<div class="div10">
									<span> <span class="div-10-span">-</span> <span
										class="div-10-span2"></span>
									</span>
								</div>
								<div class="_172">
									<span> <span class="_172-span">17시</span> <span
										class="_172-span2"></span>
									</span>
								</div>
								<div class="div10">
									<span> <span class="div-10-span">(화)</span> <span
										class="div-10-span2"></span>
									</span>
								</div>
							</div>
							<div class="frame-410">
								<div class="icon-maps-04">
									<img class="icon-maps-map-pin"
										src="${pageContext.request.contextPath}/resources/images/mentos1/maps.svg" />
								</div>
								<div class="div8">홍대</div>
							</div>
							<div class="frame-3659">
								<div class="_45-000">₩45,000</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>




</body>
</html>