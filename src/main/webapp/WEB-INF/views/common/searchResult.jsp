<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<div class="tab_type1"><!-- tab_type1 -->
						<ul>
							
							
							<li class="on">
								<p class="tab none_mar">통합검색</p>
								<div class="t_content">  <!-- t_content통합검색 -->

									 <div class="list_type1" ><!-- list_type1 -->
									 	<ul>
											<li>
												<dl>
													<dt>
														<span class="bold">총 ${total } 건을 검색하였습니다.</span>
													</dt>	
													<dt>
															정렬
															<select id="sort" title="정렬">
																<option value="sim">유사도순</option>
																<option value="latest">최신순</option>
															</select>
															범위 
															<select id="range" title="범위">
																<option value="total">전체</option>
																<option value="subject">제목</option>
																<option value="content">본문</option>
															</select>
															기간
															<select id="period" title="기간">
																<option value="total">전체</option>
																<option value="week">1주</option>
																<option value="month">1개월</option>
																<option value="year">1년</option>
																<option value="custom">직접 입력</option>
															</select> 
															시작일<input id="startDate" onfocus="switchPeriod()">
															종료일<input id="endDate" onfocus="switchPeriod()">
															<a href="#"><img src="${contextPath}/resources/images/list/type4/icon_sort.gif" alt="정렬"/></a>
													</dt>
												</dl>
											</li>
										</ul>			
 
									</div><!-- list_type1 -->


									<div class="mar_top50 hei_type1"> <!-- 게시판 -->
										<p class="line_type1"> </p>
										<span class="txt_bold">
										<img src="${contextPath}/resources/images/searchBar/btn_type3_arr_rgt.gif" alt="게시판"/>
										게시판</span>
										<p class="line_type2"> </p>


										<ul class="list_type5" >
										<c:forEach var="scd" items="${scdList }" varStatus="status">
											<li>
												<dl>
													<dt>
														<span class="bu_divi">${status.index }</span>
														<span class="bu_divi">[${scd.forumId }]</span> 													 
														<a href="#">${scd.postSubject }</a>
														<span> (유사도 : 99.9%)</span>											
													</dt>

													<dd>
														<span class="bu_divi none_pl">작성자 : ${scd.postUsername }</span>
														<span>작성일 : ${scd.postDate }</span>
													</dd>
													<dd>
														<span class="bu_divi none_pl">하위카테고리 : ${scd.forumId }</span>
													</dd>

													<dd class="desc">${scd.postText }</dd>
													<dd>
														<span class="bu_divi none_pl">첨부파일 : ${scd.postAttachment }</span>
													
														<br><br><br>
													</dd>
												</dl>
											</li>
										</c:forEach>
										</ul>
										<div class="line_type3"> 
											<a href="#"><img src="${contextPath}/resources/images/searchBar/btn_add.gif" alt="addshow"/></a>
										</div>
									</div> <!-- 게시판 -->


									<div class="mar_top50 hei_type1"> <!-- 지식샘 -->
										<p class="line_type1"> </p>
										<span class="txt_bold">
										<img src="${contextPath}/resources/images/searchBar/btn_type3_arr_rgt.gif" alt="지식샘"/>
										지식샘</span>
										<p class="line_type2"> </p>


										<ul class="list_type5">
										</ul>
										<div class="line_type3"> 
											<a href="#"><img src="${contextPath}/resources/images/searchBar/btn_add.gif" alt="addshow"/></a>
										</div>
									</div> <!-- 지식샘 -->

									<div class="mar_top50 hei_type1"> <!-- 커뮤니티 -->
										<p class="line_type1"> </p>
										<span class="txt_bold">
										<img src="${contextPath}/resources/images/searchBar/btn_type3_arr_rgt.gif" alt="커뮤니티"/>
										커뮤니티</span>
										<p class="line_type2"> </p>

										<ul class="list_type5">
										</ul>
										<div class="line_type3"> 
											<a href="#"><img src="${contextPath}/resources/images/searchBar/btn_add.gif" alt="addshow"/></a>
										</div>
									</div> <!-- 커뮤니티 -->

									<div class="mar_top50 hei_type1"> <!-- 전자도서관 -->
										<p class="line_type1"> </p>
										<span class="txt_bold">
										<img src="${contextPath}/resources/images/searchBar/btn_type3_arr_rgt.gif" alt="전자도서관"/>
										전자도서관</span>
										<p class="line_type2"> </p>


										<ul class="list_type5">
										</ul>
										<div class="line_type3">
											<a href="#"><img src="${contextPath}/resources/images/searchBar/btn_add.gif" alt="addshow"/></a>
										</div>
									</div> <!-- 전자도서관 -->

									 
							
								</div> <!-- t_content통합검색 -->
							</li>



							<li>
								<p class="tab">게시판</p>
								<div class="t_content"> <!-- t_content 게시판 -->
								
									<div class="list_type1" ><!-- list_type1 -->
									 	<ul>
											<li>
												<dl>
													<dt>
														<span class="bold">총 821 건을 검색하였습니다.</span>
													</dt>	
													<dt>
															<select>
																<option>유사도순</option>
																<option>DOC ID순</option>
															</select> 
															<select>
																<option>오름차순</option>
																<option>내림차순</option>
															</select>
													 
															<label for="srch_total">리스트 출력 건수</label>
															<select>
																<option>3</option>
																<option>5</option>
																<option>10</option>
															</select> 
															<span> 건수 </span>
															<a href="#"><img src="${contextPath}/resources/images/list/type4/icon_sort.gif" alt="정렬"/></a>			
													</dt>
												</dl>
											</li>
										</ul>			
									</div><!-- list_type1 -->


									<div class="mar_top50 hei_type1"> <!-- 게시판 -->
										<p class="line_type1"> </p>
										<span class="txt_bold">
										<img src="${contextPath}/resources/images/searchBar/btn_type3_arr_rgt.gif" alt="게시판"/>
										게시판</span>
										<p class="line_type2"> </p>


										<ul class="list_type5">
										</ul>
									</div> <!-- 게시판 -->


									<p class="pagging_type1 mar_top10"> 
										<span class="pre"><a href="#"><img src="${contextPath}/resources/images/pagging/btn_first.gif" alt="첫페이지"/></a></span>
										<span class="pre"><a href="#"><img src="${contextPath}/resources/images/pagging/btn_pre.gif" alt="이전페이지"/></a></span>
										<span><a href="#">1</a></span>
										<span><a href="#">2</a></span>
										<span><a href="#">3</a></span>
										<span><a href="#">4</a></span>
										<span><a href="#">5</a></span>
										<span><a href="#">6</a></span>
										<span><a href="#">7</a></span>
										<span><a href="#">8</a></span>
										<span><a href="#">9</a></span>
										<span><a href="#">10</a></span>
										<span class="next"><a href="#"><img src="${contextPath}/resources/images/pagging/btn_next.gif" alt="다음페이지"/></a></span>
										<span class="next"><a href="#"><img src="${contextPath}/resources/images/pagging/btn_end.gif" alt="마지막페이지"/></a></span>
									</p>
								
								</div> <!-- t_content 게시판 -->
							</li>
							<li>
								<p class="tab">지식샘</p>
								<div class="t_content"> <!-- t_content 지식샘 -->
								
									<div class="list_type1" ><!-- list_type1 -->
									 	<ul>
											<li>
												<dl>
													<dt>
														<span class="bold">총 821 건을 검색하였습니다.</span>
													</dt>	
													<dt>
															<select>
																<option>유사도순</option>
																<option>DOC ID순</option>
															</select> 
															<select>
																<option>오름차순</option>
																<option>내림차순</option>
															</select>
													 
															<label for="srch_total">리스트 출력 건수</label>
															<select>
																<option>3</option>
																<option>5</option>
																<option>10</option>
															</select> 
															<span> 건수 </span>
															<a href="#"><img src="${contextPath}/resources/images/list/type4/icon_sort.gif" alt="정렬"/></a>			
													</dt>
												</dl>
											</li>
										</ul>		
									</div><!-- list_type1 -->


									<div class="mar_top50 hei_type1"> <!-- 지식샘 -->
										<p class="line_type1"> </p>
										<span class="txt_bold">
										<img src="${contextPath}/resources/images/searchBar/btn_type3_arr_rgt.gif" alt="지식샘"/>
										지식샘</span>
										<p class="line_type2"> </p>


										<ul class="list_type5">
										</ul>
									</div> <!-- 지식샘 -->


									<p class="pagging_type1 mar_top10"> 
										<span class="pre"><a href="#"><img src="${contextPath}/resources/images/pagging/btn_first.gif" alt="첫페이지"/></a></span>
										<span class="pre"><a href="#"><img src="${contextPath}/resources/images/pagging/btn_pre.gif" alt="이전페이지"/></a></span>
										<span><a href="#">1</a></span>
										<span><a href="#">2</a></span>
										<span><a href="#">3</a></span>
										<span><a href="#">4</a></span>
										<span><a href="#">5</a></span>
										<span><a href="#">6</a></span>
										<span><a href="#">7</a></span>
										<span><a href="#">8</a></span>
										<span><a href="#">9</a></span>
										<span><a href="#">10</a></span>
										<span class="next"><a href="#"><img src="${contextPath}/resources/images/pagging/btn_next.gif" alt="다음페이지"/></a></span>
										<span class="next"><a href="#"><img src="${contextPath}/resources/images/pagging/btn_end.gif" alt="마지막페이지"/></a></span>
									</p>
								
								</div> <!-- t_content 지식샘 -->
							</li>
							<li>
								<p class="tab">커뮤니티</p>

								<div class="t_content"> <!-- t_content 커뮤니티 -->
								
									<div class="list_type1" ><!-- list_type1 -->
									 	<ul>
											<li>
												<dl>
													<dt>
														<span class="bold">총 821 건을 검색하였습니다.</span>
													</dt>	
													<dt>
															<select>
																<option>유사도순</option>
																<option>DOC ID순</option>
															</select> 
															<select>
																<option>오름차순</option>
																<option>내림차순</option>
															</select>
													 
															<label for="srch_total">리스트 출력 건수</label>
															<select>
																<option>3</option>
																<option>5</option>
																<option>10</option>
															</select> 
															<span> 건수 </span>
															<a href="#"><img src="${contextPath}/resources/images/list/type4/icon_sort.gif" alt="정렬"/></a>			
													</dt>
												</dl>
											</li>
										</ul>			
									</div><!-- list_type1 -->


									<div class="mar_top50 hei_type1"> <!-- 커뮤니티 -->
										<p class="line_type1"> </p>
										<span class="txt_bold">
										<img src="${contextPath}/resources/images/searchBar/btn_type3_arr_rgt.gif" alt="커뮤니티"/>
										커뮤니티</span>
										<p class="line_type2"> </p>


										<ul class="list_type5">
										</ul>
									</div> <!-- 커뮤니티 -->


									<p class="pagging_type1 mar_top10"> 
										<span class="pre"><a href="#"><img src="${contextPath}/resources/images/pagging/btn_first.gif" alt="첫페이지"/></a></span>
										<span class="pre"><a href="#"><img src="${contextPath}/resources/images/pagging/btn_pre.gif" alt="이전페이지"/></a></span>
										<span><a href="#">1</a></span>
										<span><a href="#">2</a></span>
										<span><a href="#">3</a></span>
										<span><a href="#">4</a></span>
										<span><a href="#">5</a></span>
										<span><a href="#">6</a></span>
										<span><a href="#">7</a></span>
										<span><a href="#">8</a></span>
										<span><a href="#">9</a></span>
										<span><a href="#">10</a></span>
										<span class="next"><a href="#"><img src="${contextPath}/resources/images/pagging/btn_next.gif" alt="다음페이지"/></a></span>
										<span class="next"><a href="#"><img src="${contextPath}/resources/images/pagging/btn_end.gif" alt="마지막페이지"/></a></span>
									</p>
								
								</div> <!-- t_content 커뮤니티 -->

							</li>
							<li>
								<p class="tab">전자도서관</p>
								<div class="t_content"> <!-- t_content 전자도서관 -->
								
									<div class="list_type1" ><!-- list_type1 -->
									 	<ul>
										</ul>
									</div> <!-- 전자도서관 -->


									<p class="pagging_type1 mar_top10"> 
										<span class="pre"><a href="#"><img src="${contextPath}/resources/images/pagging/btn_first.gif" alt="첫페이지"/></a></span>
										<span class="pre"><a href="#"><img src="${contextPath}/resources/images/pagging/btn_pre.gif" alt="이전페이지"/></a></span>
										<span><a href="#">1</a></span>
										<span><a href="#">2</a></span>
										<span><a href="#">3</a></span>
										<span><a href="#">4</a></span>
										<span><a href="#">5</a></span>
										<span><a href="#">6</a></span>
										<span><a href="#">7</a></span>
										<span><a href="#">8</a></span>
										<span><a href="#">9</a></span>
										<span><a href="#">10</a></span>
										<span class="next"><a href="#"><img src="${contextPath}/resources/images/pagging/btn_next.gif" alt="다음페이지"/></a></span>
										<span class="next"><a href="#"><img src="${contextPath}/resources/images/pagging/btn_end.gif" alt="마지막페이지"/></a></span>
									</p>
								
								</div> <!-- t_content 전자도서관 -->
							</li>
						</ul>


					</div><!-- tab_type1 -->
