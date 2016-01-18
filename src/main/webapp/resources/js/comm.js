/**
* Author: Kim Jong O
* Email: tgjoo@opensns.co.kr
* Update: 2011.12.16
**/

function gnb_rollover (ele){
	// gnb_type1 rollover effect
	$(ele).hover(
		function(){
			var dn_src = $(this).children('img').attr('src');
			if(dn_src.match('.gif') != null){
				$(this).children('img').attr('src',dn_src.replace('_off.gif','_on.gif'));
			}else{
				$(this).children('img').attr('src',dn_src.replace('_off.png','_on.png'));
			}
		},
		function(){
			var dn_src = $(this).children('img').attr('src');
			if (dn_src.match('.gif') != null) {
				$(this).children('img').attr('src',dn_src.replace('_on.gif','_off.gif'));
			}else{
				$(this).children('img').attr('src',dn_src.replace('_on.png','_off.png'));
			}
		}
	);
}

function gnb_over(ele){
	var dn_src = $(ele).attr('src');
	if(dn_src.match('.gif') != null){
		$(ele).attr('src',dn_src.replace('_off.gif','_on.gif'));
	}else{
		$(ele).attr('src',dn_src.replace('_off.png','_on.png'));
	}
}

function gnb_out(ele){
	var dn_src = $(ele).children('img').attr('src');
	if(dn_src.match('.gif') != null){
		$(ele).children('img').attr('src',dn_src.replace('_on.gif','_off.gif'));
	}else{
		$(ele).children('img').attr('src',dn_src.replace('_on.png','_off.png'));
	}
}


function background_rollover(ele){
	$(ele).hover(
		function(){
			var bg_src = $(this).parent().css('background-image');
			$(this).parent().css('background-image',bg_src.replace('_off.gif','_on.gif'));
		},
		function(){
			var bg_src = $(this).parent().css('background-image');
			$(this).parent().css('background-image',bg_src.replace('_on.gif','_off.gif'));
		}
	);
}

// get element width
function getContWidth(ele){
	var tot_wid = 0;
	$(ele).each(function(index, element) {
		tot_wid += $(this).width();
	});
	return tot_wid;
}

// gnb_type4 init
function gnb_type4_init(){
	$('.gnb_type4_3d > li').each(function(index, element) {
		gnb_out($(this).children('span'));
		$(this).children('.sub_gnb_type4_3d').hide();
	});
}

function intTopx (pVal){
	var s = pVal.replace('px','');
	return parseInt(s,10);
}

function focusEvnt(ele,str){
	var str1 = str;
	$(ele).focusin(function(e,str1) {
		if($(this).val() === str){
			$(this).val('');
		}
	}).focusout(function(e,str1) {
		if($(this).val() === ''){
			$(this).val(str);
		}
	});
}

// 자식 초기화 함수
function ele_init(ele,child){
	$(ele).each(function(index, element) {
		var a = $(this).children(child);
		gnb_out(a);
	});
}

// 테이블 하단 보더 제거
function rmTableBtm(tb){
	$(tb).find('tbody tr:last-child').each(function(index, element) {
		$(this).children().addClass('none_bb');
	});
}

function popupOpen(src,title,w,h){
	window.open(src,title,'width='+w+',height='+h+',toolbar=no,location=no,status=no,menubar=no,scrollbars=no,resizeable=no,left=600,top=300'); 
	return false;
}
