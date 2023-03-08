<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<article >
        <header>
            <h1>Survey Detail Demo</h1>
        </header>
        <ul class="list-unstyled"><li class="border-top my-3"></li></ul>
<div>
<%-- form start --%>
 <table class="table">
		<thead>
			<tr>
				<th colspan="2">SurveyDetail</th>
			</tr>
		</thead>
		<tbody>
			<tr>
			<th>제목</th>
			<td>
			<input type="text" name="sub" id="sub" value="${vo.sub }"
							readonly="readonly"> 
			<input type="hidden" name="num"	value="${vo.num }" id="num">
			</td>
			</tr>
			<c:forEach var="e" items="${vo.subvey }" varStatus="i">
				<tr>
					<th>${i.index+1}번설문문항 ${e.subtype }</th>
					<td>${e.surveytitle } => ${e.surveycnt }</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<th colspan="2"><input type="button" value="list"
					onclick="location='surveylist'"> 
					<input type="button" value="delete" id="delete"></th>
			</tr>
		</tfoot>
	</table> 
</div>
 
</article>
