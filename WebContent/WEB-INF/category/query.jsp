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
			queryParams: {type:'gaga'},
			fitColumns: true,
			striped: true,
			nowrap: true,
			singleSelect: true,
			pagination: true,
			rowStyler: function (index, row) {
				 console.info("index" + index + "," + row);  
				 /*if (index % 2 == 0) {
					 return "background-color:#fff;";
				 } else {
					 return "background-color:#ff0;";
				 }*/
			},
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
	});
</script>
</head>
<body>
<table id="dg"></table>
</body>
</html>