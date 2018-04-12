<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: SillySnnall
  Date: 2018/4/6
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <title>upload_test</title>
</head>

<body>
<s:form action="update" method="post" theme="simple" enctype="multipart/form-data">
    输入帐号：<s:textfield name="uid"/><br>
    选择头像：<s:file name="headImage"/><br>
    <s:submit value="提交"/>
    　　　　
    　　　　　<s:fielderror/>
</s:form>
</body>
</html>
