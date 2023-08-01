<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %><%--
  Created by IntelliJ IDEA.
  User: hong
  Date: 2021-12-15
  Time: 오후 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    MemberRepository memberRepository = MemberRepository.getInstance();
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(username, age);
    memberRepository.save(member);
%>
<html>
<head>
    <title>Save Success</title>
</head>
<body>
<h1>성공!</h1>
<ul>
    <li>
        id=<%=member.getId()%>
    </li>
    <li>
        username=<%=member.getUsername()%>
    </li>
    <li>
        age=<%=member.getAge()%>
    </li>
</ul>
</body>
</html>
