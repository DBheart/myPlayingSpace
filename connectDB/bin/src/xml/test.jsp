[[--c_define--]]
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/icss-tags.tld" prefix="icss" %> 
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title> 한국콘텐츠진흥원 - [[--Ifstart,is:nowid=ks84--]][[--Thenstart--]][[--ReplaceStart,Regex:<,To:&lt;--]][[--Write,Name:t_title--]] - 콘텐츠산업정보포털(kocca.kr)[[--ReplaceEnd--]][[--Thenend--]][[--Elsestart--]][[--CatExp--]] - 콘텐츠산업정보포털(kocca.kr)[[--ElseEnd--]][[--Ifend--]] </title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />	
	<!--meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" /-->
	<link rel="SHORTCUT ICON"  href="[[--RootDir--]]images/kocca.ico" /> [[---파비콘적용---]]
	<link rel="stylesheet" href="http://kocca.kr[[--CatAddress,kscss,tplid:3724--]]" type="text/css" />[[---/common/css/together1.css---]]	
	[[--IFstart,is:sid3=ks4--]][[--ThenStart--]]<link rel="stylesheet" href="http://kocca.kr[[--CatAddress,kscss,tplid:3301--]]" type="text/css" />[[---/common/css/knowledge.css---]][[--ThenEnd--]][[--IFEnd--]]
	[[--IFStart,is:sid3=ks1--]][[--ThenStart--]]<link rel="stylesheet" href="http://kocca.kr[[--CatAddress,kscss,tplid:3335--]]" type="text/css" />[[---/common/css/callcenter.css---]][[--ThenEnd--]][[--IFEnd--]]
	[[--IFStart,is:sid3=ks7--]][[--ThenStart--]]<link rel="stylesheet" href="http://kocca.kr[[--CatAddress,kscss,tplid:3341--]]" type="text/css" />[[---/common/css/mypage.css---]][[--ThenEnd--]][[--IFEnd--]]
	<script type="text/javascript" src="http://kocca.kr[[--CatAddress,ksjs,tplid:1121--]]" charset="utf-8"></script>[[---/js/jquery.js---]]
	<script type="text/javascript" src="http://kocca.kr[[--CatAddress,ksjs,tplid:3380--]]" charset="utf-8"></script> [[---js/ics.js---]]
</head>
<body>
 <iframe name="resizeIframe" id="resizeIframe" src="" width="670" height="0" frameborder="0"></iframe>
 [[--cnt_list_t--]]
 <icss:search repository="ko" type="part" position="main" siteid="ks23" synonymity="false" sort="credate:desc" cntperpage="15">
	<%
		String selectForSort = request.getParameter("icss:search:query");
		String qry = "";
		String selectForQry = "";
		if (request.getParameter("icss:search:all1") != null) {
			qry = request.getParameter("icss:search:all1");
			selectForQry = "all1";
		} else if (request.getParameter("icss:search:subject") != null) {
			qry = request.getParameter("icss:search:subject");
			selectForQry = "subject";
		} else if (request.getParameter("icss:search:content") != null) {
			qry = request.getParameter("icss:search:content");
			selectForQry = "content";
		}

		if (selectForSort == null || selectForSort == "") {
			selectForSort = "sort";
		}
	%>
	<div id="content">
	<!-- content -->
		[[--Custom,Tag:c_stitle_05,CID=ks23--]][[---소제목영역 ---]]
		<!-- 카테고리 -->
		<form name="searchForm" id="searchForm" method="get" onsubmit="return goSb();">
			<input type="hidden" name="icss:search:catid" id="icss:search:catid" value="ks23" /> 
			<input type="hidden" name="icss:search:query:field" id="icss:search:query:field" value="lgroup" />
			<input type="hidden" name="icss:search:query" id="icss:search:query"/>
			 <input type="hidden" name="icss:search:query:op" id="icss:search:query:op" value="and"/>
			<div class="search_group">
				<div class="cate_lay mg_t30">
					<p class="pd_t4 float_l">
						<strong>Total</strong> <span class="f_bold f_puple"><icss:notequal type="search" name="count" value="0"><icss:count /></icss:notequal><icss:equal type="search" name="count" value="0">0</icss:equal></span>건
					</p>
					<fieldset class="float_l">
						<legend>리스트 분류</legend>
							<select name="query" id="query">
								<option value="" <%=(selectForSort.equalsIgnoreCase("sort")) ? "selected": ""%>>분류</option>
								<option value="공지" <%=(selectForSort.equalsIgnoreCase("공지")) ? "selected": ""%>>공지</option>
								<option value="전시회" <%=(selectForSort.equalsIgnoreCase("전시회")) ? "selected": ""%>>전시회</option>
								<option value="세미나" <%=(selectForSort.equalsIgnoreCase("세미나")) ? "selected": ""%>>세미나</option>
								<option value="교육" <%=(selectForSort.equalsIgnoreCase("교육")) ? "selected": ""%>>교육</option>
								<option value="이벤트" <%=(selectForSort.equalsIgnoreCase("이벤트")) ? "selected": ""%>>이벤트</option>
								<option value="공고" <%=(selectForSort.equalsIgnoreCase("공고")) ? "selected": ""%>>공고</option>
								<option value="결과" <%=(selectForSort.equalsIgnoreCase("결과")) ? "selected": ""%>>결과</option>
								<option value="기타" <%=(selectForSort.equalsIgnoreCase("기타")) ? "selected": ""%>>기타</option>
							</select>
					</fieldset>
					<p class="float_l">
						<a href="#none" onclick="goSb();"><img src="http://kocca.kr/images/common/btn/btn_confirm.gif" alt="확인" class="valign_t" /> </a>
					</p>
				</div>
				<div class="search_lay mg_t30">
					<fieldset class="float_l">
						<legend>분류</legend>
							<select name="field" id="field">
								<option value="all1" <%=(selectForQry.equalsIgnoreCase("all1")) ? "selected": ""%>>전체</option>
								<option value="subject" <%=(selectForQry.equalsIgnoreCase("subject")) ? "selected": ""%>>제목</option>
								<option value="content" <%=(selectForQry.equalsIgnoreCase("content")) ? "selected": ""%>>내용</option>
							</select>
					</fieldset>
					<p class="float_l">
						<input id="qry" name="qry" type="text" style="width: 148px; margin-right: 5px;" class="search" title="search" maxlength="30" value="<%=qry%>" />
					</p>
					<p class="float_l">
						<a href="#none" onclick="goSb();"><img src="http://kocca.kr/images/common/btn/btn_search.gif" alt="SEARCH" class="valign_t" /> </a>
					</p>
				</div>
			</div>
		</form>
		<!-- //카테고리 -->
		<!-- 리스트 -->
		<div class="board_list">
			<table summary="공지사항 리스트입니다.">
				<caption>공지사항 리스트</caption>
				<colgroup>
					<col width="9%" />
					<col width="9%" />
					<col width="" />
					<col width="11%" />
					<col width="8%" />
				</colgroup>
				<thead>
					<tr>
						<th class="nogap">번호</th>
						<th>분류</th>
						<th>제목</th>
						<th>등록일</th>
						<th>조회</th>
					</tr>
				</thead>
				<tbody>
				<icss:notequal name="count" value="0">
				<icss:iterate>
					<tr>
						<td class="num">
						<script type="text/javascript">
							var index= <icss:count/> - <icss:iterateindex/> + 1;
							document.write(index);
						</script>
						</td>
						<td class="num"><icss:field field="lgroup"/></td>
						<td class="left">
						<a href="<icss:url  number="2" />" target="_top"><icss:field field="subject" highlight="true" bold="true" color="red"/></a>
						</td>
						<td class="num"><icss:date field="credate" format="yy.MM.dd" /></td>
						<td class="num">[[--cnt_list_ms--]]</td>
					</tr>
				</icss:iterate>
				</icss:notequal>
				</tbody>
			</table>
		</div>
		<!-- //리스트 -->
		<p class="board_btn">
			<a href="#1"><img src="http://kocca.kr/images/common/btn/board_rss.gif" alt="RSS 구독신청" /> </a>
		</p>
		<!-- 페이징 -->
		<icss:navigator>
		<div class="paging">
			<ul>
				<li><a href="<icss:page type='link' property='first'/>"><img src="http://kocca.kr/images/common/btn/prev_paging2.gif" alt="맨앞으로" /> </a> 
				<a href="<icss:page type='link' property='prev'/>"><img src="http://kocca.kr/images/common/btn/prev_paging.gif" alt="왼쪽으로이동" class="mg_l15" /> </a>
				</li>
				<icss:iterate type="navigator">
				<li><a href="<icss:page type='link' property='page'/>"><span class="f_puple f_bold"><icss:page type="num" curpagebold="true" curpagecolor="RED"/></span></a> </li>
				</icss:iterate>
				<li><a href="<icss:page type='link' property='next'/>"><img src="http://kocca.kr/images/common/btn/next_paging.gif" alt="오른쪽으로이동" /> </a> 
				<a href="<icss:page type='link' property='last'/>"><img src="http://kocca.kr/images/common/btn/next_paging2.gif" alt="맨뒤로" class="mg_l15" /> </a>
				</li>
			</ul>
		</div>
		</icss:navigator>
		<!-- //페이징 -->
	<!-- // content -->
	</div>
	[[--cnt_list_bs--]]
	</icss:search>
</body>
</html>