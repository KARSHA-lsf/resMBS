
    var width = 1000,
        height = 900,
        padding = 1.5, // separation between same-color nodes
        clusterPadding = 6, // separation between different-color nodes
        maxRadius = 12;

    var color = d3.scale.ordinal()
        .range(["#7A99AC", "#E4002B"]);



    d3.json("rest/topic/bubble/", function(error, data_a) {
        if (error) throw error;
        //var colNames = "text,size,group\n" + text;
        //var data = d3.csv.parse(colNames);
        var data =data_a;
        console.log("test",data[0]);
        data.forEach(function(d) {
            d.size = +d.size;
        });

        color = d3.scale.linear().domain([0,29])
            .interpolate(d3.interpolateHcl)
            .range([d3.rgb("#007AFF"), d3.rgb('#FFF500')]);

//unique cluster/group id's
        var cs = [];
        data.forEach(function(d){
            console.log("d==>",d);
            if(!cs.contains(d[2])) {
                cs.push(d[2]);
            }
        });

        var n = data.length, // total number of nodes
            m = cs.length; // number of distinct clusters

        // add max size and minimum for the bubbles
        var maxIndex=0;
        var minIndex=0;
        for (var j = 0; j < data.length; j++){
            if(data[j][1]>data[maxIndex][1]){
                maxIndex=j;
            }
            if(data[j][1]<data[minIndex][1]){
                minIndex=j;
            }
        }
        var radiusScal=d3.scale.linear()
            .domain([data[minIndex][1],data[maxIndex][1]])
            .range([10,80]);
        //---------------------------------
//create clusters and nodes
        var clusters = new Array(m);
        var nodes = [];
      //  console.log("final",data[0]);
        for (var i = 0; i<n; i++){
            nodes.push(create_nodes(data,i));
        }

        var force = d3.layout.force()
            .nodes(nodes)
            .size([width, height])
            .gravity(.03)
            .charge(0)
            .on("tick", tick)
            .start();

        var svg = d3.select("#bubble_area").append("svg")
            .attr("width", width)
            .attr("height", height);


        var node = svg.selectAll("circle")
            .data(nodes)
            .enter().append("g").call(force.drag);
        var div = d3.select("body").append("div")
            .attr("class", "tooltip")
            .style("opacity", 0);

        node.on("mouseover",function (d) {
            console.log("mouseover",d)
            div.transition()
                .duration(200)
                .style("opacity", .9);
            div	.html(d.text + "<br/>")
                .style("left", (d3.event.pageX) + "px")
                .style("top", (d3.event.pageY - 28) + "px");
        })
            .on("mouseout",function () {
                div.transition()
                    .duration(500)
                    .style("opacity", 0);
            });

        var tooltip =svg.append("g")
            .attr("class",tooltip)
            .style("display","none");
        tooltip.append("text")
            .attr("x",15)
            .attr("dy","1.2em")
            .style("font_size","1.25em")
            .attr("font-weight","bold");

        node.append("circle")
            .style("fill", function (d) {
                  console.log(d);
                var group =d.cluster;
                console.log('group :=',d.cluster);
                return color(d.cluster);



            })
            .attr("r", function(d){return d.radius});

///---------------------------------------------------------------------
        node.append("text")
            .attr("dy", ".3em")
            .style("text-anchor", "middle")
            .text(function(d) {
                console.log("text_abc",d.text.substring(0,5)); 
                return d.text.substring(0,5); 
                });




        function create_nodes(data,node_counter) {
            // console.log('R :',data[node_counter].size*150);
            //
            var i = cs.indexOf(data[node_counter][2]),
                r = Math.sqrt((i + 1) / m * -Math.log(Math.random())) * maxRadius,
                d = {
                    cluster: i,
                    radius:radiusScal(data[node_counter][1]),
                    text: data[node_counter][0],
                    x: Math.cos(i /m*2*Math.PI) * 200 + width / 2 + Math.random(),
                    y: Math.sin(i /m*2*Math.PI) * 200 + height / 2 + Math.random()
                };
            if (!clusters[i] || (r > clusters[i].radius)) clusters[i] = d;
            return d;
        };

        function tick(e) {
            node.each(cluster(10 * e.alpha * e.alpha))
                .each(collide(.5))
                .attr("transform", function (d) {
                    var k = "translate(" + d.x + "," + d.y + ")";
                    return k;
                })
        }

// Move d to be adjacent to the cluster node.
        function cluster(alpha) {
            return function (d) {
                var cluster = clusters[d.cluster];
                if (cluster === d) return;
                var x = d.x - cluster.x,
                    y = d.y - cluster.y,
                    l = Math.sqrt(x * x + y * y),
                    r = d.radius + cluster.radius;
                if (l != r) {
                    l = (l - r) / l * alpha;
                    d.x -= x *= l;
                    d.y -= y *= l;
                    cluster.x += x;
                    cluster.y += y;
                }
            };
        }

// Resolves collisions between d and all other circles.
        function collide(alpha) {
            var quadtree = d3.geom.quadtree(nodes);
            return function (d) {
                var r = d.radius + maxRadius + Math.max(padding, clusterPadding),
                    nx1 = d.x - r,
                    nx2 = d.x + r,
                    ny1 = d.y - r,
                    ny2 = d.y + r;
                quadtree.visit(function (quad, x1, y1, x2, y2) {
                    if (quad.point && (quad.point !== d)) {
                        var x = d.x - quad.point.x,
                            y = d.y - quad.point.y,
                            l = Math.sqrt(x * x + y * y),
                            r = d.radius + quad.point.radius + (d.cluster === quad.point.cluster ? padding : clusterPadding);
                        if (l < r) {
                            l = (l - r) / l * alpha;
                            d.x -= x *= l;
                            d.y -= y *= l;
                            quad.point.x += x;
                            quad.point.y += y;
                        }
                    }
                    return x1 > nx2 || x2 < nx1 || y1 > ny2 || y2 < ny1;
                });
            };
        }
    });

    Array.prototype.contains = function(v) {
        for(var i = 0; i < this.length; i++) {
            if(this[i] === v) return true;
        }
        return false;
    };

