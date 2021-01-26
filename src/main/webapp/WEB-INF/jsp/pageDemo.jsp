<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
<div align="center">
 
</div>
 
<div style="width:500px;margin:20px auto;text-align: center">
    <table align='center' border='1' cellspacing='0'>
        <tr>
            <td>id</td>
            <td>userName</td>
            <td>编辑</td>
            <td>删除</td>
        </tr>
        <c:forEach items="${page.list}" var="c" varStatus="st">
            <tr>
                <td>${c.id}</td>
                <td>${c.userName}</td>
                <td><a href="">编辑</a></td>
                <td><a href="">删除</a></td>
            </tr>
        </c:forEach>
         
    </table>
    <br>
    <div>
                <a href="?start=1">[首  页]</a>
            <a href="?start=${page.pageNum-1}">[上一页]</a>
            <a href="?start=${page.pageNum+1}">[下一页]</a>
            <a href="?start=${page.pages}">[末  页]</a>
    </div>
    <br>
</div>