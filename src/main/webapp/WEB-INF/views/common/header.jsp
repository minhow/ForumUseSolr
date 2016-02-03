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
// 		alert("into search");
		var url = "searchTotal.do"
		var period = $(".on .period").val();
		var research;
// 		alert(period);
// 		alert($(".on .tab").text());
		var whichPageSearch = $("#whichPageSearch").val();
		var sDate = new Date();
		var eDate = new Date();
		var sDateParam;
		var eDateParam;

		
		
		if (whichPageSearch == "total") { //total 페이지에서 검색이 일어남.
			if ($("input:checkbox[id='research']").is(":checked")) {
				// 				alert('체크 되어있습니다.');
				research = 'y'
			} else {
				// 				alert('체크 안되 있습니다.');
				research = 'n'

			}

			

			if (period == "week") {
				sDate.setDate(sDate.getDate() - 7);
				sDateParam = Math.round(sDate / 1000);
				eDateParam = Math.round(eDate / 1000);

			} else if (period == "month") {
				sDate.setMonth(sDate.getMonth() - 1);
				sDateParam = Math.round(sDate / 1000);
				eDateParam = Math.round(eDate / 1000);
			} else if (period == "year") {
				sDate.setFullYear(sDate.getFullYear() - 1);
				sDateParam = Math.round(sDate / 1000);
				eDateParam = Math.round(eDate / 1000);
			} else if (period == "custom") {
				var sdate = $(".on .sDate").val();
				var edate = $(".on .eDate").val();
				
				sDate.setFullYear(sdate.substring(0, 4));
				sDate.setMonth(sdate.substring(4, 6));
				sDate.setMonth(sDate.getMonth() - 1);
				sDate.setDate(sdate.substring(6, 8));
		
				eDate.setFullYear(edate.substring(0, 4));
				eDate.setMonth(edate.substring(4, 6));
				eDate.setMonth(eDate.getMonth() - 1);
				eDate.setDate(edate.substring(6, 8));
				
				sDateParam = Math.round(sDate / 1000);
				eDateParam = Math.round(eDate / 1000);
			}
// 			alert("before call ajax");
			$.ajax({
				type : 'POST',
				url : url,
				data : {
					expression : $(".sch_input").val(),
					field : $(".on .range option:selected").val(),
					sort_field : $(".on .sort option:selected").val(),
					sDate : sDateParam,
					eDate : eDateParam,
					period : period,
					researchQuery : $("#researchQuery").val(),
					researchField : $("#researchField").val(),
					research : research
				},
				dataType : "text",
				success : function(result) {
					cb_loadRightBody(result);
				},
				error : function() {
					alert("error");
				}
			});
		} else if (whichPageSearch == "detail") { //상세 페이지에서 검색이 일어남
			location.replace("${contextPath}/searchForum?expression=" + $(".sch_input").val());
		}
	}

	function searchCategory(category) {
		var url = "searchCategory.do"
		var period = $(".on .period").val();
		
		var sDate = new Date();
		var eDate = new Date();
		var sDateParam;
		var eDateParam;
// 		alert(period);
// 		alert($(".on .tab").text());
		var research;

		if ($("input:checkbox[id='research']").is(":checked")) {
			// 				alert('체크 되어있습니다.');
			research = 'y'
		} else {
			// 				alert('체크 안되 있습니다.');
			research = 'n'

		}

		if (period == "week") {
			sDate.setDate(sDate.getDate() - 7);
			sDateParam = Math.round(sDate / 1000);
			eDateParam = Math.round(eDate / 1000);

		} else if (period == "month") {
			sDate.setMonth(sDate.getMonth() - 1);
			sDateParam = Math.round(sDate / 1000);
			eDateParam = Math.round(eDate / 1000);
		} else if (period == "year") {
			sDate.setFullYear(sDate.getFullYear() - 1);
			sDateParam = Math.round(sDate / 1000);
			eDateParam = Math.round(eDate / 1000);
		} else if (period == "custom") {
			var sdate = $(".on .sDate").val();
			var edate = $(".on .eDate").val();
			
			sDate.setFullYear(sdate.substring(0, 4));
			sDate.setMonth(sdate.substring(4, 6));
			sDate.setMonth(sDate.getMonth() - 1);
			sDate.setDate(sdate.substring(6, 8));
	
			eDate.setFullYear(edate.substring(0, 4));
			eDate.setMonth(edate.substring(4, 6));
			eDate.setMonth(eDate.getMonth() - 1);
			eDate.setDate(edate.substring(6, 8));
			
			sDateParam = Math.round(sDate / 1000);
			eDateParam = Math.round(eDate / 1000);
		}
		

		$.ajax({
			type : 'POST',
			url : url,
			data : {
				forum_id : category,
				expression : $(".sch_input").val(),
				field : $(".on .range option:selected").val(),
				sort_field : $(".on .sort option:selected").val(),
				sDate : sDateParam,
				eDate : eDateParam,
				period : period,
				researchQuery : $("#researchQuery").val(),
				researchField : $("#researchField").val(),
				research : research,
				page : $("#page").val()
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
	
	function apply() {
		var url; 
		var curPage = $(".on .tab").attr('id');
		if(curPage=="0"){
			searchTotal();
		} else {
			searchCategory(curPage);
		}
	}

	function switchPeriod() {
		$("#container .on .period").val("custom").prop("selected", true);
	}

	/* 날짜 유효성 체크 */
	function day_check() {

		if ($(".on .sDate").val() != '' && $(".on .eDate").val() != '') {
			if ($(".on .sDate").val() > $(".on .eDate").val()) {
				$(".on .eDate").val('');
				alert("시작날짜는 종료날짜 보다 작아야 합니다.");
			}
		} else {
			switchPeriod();
		}
	}
	

	/* 날짜 초기화 */
	function clearDate() {
		$(".on .sDate").val("");
		$(".on .eDate").val("");
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
	
	function movePage(page) {
		$("#page").val(page);
		searchCategory($(".on .tab").attr("id"));
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
						<span class="txt"></span> <span class="btn"> <img class
							src="${contextPath}/resources/images/searchBar/btn_type2_arr_off.gif"
							alt="리스트보기" />
						</span>
					</p>
					<ul>
						<li id="0">통합검색</li>
						<li id="3">프로젝트</li>
						<li id="36">개발이슈</li>
						<li id="37">지식공유</li>
						<li id="7">그룹</li>
						<li id="14">기타</li>
						<li id="43">포럼</li>
						<li id="46">다운로드 및 Q&A</li>
					</ul>


					<input class="sch_input" type="text" value="${expression }"
						onkeydown="if (event.keyCode == 13) { searchTotal(); return false;}"
						placeholder="검색어를 입력하세요." /> <span class="sch_btn"
						onClick="searchTotal();"> <img
						src="${contextPath}/resources/images/searchBar/btn_type2_sch.gif"
						alt="검색" /></span>
				</div>
				<!-- sch_bar -->

				<br> <br>

				<div class="sch_bar2">
					&nbsp;&nbsp; <input type="checkbox" id="research"
						onclick="serachInSearch(this);" /> <label for="research">결과 내 검색</label>
				</div>


				<dl>
					<dt>
						<img
							src="${contextPath}/resources/images/searchBar/icon_keyword.png"
							alt="키워드" />
					</dt>
					<dd>이재호</dd>
					<dd>유민호</dd>
					<dd>주현태</dd>
					<dd class="none_bg">솔라</dd>
				</dl>
			</div>
			<!-- searchBar_type2-->
		</tr>
	</tbody>
</table>
