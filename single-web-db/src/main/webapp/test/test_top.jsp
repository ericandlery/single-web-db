<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	*{margin: 0px;padding: 0px;}
	header{background-color: gray;}
	header div#title{background-color: pink;width: 100%;height: 30vh;}
	header div#title h1{background-color: aqua;text-align: center;}
	header div#title div#but{background-color: green;display: inline;}
	header div#title div#but span{background-color: fuchsia;}
	div#gap{width: 100%;height: 5vh;background-color: black;}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.6/angular.js"></script>
<script type="text/javascript">
	function expand(){
		var b=document.getElementById('b');
		var f=document.createDocumentFragment();
		var span=document.createElement('span');
		span.textContent='TESTSPAN';
		console.log(span);
		f.append(span);
		f.append(document.createElement('br'))
		
		for(var i=0;i<5;i++){
			span=document.createElement('span');
			span.textContent='TESTSPAN';
			f.append(span);
			f.append(document.createElement('br'))
		}
		
		console.log(f);
		console.log(b.parentNode);
		b.parentNode.append(f);
		b.setAttribute('onclick','shrink()');
		console.log(b);
	}
	
	function shrink(){
		alert();
	}
</script>
</head>
<body>
	<header>
		<div id="title">
			<h1>TOP</h1>
			<div id="but">
				<button id="b" onclick="expand()">TEST</button><br>
			</div>
		</div>
	</header>
	<div id="gap">
	</div>
</body>
</html>