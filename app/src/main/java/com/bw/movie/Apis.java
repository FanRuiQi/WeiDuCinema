package com.bw.movie;

/**
 * Author: 范瑞旗
 * Date: 2019/1/24 14:33
 * Description: 全局接口类
 */
public class Apis {


    //登录           - <通用>
    public static final String URL_LOGIN="user/v1/login";
    //注册
    public static final String URL_REGISTER="user/v1/registerUser";

    //查询推荐影院信息 - <影院>
    public static final String UEL_FIND_RECOMMEND_CINEMAS="cinema/v1/findRecommendCinemas?page=1&count=10";
    //查询附近影院
    public static final String UEL_FIND_NEARLY_CINEMAS="cinema/v1/findNearbyCinemas";
    //关注影院
    public static final String UEL_FOLLOW_CINEMA="cinema/v1/verify/followCinema?cinemaId=%s";
    //取消关注影院
    public static final String UEL_CANCEL_FOLLOW_CINEMA="cinema/v1/verify/cancelFollowCinema?cinemaId=%s";
    //查询电影信息明细
    public static final String URL_FIND_CINEMA_INFO="cinema/v1/findCinemaInfo?cinemaId=%s";
    //根据影院ID查询该影院当前排期的电影列表
    public static final String URL_FIND_MOVIE_LIST="movie/v1/findMovieListByCinemaId?cinemaId=%s";
    //根据电影ID和影院ID查询电影排期列表
    public static final String URL_FIND_MOVIE_SCHEDULE_LIST="movie/v1/findMovieScheduleList?cinemasId=%s&movieId=%s";
    //影院评论
    public static final String URL_CINEMA_COMMENT="cinema/v1/verify/cinemaComment";



}
