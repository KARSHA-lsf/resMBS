<%@page import="com.finnetwork.controllers.IDController"%>
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
<%
	String comapny_name = request.getParameter("param1");
	String data_set =request.getParameter("param2");
	String company =request.getParameter("param3");
	
	int id;
	if(data_set.equals("sec_data")){
		id = IDController.getID(comapny_name);
		
	}else{
		id=0;
	}
	
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
                    <h2>SEC DataSet</h2>
                    
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
                    <div class="clearfix"></div>
                </div>
                <div class="x_content">
                	<button id="grphALL" type="button" class="btn btn-default">All</button>
                	<button id="grph2016" type="button" class="btn btn-default">2016</button>
                	<button id="grph2015" type="button" class="btn btn-default">2015</button>
					<button id="grph2014" type="button" class="btn btn-default">2014</button>
					<button id="grph2013" type="button" class="btn btn-default">2013</button>
					<button id="grph2012" type="button" class="btn btn-default">2012</button>
					<button id="grph2011" type="button" class="btn btn-default">2011</button>
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
    <script src="js/SEC_viz.js"></script>
    <script src="js/jquery.auto-complete.min.js"></script>

    <script>
     $(document).ready(function (){
    	$("#company_network").hide();
     	$('.ui-pnotify').remove(); 
     	var edgeLabel_param = "";
     	$('#edge_filter').on('change', function() {
     		edgeLabel_param = this.value;
     		process_sec_c8(edgeLabel_param);
    		
    	});
     	process_sec_c8("ALL");   	
     });
     
     function process_sec_c8(edgeLabel_param){
  		var company_record = "<%= parm1 %>";
  		var id = <%=id%> ;
  		if(company_record){
  			$("#company_network").show();
  			$("#company_header").html("<h2>"+company_record+" : ALL"+"</h2>");
  				SEC_draw_me("../../FinNetwork/rest/sec/"+company_record+"?Role="+edgeLabel_param,"content_btn",id); 
  				//TNIC2_viz("rest/tnic2/"+company_cik+"/2015","content_btn");
  					$("#grphALL").click(function(){ $("#company_header").html("<h2>"+company_record+" | Year : ALL </h2>");SEC_draw_me("../../FinNetwork/rest/sec/"+company_record+"?Role="+edgeLabel_param,"content_btn",id);   });
  					$("#grph2016").click(function(){$("#company_header").html("<h2>"+company_record+" | Year : 2016</h2>");SEC_draw_me("../../FinNetwork/rest/sec/"+company_record+"/2016"+"?Role="+edgeLabel_param,"content_btn",id);});
  					$("#grph2015").click(function(){$("#company_header").html("<h2>"+company_record+" | Year : 2015</h2>");SEC_draw_me("../../FinNetwork/rest/sec/"+company_record+"/2015"+"?Role="+edgeLabel_param,"content_btn",id);});
  					$("#grph2014").click(function(){$("#company_header").html("<h2>"+company_record+" | Year : 2014</h2>");SEC_draw_me("../../FinNetwork/rest/sec/"+company_record+"/2014"+"?Role="+edgeLabel_param,"content_btn",id);});
  					$("#grph2013").click(function(){$("#company_header").html("<h2>"+company_record+" | Year : 2013</h2>");SEC_draw_me("../../FinNetwork/rest/sec/"+company_record+"/2013"+"?Role="+edgeLabel_param,"content_btn",id);});
  					$("#grph2012").click(function(){$("#company_header").html("<h2>"+company_record+" | Year : 2012</h2>");SEC_draw_me("../../FinNetwork/rest/sec/"+company_record+"/2012"+"?Role="+edgeLabel_param,"content_btn",id);});
  					$("#grph2011").click(function(){$("#company_header").html("<h2>"+company_record+" | Year : 2011</h2>");SEC_draw_me("../../FinNetwork/rest/sec/"+company_record+"/2011"+"?Role="+edgeLabel_param,"content_btn",id);});
  				}
  			}
		
  		//console.log(company_cik+"  "+ company_tsy);
  	
     
    </script>

  </body>
</html>