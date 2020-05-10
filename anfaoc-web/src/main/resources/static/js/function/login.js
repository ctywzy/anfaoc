/**
 * @data 2020 5月9日
 * @author wangzy
 */
$(document).ready(function() {
    //登陆
    $("#loginButton").click(function () {
        var phone = $("#phone").val();
        var verity = $("#verity").val();
        $.get({
            url: "/api/anfaoc/user/ordinary/userLogin/verityCode", //请求后台
            dataType: "text",
            async: true,
            data: {
                phoneNumber : phone,
                verityCode : verity
            },
            success: function (result) {
                console.log(result);
                var response = $.parseJSON(result);
                var success = response.success;
                var msg = response.error;
                if (success == true) {
                    $("#bingo").html("验证成功，即将跳转");
                    window.setTimeout("location.href=\"http://localhost:8005/homepage\"", 2000);
                }else {

                    $("#bingo").html(msg);
                    document.getElementById("bingo").style.color="red";
                }
            }
        });
    })

    //注册
    $("#registerButton").click(function () {
        $.get(
            {

            }
        )
        alert("密码格式错误");
    })

    var time = 60;
    var flag = true;
    //获取验证码
    $("#getVerity").click(function () {
        $(this).attr("disabled",true);
        var phone = $('#phone').val();
        if(flag){
            var timer = setInterval(function () {

                if(time == 60 && flag){
                    flag = false;
                    $.get({
                        async : false,
                        url : '/api/anfaoc/user/ordinary/getVerifyCode',
                        data : {
                            "phoneNumber" : phone
                        },
                        dataType:"text",
                        success : function(result) {
                            response = $.parseJSON(result);
                            var error = response.error;
                            var success = response.success;
                            if(success == true){
                                $("#bingo").html("发送成功");
                            }else {
                                $("#getVerity").removeAttr("disabled");
                                $("#getVerity").css("background-color","#4CAF50");
                                $("#getVerity").css("border-color","#4CAF50");
                                $("#bingo").html(error);
                                document.getElementById("bingo").style.color="red";
                                flag = true;
                                time = 60;
                                clearInterval(timer);
                            }
                        }
                    });
                }else if(time == 0){
                    $("#getVerity").removeAttr("disabled");
                    $("#getVerity").html("免费获取验证码");
                    $("#getVerity").css("background-color","#4CAF50");
                    $("#getVerity").css("border-color","#4CAF50");
                    clearInterval(timer);
                    time = 60;
                    flag = true;
                }else {
                    $("#getVerity").html(time + " s 后可重新发送");
                    time--;
                }
            },1000);
        }
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

    //鼠标悬浮事件
    $("#getVerity").mouseover(function () {
        $("#getVerity").css("background-color","#008CBA");
        $("#getVerity").css("border-color","#008CBA");
    })

    //鼠标移开事件
    $("#getVerity").mouseleave(function () {
        $("#getVerity").css("background-color","#4CAF50");
        $("#getVerity").css("border-color","#4CAF50");
    })





})
