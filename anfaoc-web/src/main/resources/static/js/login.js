/**
 * @data 2020 5月9日
 * @author wangzy
 */
$(document).ready(function() {
    //登陆
    $("#loginButton").click(function () {
        $.ajax({
            url: "home", //请求后台
            dataType: "text",
            type: "get",
            async: true,
            data: "name=" + $("#name").val(),
            success: function (result) {
                console.log(result);
                var response = $.parseJSON(result);
                var success = response.success;
                if (success == true) {
                    $("#bingo").html("验证成功，即将跳转");
                    window.setTimeout("location.href=\"http://localhost:8005/login\"", 2000);
                }else {

                    $("#bingo").html("用户名密码不正确");
                    document.getElementById("bingo").style.color="red";
                }
            }
        });
    })

    //注册
    $("#registerButton").click(function () {
        $.ajax(
            {

            }
        )
        alert("密码格式错误");
    })

    $("#registerButton").mousedown(function () {
        $("#registerButton").css("background-color","yellow");
        $("#registerButton").css("border-color","yellow");
        $("#registerButton").css("color","black");
    })

    $("#registerButton").mouseover(function () {
        $("#registerButton").css("background-color","#ED2553");
        $("#registerButton").css("border-color","#ED2553");
        $("#registerButton").css("color","#FFFFFF");
    })

    $("#registerButton").mouseleave(function () {
        $("#registerButton").css("background-color","#FFFFFF");
        $("#registerButton").css("border-color","#FFFFFF");
        $("#registerButton").css("color","#ED2553");
    })

    //鼠标点击事件
    $("#loginButton").mousedown(function () {
        $("#loginButton").css("background-color","blue");
        $("#loginButton").css("border-color","blue");
    })

    //鼠标悬浮事件
    $("#loginButton").mouseover(function () {
        $("#loginButton").css("background-color","#ED2553");
        $("#loginButton").css("border-color","#ED2553");
        $("#loginButton").css("color","#FFFFFF");
    })

    //鼠标移开事件
    $("#loginButton").mouseleave(function () {
        $("#loginButton").css("background-color","#FFFFFF");
        $("#loginButton").css("color","#E5E5E5");
        $("#loginButton").css("border-color","#E5E5E5");
    })
})
