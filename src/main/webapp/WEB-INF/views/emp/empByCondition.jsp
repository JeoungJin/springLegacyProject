<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="cpath" value="${pageContext.servletContext.contextPath}" />

<c:forEach items="${emplist}" var="emp" varStatus="status">
     <tr>
       <td>${status.index}
       <span>👌❤️</span>       
       ${status.count}
       <span>${status.first?"처음":""}</span>
       <span>${status.last?"끝":""}</span>
       </td>
       
       <td>
         <c:if test="${loginEmp.employee_id==emp.employee_id}">
            <span class="login">로그인중</span>
         </c:if>
         <c:if test="${loginEmp.employee_id!=emp.employee_id}">
            <span class="logout">직원</span>
         </c:if>
       </td>
       <td><a href="${cpath}/emp/empdetail.do?empid2=${emp.employee_id}">${emp.employee_id}</a></td>
       <td><a href="${cpath}/emp/empdetail.do?empid2=${emp.employee_id}">${emp.first_name}</a></td>
       <td>${emp.last_name}</td>
       <td>
         <fmt:formatNumber type="currency" currencySymbol="$"
          groupingUsed="true" value="${emp.salary}" />
        </td>
       <td>${emp.email}</td>
       <td>${emp.department_id}</td>
       <td>${emp.commission_pct}</td>
       <td>${emp.manager_id}</td>
       <td>${emp.phone_number}</td>
       <td>${emp.job_id}</td>
       <td>
         <fmt:formatDate  pattern="YYYY-MM-dd hh:mm:ss" value="${emp.hire_date}"/>
       
       
       </td>
       
       <td><a href="${cpath}/emp/empdelete.do?empid=${emp.employee_id}">
             <c:if test="${status.count%2==0}">
                 <img src="${cpath}/resources/images/delete.png" >
             </c:if>
             <c:if test="${status.count%2==1}">
                 <img src="${cpath}/resources/images/delete3.png" width="30" height="30">
             </c:if>
           </a>
       </td>
     </tr>
   
   </c:forEach>