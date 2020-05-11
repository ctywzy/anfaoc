/**
 * @Description 填充新闻
 * Author wangzy
 * Date 5月10日
 **/

$(document).ready(function () {
    //新闻页面填充
    var newDiv = "";
    var pageNumber = $("#pageNumber").val();
    var success;
    $.get({
        url : "api/anfaoc/news/getHotNews",
        dataType : "text",
        async : true,
        data : {
            pageNo : pageNumber

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


    //最后的div表格
    function finalDiv(result){
        for(var i = 0 ;i<result.length ; i++){
            var ajumpurl = "getNewsDetail/"+result[i].id;
            singleDiv(ajumpurl,result[i].newLabels,result[i].newTitle,result[i].preViewPara,result[i].pageViews,i,result[i].id);
        }
        connRow("<button class=\"main__btn\" type=\"button\"><span>load more</span></button>")
        $("#newsDiv").html(newDiv);
    }

    //单个div格
    /**
     *
     * @param aurl 跳转详情连接
     * @param labelList 标签列表
     * @param title 文章标题
     * @param introduction 简介
     * @Param pageViews 浏览量
     */
    function singleDiv(aurl,labelList,title,introduction,pageViews,count,newsNo){
       connRow("<div class=\"post\">\n" +
           "\t\t\t\t\t\t<div class=\"post__head\">\n" +
           "\t\t\t\t\t\t\t<div class=\"post__head-title\">\n" +
           "\t\t\t\t\t\t\t\t<h5><a href=\"#\">"+ title +"</a></h5>\n" +
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
           "\t\t\t\t\t\t\t\t<i class=\"icon ion-ios-briefcase\"></i>\n" + "<span>简介</span>" +
           "\t\t\t\t\t\t\t</div>\n" +
           "\n" +
           "\t\t\t\t\t\t\t<div class=\"post__actions\">\n" +
           "\t\t\t\t\t\t\t\t<a class=\"post__actions-btn post__actions-btn--green\" href=\"#\">\n" +
           "\t\t\t\t\t\t\t\t\t<i class=\"icon ion-ios-bookmark\"></i>\n" +
           "\t\t\t\t\t\t\t\t</a>\n" +                                                 /** 收藏按钮 **/
           "\t\t\t\t\t\t\t\t<a href=\"#\" class=\"post__actions-btn post__actions-btn--blue\"><span>收藏</span></a>\n" +
           "\t\t\t\t\t\t\t</div>\n" +
           "\t\t\t\t\t\t</div>\n" +
           "\n" +
           "\t\t\t\t\t\t<div class=\"post__description\">\n" +
           "\t\t\t\t\t\t\t<p>"+ introduction +"</p>\n" +
           "\t\t\t\t\t\t\t<a href="+aurl+">view more</a>\n" + /** 新闻详情**/
           "\t\t\t\t\t\t</div>\n"
            )

            //标签添加
           connLabel(labelList);

            //剩余部分
           connRow("\t\t\t\t\t\t<div class=\"post__stats\">\n" +
           "\t\t\t\t\t\t\t<div>\n" +
           "\t\t\t\t\t\t\t\t<a class=\"post__likes\" href=\"#\"><i class=\"icon ion-ios-heart\"></i> <span>15</span></a>\n" +
           "\t\t\t\t\t\t\t\t<a class=\"post__comments\" data-toggle=\"collapse\" href=\"#collapse"+ count +"\" role=\"button\" aria-expanded=\"false\" aria-controls=\"collapse1\"><i class=\"icon ion-ios-text\"></i> <span>0</span></a>\n" +
           "\t\t\t\t\t\t\t</div>\n" +
           "\n" +
           "\t\t\t\t\t\t\t<div class=\"post__views\">\n" +
           "\t\t\t\t\t\t\t\t<i class=\"icon ion-ios-eye\"></i> <span>"+ pageViews +"</span>\n" +
           "\t\t\t\t\t\t\t</div>\n" +
           "\t\t\t\t\t\t</div>\n" +
           "\n" +
           "\t\t\t\t\t\t<div class=\"collapse post__collapse\" id=\"collapse"+ count +"\">\n" +
           "\t\t\t\t\t\t\t<form action=\"#\" class=\"post__form\">\n" +
           "\t\t\t\t\t\t\t\t<input type=\"text\" placeholder=\"Type your comment...\">\n" +  /** 评论的话 **/
           "\t\t\t\t\t\t\t\t<button type=\"button\"><i class=\"icon ion-ios-paper-plane\"></i></button>\n" +  /** 评论按钮 **/
           "\t\t\t\t\t\t\t</form>\n" +
           "\t\t\t\t\t\t</div>\n" +
           "\t\t\t\t\t</div>")
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
})