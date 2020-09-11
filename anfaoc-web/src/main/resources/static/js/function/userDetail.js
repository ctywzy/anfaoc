/**
 * 获取用户信息
 * @Author wangzy
 */

$(document).ready(function () {

    $.get({
        url : "/api/anfaoc/user/ordinary/getNowUserDetail",
        dataType : "text",
        async : true,
        data : {
        },
        success : function(result){
            var response = $.parseJSON(result);
            success = response.success;
            var user = response.result;
            if(success == true){
                $("#pageUserName").html(user.userName);
            }else{
                $("#pageUserName").html(response.error);
            }
        }
    })

})