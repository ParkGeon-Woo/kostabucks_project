<%@ page import="java.util.ArrayList"%>
<%@ page import="com.my.vo.Drink" %>
<%@ page import="com.my.vo.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>음료리스트</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <style>
        * {
            box-sizing: border-box;
            padding: 0;
            margin: 0;
        }

        header {
            background: #f6f5ef;
            margin: 0px auto;
            height: 120px;
        }

        header>nav>ul>li>a {
            text-decoration: none;
        }

        header>nav>ul>li>a:hover {
            background-color: black;
            color: white;
            font-weight: bold;
        }

        header>nav {
            display: inline-block;
            /* 줄바꿈 없이 한 줄에 배치 + width, height 속성 지정 가능*/
            width: 100%;
            height: 120px;
            /* border:1px solid; */
            position: absolute;
            /*static 속성을 가지고 있지 않은 부모를 기준*/
            top: 0px;
        }

        section {
            background-color: white;
            min-height: 3815px;
            height: auto;

        }

        section>div {
            height: 100%;
            float: left;
            margin: 0 290px;
        }

        section>div.sub_title {
            vertical-align: top;
            width: 100%;
            font-size: 20px;
            padding: 30px 0px;
        }

        section>div.drink_kind_wrap {
            width: 1100px;
            padding: 30px 30px 30px 30px;
            font-size: 18px;
            font-weight: bold;
            border: 2px solid #e0e0e0;
            position: relative;
            border-radius: 5px;
            margin-bottom: 40px;    
        }

        section>div.drink_kind_wrap>div.drink_toggle_wrap {
            border-top: 1px solid #ddd;
            padding: 30px 0;
            position: relative;
        }

        section>div.drink_kind_wrap .category_theme_ul {
            display: flex;
            list-style-type: none;
        }

        section>div.drink_kind_wrap .category_theme_ul > li{
            margin: 10px;
            border: 1px solid black;
            width: 150px;
            height: 30px;
            text-align: center;
        }

        section>div.drink_kind_wrap .category_theme_ul > li:nth-child(1){
            background-color: #1b5e20;
            
        }

        section>div.drink_kind_wrap .category_theme_ul > li:nth-child(2){
            background-color: #eeeeee;
        }

        .category_theme_ul > li > a:nth-child(1){
            text-decoration: none;
            color: white;
        }

        .category_theme_ul > li > a:nth-child(2){
            text-decoration: none;
            color: black;
        }

        section>div.drink_kind_wrap .category-list {
            width: 1100px;
            display: flex;
            float:left;
            list-style-type: none;
            flex-wrap: wrap;
        }

        section>div.drink_kind_wrap .category-list> li{
            margin-left: 10px;
            margin-right: 10px;
            margin-top: 5px;
        }

        section>div.drink_list {
            text-align: center;
            overflow: auto;
            /* border: 2px solid green; */
            width: 1100px;
        }

        section>div.drink_list>div.drink {
            float: left;
        }

        section>div.drink_list>div.drink>div.drink_category{
            display: flex;
        }

        section>div.drink_list>div.drink>div.drink_category>div.drink_category_select1>ul{
            display: flex;
            list-style: none;
        }

        section>div.drink_list>div.drink>div.drink_category>div.drink_category_select1>ul>li.photo{
            height: 26px;
            line-height: 26px;
            font-size: 12px;
            border: 1px solid #ddd;
            border-radius: 3px;
            background-color: #666;
        }

        section>div.drink_list>div.drink>div.drink_category>div.drink_category_select1>ul>li.nutrition{
            height: 26px;
            line-height: 26px;
            font-size: 12px;
            border: 1px solid #ddd;
            border-radius: 3px;
            margin-left: 25px;
        }

        section>div.drink_list>div.drink>div.drink_category>div.drink_category_select2{
            margin-left: 696px;
        }

        section>div.drink_list>div.drink>div.drink_category a{
            text-decoration: none;
            cursor: pointer;
            margin: 0;
        }

        section>div.drink_list>div.drink>div.drink_info {
            width: 1100px;
            padding: 20px;
            background: #f4f4f2;
            border-radius: 3px;
            overflow: hidden;
            margin: 20px 0px;
        }

        section>div.drink_list>div.drink>ul {
            list-style: none;
            float: left;
        }

        section>div.drink_list>div.drink>ul>li>img {
            width: 258px;
            height: 269px;
            padding-left: 25px;
        }

        footer {
            background-color: #2C2A29;
            color: #fff;
            height: 525px;
            width: 100%;
        }      
    </style>
    <script>
        $(function(){
        	var $categoryObj = $("div.drink_kind_wrap>div.drink_toggle_wrap .category");
            var $categorylistObj = $("div.drink_kind_wrap .category-list");
            var $themeObj = $("div.drink_kind_wrap>div.drink_toggle_wrap .theme");
            var $themelistObj = $("div.drink_kind_wrap .theme-list");
            $themelistObj.hide();

            $categoryObj.click(function () {
                $themelistObj.hide();
                $categorylistObj.show();

            

            });

            $themeObj.click(function () {
                $categorylistObj.hide();
                $themelistObj.show();

            });
            //DOM트리에서 class속성값이 drink인 div객체찾기
            var $drinkDivObj = $("div.drink_list>div.drink");

            $drinkDivObj.each(function(index, element){
                $(element).click(function(){
                    var imgSrc = $(this).find("ul>li.drink_no>img").attr("src");

                    var lastSlash = imgSrc.lastIndexOf("/"); //마지막 슬래시 위치
                    var ext = imgSrc.indexOf(".jpg"); //.jpg파일확장자 위치
                    var drink_no = imgSrc.substring(lastSlash+1, ext);
                    alert("음료가 클릭됨. 음료번호:" + drink_no);
                    var drink_name_kor = $(this).find("ul>li.drink_name_kor").html();



                });
            });
        });
    </script>
</head>

<body>
    <header>
        <nav>
            <ul>
                <li><a href="#" class="drink">Customer Service & Ideas</a></li>
                <li><a href="./drink_list.html" class="drink">음료</a></li>
                <li><a href="./food_list.html" class="food">푸드</a></li>
            </ul>
        </nav>
    </header>
    <section>
        <div class="sub_title">
            <h1>음료</h1>
        </div>
        <!-- <div class="drink_list">
        <input type="checkbox" name="select_all" checked>
        <label>전체선택</label> -->
        <div class="drink_kind_wrap">
            <p class="tit">분류 보기</p>
            <div class="drink_toggle_wrap">
                <nav class="category_theme">
                    <ul class="category_theme_ul">
                        <li><a href="#" class="category">카테고리</a></li>
                        <li><a href="#" class="theme">테마</a></li>
                    </ul>
                </nav>
                <div class="drink_select_wrap">
                    <form method="post">    
                            <ul class="category-list">
                            <li>
                                <label><input type="checkbox" name="select_all" checked>전체 상품보기</label>
                            </li>
                            <li>
                                <label><input type="checkbox" name="coldbrew">콜드 브루 커피</label>
                            </li>
                            <li>
                                <label><input type="checkbox" name="brood">브루드 커피</label>
                            </li>
                            <li>
                                <label><input type="checkbox" name="espresso">에스프레소</label>
                            </li>
                            <li>
                                <label><input type="checkbox" name="frappuccino">프라푸치노</label>
                            </li>
                            <li>
                                <label><input type="checkbox" name="blended">블렌디드</label>
                            </li>
                            <li>
                                <label><input type="checkbox" name="figio">스타벅스 피지오</label>
                            </li>
                            <li>
                                <label><input type="checkbox" name="tea">티(티바나)</label>
                            </li>
                            <li>
                                <label><input type="checkbox" name="etc">기타 제조 음료</label>
                            </li>
                            <li>
                                <label><input type="checkbox" name="juice">스타벅스 주스(병음료)</label>
                            </li>
                        </ul>
                        <ul class="theme-list">
                            <li>
                                <a href="#"><img src="images/D001.jpg" alt="나이트로 바닐라 크림"></a>
                            </li>
                        </ul>
                    </form>
                </div>
            </div>
        </div>
        <%
        List<Category> category = new ArrayList<Category>();
        /* List<String> category = new ArrayList<String>();
        category.add("콜드 브루 커피");
        category.add("브루드 커피"); */
        
        //요청 속성얻기
        /*for(String categoryName: category){*/
        for(Category categoryName: category) {
        %>
        <input type="checkbox" name="<%=categoryName %>">
        <label><%=categoryName %></label>
        <%} %>
        
        <%
        List<Drink> list = (List)request.getAttribute("list");
        for(Drink d: list){
        %>
        
            <div class="drink">
                <input type="hidden" value="<%=d.category.category_no %>" />
                <div class="drink_category">
                    <div class="drink_category_select1">
                        <ul>
                            <li class="photo"><a href="#">사진으로 보기</a></li>
                            <li class="nutrition"><a href="#">영양정보로 보기</a></li>
                        </ul>
                    </div>
                    <div class="drink_category_select2">
                        <select>
                            <option>상세분류</option>
                            <option>신규 출시된 메뉴</option>
                            <option>한정기간 출시되는 시즌성 메뉴</option>
                        </select>
                    </div>
                </div>
                <div class="drink_info">
                    <span><%=d.category.category_name %></span><span>디카페인 에스프레소 샷 추가 가능 (일부 음료 제외)</span>
                </div>
                <ul>
                    <li class="drink_no"><img src="../images/<%=d.getDrink_no() %>.jpg" alt="<%=d.getDrink_name_kor() %>"></li>
                    <li class="drink_name_kor"><%=d.getDrink_name_kor() %></li>
                </ul>
            </div>
            <%}
        %>
        </div>
    </section>
    <footer>

    </footer>
</body>

</html>