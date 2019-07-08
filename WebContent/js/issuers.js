$(document).ready(
		function() {
			$("#company_network").hide();
			$('.ui-pnotify').remove();

			$.getJSON("rest/topic/issuers/", function(data) {
				// console.log('data.company',data.company);
				$('#company_search').autoComplete({
					minChars : 1,
					source : function(term, suggest) {
						// console.log("AAAAA",term);
						term = term.toLowerCase();
						var choices = data.company;
						var suggestions = [];
						for (i = 0; i < choices.length; i++)
							if (~choices[i].toLowerCase().indexOf(term))
								suggestions.push(choices[i]);
						suggest(suggestions);
					}
				});
			});

			$("#select_company").click(function() {
				// $('#edge_filter').val("ALL");
				var search_company_record = $('#company_search').val();

				process_sec(search_company_record);

			});

			function process_sec(search_company_record) {
				if (search_company_record) {
					var res = search_company_record.split(":");
					if (res.length > 1) {
						var company_record = res[0];
						var id = res[1];
						console.log("FI=", id);
						if (res.length > 1) {

							$("#company_network").show();
							$("#company_header").html(
									"<h2>" + company_record + "</h2>");
							issuers_draw_me("rest/topic/" + id);
						}
					}
				}
			}

			// console.log(company_cik+" "+ company_tsy);

			// TNIC2_viz("rest/sec/ADP/2013","content_2015");

		});

function issuers_draw_me(url) {
	console.log('issuers_draw_me_ URL', url);
	$.getJSON(url, function(data) {
		console.log('data__>', data);
		var y = [ 'FC' ];
		var x = [];
		var n_a = [ 'a' ];
		var n_b = [ 'b' ];
		var n_m = [ 'm' ];
		var count = 0;
		data.company.forEach(function(d) {
			console.log('data__>', d);
			y[count + 1] = parseInt(d[1]);
			x[count] = d[0];
			n_a[count + 1] = parseInt(d[2]);
			n_b[count + 1] = parseInt(d[3]);
			n_m[count + 1] = parseInt(d[4]);
			count++;
		})
		console.log('y--> ', y);
		var temp = y.slice(1, y.length).sort(sortNumber);
		console.log('temp--> ', temp, 'max', temp[temp.length - 1]);

		var chart = c3.generate({
			data : {
				columns : [ y ],
				type : 'bar',

			},
			bindto : '#content_btn',
			bar : {
				width : {
					ratio : 0.5
				// this makes bar width 50% of length between ticks
				}
			// or
			// width: 100 // this makes bar width 100px
			},
			axis : {
				x : {
					label : {
						text : 'FC',
						position : 'outer-middle',
					},
					type : 'category',
					tick : {
						rotate : 85,
						multiline : false
					},
					height : 80,
					categories : x
				},
				tick : {
					x : {

						multiline : false,
						culling : {
							max : 1
						},
					},
					label : {
						text : 'Days',
						position : 'center-bottom',

					},
				},
				y : {
					label : {
						text : 'n Value',
						position : 'outer-middle',
					},
					max : temp[temp.length - 1] + 1,
					min : 0,
					padding : {
						top : 0,
						bottom : 0
					}
				}
			}
		});
		// second chart

		var chart = c3.generate({
			data : {
				columns : [ n_m, n_b, n_a,

				],
				type : 'bar',
				groups : [ [ 'b', 'a', 'm' ] ],
				colors : {
					'a' : '#ADD8E6',
					'b' : '#90EE90',
					'm' : '#FF1493',
				},
				order : null
			},
			bindto : '#content_btn2',
			bar : {
				width : {
					ratio : 0.5
				// this makes bar width 50% of length between ticks
				}
			// or
			// width: 100 // this makes bar width 100px
			},
			axis : {
				x : {
					label : {
						text : 'FC',
						position : 'outer-middle',
					},
					type : 'category',
					tick : {
						rotate : 85,
						multiline : false
					},
					height : 80,
					categories : x
				},
				tick : {
					x : {

						multiline : false,
						culling : {
							max : 1
						},
					},
					label : {
						text : 'Days',
						position : 'center-bottom',

					},
				},
				y : {
					label : {
						text : 'n Value',
						position : 'outer-middle',
					},
					max : temp[temp.length - 1] + 1,
					min : 0,
					padding : {
						top : 0,
						bottom : 0
					}
				}
			}
		});

	});
}
function sortNumber(a, b) {
	return a - b;
}
