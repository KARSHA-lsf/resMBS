function sortNumber(a,b) {
    return a - b;
}
    
    //------------------------------------------
    getDataForGivenYear('2002','chart_2002','Graph_for_specific_topic_2002');
	function sortNumber(a, b) {
		return a - b;
	}
	function getDataForGivenYear(year,id_chart,id_specific_topic) {
		d3.json("rest/topic/prospectus/", function(error, data) {
			//----- first graph 
	    	var year_count = {year_2002:0, year_2003:0,year_2004:0, year_2005:0, year_2006:0, year_2007:0,year_2008:0 };
	        
	        data.forEach(function(d) {
	        	
	           if('2002'===d[1]){               
	        	   year_count.year_2002=year_count.year_2002+1; 			
	               }
	           else if('2003'===d[1]){
	        	   year_count.year_2003=year_count.year_2003+1;
	               }
	           else if('2004'===d[1]){
	        	   year_count.year_2004=year_count.year_2004+1;
	               }
	           else if('2005'===d[1]){
	        	   year_count.year_2005=year_count.year_2005+1;
	               }
	           else if('2006'===d[1]){
	        	   year_count.year_2006=year_count.year_2006+1;
	               }
	           else if('2007'===d[1]){
	        	   year_count.year_2007=year_count.year_2007+1;
	               }
	           else if('2008'===d[1]){
	        	   year_count.year_2008=year_count.year_2008+1;
	               }
	        });
	        var temp = [];
	    	temp[0]=year_count.year_2002;
	    	temp[1]=year_count.year_2003;
	    	temp[2]=year_count.year_2004;
	    	temp[3]=year_count.year_2005;
	    	temp[4]=year_count.year_2006;
	    	temp[5]=year_count.year_2007;
	    	temp[6]=year_count.year_2008;
	    																												
	    
	    	console.log(year_count);
	    	temp.sort(sortNumber);
	    
	        var chart = c3.generate({
	            data: {
	                columns: [
	                    ['Prospectus Count ',year_count.year_2002, year_count.year_2003, year_count.year_2004, year_count.year_2005, year_count.year_2006, year_count.year_2007,year_count.year_2008]
	                ],
	                type: 'bar'
	            },
	            bindto : '#chart',
	            bar: {
	                width: {
	                    ratio: 0.5 // this makes bar width 50% of length between ticks
	                }
	                // or
	                //width: 100 // this makes bar width 100px
	            },
	            axis: {
	                x : {label : {
	                    text: 'Years',
	                    position: 'outer-middle',
	                },
	                    type: 'category',
	                    categories:  ['2002', '2003', '2004', '2005', '2006', '2007', '2008']
	                },
	                tick: {
	                    x:{
	                       
	                        multiline:false,
	                        culling: {
	                            max: 1
	                        },
	                    },
	                    label : {
	                        text: 'Days',
	                        position: 'center-bottom',

	                    },
	                },
	                y: {
	                    label : {
	                        text: ' Prospectus Count',
	                        position: 'outer-middle',
	                    },
	                    max: temp[6],
	                    min: 0,
	                    padding: {top:0, bottom:0}
	                }
	            }
	        });


	        
			//-----
	        
	        //---  second graph
			var topic = [ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ];

			var new_arr = [];
			data.forEach(function(d) {
				//console.log(d);
				if (d[1] == year) {
					if (d[4] == 'w1') {
						topic[0] = topic[0] + parseFloat(d[3]);
						//console.log('d[1]=',d[1],'d[4]=',d[4],'d[3]=',d[3],'	topic[0]=',	topic[0]);
					} else if (d[4] == 'w2') {
						topic[1] = topic[1] + parseFloat(d[3]);
					} else if (d[4] == 'w3') {
						topic[2] = topic[2] + parseFloat(d[3]);
					} else if (d[4] == 'w4') {
						topic[3] = topic[3] + parseFloat(d[3]);
					} else if (d[4] == 'w5') {
						topic[4] = topic[4] + parseFloat(d[3]);
					}

					else if (d[4] == 'w6') {
						topic[5] = topic[5] + parseFloat(d[3]);
					} else if (d[4] == 'w7') {
						topic[6] = topic[6] + parseFloat(d[3]);
					} else if (d[4] == 'w8') {
						topic[7] = topic[7] + parseFloat(d[3]);
					} else if (d[4] == 'w9') {
						topic[8] = topic[8] + parseFloat(d[3]);
					} else if (d[4] == 'w10') {
						topic[9] = topic[9] + parseFloat(d[3]);
					} else if (d[4] == 'w11') {
						topic[10] = topic[10] + parseFloat(d[3]);
					} else if (d[4] == 'w12') {
						topic[11] = topic[11] + parseFloat(d[3]);
					} else if (d[4] == 'w13') {
						topic[12] = topic[12] + parseFloat(d[3]);
					} else if (d[4] == 'w14') {
						topic[13] = topic[13] + parseFloat(d[3]);
					} else if (d[4] == 'w15') {
						topic[14] = topic[14] + parseFloat(d[3]);
					} else if (d[4] == 'w16') {
						topic[15] = topic[15] + parseFloat(d[3]);
					} else if (d[4] == 'w17') {
						topic[16] = topic[16] + parseFloat(d[3]);
					} else if (d[4] == 'w18') {
						topic[17] = topic[17] + parseFloat(d[3]);
					} else if (d[4] == 'w19') {
						topic[18] = topic[18] + parseFloat(d[3]);
					} else if (d[4] == 'w20') {
						topic[19] = topic[19] + parseFloat(d[3]);
					} else if (d[4] == 'w21') {
						topic[20] = topic[20] + parseFloat(d[3]);
					} else if (d[4] == 'w22') {
						topic[21] = topic[21] + parseFloat(d[3]);
					} else if (d[4] == 'w23') {
						topic[22] = topic[22] + parseFloat(d[3]);
					} else if (d[4] == 'w24') {
						topic[23] = topic[23] + parseFloat(d[3]);
					} else if (d[4] == 'w25') {
						topic[24] = topic[24] + parseFloat(d[3]);
					} else if (d[4] == 'w26') {
						topic[25] = topic[25] + parseFloat(d[3]);
					} else if (d[4] == 'w27') {
						topic[26] = topic[26] + parseFloat(d[3]);
					} else if (d[4] == 'w28') {
						topic[27] = topic[27] + parseFloat(d[3]);
					} else if (d[4] == 'w29') {
						topic[28] = topic[28] + parseFloat(d[3]);
					} else if (d[4] == 'w30') {
						topic[29] = topic[29] + parseFloat(d[3]);
					}
				}

			});
			var temp_year='Prospectus_of_'+year;
			var chart = c3.generate({
				data : {
					columns : [
							[ temp_year, topic[0], topic[1], topic[2], topic[3],
									topic[4], topic[5], topic[6], topic[7],
									topic[8], topic[9], topic[10], topic[11],
									topic[12], topic[13], topic[14], topic[15],
									topic[16], topic[17], topic[18], topic[19],
									topic[20], topic[21], topic[22], topic[23],
									topic[24], topic[25], topic[26], topic[27],
									topic[28], topic[29] ],

					],
					type : 'bar',
					groups : [ [ temp_year ] ],
					onclick : function(d, element) { 
						showPidWhenGivenTopicAndYear(d, data,id_specific_topic);
					}
				},
				bindto : '#'+id_chart,
				grid : {
					y : {
						lines : [ {
							value : 0
						} ]
					}
				},
				axis : {
					x : {
						label : {
							text : 'topics',
							position : 'outer-middle',
						},
						type : 'category',
						categories : [ 'w1', 'w2', 'w3', 'w4', 'w5', 'w6',
								'w7', 'w8', 'w9', 'w10', 'w11', 'w12', 'w13',
								'w14', 'w15', 'w16', 'w17', 'w18', 'w19',
								'w20', 'w21', 'w22', 'w23', 'w24', 'w25',
								'w26', 'w27', 'w28', 'w29', 'w30' ]
					},
					tick : {
						x : {

							multiline : false,
							culling : {
								max : 1
							},
						},
						label : {
							text : 'topics',
							position : 'center-bottom',

						},
					},
					y : {
						label : {
							text : ' Sum of Nominal values (Million $)',
							position : 'outer-middle',
						},
//						max : 33,
//						min : 0,
//						padding : {
//							top : 0,
//							bottom : 0
//						}
					}
				}
			});

		});
	}
	// drawing third graph when necessary use this function 
	function showPidWhenGivenTopicAndYear(event_data, data,id_specific_topic) {
		console.log("event_data",event_data);
		document.getElementById(event_data.id).innerHTML = 'Associated topic  w'+(event_data.index+1);
		var PidArray = [];
		var WeightAray = [ 'Weight-PID' ];
		var countPid = 0;
		console.log("data",data[0]);
		//console.log("event_data",event_data);
		var only_year_str= event_data.id.split("_");
		//console.log('only_year_str',only_year_str[2]);
		data.forEach(function(d) {
			if (d[1] == only_year_str[2]) {//compare year
				if (d[4] == 'w' + (event_data.index + 1)) {
					//console.log(d);
					PidArray[countPid] = d[0];
					WeightAray[countPid + 1] = parseFloat(d[3]);
					countPid++;

				}
			}
		})
		array = WeightAray.slice(1, WeightAray.length).sort();
		console.log(array);
		var chart = c3.generate({
			data : {
				columns : [ WeightAray,

				],
				type : 'bar',
				colors: {
					'Weight-PID': '#FFA500',
		        },
				groups : [ [ 'Weight-PID' ] ]
			},
			bindto : '#'+id_specific_topic,
			grid : {
				y : {
					lines : [ {
						value : 0
					} ]
				}
			},
			axis : {
				x : {
					label : {
						text : 'Pids',
						position : 'outer-middle',
					},
					type : 'category',
					categories : PidArray
				},
				tick : {
					x : {

						multiline : false,
						culling : {
							max : 1
						},
					},
					label : {
						text : 'PID',
						position : 'center-bottom',

					},
				},
				y : {
					label : {
						text : 'Nominal value (Million $)',
						position : 'outer-middle',
					},
					max : array[array.length]+0.2,
					min : 0,
					padding : {
						top : 0,
						bottom : 0
					}
				}
			}
		});

		var x = document.getElementById(id_specific_topic);
		if (x.style.display === "none") {
			x.style.display = "block";
		} else {
			x.style.display = "none";
		}

	}