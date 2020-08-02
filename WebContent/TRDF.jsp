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
    <link href="vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="vendors/pnotify/dist/pnotify.css" rel="stylesheet">
    <link href="vendors/pnotify/dist/pnotify.buttons.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="build/css/custom.min.css" rel="stylesheet">
    <link href="css/jquery.auto-complete.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/tabs.css">
    <style type="text/css">
      #container{
       position: relative;
       overflow: hidden;
      }
    </style>
</head>
<%
	String parm1 = request.getParameter("param1");
%>
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
                    <h2>TRDF ground truth DataSet</h2>
                    <div class="clearfix"></div>
                  </div>
           </div>
           <div id="company_network" class="x_panel" >
           		<div class="x_title">
                    <h2 id="company_header" ></h2>
                    <div class="pull-right">
                     <div class="form-group">
                        <div class="col-md-12 col-sm-9 col-xs-12">
                          <select id="edge_filter" class="form-control">
                          <option>All</option>
                          </select>
                        </div>
                        </div>
                        </div>
                    
                    <!-- <ul class="nav nav-pills pull-right" role="tablist" >
                    	
                    	<li role="presentation" class="dropdown">
		                    <a id="headeref" href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" role="button" aria-expanded="false">
		                      	Edge Filters 
		                      	<span class="caret"></span>
                            </a>
                      		<ul id="edge_filter" class="dropdown-menu animated fadeInDown" role="menu">	
                      		</ul>
                    	</li> -->
                     </ul>  
                    <div class="clearfix"></div>
                </div>
                <div class="x_content">                  
                    <div id="content_btn" style="height:650px;">
               
                    </div>
				</div>
           </div>
           </div>
       </div>
       </div>
      
       
      
       
        <!-- footer content -->
        <footer>

        </footer>
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
    <script src="js/TRDF_gt_viz.js"></script>
    <script src="js/jquery.auto-complete.min.js"></script>

    <script>
     $(document).ready(function (){
    	 var edgeLabel_param = "";
    	$("#company_network").hide();
     	$('.ui-pnotify').remove(); 
     	$('#edge_filter').on('change', function() {
     		if(this.value == 'All'){
     			edgeLabel_param = "";
     		}else{
     			edgeLabel_param = this.value;
     		}
     		
     		process_trdf(edgeLabel_param);
    		console.log( this.value );
    	 });
     	process_trdf(edgeLabel_param);
     });
     
     function process_trdf(edgeLabel_param){
    	var company_record = "<%= parm1 %>";
  		var company_details = null;
  		var company_uriID = null;
  		if(company_record){
  			var res = company_record.split("uri_id:");
  			if(res.length>1){
  				company_uriID = res[1].replace(/ /g,'');
  				company_details = res[0];
  					$("#company_network").show();
  					$("#company_header").html("<h2>"+company_details+"</h2>");
  					TRDF_gt_viz("rest/trdf_gt/"+company_uriID,"content_btn",edgeLabel_param);
  					
  			}
  		} 
  		
     }
     
    </script>

  </body>
</html>