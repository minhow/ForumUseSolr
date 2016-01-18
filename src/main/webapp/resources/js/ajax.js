(function($) {
	var isStart = true;
	var settingsArr = [];
	
	$.ajaxCall = function(settings) {
		ajaxInit(settings);
	};
	
	function ajaxTest()
	{
		alert("ajaxTest");
	}
	

	function ajaxInit(settings) {
		settings = jQuery.extend({
			method: "POST",						// 통신 방식 (GET, POST)
			url: "",							// 통신 Target URL
			param: "",							// 파라메터
			dataType: "text",					// 결과 데이터 타입
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			callback: function() {},			// 통신 완료후 호출할 함수
			beforeSend: function() {},			// Ajax통신 시작시 호출 함수
			complete: function() {}				// Ajax통신 완료시 호출 함수
		}, settings);

		if(isStart) {
			isStart = false;
			ajaxStart(settings);
		} else {
			settingsArr[settingsArr.length] = settings;
		}		
	}

	function ajaxStart(settings) {
		loading();
		// Ajax 통신 처리
		$.ajax({type: settings.method, url: settings.url, data: settings.param,
			success: function(data, textStatus, jqXHR) {
				try {
					if (data == null) {
						alert("데이터 조회를 실패하였습니다. [결과값 null]");
					} else {
						try {
							if (settings.dataType == 'json') {
								// TO-DO : json 처리
								data = eval('(' + data + ')');
							}
							settings.callback(data);
						}catch(e){
							if (data.indexOf("login.do") > 0) {
								alert("로그인이 필요한 서비스입니다.\n로그인 화면으로 이동하겠습니다.");
								window.location = "login.do";
							} else {
								alert("JSON 데이타 전송 오류 : " + e);
							}
						}
					}
				} catch(err) {
					var errMsg = "데이터 조회를 실패하였습니다. [자바스크립트 오류 : " + err + "]";
					alert(errMsg);
				}
			}, error: function(x, o, e){
				closeLoading();
				alert(x.status + " : "+ o +" : "+e);
				alert("Ajax 통신조회를 실패하였습니다.");
			}, beforeSend : function() {
				
				settings.beforeSend();

			}, complete: function() {
				closeLoading();
				settings.complete();
				
				// 통신 완료후 다음 통신이 있을시 시작
				if(settingsArr.length > 0) {
					var next_settings = settingsArr[0];
					var tmpArr = [];
					
					for (var i = 1; i < settingsArr.length; i++) {
						tmpArr[i-1] = settingsArr[i];
					}
					
					settingsArr = tmpArr; 
					
					ajaxStart(next_settings);
				} else {
					isStart = true;	
				}
			}
		});
	}
})(jQuery);


function loading() {
	var $mask = $("<div></div>");
	$mask.attr("id", "loadingOmp").addClass("mask");
	
	var height = window.innerHeight ? window.innerHeight : document.documentElement.clientHeight;
	var scrollTop = document.documentElement.scrollTop;
	var style = "position:absolute; top:" + scrollTop + "px; width:100%; height:" + height + "px;";
	var tag = "<table style='" + style + "'><tr><td><center><img src=\"./images/loading.gif\"/></center></td></tr></table>";
	$mask.html(tag);
	
	$("body").append($mask);
	var maskHeight = $(document).height();
	var maskWidth = $(window).width();
	$("#loadingOmp").css({"width":maskWidth, "height":maskHeight, "z-index": 1000});
	$("#loadingOmp").fadeTo(10, 0.3);
}
function closeLoading() {
	if($("#loadingOmp").length > 0) {
		$("#loadingOmp").remove();
	}
}
