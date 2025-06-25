<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<c:set var="cpath" value="${pageContext.servletContext.contextPath}" />

<!-- 빈 파비콘 (브라우저 요청 방지) -->
<link rel="icon" href="data:;base64,iVBORw0KGgo=">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>



<style>
  .header-container {
    display: flex;
    justify-content: center;
    align-items: center;
    background-color: orange;
    height: 50px;
    position: relative;
  }

  .header-title {
    font-weight: bold;
    font-size: 18px;
    color: white;
  }

  .welcome-container {
    position: absolute;
    right: 20px;
    display: flex;
    align-items: center;
    gap: 10px;
  }

  .welcome-msg {
    margin: 0;
    color: white;
  }

  .logout-btn {
    padding: 4px 8px;
    font-size: 12px;
  }
</style>

<div class="header-container">
  <!-- 가운데 제목 -->
  <div class="header-title">직원 관리 시스템</div>

  <!-- 오른쪽 환영 메시지 + 로그아웃 버튼 -->
  <div class="welcome-container">
    <p class="welcome-msg">
      ${loginEmp == null ? "guest" : loginEmp.first_name}님 환영합니다.
    </p>
    <c:if test="${loginEmp != null}">
      <a class="btn btn-light btn-sm logout-btn" href="${cpath}/auth/logout.do">로그아웃</a>
    </c:if>
  </div>
</div>



