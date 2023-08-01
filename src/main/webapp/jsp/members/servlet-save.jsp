<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%--
  Created by IntelliJ IDEA.
  User: hongdae
  Date: 2023/07/25
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>

<%
    final MemberRepository memberRepository = MemberRepository.getInstance();
    final String username = request.getParameter("username");
    final int age = Integer.parseInt(request.getParameter("age"));

    final Member member = new Member(username, age);
    memberRepository.save(member);
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>
        id=<%=member.getId()%>
    </li>
    <li>
        id=<%=member.getUsername()%>
    </li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
