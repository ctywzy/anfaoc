/**
 * @Description 填充新闻
 * Author wangzy
 * Date 5月10日
 **/

$(document).ready(function () {
    //新闻页面填充
    var newDiv = "";

    finalDiv();

    //最后的div表格
    function finalDiv(){
        singleDiv();
        $("#newsDiv").html(newDiv);
    }

    //单个div格
    function singleDiv(){
       connRow("<div class=\"post\">\n" +
           "<div class=\"post__head\">\n" +
           "<a href=\"#\" class=\"post__head-img\">\n" +
           "<img src=\"/static/images/user2.jpg\" alt=\"\">\n" +
           "</a>\n" +
           "<div class=\"post__head-title\">\n" +
           "<h5><a href=\"#\">Andy Ramos</a></h5>\n" +
           "<p>11 min ago</p>\n" +
           "</div>\n" +
           "\n" +
           "<div class=\"post__dropdown\">\n" +
           "<a class=\"dropdown-toggle post__dropdown-btn\" href=\"#\" role=\"button\" id=\"dropdownMenu3\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n" +
           "<i class=\"icon ion-md-more\"></i>\n" +
           "</a>\n" +
           "\n" +
           "<ul class=\"dropdown-menu dropdown-menu-right post__dropdown-menu\" aria-labelledby=\"dropdownMenu3\">\n" +
           "<li><a href=\"#\">Edit</a></li>\n" +
           "<li><a href=\"#\">Delete</a></li>\n" +
           "<li><a href=\"#\">Hide</a></li>\n" +
           "</ul>\n" +
           "</div>\n" +
           "</div>\n" +
           "\n" +
           "<div class=\"post__wrap\">\n" +
           "<div class=\"post__company\">\n" +
           "<i class=\"icon ion-ios-briefcase\"></i>\n" +
           "<span>Front-end Developer</span>\n" +
           "</div>\n" +
           "\n" +
           "<div class=\"post__actions\">\n" +
           "<a class=\"post__actions-btn post__actions-btn--green\" href=\"#\">\n" +
           "<i class=\"icon ion-ios-bookmark\"></i>\n" +
           "</a>\n" +
           "<a class=\"post__actions-btn post__actions-btn--red\" href=\"#\">\n" +
           "<i class=\"icon ion-ios-mail\"></i>\n" +
           "</a>\n" +
           "<a href=\"#\" class=\"post__actions-btn post__actions-btn--blue\"><span>Bid now</span></a>\n" +
           "</div>\n" +
           "</div>\n" +
           "\n" +
           "<h2 class=\"post__title\">PSD to HTML</h2>\n" +
           "\n" +
           "<div class=\"post__options\">\n" +
           "<p>$300 - $350</p>\n" +
           "</div>\n" +
           "\n" +
           "<div class=\"post__description\">\n" +
/*文章*/   "<p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text.</p>\n" +
/*跳转到正文*/          "<a href=\"#\">view more</a>\n" +
           "</div>\n" +
           "\n" +
/* 标签 */           "<div class=\"post__tags\">\n" +
           "<a href=\"#\">HTML</a>\n" +
           "<a href=\"#\">CSS</a>\n" +
           "<a href=\"#\">JS</a>\n" +
           "<a href=\"#\">PSD</a>\n" +
/* 标签 */            "</div>\n" +
           "\n" +
           "<div class=\"post__stats\">\n" +
           "<div>\n" +
           "<a class=\"post__likes\" href=\"#\"><i class=\"icon ion-ios-heart\"></i> <span>15</span></a>\n" +
           "<a class=\"post__comments\" data-toggle=\"collapse\" href=\"#collapse3\" role=\"button\" aria-expanded=\"false\" aria-controls=\"collapse1\"><i class=\"icon ion-ios-text\"></i> <span>0</span></a>\n" +
           "</div>\n" +
           "\n" +
           "<div class=\"post__views\">\n" +
           "<i class=\"icon ion-ios-eye\"></i> <span>214</span>\n" +
           "</div>\n" +
           "</div>\n" +
           "\n" +
           "<div class=\"collapse post__collapse\" id=\"collapse3\">\n" +
           "<form action=\"#\" class=\"post__form\">\n" +
           "<input type=\"text\" placeholder=\"Type your comment...\">\n" +
           "<button type=\"button\"><i class=\"icon ion-ios-paper-plane\"></i></button>\n" +
           "</form>\n" +
           "</div>\n" +
           "</div>\n" +
           "<!-- end post -->\n" +
           "<button class=\"main__btn\" type=\"button\"><span>load more</span></button>")
    }

    //html拼接
    function connRow(Row){
        newDiv += Row + "\n";
    }
})