/**
 * @Description 热点新闻相关按钮
 * @Date 2020年5月11日
 * @Author wangzy
 */

$(document).ready(function () {

    var newDiv = "";
    var newsId = $("#newsNo").val();
    var collectUrl = "../collectNews/"+newsId;
    var commentDiv = "";

    loadNews();

    $("#reply").click(function () {
        $.post({
            url : "../api/anfaoc/news/newsComment",
            dataType : "json",
            contentType: "application/json;charset=UTF-8",
            async : true,
            data : JSON.stringify({
                newsId : newsId,
                content : $("#replymsg").val()
            }),
            success : function (response) {

                var success = response.success;
                var msg = response.error;
                if(success == true){
                    loadNews();
                }else{
                    alert(msg);
                }
            }
        })
    })

    function fillDiv(result) {
        newDiv = "";
        connRow("<div class=\"post\">\n" +
            "\t\t\t\t\t\t<div class=\"post__head\">\n" +
            "\t\t\t\t\t\t\t<div class=\"post__head-title\">\n" +
            "\t\t\t\t\t\t\t\t<h5><a href=\"#\">"+ result.newTitle +"</a></h5>\n" +
            "\t\t\t\t\t\t\t</div>\n" +
            "\n" +
            "\t\t\t\t\t\t\t<div class=\"post__dropdown\">\n" +
            "\t\t\t\t\t\t\t\t<a class=\"dropdown-toggle post__dropdown-btn\" href=\"#\" role=\"button\" id=\"dropdownMenu3\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"icon ion-md-more\"></i>\n" +
            "\t\t\t\t\t\t\t\t</a>\n" +
            "\n" +
            "\t\t\t\t\t\t\t\t<ul class=\"dropdown-menu dropdown-menu-right post__dropdown-menu\" aria-labelledby=\"dropdownMenu3\">\n" +
            "\t\t\t\t\t\t\t\t\t<li><a href=\"#\">Edit</a></li>\n" +
            "\t\t\t\t\t\t\t\t\t<li><a href=\"#\">Delete</a></li>\n" +
            "\t\t\t\t\t\t\t\t\t<li><a href=\"#\">Hide</a></li>\n" +
            "\t\t\t\t\t\t\t\t</ul>\n" +
            "\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t</div>\n" +
            "\n" +
            "\t\t\t\t\t\t<div class=\"post__wrap\">\n" +
            "\t\t\t\t\t\t\t<div class=\"post__company\">\n" +
            "\t\t\t\t\t\t\t\t<i class=\"icon ion-ios-briefcase\"></i>\n" +
            "\t\t\t\t\t\t\t\t<span>详细</span>\n" +
            "\t\t\t\t\t\t\t</div>\n" +
            "\n" +
            "\t\t\t\t\t\t\t<div class=\"post__actions\">\n" +
            "\t\t\t\t\t\t\t\t<a class=\"post__actions-btn post__actions-btn--green\" href=\"#\">\n" +
            "\t\t\t\t\t\t\t\t\t<i class=\"icon ion-ios-bookmark\"></i>\n" +
            "\t\t\t\t\t\t\t\t</a>\n" +
            "\t\t\t\t\t\t\t\t<a href=\""+collectUrl+"\" class=\"post__actions-btn post__actions-btn--blue\"><span>"+ "收藏"+"</span></a>\n" +
            "\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t</div>\n" +
            "\n" +
            "\t\t\t\t\t\t<div class=\"post__description\">\n" +
            "\t\t\t\t\t\t\t<p>"+ result.newsFinalPara +"</p>\n" +
            "\t\t\t\t\t\t</div>\n");

        connLabel(result.newLabels);

        connRow("\t\t\t\t\t\t<div class=\"post__stats\">\n" +
            "\t\t\t\t\t\t\t<div>\n" +
            "\t\t\t\t\t\t\t\t<a class=\"post__comments\" data-toggle=\"collapse\" href=\"#collapse3\" role=\"button\" aria-expanded=\"false\" aria-controls=\"collapse3\"><i class=\"icon ion-ios-text\"></i> <span>"+ result.commentsNum +"</span></a>\n" +
            "\t\t\t\t\t\t\t</div>\n" +
            "\n" +
            "\t\t\t\t\t\t\t<div class=\"post__views\">\n" +
            "\t\t\t\t\t\t\t\t<i class=\"icon ion-ios-eye\"></i> <span>"+ result.pageViews +"</span>\n" +
            "\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t</div>\n" +
            "\n" +
            "\t\t\t\t\t</div>");


        $("#newsDiv").html(newDiv);
    }

    //html拼接
    function connRow(Row){
        newDiv += Row + "\n";
    }

    //标签列表
    function connLabel(labels){
        connRow("\t\t\t\t\t\t<div class=\"post__tags\">");
        for(var i = 0;i < labels.length; i++){
            var label = "\t\t\t\t\t\t\t<a href=\"#\">" + labels[i] + "</a>";
            connRow(label);
        }
        connRow("\t\t\t\t\t\t</div>");
    }

    function loadNews() {
        $.get({
            url : "../api/anfaoc/news/getNewsDetail",
            dataType : "json",
            contentType: "application/json;charset=UTF-8",
            async : false,
            data : {
                newsId : newsId
            },
            success: function (response){
                var success = response.success;
                if(success == true){
                    fillDiv(response.result);
                    fillReply(response.result);
                }else{
                    alert("查询失败");
                }
            }
        });
    }

    function fillReply(result){
        commentDiv = "";
        var replyNum = result.commentsNum;
        for(var i = 0; i< replyNum;i++){
            commentDiv += "<div id = \"comments\">\n" +
                "\t\t\t\t\t\t\t<div class=\"post__comment\">\n" +
                "\t\t\t\t\t\t\t\t<div class=\"post__comment-title\">\n" +
                "\t\t\t\t\t\t\t\t\t<h5><a href=\"#\">"+ result.commentsName[i] +"</a></h5>\n" +
                "\t\t\t\t\t\t\t\t</div>\n" +
                "\n" +
                "\t\t\t\t\t\t\t\t<p class=\"post__comment-text\">"+ result.comments[i] +"</p>\n" +
                "\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t</div>";
        }
        $("#comments").html(commentDiv);
    }

})