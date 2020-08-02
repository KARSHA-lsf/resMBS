<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Fin network</title>
<!-- Bootstrap -->
<link href="vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link href="vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link href="vendors/pnotify/dist/pnotify.css" rel="stylesheet">
<link href="vendors/pnotify/dist/pnotify.buttons.css" rel="stylesheet">
<!-- Custom Theme Style -->
<link href="build/css/custom.min.css" rel="stylesheet">
<link href="css/jquery.auto-complete.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/tabs.css">

<link href="vendors/datatables.net-bs/css/dataTables.bootstrap.min.css"
	rel="stylesheet">
<link
	href="vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css"
	rel="stylesheet">
<link
	href="vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css"
	rel="stylesheet">
<link
	href="vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css"
	rel="stylesheet">
<link
	href="vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css"
	rel="stylesheet">

<style type="text/css">
#container {
	position: relative;
	overflow: hidden;
}

.active1 {
	background-color: #52B9FA;
	color: white;
}
</style>
</head>
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">
					<jsp:include page="menu.jsp" />
					<div class="clearfix"></div>
				</div>
			</div>
			<!-- top navigation -->
			<div class="top_nav">
				<div class="nav_menu">
					<div class="nav toggle">
						<a id="menu_toggle"><i class="fa fa-bars"></i></a>
					</div>
				</div>
			</div>
			<!-- /top navigation -->
			<!-- page content -->
			<div class="right_col" role="main">
				<div class="row">

				 <div class="x_panel">
						<div class="x_title">
							<h2>Sector 51 : <span id="cmp_header"></span></h2>
							<ul class="nav navbar-right panel_toolbox">
								<li><a class="collapse-link"><i
										class="fa fa-chevron-up"></i></a></li>
							</ul>
							<div class="clearfix"></div>
						</div>
						<div class="x_content">
							<button id="TRDF" type="button" class="btn btn-default">TRDF</button>
		                	<button id="APP" type="button" class="btn btn-default">Additional Participant Predictions [
		                	<span><i class="fa fa-square" style="color:red"> : Not in TNIC</i> </span>
		                	 ]</button>
		                	<button id="TNIC" type="button" class="btn btn-default">TNIC</button>
		                	
		                	
		                	
							<div id="content_post" style="height:650px;"></div>
						
						
						
						

		
						</div>
					</div>

				</div>
			</div>
		</div>




		<!-- footer content -->
		<footer> </footer>
		<!-- /footer content -->
	</div>
	</div>

	<!-- jQuery -->
	<script src="vendors/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="vendors/bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="vendors/pnotify/dist/pnotify.js"></script>
	<script src="vendors/pnotify/dist/pnotify.buttons.js"></script>
	<script src="build/js/custom.min.js"></script>
	<script src="js/d3.v4.min.js"></script>
	<script src="js/d3-selection-multi.v1.js"></script>
	<script src="js/TRDF_gt_vizSec51.js"></script>
	<script src="js/TNIC2_viz.js"></script>
	<script src="js/APP_viz.js"></script>

	<script src="js/jquery.auto-complete.min.js"></script>

	<script src="vendors/datatables.net/js/jquery.dataTables.min.js"></script>
	<script src="vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
	<script
		src="vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
	<script
		src="vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
	<script src="vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
	<script src="vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
	<script src="vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
	<script
		src="vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
	<script
		src="vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
	<script
		src="vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
	<script
		src="vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
	<script
		src="vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
	

	<script>
	function getUrlParameter(name) {
	    name = name.replace(/[\[]/, '\\[').replace(/[\]]/, '\\]');
	    var regex = new RegExp('[\\?&]' + name + '=([^&#]*)');
	    var results = regex.exec(location.search);
	    return results === null ? '' : decodeURIComponent(results[1].replace(/\+/g, ' '));
	};
	
    
     $(document).ready(function (){
    	$("#company_network").hide();
     	$('.ui-pnotify').remove(); 
  
     		var TRDF_id = getUrlParameter('TRDF_id');
     		var CIK = getUrlParameter('cik');
     		var T_symbol = getUrlParameter('T_symbol');
     		
     		$("#cmp_header").text(T_symbol);
     		TRDF_gt_vizSec51("rest/trdf_gt/sec51/"+TRDF_id,"content_post","isCompetitorOf"); 
     		$("#TRDF").click(function(){
     			TRDF_gt_vizSec51("rest/trdf_gt/sec51/"+TRDF_id,"content_post","isCompetitorOf"); 
     			$("#cmp_header").text(T_symbol +" : TRDF");
     		});
     		$("#APP").click(function(){
     			APP_viz("rest/APP/"+cik_manipulate(CIK,10),"content_post");
     			$("#cmp_header").text(T_symbol +" : Additional Participant Prediction");
     		});
     		$("#TNIC").click(function(){
     			TNIC2_viz("rest/tnic2/noduplicates/"+cik_manipulate(CIK,10),"content_post");
     			$("#cmp_header").text(T_symbol +" : TNIC");
     		});
        	
          
        	

            
      
     	
         
     	
     	
     });
     
     function cik_manipulate(num,length){
    	 var r = "" + num;
    	    while (r.length < length) {
    	        r = "0" + r;
    	    }
    	    console.log(r);
    	    return r;
     }
     
    </script>

</body>
</html>