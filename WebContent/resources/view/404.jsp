<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!Doctype html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>404错误 - ${WEB_FOOTER_COPY}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>

        * {
            line-height: 1.7;
            margin: 0;
            box-sizing: border-box;
        }

        html {
            background-color: #f3f3f3;
            color: #888;
            display: table;
            font-family: Helvetica, "Helvetica Neue", Arial, sans-serif;
            height: 100%;
            width: 100%;
        }

        body {
            display: table-cell;
            vertical-align: middle;
            margin: 2em auto;
        }

        h1 {
            color: #555;
            font-size: 2em;
        }

        a {
            color: #06a;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }

        p, .p { margin: 10px 0 15px; }

        input, button {
            font-size: 16px;
            padding: 6px 10px;
            border: none;
            border-radius: 2px;
        }
        input {
            background-color: #f3f3f3;
            width: 60%;
        }
        button {
            min-width: 80px;
            background-color: #009a61;
            text-align: center;
            color: #fff;
            cursor: pointer;
        }
        button:hover,
        button:active {
            background-color: #008151;
        }

        .error { color: #d9534f; }
        .text-center { text-align: center; }

        .box {
            margin: 0 auto;
            padding: 40px;
            background-color: #fff;
            width: 540px;
        }

        .figure {
            float: right;
            line-height: 0;
        }
        .figure img {
            height: 200px;
        }

        .footer {
            margin: 15px 0 0;
            color: #999;
            text-transform: uppercase;
            font-size: 13px;
        }
        .footer a {
            color: #999;
        }

        @media only screen and (max-width: 480px) {

            .box {
                padding: 20px;
                width: 100%;
            }

            h1 {
                font-size: 1.5em;
                margin: 0 0 0.3em 0;
            }

            .figure {
                float: none;
            }

        }

        .clearfix:before,
        .clearfix:after {
            content: " ";
            display: table;
        }
        .clearfix:after {
            clear: both;
        }

    </style>
</head>
<body>
    <div class="box">
        <div class="clearfix">
            <div class="figure"><img src="${pageContext.request.contextPath}/resources/img/404.jpg" alt="维护中"></div>
    
            <h1>404</h1>

            <div class="p">
                <p>访问页面不存在</p>
                <p>任何疑问请联系网站管理员。</p>
            </div>

            <div class="p"><button type="button"      onclick="window.location.href='index.do'">返回首页</button></div>
        </div>
    </div>
    <div class="footer text-center">
        2017 &copy; <a href="index.do">${WEB_FOOTER_COPY}</a>
    </div>
 </div>
</body>
</html>
