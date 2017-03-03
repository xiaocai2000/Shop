<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/public/head.jspf" %>
	<style type="text/css">  
        #menu {  
            width:200px;  
            /*border:1px solid red;*/  
        }  
        #menu ul {  
            list-style: none;  
            padding: 0px;  
            margin: 0px;  
        }  
        #menu ul li {  
            border-bottom: 1px solid #fff;  
              
        }  
        #menu ul li a {  
            /*先将a标签转换为块级元素，才能设置宽和内间距*/  
            display: block;  
            background-color: #00a6ac;  
            color: #fff;  
            padding: 5px;  
            text-decoration: none;  
        }  
        #menu ul li a:hover {  
            background-color: #008792;  
        }  
          
    </style>
    <script type="text/javascript">
    	$(function() {
    		$("a[title]").click(function() {
    			var text = $(this).text();
    			var href = $(this).attr("title");
    			
    			if ($("#tt").tabs("exists", text)) {
    				$("#tt").tabs("select", text);
    			} else {
    				$("#tt").tabs("add", {
    					title: text,
    					closable: true,
    					content: '<iframe title=' + text + ' src="' + href +
    						"\" frameborder='0' width='100%' height='100%'/>"
    				});
    			}
    		});
    	});
    </script>
</head>

<!-- frameset border="5" rows="150,*">
	<frame src="send_main_top.action"/>
	
	<frameset border="5" cols="150,*">
		<frame src="send_main_left.action"/>
		<frame src="send_main_right.action"/>
	</frameset>
</frameset> -->

<body class="easyui-layout">
	<div data-options="region:'north',title:'欢迎来到后台管理',split:true" style="height:100px;"></div>
	<div data-options="region:'west',title:'系统操作',split:true" style="width:200px;">
		<!-- 此处显示的是系统菜单 -->
		<div id="menu" class="easyui-accordion" data-options="fit:true">
			<div title="基本操作" data-options="iconCls:'icon-save'">
				<ul>
					<li><a href="#" title="send_category_query.action">类别管理</a>
					<li><a href="#">商品管理</a>
				</ul>
			</div>
			<div title="其他操作" data-options="iconCls:'icon-reload'">
				<ul>
					<li><a href="#">类别管理</a>
					<li><a href="#">商品管理</a>
				</ul>
			</div>
		</div>
		<!-- div id="aa" class="easyui-accordion" style="width:300px;height:200px;">
			<div title="Title1" data-option="iconCls:'icon-save'" style="overflow:auto;padding:10px;">
				<h3 style="color:#0099FF;">Accordion for jQuery</h3>     
                    <p>Accordion is a part of easyui framework for jQuery.       
                    It lets you define your accordion component on web page more easily.</p> 
			</div>
            <div title="Title2" data-options="iconCls:'icon-reload',selected:true" style="padding:10px;">content2</div>     
            <div title="Title3">content3</div> 
		</div> -->
	</div>	
	<div data-options="region:'center',title:'后台操作页面'" style="padding:1px;background:#eee;">
		<div id="tt" class="easyui-tabs" data-options="fit:true">
			<div title="系统缺省页面" style="padding:10px;">
				
			</div>
		</div>
	</div>     
</body>

</html>