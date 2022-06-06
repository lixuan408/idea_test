<%--
  Created by IntelliJ IDEA.
  User: 李轩
  Date: 2022/6/1
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>欢迎注册</title>
    <link href="css/register.css" rel="stylesheet">
</head>
<body>

<div class="form-div">
    <div class="reg-content">
        <h1>欢迎注册</h1>
        <span>已有帐号？</span> <a href="login.html">登录</a>
    </div>
    <form id="reg-form" action="/brand_demo/registerServlet" method="post">

        <table>

            <tr>
                <td>用户名</td>
                <td class="inputs">
                    <input name="username" type="text" id="username" value="${username}">
                    <br>
                    <span id="username_err" class="err_msg">${register_msg}${VerifyCode_msg}</span>
                </td>

            </tr>

            <tr>
                <td>密码</td>
                <td class="inputs">
                    <input name="password" type="password" id="password" value="${password}">
                    <br>
                    <span id="password_err" class="err_msg" style="display: none">密码格式有误</span>
                </td>
            </tr>


            <tr>
                <td>验证码</td>
                <td class="inputs">
                    <input name="checkCode" type="text" id="checkCode" value="${checkCode}">
                    <img src="/brand_demo/checkCodeServlet" id="VerifyCode">
                    <a href="#" id="changeImg">看不清？</a>
                </td>
            </tr>
        </table>

        <div class="buttons">
            <input value="注 册" type="submit" id="reg_btn">
        </div>
        <br class="clear">
    </form>

</div>
</body>
<script>

    //1.验证用户名是否符合规则
    var usernameInput = document.getElementById("username");

    //1.2 绑定onblur
    usernameInput.onfocus=clear;
    usernameInput.onblur = testUsername;

    function clear(){
        document.getElementById("username_err").innerText="";
    }

    function testUsername() {
        let username = usernameInput.value.trim();

        let reg = /^(?=.*[A-Z])(?=.*[a-z])(?=.*[\d])[A-Za-z][A-Za-z\d]{5,11}$/;

        //判断用户名是否符合规则：长度6~12,仅仅可以由字母和数组组成且开头必须为字母
        if (!reg.test(username)) {
            document.getElementById("username_err").innerText="用户名格式错误！";
            return false;
        } else{
            document.getElementById("username_err").innerText="";
            return true;
        }
    }



    //1.验证密码是否符合规则
    var passwordInput = document.getElementById("password");

    //1.2 绑定onblur
    passwordInput.onblur = function () {
        testPassword()
    };

    function testPassword() {
        var password = passwordInput.value.trim();
        //判断用户名是否符合规则：长度6~12,仅仅可以由字母和数组组成且开头必须为数字
        if (password.length > 12) {
            document.getElementById("password_err").style.display = '';
            return false;
        } else {
            document.getElementById("password_err").style.display = 'none';
            return true;
        }
    }


    /*  //1.验证手机号是否符合规则
      var telInput = document.getElementById("tel");

      //1.2 绑定onblur
      telInput.onblur = function () {
          testTel();
      };

      function testTel() {
          var tel = telInput.value.trim();
          //判断用户名是否符合规则：长度6~12
          if (tel.length > 12) {
              document.getElementById("tel_err").style.display = '';
              return false;
          } else {
              document.getElementById("tel_err").style.display = 'none';
              return true;
          }
      }*/


    //2，注册按钮
    var regForm = document.getElementById("reg-form");

    regForm.onsubmit = function () {
        if (testPassword() && testUsername()) {
            return true;
        } else {
            return false;
        }
    }


    //3.验证码的生成和校对
    document.getElementById("changeImg").onclick=function (){
        let milliseconds = new Date().getMilliseconds();
        document.getElementById("VerifyCode").src="/brand_demo/checkCodeServlet?"+milliseconds;
    }

    document.getElementById("VerifyCode").onclick=function (){
        let milliseconds = new Date().getMilliseconds();
        document.getElementById("VerifyCode").src="/brand_demo/checkCodeServlet?"+milliseconds;
    }


   /* document.getElementById("username").onblur = function () {
        //1.创建核心对象

        var username = this.value;

        var xhttp;
        if (window.XMLHttpRequest) {
            xhttp = new XMLHttpRequest();
        } else {
            // code for IE6, IE5
            xhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }

        //2.发送数据
        xhttp.open("GET", "http://localhost:8080/brand_demo/selectUserServlet?username="+username, true);
        xhttp.send();

        //3.获取响应
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {

                if (this.responseText=="false") {
                    document.getElementById("username_err").innerText='用户名已经存在！！';
                }else{
                    document.getElementById("username_err").style.display="";
                }
            }
        };

    }*/

</script>
</html>
