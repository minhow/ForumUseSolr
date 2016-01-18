<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/includejs.jsp" %>
<%@include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<script>
$(document).ready(function(){
	
	/* $( "#startDate0" ).datepicker({
      defaultDate: "+1w",
      changeMonth: true,
      changeYear: true,
      numberOfMonths: 1,
      onClose: function( selectedDate ) {
        $( "#endDate0" ).datepicker( "option", "minDate", selectedDate );
	    $( "#startDate0" ).datepicker( "option", "dateFormat", "yy.mm.dd" );
      }
    });

	$( "#endDate0" ).datepicker({
      defaultDate: "+1w",
      changeMonth: true,
      changeYear: true,
      numberOfMonths: 1,
      onClose: function( selectedDate ) {
        $( "#startDate0" ).datepicker( "option", "maxDate", selectedDate );
        $( "#endDate0" ).datepicker( "option", "dateFormat", "yy.mm.dd" );
      }
    });
	 */
	$('#clearBtn').click(function(){
		$("#startDate0").val("");
		$("#endDate0").val("");
	});	
	
	
	$(".btn_search").click(function(){
		$("#selName1").val("1");

	});	

	$("#ally_Btn").click(function(){
		$("#datesel1").val("");
		$("#startDate").val($("#startDate0").val());
		$("#endDate").val($("#endDate0").val());
		searchForm.submit();
	});	

	  $(function() {
		    $( "#menu" ).menu();
		  });
	  $(function() {
		    $( "#radio" ).buttonset();
		    $("#dateradio").buttonset();
		    $("#sectionradio").buttonset();
		  });
	  
	$("#ally_Btn1").click(function(){
			$("#csqname").val($("#author").val());
			searchForm.submit();
		});		  	  	  
	
});


function dateSel(){
	var date=$('#date').val();
	if(date==15){
		$('#startDate0').attr('disabled',false);
		$('#endDate0').attr('disabled',false);
	}else{
		$('#startDate0').attr('disabled',true);
		$('#endDate0').attr('disabled',true);
	}
	
}
function initPage()
{
	$('#page').val(1);
}

</script>
</head>
<body>

		<form action="${contextPath}/" name="searchForm" id="searchForm">
			<select name="field">
				<option value="scd_rd_addr">scd_rd_addr</option>
				<option value="all">전체</option>
			</select>
			<input type="text" name="expression" value="${expression }" onclick="initPage()"/>			
			<input type="submit" value="검색" /><br>
			
			정렬 : 
			<select name="sort">
				<option value="score" <c:if test="${sort=='score' }">selected="selected"</c:if>>정확도</option>
				<option value="date" <c:if test="${sort=='rank_idx_bc' }">selected="selected"</c:if>>최신순</option>
			</select><br/>
			기간 : 
			<select name="date" id="date" onchange="dateSel()">
				<option value="11" <c:if test="${date==11 }">selected="selected"</c:if>>전체</option>
				<option value="12" <c:if test="${date==12 }">selected="selected"</c:if>>1주</option>
				<option value="13" <c:if test="${date==13 }">selected="selected"</c:if>>1개월</option>
				<option value="14" <c:if test="${date==14 }">selected="selected"</c:if>>1년</option>		
				<option value="15" <c:if test="${date==15 }">selected="selected"</c:if>>직접입력</option>		
				
			</select>
			<label style="margin: 0 2px 0 0; font-size: 11px; font-weight: bold;">직접입력</label>
			<br>
			<div id="selectdate">
				<!-- <input type="text" id="startDate0" name="startDate0" value=""
				style="width: 65px; border: 1px solid #75706D; padding: 1px 1px 1px; color: #c97c37;" disabled="disabled"/>
				~ 
				<input type="text" id="endDate0" name="endDate0"value=""
				style="width: 65px; border: 1px solid #75706D; padding: 1px 1px 1px; color: #c97c37;" disabled="disabled" /> -->
				<input type="text" id="startDate0" name="startDate0" value="${startDate0 }">
				~
				<input type="text" id="endDate0" name="endDate0" value="${endDate0 }">				
			</div>
			
			
			<input type="hidden" name="page" id="page" value="${page }"/>

						
		</form>
		
			

	<hr>
	전체 문서수 : ${total }
	<br><br>
	<c:forEach var="scd" items="${scdList }">
		${scd.scd_rd_addr }<br>
		${scd.scd_addr_term }<br>
		${scd.poi_nm }<br>
		${scd.xy_value }<br>
		${scd.scd_tel_no_term }<br>
		${scd.rank_idx_bc }<br>
		<hr>
	</c:forEach>
	<c:if test="${cPage != 1 }">
					<a href="javascript:movePage('1');">&#60;&#60;</a>
				</c:if>
				<c:if test="${cPage - 1 > 0 }">
					<a href="javascript:movePage('${cPage - 1 }');">&#60;</a>
				</c:if>

				<c:forEach var="value" begin="${sPage }" end="${ePage }" step="1">
					<c:choose>
						<c:when test="${cPage == value }">
							<a>${value}</a>
						</c:when>
						<c:otherwise>
							<a href="javascript:movePage('${value}');">${value}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>

				<c:if test="${cPage + 1 <= tPage }">
					<a href="javascript:movePage('${cPage + 1 }');">&#62;</a>
				</c:if>
				<c:if test="${cPage != tPage && tPage != 0 }">
					<a href="javascript:movePage('${tPage }');">&#62;&#62;</a>
				</c:if>
</body>

<script type="text/javascript">
function movePage(page)
{
	var form=document.searchForm;
	$("#page").val(page);
	form.submit();
}

</script>
</html>