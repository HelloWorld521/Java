<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<style type="text/css">
	#mydiv{
		position:absolute;
		left:50%;
		top:50%;
		margin-left:-200px; 
		margin-top:-50px;
	}
	.mouseOver{
		background:#708090;
		color:#fffafa;
	}
	.mouseOut{
		background:#fffafa;
		color:#000000;
	}
</style>
<script>
  	//获得用户输入内容相关联信息的函数
  	var xmlHttp;
  	function getMoreContents(){
  		//获取用户输入
  		var content = document.getElementById("keyword");
  		if(content.value == ""){
  			clearContent(); //清除
  			return;
  		}
  		//然后要给服务器发送用户输入内容，采用ajax异步发送请求数据
  		//核心【xmlHttp】对象
  		xmlHttp = newAjax();
  		//与服务器交互
		var url = "search?keyword="+escape(content.value);
		//三参
		//true表示javascript脚本会在send()方法执行后继续执行，而不会等待来自服务器的相应
		xmlHttp.open("GET",url,true);
		//xmlHttp绑定回调方法，这个回调方法会在xmlHttp状态被改变的时候被调用
		//xmlHttp的状态0-4，4表示完成(complete)。
		//状态改变之后(即数据传输完成)，调用回调方法
		xmlHttp.onreadystatechange = callback;
		xmlHttp.send(null);
		   		
  	}
  	
  	//获取 xmlHttp 对象,兼容多种浏览器
  	function createXMLHttp(){
  		var xmlHttp;
  		//大多数浏览器使用
  		if(window.XMLHttpRequest){
  			xmlHttp = new XMLHttpRequest();
  		}
  		//考虑浏览器兼容性
  		if(window.ActiveXObject){
  			//ie5,ie6
  			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
  			if(!xmlHttp){
  			//针对ie7以前
  				xmlHttp = new ActiveXObject("MSXML2.XMLHTTP.3.0");
  			}
  		}
  		return xmlHttp;
  	}
  	//通用获取xmlhttp方法
  	function newAjax() {
    	try { return new XMLHttpRequest();                    } catch(e){}
    	try { return new ActiveXObject('Msxml2.XMLHTTP.6.0'); } catch(e){}
    	try { return new ActiveXObject('Msxml2.XMLHTTP.3.0'); } catch(e){}
    	try { return new ActiveXObject('Msxml2.XMLHTTP');     } catch(e){}
    	try { return new ActiveXObject('Microsoft.XMLHTTP');  } catch(e){}
    	return false;
	}
	
//回调函数
	function callback(){
		//4表示完成
		if(xmlHttp.readyState==4){
		//200服务器响应成功
		//404代表资源未找到，500代表服务器内部错误
			if(xmlHttp.status==200){
			//交互成功，获得响应数据
				var result = xmlHttp.responseText;
				//解析获得数据 eval解析json
				var json=eval("("+result+")");
				//获得数据之后，动态显示这些数据了，把这些数据展示到输入框下
				setContent(json);
			}
		}
	}
//设置关联数据的展示，参数为服务器传过来的数据
	function setContent(contents){
		//清除tr
		clearContent();
		//设置位置
		setLocation();
	//获取关联数据的长度，确定生成<tr>
		var size = contents.length;
	//设置内容
		for(var i=0;i<size;i++){
			var nextNode = contents[i];//json数据第i个元素
			var tr = document.createElement("tr");
			var td = document.createElement("td");
			td.setAttribute("border",0);
			td.setAttribute("bgcolor","#fffafa");
			td.setAttribute("size","50");
			td.onmouseover=function(){
				this.className='mouseOver';
			};
			td.onmouseout=function(){
				this.className='mouseOut';
			};
			//将关联内容显示在输入框中。而onmousedown执行顺序在input的onblur之前
			//注意
			//此处必须使用onmousedown 不能使用onclick
			//onclick = onmousedown + onmouseup
			//onclick点击之后input就会失去焦点，执行清除函数，清空关联内容，导致无法
			td.onmousedown=function(){
				//鼠标点击关联数据，在输入框中显示
//				alert("onmousedown");
				document.getElementById("keyword").value = this.innerHTML;
			};
			
			var text = document.createTextNode(nextNode);
			td.appendChild(text);
			tr.appendChild(td);
			document.getElementById("content_table_body").appendChild(tr);
		}
	}	
	function clearContent(){
		var contentTableBody = document.getElementById("content_table_body");
		//获取tr长度
		var size = contentTableBody.childNodes.length;
		//从后向前清除tr
		for(var i=size-1; i>=0; i--){
			contentTableBody.removeChild(contentTableBody.childNodes[i]);		
		}
		document.getElementById("popDiv").style.border = "";
	}
	
	//失去焦点，清除关联数据
	function keywordBlur(){
		clearContent();
	}
	
	//获得焦点，获取关联数据
	function keywordFocus(){
		getMoreContents();
	}
	
	//设置关联内容的位置
	function setLocation(){
		//关联位置显示位置与输入框一直
		var content = document.getElementById("keyword");
		var width = content.offsetWidth-2;  //input width
		var left = content["offsetLeft"]; //距左边框的距离
		var top = content["offsetTop"]+content.height; //到顶部的距离
		//获得显示数据的div
		var popDiv = document.getElementById("popDiv");
		popDiv.style.border = "black 1px solid";
		popDiv.style.left = left + "px";
		popDiv.style.top = top + "px";
		popDiv.style.width = width + "px";
		document.getElementById("content_table").width = width + "px";	
		
	} 
  </script>
  
  </head>
  
  <body>
    <div id="mydiv">
    	<!-- 输入框 -->
    	<input type="text" size="50" id="keyword" onkeyup="getMoreContents()" 
    		onblur="keywordBlur()" onfocus="keywordFocus()">
    	<input type="button" value="百度一下" width="50px" >     	
    	<!-- 下面为内容展示区域 -->
    	<div id="popDiv">
    		<table id="content_table" bgcolor="#fffafa" border="0" cellspacing="0"
    		cellpadding="0" >
    			<tbody id="content_table_body">
    			<!-- 动态查询出来的数据显示的地方 -->
    			</tbody>
    		</table>
    	</div>
    </div>
  </body>
</html>
