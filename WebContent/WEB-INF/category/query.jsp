<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/public/head.jspf" %>
<script type="text/javascript">
	$(function() {
		$("#dg").datagrid({
			url: "category_queryJoinAccount.action",
			loadMsg: "loading...",
			queryParams: {type:''},
			fitColumns: true,
			striped: true,
			nowrap: true,
			singleSelect: true,
			pagination: true,
			pageSize: 5,
			pageList: [5, 10, 15, 20],
			idField: "id",
			rowStyler: function (index, row) {
				 console.info("index" + index + "," + row);  
				 /*if (index % 2 == 0) {
					 return "background-color:#fff;";
				 } else {
					 return "background-color:#ff0;";
				 }*/
			},
			toolbar: [{
				iconCls: "icon-add",
				text: "添加类别",
				handler: function () {
					parent.$("#win").window({
						title: "添加类别",
						width: 350,
						height: 150,
						content: "<iframe src='send_category_save.action' frameborder='0' width='100%' height='100%'/>"
					});
				}
			}, "-", {
				iconCls: "icon-edit",
				text: "更新类别",
				handler: function() {
					//判断是否有选中行记录，使用getSelections获取选中的所有行  
			        var rows = $("#dg").datagrid("getSelections");  
			        if(rows.length == 0) {  
			            //弹出提示信息  
			            $.messager.show({ //语法类似于java中的静态方法，直接对象调用  
			                title:'错误提示',  
			                msg:'至少要选择一条记录',  
			                timeout:2000,  
			                showType:'slide',  
			            });  
			        }else if(rows.length != 1) {  
			            //弹出提示信息  
			            $.messager.show({ //语法类似于java中的静态方法，直接对象调用  
			                title:'错误提示',  
			                msg:'每次只能更新一条记录',  
			                timeout:2000,  
			                showType:'slide',  
			            });  
			        } else{  
			            //1. 弹出更新的页面  
			            parent.$("#win").window({  
			                title:"添加类别",  
			                width:350,  
			                height:250,  
			                content:'<iframe src="send_category_update.action" frameborder="0" width="100%" height="100%"/>'  
			            });  
			            //2.   
			        }  
				}
			}, "-", {
				iconCls: "icon-remove",
				text: "删除类别",
				handler: function () {
					var rows = $("#dg").datagrid("getSelections");
					if (0 === rows.length) {
						$.messager.show({
							title: "错误提示",
							msg: "至少选择一条记录！",
							timeout: 2000,
							showType: "slide"
						});
					} else {
						$.messager.confirm("删除的确认对话框", "您确定要删除此项吗", function (r) {
							var ids = "";
							if (r) {
								for (var i = 0; i < rows.length; i += 1) {
									ids += rows[i].id + ","
								}
								ids = ids.substr(0, ids.lastIndexOf(","));
								$.post("category_deleteByIds.action", {ids: ids}, function (result) {
									if ("true" === result) {
										$("#dg").datagrid("uncheckAll");
										$("#dg").datagrid("reload");
									} else {
										$.messager.show({
											title: "删除异常",
											msg: "删除失败，请检查操作",
											timeout: 2000,
											showType: "slide"
										});
									}
								}, "text");
							}
						});
					}
				}
			}, "-", {
				text: "<input id='ss' name='search' />"
			}
			],
			frozenColumns: [[
				{field: "checkbox", checkbox: true},
				{field: "id", title: "编号", width: 200}
			]],
			columns: [
				[
					{
						field: "type",
						title: "类别名称",
						width: 100,
						formatter: function (value, row, index) {
							return "<span title=" + value + ">" + value + "</span>";
						}
					},
					{
						field: "hot",
						title: "热卖",
						width: 100,
						styler: function (value, row, index) {
							if (value) {
								return "<input type='checkbox' checked='checked' disabled='true'/>";
							} else {
								return "<input type='checkbox' disabled='true'/>"
							}
						}
					},
					{
						field: "account.login",
						title: "所属管理员",
						width: 200,
						formatter: function (value, row, index) {
							if (row.account != null && row.account.login != null) {
								return row.account.login;
							} else {
								return "此类别没有管理员";
							}
						}
					}
				]
			]
		});
		$("#ss").searchbox({
			searcher: function (value, name) {
				$("#dg").datagrid('load', {
					type: value
				});
			},
			prompt: "请输入搜索关键字："
		});
	});
</script>
</head>
<body>
<table id="dg"></table>
</body>
</html>