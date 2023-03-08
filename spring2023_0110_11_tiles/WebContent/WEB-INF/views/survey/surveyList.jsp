<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<article>
        <header>
            <h1>SurveyList Demo</h1>
        </header>
        <ul class="list-unstyled"><li class="border-top my-3"></li></ul>
<div>
<table class="table">
		<caption> ID : ${sessionScope.sessionID}</caption>
		<thead>
		
			<tr>
				<th>No</th>
				<th>����</th>
				<th>�׸�</th>
				<th>��ǥ��</th>
				<th>Date</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="e" items="${list }" varStatus="status">
				<tr>
					<th>${e.num }</th>
					<td>&nbsp;
					<c:choose>
						<c:when test="${sessionScope.sessionID eq 'admin' }">
						<a href="surveyAdminDetail?num=${e.num}">${e.sub }</a>
						</c:when>
						<c:otherwise>
						<a href="surveyDetail?num=${e.num}">${e.sub }</a>
						</c:otherwise>
					</c:choose>
					</td>
					<td>${e.code }</td>
					<td>[${e.surveytotal}]</td>
					<td>${e.sdate }</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<th colspan="5">
				<input type="button" value="�����" id="writeBtn"
					onclick="location='surveyForm'">
					<input type="button" value="���������ϱ�" id="surveyClient"></th>
			</tr>
		</tfoot>
</table>
</div>
 
</article>