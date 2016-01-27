<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/common/includejs.jsp"%>
<!DOCTYPE html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript">
	function cb_loadRightBody(result) {
		$("#container").html(result);
		reload();
	}

	function searchTotal() {
		var url = "searchTotal.do"
		var period = $("#period").val();
		var research;
		var whichPageSearch=$("#whichPageSearch").val();
			
		
		if(whichPageSearch=="total"){ 		//total 페이지에서 검색이 일어남.
			if($("input:checkbox[id='research']").is(":checked")){
				alert('체크 되어있습니다.');
				research='y'
			}
			else{
				alert('체크 안되 있습니다.');
				research='n'
			}
			alert($("#researchQuery").val()+","+$("#researchField").val())

			$.ajax({
				type : 'POST',
				url : url,
				data : {
					expression : $(".sch_input").val(),
					field : $("#range option:selected").val(),
					sort_field : $("#sort option:selected").val(),
					sDate : $("#hsDate").val(),
					eDate : $("#heDate").val(),
					period : period,
					researchQuery:$("#researchQuery").val(),
					researchField:$("#researchField").val(),
					research:research
				},
				dataType : "text",
				success : function(result) {
					cb_loadRightBody(result);
				},
				error : function() {
					alert("error");
				}
			});
		}
		else if(whichPageSearch=="detail"){ //상세 페이지에서 검색이 일어남
			location.replace("/forumn?expression="+$(".sch_input").val());
		}							
	}

	function searchCategory(category) {
		var url = "searchCategory.do"
		var params = "expression=" + $(".sch_input").val();
		var sDate = new Date();
		var eDate = new Date();
		// 		alert($("#sort").val());
		// 		alert(category);
		params += "&field=" + $("#range option:selected").val();
		params += "&sort_field=" + $("#sort option:selected").val();
		params += "&forum_id=" + category;
		if ($("#period").val() == "week") {
			alert(eDate.getMilliseconds());
			sDate.setDate(sDate.getDate() - 7);
			alert(eDate.getMilliseconds());
			params += "&sDate=" + sDate.getTime();
			params += "&eDate=" + eDate.getTime();
		} else if ($("#period").val() == "month") {
			sDate.setMonth(sDate.getMonth() - 1);
			params += "&sDate=" + sDate.getTime();
			params += "&eDate=" + eDate.getTime();
		} else if ($("#period").val() == "year") {
			sDate.setFullYear(sDate.getFullYear() - 1);
			params += "&sDate=" + sDate.getTime();
			params += "&eDate=" + eDate.getTime();
		} else if ($("#period").val() == "custom") {
			var sdate = $("#sDate").val();
			var edate = $("#eDate").val();
			alert(sdate.substring(0, 4) + "/" + sdate.substring(4, 6) + "/"
					+ sdate.substring(6, 8));
			sDate = new Date(sdate.substring(0, 4), sdate.substring(4, 6),
					sdate.substring(6, 8), 0, 0, 0, 0);
			eDate = new Date(edate.substring(0, 4), edate.substring(4, 6),
					edate.substring(6, 8), 0, 0, 0, 0);
			params += "&sDate=" + sDate.getTime();
			params += "&eDate=" + eDate.getTime();
		}
// 		alert(params);
		$.ajax({
			type : 'POST',
			url : url,
			data : params,
			dataType : "text",
			success : function(result) {
				cb_loadRightBody(result);
			},
			error : function() {
				alert("error");
			}
		});
	}

	function switchPeriod() {
		$("#container #period").val("custom").prop("selected", true);
	}

	/* 날짜 유효성 체크 */
	function day_check() {

		if ($("#sDate").val() != '' && $("#eDate").val() != '') {
			if ($("#sDate").val() > $("#eDate").val()) {
				$("#eDate").val('');
				alert("시작날짜는 종료날짜 보다 작아야 합니다.");
			}
		} else {
			switchPeriod();
		}
	}
	function periodCheck() {
		// 		alert('period');
		var period = $("#period option:selected").val();
		var sDate = new Date();
		var eDate = new Date();
		if (period != "custom") {
			if (period == "week") {
				sDate.setDate(sDate.getDate() - 7);
				$("#hsDate").val(sDate.getTime());
				$("#heDate").val(eDate.getTime());
			} else if (period == "month") {
				sDate.setMonth(sDate.getMonth() - 1);
				$("#hsDate").val(sDate.getTime());
				$("#heDate").val(eDate.getTime());
			} else if (period == "year") {
				sDate.setFullYear(sDate.getFullYear() - 1);
				$("#hsDate").val(sDate.getTime());
				$("#heDate").val(eDate.getTime());
			} else {
				$("#hsDate").val("");
				$("#heDate").val("");
			}
			clearDate();
		} else {
			var sdate = $("#sDate").val();
			var edate = $("#eDate").val();
			alert(sdate.substring(0, 4) + "/" + sdate.substring(4, 6) + "/"
					+ sdate.substring(6, 8));
			sDate = new Date(sdate.substring(0, 4), sdate.substring(4, 6),
					sdate.substring(6, 8), 0, 0, 0, 0);
			eDate = new Date(edate.substring(0, 4), edate.substring(4, 6),
					edate.substring(6, 8), 0, 0, 0, 0);
			$("#hsDate").val(sDate.getTime());
			$("#heDate").val(eDate.getTime());
		}
		alert($("#hsDate").val() + ", " + $("#heDate").val());

	}

	/* 날짜 초기화 */
	function clearDate() {
		$("#sDate").val("");
		$("#eDate").val("");
		//2013-12-27 날짜 초가화 선택시 카테고리 선택 풀리는 현상때문에 주석 
		//$("#categoryId").val("");\
	}
	function serachInSearch(chkBox) {
		if (chkBox.checked) {
			$("#sort").attr("disabled", true);
			$("#range").attr("disabled", true);
			$("#period").attr("disabled", true);
			$("#sDate").attr("disabled", true);
			$("#eDate").attr("disabled", true);
		} else {
			$("#sort").attr("disabled", false);
			$("#range").attr("disabled", false);
			$("#period").attr("disabled", false);
			$("#sDate").attr("disabled", false);
			$("#eDate").attr("disabled", false);
		}
	}
</script>
<table>
	<tbody>
		<tr>
			<div class="searchBar_type2">
				<p class="sch_txt">
					<img src="${contextPath}/resources/images/searchBar/txt_search.png"
						alt="search" />
				</p>
				<div class="sch_bar">
					<p class="selected">
						<span class="txt"></span> 
						<span class="btn">
							<img class src="${contextPath}/resources/images/searchBar/btn_type2_arr_off.gif" alt="리스트보기" />
						</span>
					</p>
					<ul>
						<li>통합검색</li>
						<li>게시판</li>
						<li>지식샘</li>
						<li>커뮤니티</li>
						<li>전자도서관</li>
					</ul>


					<input class="sch_input" type="text" value="${expression }"
						onkeydown="if (event.keyCode == 13) { searchTotal(); return false;}" placeholder="검색어를 입력하세요."  />
											
					<span class="sch_btn" onClick="searchTotal();"> 
					<img src="${contextPath}/resources/images/searchBar/btn_type2_sch.gif"
						alt="검색" /></span>
				</div>
				<!-- sch_bar -->

				<br> <br>

						<div class="sch_bar2">
							&nbsp;&nbsp; <input type="checkbox" id="research"
								onclick="serachInSearch(this);" /> <label for="research">결과내
								검색</label>
						</div>


						<dl>
							<dt>
								<img
									src="${contextPath}/resources/images/searchBar/icon_keyword.png"
									alt="키워드" />
							</dt>
							<dd>검색어01</dd>
							<dd>검색어02</dd>
							<dd>검색어03</dd>
							<dd class="none_bg">검색어04</dd>
						</dl>
			</div>
			<!-- searchBar_type2-->
		</tr>
	</tbody>
</table>
