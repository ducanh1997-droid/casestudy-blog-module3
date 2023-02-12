<%--
  Created by IntelliJ IDEA.
  User: linh
  Date: 2/12/2023
  Time: 10:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>ACCOUNT PROFILE</title>
</head>
<body>
<div>
  <button id="accountDetail" onclick="showAccountDetail()">Account information</button>
  <button id="Blog" onclick="showMyBlog()" >My posted blog </button>
  <button id="myComment">My Comment</button>
    <button id="security" onclick="showSecurity()">Password and security</button>
</div>
<div id="accountInformation" style="display:
<c:choose>
<c:when test="${requestScope.accountDisplay=='block'}">
     block">
</c:when>
<c:otherwise>
    none">
</c:otherwise>
</c:choose>
    <form>
    <table>
        <tr>
            <td>Username:</td>
            <td><p id="displayUsername">${requestScope.account.userName}</p><input id="username" style=" display:none" value="${requestScope.account.userName}"></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><p id="displayEmail">${requestScope.account.email}</p><input id="email" style=" display:none"  value="${requestScope.account.email}"></td>
        </tr>
        <tr>
            <td>Full name:</td>
            <td>
                <p id="displayFullName">${requestScope.account.fullName}</p>
                <input id="fullName" style=" display:none" onchange="checkRegexFullName()" value="${requestScope.account.fullName}">
            </td>
        </tr>
        <tr>
            <td>PhoneNumber:</td>
            <td>
                <p id="displayPhoneNumber">${requestScope.account.phoneNumber}</p>
                <input id="phoneNumber" onchange="checkRegexPhoneNumber()" style=" display:none" value="${requestScope.account.phoneNumber}">
                <span id="phoneWarning" style="color: red;display: none">Your phone isn't suit with phone format  </span>
            </td>
        </tr>
        <tr>
            <td>Address:</td>
            <td>
                <p id="displayAddress">${requestScope.account.address}</p>
                <input id="address" onchange="checkRegexAddress()" style=" display:none" value="${requestScope.account.address}">
                <span id="addressWarning" style="color: red;display: none">Your address isn't suit with address format  </span>
            </td>
        </tr>
        <tr>
            <td>Admin right:</td>
            <td id="adminRight" >
                <c:choose>
                    <c:when test="${requestScope.account.role}">
                        Yes
                    </c:when>
                    <c:otherwise>
                        No
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </table>
    <button id="editInformation" type="button" value="" onclick="editInform()">Edit your profile</button>
        <button id="confirm" type="submit" disabled style="display: none">Confirm change</button>
     <button id="abort" type="button" style="display: none" onclick="editInform()">Abort changing</button>
    </form>
</div>
<div id="myBlog" style="display:
<c:choose>
        <c:when test="${requestScope.blogDisplay=='block'}">
            block">
        </c:when>
        <c:otherwise>
            none">
        </c:otherwise>
            </c:choose>
    <div>
    <table  style="border: solid">
        <tr>
            <th>Index</th>
            <th>Title</th>
            <th>Category</th>
            <th>Date</th>
        </tr>
        <c:forEach items="${requestScope.blogs}" var="b" varStatus="index1">
            <tr>
            <th>${index1.index+1}</th>
                <th><a href="/AccountServlet?action=loadBlog&blogId=${b.id}">${b.title}</a></th>
            <th>${b.category.name}</th>
            <th>${b.date}</th>
            </tr>
        </c:forEach>
    </table>
    </div>
    <div id="blogReq" style="border: 1px solid black;display:
        <c:choose>
        <c:when test="${requestScope.blogReq!= null}">
                block">
            </c:when>
            <c:otherwise>
                none">
            </c:otherwise>
            </c:choose>
        <p>${requestScope.blogReq.title}</p>
        <p>${requestScope.blogReq.content}</p>
    </div>
</div>
<div id="mySecurity" style="display:
<c:choose>
<c:when test="${requestScope.Security=='block'}">
        block">
    </c:when>
    <c:otherwise>
    none">
    </c:otherwise>
    </c:choose>
        <select id="securityChange">
            <option></option>
            <option id="password"  >Change username,email and password </option>
            <option id="secondSecurity" >Set your two-step verification </option>
        </select>
    <button onclick="confirmChoice()">Confirm</button>
        <div id="verifyPassword" style="display: none">
            <label for="password1">Input your password to continue</label><br>
            <input type="text" id="password1" onchange="checkPassword()">
            <span id="passWarning1" style="color: red;display: none">!!Wrong password!!</span>
        </div>

</div>
<script>
<%--Dành cho phần Account information --%>
    function showAccountDetail(){
        if (document.getElementById("accountInformation").style.display==="none"){
            document.getElementById("accountInformation").style.display="block";
            document.getElementById("myBlog").style.display="none";
            document.getElementById("mySecurity").style.display="none";

        }
    }
function showMyBlog(){
    if (document.getElementById("myBlog").style.display==="none"){
        document.getElementById("myBlog").style.display="block";
        document.getElementById("accountInformation").style.display="none";
        document.getElementById("mySecurity").style.display="none";
    }
}
function showSecurity(){
    if (document.getElementById("mySecurity").style.display==="none"){
        document.getElementById("mySecurity").style.display="block";
        document.getElementById("accountInformation").style.display="none";
        document.getElementById("myBlog").style.display="none";
    }
}
    function editInform(){
        let confirm = document.getElementById("confirm");
        if(confirm.style.display==="none"){
            confirm.style.display="block";
            confirm.disabled = "true";
            document.getElementById("abort").style.display="block";
            document.getElementById("editInformation").style.display="none";
            document.getElementById("displayPhoneNumber").style.display="none";
            document.getElementById("displayAddress").style.display="none";
            document.getElementById("displayFullName").style.display="none";
            document.getElementById("phoneNumber").style.display="block";
            document.getElementById("address").style.display="block";
            document.getElementById("fullName").style.display="block";
            document.getElementById("phoneNumber").value=document.getElementById("displayPhoneNumber").innerHTML;
            document.getElementById("address").value=document.getElementById("displayAddress").innerHTML;
            document.getElementById("fullName").value=document.getElementById("displayFullName").innerHTML;
        }else {
            confirm.style.display="none";
            document.getElementById("abort").style.display="none";
            document.getElementById("editInformation").style.display="block";
            document.getElementById("displayPhoneNumber").style.display="block";
            document.getElementById("displayAddress").style.display="block";
            document.getElementById("displayFullName").style.display="block";
            document.getElementById("phoneNumber").style.display="none";
            document.getElementById("address").style.display="none";
            document.getElementById("fullName").style.display="none";
        }
    }
    function checkRegexUsername(){
        let username = document.getElementById("username1").value;
        let pattern = /^[a-z0-9_-]{8,15}$/;
        if (!pattern.test(username)){
            document.getElementById("nameWarning").style.display="block";
        }else{
            document.getElementById("nameWarning").style.display="none";
        }
    }
    function checkRegexEmail(){
        let email = document.getElementById("email").value;
        let pattern = /[^@]{2,64}@[^.]{2,253}\.[0-9a-z-.]{2,63}/;
        if (!pattern.test(email)){
            document.getElementById("emailWarning").style.display="block";
        }else{
            document.getElementById("emailWarning").style.display="none";
        }
    }
    function checkRegexPassword(){
        check()
        let password = document.getElementById("password1").value;
        let pattern = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$/;
        if (!pattern.test(password)){
            document.getElementById("passWarning").style.display="block";
        }else{
            document.getElementById("passWarning").style.display="none";
        }
        checkRegisterCondition()
    }
    function checkRegexPhoneNumber(){
        let phone = document.getElementById("phoneNumber").value;
        let pattern = /^[0-9]{10}$/;
        if (!pattern.test(phone)){
            document.getElementById("phoneWarning").style.display="block";
        }else{
            document.getElementById("phoneWarning").style.display="none";
        }
        checkConfirmCondition()
    }
    function checkRegexAddress(){
        let address = document.getElementById("address").value;
        let pattern = /^(?=.*\w).+$/;
        if (!pattern.test(address)){
            document.getElementById("addressWarning").style.display="block";
        }else{
            document.getElementById("addressWarning").style.display="none";
        }
        checkConfirmCondition()
    }
    function checkRegexFullName(){
        checkConfirmCondition()
    }
    function checkConfirmCondition(){
        let aw= document.getElementById("addressWarning").style.display
        let phw= document.getElementById("phoneWarning").style.display
        let a= document.getElementById("address").value
        let ph= document.getElementById("phoneNumber").value
        let f= document.getElementById("fullName").value
        let check= (a!==document.getElementById("displayAddress").innerHTML)||(ph!==document.getElementById("displayPhoneNumber").innerHTML)||(f!==document.getElementById("displayFullName").innerHTML);
        document.getElementById("confirm").disabled = !(aw==="none"&&phw==="none"&&a!==""&&ph!==""&&f!==""&&check)
    }
    // -----------------------------------------------------------------
function confirmChoice(){
        if (document.getElementById("securityChange").value==="Change username,email and password"){
document.getElementById("verifyPassword").style.display="block";
        }
}
function checkPassword(){
        if (document.getElementById("password1").value==="${requestScope.account.passWord}"){
            document.getElementById("password1").style.display="none";
            document.getElementById("password1").value="";
            document.getElementById("passWarning1").style.display="none";
            document.getElementById("verifyPassword").style.display="none"
        }else{
            document.getElementById("passWarning1").style.display="block";
        }
}
</script>
</body>
</html>
