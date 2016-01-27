<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${contextPath}/resources/js/code.js"></script>
<link href="${contextPath}/resources/css/cy.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-slider/4.10.3/css/bootstrap-slider.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    <link href="http://cdnjs.cloudflare.com/ajax/libs/qtip2/2.2.0/jquery.qtip.min.css" rel="stylesheet" type="text/css" />
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/fastclick/1.0.6/fastclick.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/lodash.js/3.10.0/lodash.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-slider/4.10.3/bootstrap-slider.min.js"></script>
    <script src="http://marvl.infotech.monash.edu/webcola/cola.v3.min.js"></script>
    <script src="http://cytoscape.github.io/cytoscape.js/api/cytoscape.js-latest/cytoscape.min.js"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/qtip2/2.2.0/jquery.qtip.min.js"></script>
    <script src="https://cdn.rawgit.com/cytoscape/cytoscape.js-qtip/2.2.5/cytoscape-qtip.js"></script>
    <script src="https://cdn.rawgit.com/cytoscape/cytoscape.js-cola/1.1.1/cytoscape-cola.js"></script>
    <script type="text/javascript">
    var cy;

    $(function(){ // on dom ready
	//alert('${statusJson}')
    var statusJson = '${statusJson}';
     /*  cy = cytoscape({
        container: document.getElementById('cy'),
        
        style: [{"selector":"core","style":{"selection-box-color":"#AAD8FF","selection-box-border-color":"#8BB0D0","selection-box-opacity":"0.5"}},{"selector":"node","style":{"width":"mapData(score, 0, 0.006769776522008331, 20, 60)","height":"mapData(score, 0, 0.006769776522008331, 20, 60)","content":"data(name)","font-size":"12px","text-valign":"center","text-halign":"center","background-color":"#555","text-outline-color":"#555","text-outline-width":"2px","color":"#fff","overlay-padding":"6px","z-index":"10"}},{"selector":"node[?attr]","style":{"shape":"rectangle","background-color":"#aaa","text-outline-color":"#aaa","width":"16px","height":"16px","font-size":"6px","z-index":"1"}},{"selector":"node[?query]","style":{"background-clip":"none","background-fit":"contain"}},{"selector":"node:selected","style":{"border-width":"6px","border-color":"#AAD8FF","border-opacity":"0.5","background-color":"#77828C","text-outline-color":"#77828C"}},{"selector":"edge","style":{"curve-style":"haystack","haystack-radius":"0.5","opacity":"0.4","line-color":"#bbb","width":"mapData(weight, 0, 1, 1, 8)","overlay-padding":"3px"}},{"selector":"node.unhighlighted","style":{"opacity":"0.2"}},{"selector":"edge.unhighlighted","style":{"opacity":"0.05"}},{"selector":".highlighted","style":{"z-index":"999999"}},{"selector":"node.highlighted","style":{"border-width":"6px","border-color":"#AAD8FF","border-opacity":"0.5","background-color":"#394855","text-outline-color":"#394855","shadow-blur":"12px","shadow-color":"#000","shadow-opacity":"0.8","shadow-offset-x":"0px","shadow-offset-y":"4px"}},{"selector":"edge.filtered","style":{"opacity":"0"}},{"selector":"edge[group=\"coexp\"]","style":{"line-color":"#d0b7d5"}},{"selector":"edge[group=\"coloc\"]","style":{"line-color":"#a0b3dc"}},{"selector":"edge[group=\"gi\"]","style":{"line-color":"#90e190"}},{"selector":"edge[group=\"path\"]","style":{"line-color":"#9bd8de"}},{"selector":"edge[group=\"pi\"]","style":{"line-color":"#eaa2a2"}},{"selector":"edge[group=\"predict\"]","style":{"line-color":"#f6c384"}},{"selector":"edge[group=\"spd\"]","style":{"line-color":"#dad4a2"}},{"selector":"edge[group=\"spd_attr\"]","style":{"line-color":"#D0D0D0"}},{"selector":"edge[group=\"reg\"]","style":{"line-color":"#D0D0D0"}},{"selector":"edge[group=\"reg_attr\"]","style":{"line-color":"#D0D0D0"}},{"selector":"edge[group=\"user\"]","style":{"line-color":"#f0ec86"}}],
        
        elements: {"edges":[{"data":{"id":"edge-1","source":"node-1","target":"node-0"}},{"data":{"id":"edge-2","source":"node-2","target":"node-1"}},{"data":{"id":"edge-3","source":"node-3","target":"node-1"}},{"data":{"id":"edge-4","source":"node-4","target":"node-1"}},{"data":{"id":"edge-5","source":"node-5","target":"node-0"}},{"data":{"id":"edge-6","source":"node-6","target":"node-5"}},{"data":{"id":"edge-7","source":"node-7","target":"node-5"}},{"data":{"id":"edge-8","source":"node-8","target":"node-5"}},{"data":{"id":"edge-9","source":"node-9","target":"node-0"}},{"data":{"id":"edge-10","source":"node-10","target":"node-9"}},{"data":{"id":"edge-11","source":"node-11","target":"node-9"}},{"data":{"id":"edge-12","source":"node-12","target":"node-9"}}],"nodes":[{"data":{"id":"node-0","name":"topic_posts","score":50.0}},{"data":{"id":"node-1","name":"shard1", "score":0.005}},{"data":{"id":"node-2","name":"172.16.15.170:9002_solr"}},{"data":{"id":"node-3","name":"172.16.15.170:9000_solr"}},{"data":{"id":"node-4","name":"172.16.15.170:9001_solr"}},{"data":{"id":"node-5","name":"shard2", "score":0.005}},{"data":{"id":"node-6","name":"172.16.15.170:9002_solr"}},{"data":{"id":"node-7","name":"172.16.15.170:9001_solr"}},{"data":{"id":"node-8","name":"172.16.15.170:9000_solr"}},{"data":{"id":"node-9","name":"shard3", "score":0.005}},{"data":{"id":"node-10","name":"172.16.15.170:9002_solr"}},{"data":{"id":"node-11","name":"172.16.15.170:9000_solr"}},{"data":{"id":"node-12","name":"172.16.15.170:9001_solr"}}]}
        //elements: statusJson
      }); */
		
    var cybody = {
            container: document.getElementById('cy'),
            
            style: [{"selector":"core","style":{"selection-box-color":"#AAD8FF","selection-box-border-color":"#8BB0D0","selection-box-opacity":"0.5"}},{"selector":"node","style":{"width":"mapData(score, 0, 0.006769776522008331, 20, 60)","height":"mapData(score, 0, 0.006769776522008331, 20, 60)","content":"data(name)","font-size":"12px","text-valign":"center","text-halign":"center","background-color":"#555","text-outline-color":"#555","text-outline-width":"2px","color":"#fff","overlay-padding":"6px","z-index":"10"}},{"selector":"node[?attr]","style":{"shape":"rectangle","background-color":"#aaa","text-outline-color":"#aaa","width":"16px","height":"16px","font-size":"6px","z-index":"1"}},{"selector":"node[?query]","style":{"background-clip":"none","background-fit":"contain"}},{"selector":"node:selected","style":{"border-width":"6px","border-color":"#AAD8FF","border-opacity":"0.5","background-color":"#77828C","text-outline-color":"#77828C"}},{"selector":"edge","style":{"curve-style":"haystack","haystack-radius":"0.5","opacity":"0.4","line-color":"#bbb","width":"mapData(weight, 0, 1, 1, 8)","overlay-padding":"3px"}},{"selector":"node.unhighlighted","style":{"opacity":"0.2"}},{"selector":"edge.unhighlighted","style":{"opacity":"0.05"}},{"selector":".highlighted","style":{"z-index":"999999"}},{"selector":"node.highlighted","style":{"border-width":"6px","border-color":"#AAD8FF","border-opacity":"0.5","background-color":"#394855","text-outline-color":"#394855","shadow-blur":"12px","shadow-color":"#000","shadow-opacity":"0.8","shadow-offset-x":"0px","shadow-offset-y":"4px"}},{"selector":"edge.filtered","style":{"opacity":"0"}},{"selector":"edge[group=\"coexp\"]","style":{"line-color":"#d0b7d5"}},{"selector":"edge[group=\"coloc\"]","style":{"line-color":"#a0b3dc"}},{"selector":"edge[group=\"gi\"]","style":{"line-color":"#90e190"}},{"selector":"edge[group=\"path\"]","style":{"line-color":"#9bd8de"}},{"selector":"edge[group=\"pi\"]","style":{"line-color":"#eaa2a2"}},{"selector":"edge[group=\"predict\"]","style":{"line-color":"#f6c384"}},{"selector":"edge[group=\"spd\"]","style":{"line-color":"#dad4a2"}},{"selector":"edge[group=\"spd_attr\"]","style":{"line-color":"#D0D0D0"}},{"selector":"edge[group=\"reg\"]","style":{"line-color":"#D0D0D0"}},{"selector":"edge[group=\"reg_attr\"]","style":{"line-color":"#D0D0D0"}},{"selector":"edge[group=\"user\"]","style":{"line-color":"#f0ec86"}}],
            elements: {"edges":[{"data":{"id":"edge-1","source":"node-1","target":"node-0"}},{"data":{"id":"edge-2","source":"node-2","target":"node-1"}},{"data":{"id":"edge-3","source":"node-3","target":"node-1"}},{"data":{"id":"edge-4","source":"node-4","target":"node-1"}},{"data":{"id":"edge-5","source":"node-5","target":"node-0"}},{"data":{"id":"edge-6","source":"node-6","target":"node-5"}},{"data":{"id":"edge-7","source":"node-7","target":"node-5"}},{"data":{"id":"edge-8","source":"node-8","target":"node-5"}},{"data":{"id":"edge-9","source":"node-9","target":"node-0"}},{"data":{"id":"edge-10","source":"node-10","target":"node-9"}},{"data":{"id":"edge-11","source":"node-11","target":"node-9"}},{"data":{"id":"edge-12","source":"node-12","target":"node-9"}}],"nodes":[{"data":{"id":"node-0","name":"topic_posts","score":50.0}},{"data":{"id":"node-1","name":"shard1", "score":0.005}},{"data":{"id":"node-2","name":"172.16.15.170:9002_solr"}},{"data":{"id":"node-3","name":"172.16.15.170:9000_solr"}},{"data":{"id":"node-4","name":"172.16.15.170:9001_solr"}},{"data":{"id":"node-5","name":"shard2", "score":0.005}},{"data":{"id":"node-6","name":"172.16.15.170:9002_solr"}},{"data":{"id":"node-7","name":"172.16.15.170:9001_solr"}},{"data":{"id":"node-8","name":"172.16.15.170:9000_solr"}},{"data":{"id":"node-9","name":"shard3", "score":0.005}},{"data":{"id":"node-10","name":"172.16.15.170:9002_solr"}},{"data":{"id":"node-11","name":"172.16.15.170:9000_solr"}},{"data":{"id":"node-12","name":"172.16.15.170:9001_solr"}}]}
            
          };
      
    //cybody['elements'] = JSON.parse(statusJson);
    cy = cytoscape(cybody);
      var params = {
        name: 'cola',
        nodeSpacing: 5,
        edgeLengthVal: 45,
        animate: true,
        randomize: false,
        maxSimulationTime: 1500
      };
      var layout = makeLayout();
      var running = false;

      cy.on('layoutstart', function(){
        running = true;
      }).on('layoutstop', function(){
        running = false;
      });
      
      layout.run();

      var $config = $('#config');
      var $btnParam = $('<div class="param"></div>');
      $config.append( $btnParam );

      var sliders = [
        {
          label: 'Edge length',
          param: 'edgeLengthVal',
          min: 1,
          max: 200
        },

        {
          label: 'Node spacing',
          param: 'nodeSpacing',
          min: 1,
          max: 50
        }
      ];

      var buttons = [
        {
          label: '<i class="fa fa-random"></i>',
          layoutOpts: {
            randomize: true,
            flow: null
          }
        },

        {
          label: '<i class="fa fa-long-arrow-down"></i>',
          layoutOpts: {
            flow: { axis: 'y', minSeparation: 30 }
          }
        }
      ];

      sliders.forEach( makeSlider );

      buttons.forEach( makeButton );

      function makeLayout( opts ){
        params.randomize = false;
        params.edgeLength = function(e){ return params.edgeLengthVal / e.data('weight'); };

        for( var i in opts ){
          params[i] = opts[i];
        }

        return cy.makeLayout( params );
      }

      function makeSlider( opts ){
        var $input = $('<input></input>');
        var $param = $('<div class="param"></div>');

        $param.append('<span class="label label-default">'+ opts.label +'</span>');
        $param.append( $input );

        $config.append( $param );

        var p = $input.slider({
          min: opts.min,
          max: opts.max,
          value: params[ opts.param ]
        }).on('slide', _.throttle( function(){
          params[ opts.param ] = p.getValue();

          layout.stop();
          layout = makeLayout();
          layout.run();
        }, 16 ) ).data('slider');
      }

      function makeButton( opts ){
        var $button = $('<button class="btn btn-default">'+ opts.label +'</button>');
        
        $btnParam.append( $button );

        $button.on('click', function(){
          layout.stop();

          if( opts.fn ){ opts.fn(); }

          layout = makeLayout( opts.layoutOpts );
          layout.run();
        });
      }

      cy.nodes().forEach(function(n){
        var g = n.data('name');

        n.qtip({
          content: [
            {
              name: 'GeneCard',
              url: 'http://www.genecards.org/cgi-bin/carddisp.pl?gene=' + g
            },
            {
              name: 'UniProt search',
              url: 'http://www.uniprot.org/uniprot/?query='+ g +'&fil=organism%3A%22Homo+sapiens+%28Human%29+%5B9606%5D%22&sort=score'
            },
            {
              name: 'GeneMANIA',
              url: 'http://genemania.org/search/human/' + g
            }
          ].map(function( link ){
            return '<a target="_blank" href="' + link.url + '">' + link.name + '</a>';
          }).join('<br />\n'),
          position: {
            my: 'top center',
            at: 'bottom center'
          },
          style: {
            classes: 'qtip-bootstrap',
            tip: {
              width: 16,
              height: 8
            }
          }
        });
      });

      $('#config-toggle').on('click', function(){
        $('body').toggleClass('config-closed');

        cy.resize();
      });

    }); // on dom ready

    $(function() {
      FastClick.attach( document.body );
    });

    </script>
<title>Forum main page</title>

</head>
<body>

	<div class="layout_type2_1_wrap">
		<div class="header">
		<jsp:include page="common/header.jsp"></jsp:include>
		</div>
		<div id="container" class="container">
		
		 
			<jsp:include page="intro.jsp"></jsp:include>
		</div>		
	</div>

</body>
</html>