
$(document).ready(function () {

    var labelDiv = "";
    var pageNo = $("#pageNumber").val();

    $.get({
        url : "../api/anfaoc/news/getAllLabel",
        dataType : "text",
        async : true,
        data : {
            pageNo : pageNo

        },
        success : function(result){
            var response = $.parseJSON(result);
            success = response.success;
            if(success == true){
                finalDiv(response.result);
            }else{

            }
        }
    })

    $("#loadMoreButton").click(function () {
        labelDiv = "";
        pageNo = Number(pageNo) + Number(1);
        $("#pageNumber").val(pageNo);
        $.get({
            url : "../api/anfaoc/news/getAllLabel",
            dataType : "text",
            async : true,
            data : {
                pageNo : pageNo

            },
            success : function(result){
                var response = $.parseJSON(result);
                success = response.success;
                if(success == true){
                    finalDiv(response.result);
                }else{

                }
            }
        })
    })


    function finalDiv(result) {
        for(var i = 0; i < result.length; i++){
            var addAction = "../addLabel/" + result[i].id;
            var deleteAction = "../deleteLabel/" + result[i].id;
            var labelName = result[i].labelName;
            labelDiv += "<div class=\"col-12 col-sm-6 col-md-12 col-lg-3\">\n" +
                "\t\t\t\t\t\t\t<div class=\"company\">\n" +
                "\t\t\t\t\t\t\t\t<div class=\"company__logo\">\n" +
                "\t\t\t\t\t\t\t\t\t<img src=\"img/company.svg\" alt=\"\">\n" +
                "\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t<div class=\"company__wrap\">\n" +
                "\t\t\t\t\t\t\t\t\t<h2 class=\"company__title\" style=\"width: 100%;display: block;text-align: center;font-size: 30px;\"><a href=\"#\"> "+ labelName +"</a></h2>\n" +
                "\t\t\t\t\t\t\t\t</div>\n" +
                "\n" +
                "\t\t\t\t\t\t\t\t<div class=\"company__actions\">\n" +
                "\t\t\t\t\t\t\t\t\t\n" +
                "\n" +
                "\t\t\t\t\t\t\t\t\t<div class=\"post__actions col-lg-12\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<a class=\"post__actions-btn post__actions-btn--green col-lg-6\" href=\""+ addAction+"\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<i class=\"icon\">添加</i>\n" +
                "\t\t\t\t\t\t\t\t\t\t</a>\n" +
                "\t\t\t\t\t\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t\t\t<a class=\"post__actions-btn post__actions-btn--red col-lg-6\" href=\""+deleteAction+"\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<i class=\"icon\">删除</i>\n" +
                "\t\t\t\t\t\t\t\t\t\t</a>\n" +
                "\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t</div>"
        }
        // labelDiv += "<div class=\"col-12\">\n" +
        //     "\t\t\t\t\t\t\t<button class=\"main__btn main__btn--margin\" type=\"button\" id=\"loadMoreButton\"><span>加载更多</span></button>\n" +
        //     "\t\t\t\t\t\t</div>";
        $("#labelDiv").html(labelDiv);
    }
})