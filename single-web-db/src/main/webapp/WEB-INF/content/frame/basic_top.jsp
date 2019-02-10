<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to the Single Web DataBase</title>
<style type="text/css">
	*{margin: 0px;padding: 0px;}
	header{background-color: gray;width: 100%;height: 15vh;}
	header h1#title{font-family: fantasy;text-align: center;}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.6/angular.js"></script>
<script type="text/javascript">
	var ap=angular.module('ap',[]);
	ap.controller('header',function($scope){
		
	});
</script>
</head>
<body ng-app="ap">
	<header ng-controller="header">
		<h1 id="title">Single Web Database</h1>
	</header>