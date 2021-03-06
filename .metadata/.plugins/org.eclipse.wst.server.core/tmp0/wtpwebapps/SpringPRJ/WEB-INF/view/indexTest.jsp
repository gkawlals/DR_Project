<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>Title</title>

    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

<section id="container">


    <header id="header">
        <section class="inner">

            <h1 class="logo">
                <a href="index.html">
                    <div class="sprite_insta_icon"></div>
                    <div class="sprite_write_logo"></div>
                </a>
            </h1>

            <div class="search_box">
                <input type="text" placeholder="검색" id="search-field">

                <div class="fake_field">
                    <span class="sprite_small_search_icon"></span>
                    <span>검색</span>
                </div>
            </div>

            <div class="right_icons">
            
                <a href="/CircleMap/MapApi.do"><div class="sprite_compass_icon"></div></a>
         
                <a href="/user/MyPage.do"><div class="sprite_user_icon_outline"></div></a>
                
            </div>

        </section>

    </header>

    <section id="main_container">
        <div class="inner">

            <div class="contents_box">
                <article class="contents">
                    <header class="top">
                    
                        <div class="user_container">
                            <div class="profile_img">
                            <!-- Fiile 경로 불러와 -->
                                <img src="imgs/thumb.jpeg" alt="프로필이미지">
                            </div>
                            <!--  user_id or nicname  -->
                            <div class="user_name">
                                <div class="nick_name m_text">KindTiger</div>
                                <!-- 위치정보 가져올수 있으면 가져오기  -->
                                <div class="country s_text">Seoul, South Korea</div>
                            </div>

                        </div>

                        <div class="sprite_more_icon" data-name="more">
                            <ul class="toggle_box">
                                <a href="/Notice/NoticeDetail.do"><li>수정</li></a>
                                <a href="/Notice/NoticeDelete.do"><li>삭제</li></a>
                            </ul>
                        </div>
                        
                        
                    </header>
					<!-- 본인 게시판 사진 -->
                    <div class="img_section">
                        <div class="trans_inner">
                            <div><img src="imgs/img_section/img01.jpg" alt="visual01"></div>
                        </div>
                    </div>

                    <div class="bottom_icons">
                        <div class="left_icons">
                            <div class="heart_btn">
                                <div class="sprite_heart_icon_outline" name="39" data-name="heartbeat"></div>
                            </div>
                        </div>
                    </div>
					<!-- Like Count  -->
                    <div class="likes m_text">
                        좋아요
                        <span id="like-count-39">2,346</span>
                        <span id="bookmark-count-39"></span>
                        개
                    </div>
					<!-- 여기에 코멘트 대신 title(제목 넣기) -->
                    <div class="comment_container">
                        <div class="comment" id="comment-list-ajax-post37">
                            <div class="comment-detail">
                                <div class="nick_name m_text">dongdong2</div>
                                <div>강아지가 너무 귀여워요~!</div>
                            </div>
                        </div>
                    </div>
                    <!-- title div로 사용하기  -->
                    
                    
                    
                    <!-- 여기서 ajax or infinity scroll  -->
                </article>
                
            </div>
            <input type="hidden" id="page" value="1">

            <div class="side_box">
                <div class="user_profile">
                    <div class="profile_thumb">
                        <img src="imgs/thumb.jpeg" alt="프로필사진">
                    </div>
                    <div class="detail">
                        <div class="id m_text">KindTiger</div>
                        <div class="ko_name">심선범</div>
                    </div>
                </div>

                <article class="story">
                    <header class="story_header">
                        <div>스토리</div>
                        <div class="more">모두 보기</div>
                    </header>

                </article>
            </div>

        </div>
    </section>
</section>

<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="js/main.js"></script>
</body>
</html>