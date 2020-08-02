<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<div class="col-md-3 left_col">
		<div class="left_col scroll-view">
			<div class="navbar nav_title" style="border: 0;">
				<a href="index.jsp" class="site_title">
					<!-- <i class="fa fa-paw"></i> --> <span>Fin Network</span>
				</a>
			</div>

			<div class="clearfix"></div>

			<br />

			<!-- sidebar menu -->
			<div id="sidebar-menu" class="main_menu_side hidden-print main_menu">

				<div class="menu_section">
					<h3>General</h3>
					<ul class="nav side-menu">

						<li><a><i class="fa fa-sitemap"></i> SEC <span
								class="fa fa-chevron-down"></span></a>
							<ul class="nav child_menu">
								<%
									String array_sec[][] = new String[8][8];
								
									array_sec[0][0] = "Aetna Inc";
									array_sec[0][1] = "AETNA INC PA";
									array_sec[1][0] = "Automatic Data Processing";
									array_sec[1][1] = "AUTOMATIC DATA PROCESSING INC";
									array_sec[2][0] = "Bank of America Corp";
									array_sec[2][1] = "BANK OF AMERICA CORP DE";
									array_sec[3][0] = "BlackRock";
									array_sec[3][1] = "BlackRock Inc.";
									array_sec[4][0] = "Boston Properties";
									array_sec[4][1] = "BOSTON PROPERTIES INC";
									array_sec[5][0] = "Facebook, Inc";
									array_sec[5][1] = "Facebook Inc";
									array_sec[6][0] = "Time Warner Inc";
									array_sec[6][1] = "TIME WARNER INC.";
									array_sec[7][0] = "International Business Machines";
									array_sec[7][1] = "INTERNATIONAL BUSINESS MACHINES CORP";
									//array_sec[7][0] = "WALTDISNEY";
								    
									for (int i = 0; i < array_sec.length; i++) {
									%>	<li><a href="SEC_c8.jsp?param1=<%= array_sec[i][1] %>&param2=sec_data" id="sid_14"><%= array_sec[i][0] %></a></li> <% 
									}
								%>
									<li><a href="SEC_search.jsp" id="sid_14">SEC Search</a></li>
							</ul></li>
						<li>
							<a href="#"> 
								<i class="fa fa-sitemap" aria-hidden="true"></i>Thomson Reuters <span
								class="fa fa-chevron-down"></span>
							</a>
							<ul class="nav child_menu">
							<% 
								String array_trdf_gt[][] = new String[8][8];
									array_trdf_gt[0][0] = "Aetna Inc";
									array_trdf_gt[0][1] = "Aetna Inc CIK: ['0001013761', '0001122304'] uri_id: 4295903286";
									array_trdf_gt[1][0] = "Automatic Data Processing";	
									array_trdf_gt[1][1] = "Automatic Data Processing Inc CIK: 8670 uri_id: 4295903514";
									array_trdf_gt[2][0] = "Bank of America Corp";
									array_trdf_gt[2][1] = "Bank of America Corp CIK: ['0000070858', '0001085917'] uri_id: 8589934339";
									array_trdf_gt[3][0] = "BlackRock";
									array_trdf_gt[3][1] = "BlackRock Inc CIK: 1364742 uri_id: 4295900990";
									array_trdf_gt[4][0] = "Boston Properties";	
									array_trdf_gt[4][1] = "Boston Properties Inc CIK: 1037540 uri_id: 4295903585";	
									array_trdf_gt[5][0] = "Facebook, Inc";
									array_trdf_gt[5][1] = "Facebook Inc CIK: 1326801 uri_id: 4297297477";
									array_trdf_gt[6][0] = "Time Warner Inc.";
									array_trdf_gt[6][1] = "Time Warner Inc CIK: 1105705 uri_id: 4295903356";
									array_trdf_gt[7][0] = "International Business Machines Corp";
									array_trdf_gt[7][1] = "International Business Machines Corp CIK: 51143 uri_id: 4295904307";
								
								for (int i = 0; i < array_trdf_gt.length; i++) {
									%>	<li><a href="TRDF.jsp?param1=<%= array_trdf_gt[i][1] %>" id="sid_14"><%= array_trdf_gt[i][0] %></a></li> <% 
								}
								
							%>
							
							
							</ul>
						</li> 
						<li><a><i class="fa fa-sitemap"></i> OpenCorporates <span
								class="fa fa-chevron-down"></span></a>
								<ul class="nav child_menu">
								<%
									String array_oc[][] = new String[8][8];
								
									array_oc[0][0] = "Aetna Inc";
									array_oc[0][1] = "31223432";
									array_oc[1][0] = "Automatic Data Processing";
									array_oc[1][1] = "91267231";
									array_oc[2][0] = "Bank of America Corp";
									array_oc[2][1] = "53874222";
									array_oc[3][0] = "BlackRock";
									array_oc[3][1] = "92797866";
									array_oc[4][0] = "Boston Properties";
									array_oc[4][1] = "53874225";
									array_oc[5][0] = "Facebook, Inc";
									array_oc[5][1] = "27748339";
									array_oc[6][0] = "Time Warner Inc";
									array_oc[6][1] = "53874368";
									array_oc[7][0] = "International Business Machines";
									array_oc[7][1] = "59425444";
									//array_sec[7][0] = "WALTDISNEY";
								    
									for (int i = 0; i < array_oc.length; i++) {
									%>	<li><a href="data_visualizer.jsp?param1=<%= array_oc[i][1] %>&param2=oc_data&param3=<%= array_oc[i][0] %>" id="sid_14"><%= array_oc[i][0] %></a></li> <% 
									}
								%>
							</ul>
							<!-- <ul class="nav child_menu">
								<li><a href="data_visualizer.jsp?param1=IBM&param2=oc_data" id="sid_14">International Business Machines Corp</a></li>
							
			
							</ul> -->
						</li>
						<li>
							<a href="#"> 
								<i class="fa fa-sitemap" aria-hidden="true"></i> TNIC<span
								class="fa fa-chevron-down"></span>
							</a>
							<ul class="nav child_menu">
							<% 
								String array_tnic[][] = new String[7][7];
									array_tnic[0][0] = "AETNA Inc";
									array_tnic[0][1] = "AET : Aetna Inc : Health Care : Managed Health Care  cik: 0001122304 naics: 524114";
									array_tnic[1][0] = "AUTOMATIC DATA PROCESSING INC";	
									array_tnic[1][1] = "ADP : Automatic Data Processing : Information Technology : Internet Software and Services  cik: 0000008670 naics: 518210";
									array_tnic[2][0] = "BANK OF AMERICA corp";
									array_tnic[2][1] = "BAC : Bank of America Corp : Financials : Diversified Banks  cik: 0000070858 naics: 522110";
									array_tnic[3][0] = "BLACKROCK inc";
									array_tnic[3][1] = "BLK : BlackRock : Financials : Asset Management and Custody Banks  cik: 0001364742 naics: 523110";
									array_tnic[4][0] = "BOSTON PROPERTIES LP";	
									array_tnic[4][1] = "BXP : Boston Properties : Real Estate : Office REITs  cik: 0001037540 naics: 525930";	
									array_tnic[5][0] = "FACEBOOK Inc";
									array_tnic[5][1] = "FB : Facebook, Inc. : Information Technology : Internet Software and Services  cik: 0001326801 naics: 519130";
									//array_tr[6] = "WALT DISNEY Co";
									array_tnic[6][0] = "International Business Machines Corp";
									array_tnic[6][1] = "IBM : International Business Machines : Information Technology : IT Consulting and Other Services  cik: 0000051143 naics: 334111";
								
								for (int i = 0; i < array_tnic.length; i++) {
									%>	<li><a href="TNIC_c8.jsp?param1=<%= array_tnic[i][1] %>" id="sid_14"><%= array_tnic[i][0] %></a></li> <% 
								}	
							%>
							<li><a href="TNIC_search.jsp" id="sid_14">TNIC Search</a></li>
							</ul>
						</li>
						
						<li><a href="http://opensource.lk/"> <i
								class="fa fa-users" aria-hidden="true"></i> People
						</a></li>
					</ul>
				</div>
			</div>
			<!-- sidebar menu -->


		</div>
	</div>
</body>
</html>