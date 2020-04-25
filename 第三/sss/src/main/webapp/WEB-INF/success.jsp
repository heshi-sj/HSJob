<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
       String path = request.getContextPath();
       String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
       <base href="<%=basePath%>">

       <title>success</title>


       <script type="text/javascript">


              function edit(){
                     var aaa = document.getElementById("form1");
                  var username =aaa.getElementsByTagName("username");
                  var id =aaa.getElementsByTagName("id");
                  var adress =aaa.getElementsByTagName("adress");
                  var phone =aaa.getElementsByTagName("phone");

                     aaa.action="<%=basePath%>/resume/edit.action";
                     aaa.submit();

                  // 发送ajax请求
                  // $.ajax({
                  //     url: '/demo/userlogin01',
                  //     type: 'POST',
                  //     data: {},
                  //     contentType: 'application/json;charset=utf-8',
                  //     dataType: 'json',
                  //     success: function (data) {
                  //         alert(data.name);
                  //     }
                  // })
              }
              function del(){
                     var aaa = document.getElementById("form1");

                  var id =aaa.getElementsByTagName("id");

                     aaa.action="<%=basePath%>/resume/delete.action";
                     aaa.submit();
              }
              function add(){
                     var aaa = document.getElementById("form1");
                  var username =aaa.getElementsByTagName("username");
                  var id =aaa.getElementsByTagName("id");
                  var adress =aaa.getElementsByTagName("adress");
                  var phone =aaa.getElementsByTagName("phone");
                     aaa.action="<%=basePath%>/resume/add.action";
                     aaa.submit();
              }
       </script>
</head>

<body>
<div>
       <input type="button" id="add" value="编辑" onclick="add()"/>


</div>
<form id="form1" action='<c:url value='/AccountController/edit.action'/>' style="margin:20px;" method="post">
       <input type="text" name="id" value="${resume.id }"/>
     <input type="text" name="username" value="${resume.name }"/>
     <input type="text" name="address" value="${resume.address }"/>
       <input type="text" name="phone" value="${resume.cardNo }"/>


       id：<input type="text" name="id" value="${resume.id }"/><br/>
       name：<input type="text" name="name" value="${resume.name }"/><br/>
       address：<input type="text" name="address" value="${resume.address }"/>元<br/>
       phone：<input type="text" name="phone" value="${resume.cardNo }"/><br/>

       <c:forEach items="${categoryList }" var="c">
              <option value="${c.cid }" <c:if test="${c.cid eq book.category.cid }">selected="selected"</c:if>>${c.cname }</option>
       </c:forEach>
</select><br/>
       <input type="button" value="编辑" onclick="edit()"/>
       <input type="button" value="删除" onclick="del()"/>
</form>
</body>
</html>
