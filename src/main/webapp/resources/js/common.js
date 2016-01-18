$(function(){
	
	if (navigator.userAgent.match(/iPad/i) || navigator.userAgent.match(/iPhone/i) || navigator.userAgent.match(/iPod/i) || navigator.userAgent.match(/Android/i)){
		$('html').addClass('mobile');
	}
	if (navigator.userAgent.match(/Android/i)){
		$('html').addClass('android');
	}

	//자동완성 버튼
	$('.select_word a').click(function(e){
		e.preventDefault();
		
		$(this).toggleClass('on');
		$('.select_box').toggle();
	});
	
	$('.select_box .btm a').click(function(e){
		e.preventDefault();
		
		$('.select_word a').removeClass('on');
		$('.select_box').hide();
	});
	
});

//레이어 팝업 띄우기
function showPopup(opt) {
	var $pop = null;
	
	/* back 나타나기 */
	$('#wrap').append("<div class='popup_bg'></div>");

	/* pop 나타나기 */
	$pop = $(opt['cls']).clone(true);
	$pop.addClass('cloneDiv');
	$('#wrap').append($pop);
	$pop.show();
	
	// 팝업창 닫기
	$pop.find('.btn_close').click(function(e) {
		e.preventDefault();
		
		/* back 사라지기 */
		$('.popup_bg').remove();
		
		/* pop 사라지기 */
		$pop.remove();
		$('html').css({overflow:'auto'});
	});
}

function selectCategory(categoryId) {

	var tab = "tab1";
    if ($("#tab").length > 0) {
    	tab = $("#tab").val();
    	if (trim(tab) == "") {
    		tab = "tab1";
    	}
    }
    loadRight(tab, categoryId);
}

function loadRight(tab, categoryId) {
	$("#tab").val(tab);
	loadRightTop(tab, categoryId);
	loadRightBody(tab, categoryId);
}



function trim(str) {
	return str.replace(/(^\s*)|(\s*$)/gi, "");
}

function unTranslate(str) {
	str = str.replace(/%0/gi, "\n");
	str = str.replace(/%22/gi, "\"");
	
	return str;
}

