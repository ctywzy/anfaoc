/**
 * @wangzy
 * @Description 注册时 用到的
 */

$(document).ready(function (){


    document.getElementById("registerBigno").style.color="red";

    $("#registerButton").click(function () {
        $.post({
            url : "/api/anfaoc/user/ordinary/register",
            async : true ,
            dataType : "json",
            contentType: "application/json;charset=UTF-8",
            data : JSON.stringify({
                userName : $("#userName").val(),
                phoneNumber : $("#phoneNumber").val(),
                userPassword : $("#password").val(),
                checkPasswrod : $("#checkPassword").val(),
            }),
            success : function (response) {

                var success = response.success;
                if(success == true){
                    $("#registerBigno").html("注册成功,即将跳转到登陆页面");
                    window.setTimeout(location.href='/login', 2000);

                }else{
                    $("#registerBigno").html(response.error);
                }
            }
        })
    })
})