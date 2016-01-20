<script type="text/javascript" src="${contextPath}/resources/js/jquery-1.7.2.js"></script> 
<script type="text/javascript" src="${contextPath}/resources/js/ajax.js"></script>
<script type="text/javascript" src="${contextPath}/resources/js/common.js"></script>
<script type="text/javascript" src="${contextPath}/resources/js/jquery-ui.custom.js"></script>
<script type="text/javascript" src="${contextPath}/resources/ref/jquery/jquery.cookie.js"></script>
<script type="text/javascript" src="${contextPath}/resources/js/jquery.ui.datepicker-ko.js"></script>    
<script type="text/javascript" src="${contextPath}/resources/js/jquery.ui.datepicker.js"></script>
<script type="text/javascript" src="${contextPath}/resources/js/comm.js"></script>
<script type="text/javascript">
	$(function(){
		var cont_wid = $('.tab_type1').width() - (intTopx($('.tab_type1 ul li.on .t_content').css('padding-left'))+intTopx($('.tab_type1 ul li.on .t_content').css('border-left-width')))*2;
		$('.tab_type1 ul li .t_content').width(cont_wid);
		$('.tab_type1 ul li .tab').click(function(){
			reset_tab_type1();
			$(this).parent().addClass('on');
		});
	});
	
	function reset_tab_type1(){
		$('.tab_type1 ul li').each(function(index, element) {
			if($(this).attr('class') === 'on'){
				$(this).removeClass('on');
			}
		});
	}


	$(function(){
		var list_wid = $('.searchBar_type2 .sch_bar ul').width();
		var list_box_wid = list_wid + $('.searchBar_type2 .sch_bar .selected .btn').width() + intTopx($('.searchBar_type2 .sch_bar .selected .btn').css('padding-left'))*2;
		
		// set seleted text area width
		$('.searchBar_type2 .sch_bar .selected ').width(list_box_wid);
		
		// set list area width
		$('.searchBar_type2 .sch_bar ul').width($('.searchBar_type2 .sch_bar ul').width()+ $('.searchBar_type2 .sch_bar .selected .btn').width() + intTopx($('.searchBar_type2 .sch_bar .selected .btn').css('padding-left'))*2-2);
		
		var list_top = intTopx($('.searchBar_type2 .sch_bar').css('padding-top')) + $('.searchBar_type2 .sch_bar .selected').height();
		// set position of list
		$('.searchBar_type2 .sch_bar ul').css({'top':list_top+3,'left':intTopx($('.searchBar_type2 .sch_bar').css('padding-left'))});
		
		var input_w = $('.sch_bar').width() - $('.selected').width() - $('.sch_btn').width() - (intTopx($('.sch_bar').css('padding-left')) + intTopx($('.sch_bar').css('border-left-width'))*2) - (intTopx($('.sch_input').css('padding-left'))*2);
		$('.sch_input').width(input_w);
		
		// set init selected text
		$('.searchBar_type2 .selected .txt').text($('.searchBar_type2 ul li:first').text());
		
		// '검색어를 입력하세요' show/hide event
		focusEvnt('.searchBar_type2 .sch_input','검색어를 입력하세요.');
		
		// event show list 
		$('.searchBar_type2 .selected .btn').click(function(e) {
			$('.searchBar_type2 .sch_bar ul').slideToggle(200,function(){
				var org_src =$('.searchBar_type2 .selected .btn img').attr('src');
				if(org_src.match('_off.') === null){
					gnb_out('.searchBar_type2 .selected .btn');
				}else{
					gnb_over('.searchBar_type2 .selected .btn img');
				}
			});
		});
		
		// click event lists 
		$('.searchBar_type2 .sch_bar ul li').click(function(){
			$('.searchBar_type2 .selected .btn').trigger('click');
			$('.searchBar_type2 .selected .txt').text($(this).text());
		});
	});
	
	///현태---> 폼 
	function search()
	{
		var form=document.searchForm;
		alert('검색');
		form.submit();
	}
</script>