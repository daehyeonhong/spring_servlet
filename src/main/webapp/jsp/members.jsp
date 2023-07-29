<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: hongdae
  Date: 2023/07/25
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    final MemberRepository memberRepository = MemberRepository.getInstance();
    final List<Member> members = memberRepository.findAll();
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/index.html">메인</a>
<h1>회원 목록</h1>
<table>
    <thead>
    <th>id</th>
    <th>username</th>
    <th>age</th>
    </thead>
    <tbody>
    <% for (Member member : members) { %>
    <tr>
        <td>
            <%= member.getId() %>
        </td>
        <td>
            <%= member.getUsername() %>
        </td>
        <td>
            <%= member.getAge() %>
        </td>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>
