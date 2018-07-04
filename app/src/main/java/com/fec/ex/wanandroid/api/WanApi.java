package com.fec.ex.wanandroid.api;

import com.fec.ex.wanandroid.base.BaseBean;
import com.fec.ex.wanandroid.settings.collection.ArticleList;
import com.fec.ex.wanandroid.hierarchy.domain.KnowledgeArticleList;
import com.fec.ex.wanandroid.hierarchy.domain.KnowledgeTree;
import com.fec.ex.wanandroid.login.domain.Login;
import com.fec.ex.wanandroid.main.domain.Friend;
import com.fec.ex.wanandroid.main.domain.HotKey;
import com.fec.ex.wanandroid.main.domain.MainArticleList;
import com.fec.ex.wanandroid.main.domain.Banner;
import com.fec.ex.wanandroid.settings.navigation.Navigation;
import com.fec.ex.wanandroid.project.domain.ProjectList;
import com.fec.ex.wanandroid.project.domain.ProjectTree;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Fe2Cu on 06.29.2018
 * github: https://www.github.com/fectung
 * Email : fectong@live.com
 */
public interface WanApi {
    // Base URL: http://www.wanandroid.com/

    /**
     * 获取首页文章列表
     * http://www.wanandroid.com/article/list/0/json
     * @param page 页码，拼接在连接中，从0开始
     * @return
     */
    @GET("article/list/{page}/json")
    Observable<BaseBean<MainArticleList>> getMainArticleList(
        @Path("page") int page
    );

    /**
     * 获取首页Banner
     * http://www.wanandroid.com/banner/json
     * @return
     */
    @GET("banner/json")
    Observable<BaseBean<List<Banner>>> getBanner();

    /**
     * 获取常用网站列表
     * http://www.wanandroid.com/friend/json
     * @return
     */
    @GET("friend/json")
    Observable<BaseBean<List<Friend>>> getFriendList();

    /**
     * 获取搜索热词
     * http://www.wanandroid.com//hotkey/json
     * @return
     */
    @GET("hotkey/json")
    @Headers("Cache-Control: public, max-age=36000")
    Observable<BaseBean<List<HotKey>>> getHotKey();

    /**
     * 获取知识体系数据树
     * http://www.wanandroid.com/tree/json
     * @return
     */
    @GET("tree/json")
    Observable<BaseBean<List<KnowledgeTree>>> getKnowledgeTree();

    /**
     * 获取知识体系下的文章
     * http://www.wanandroid.com/article/list/0/json?cid=60
     * @param page 拼接在链接上，从0开始
     * @param cid 分类的id，上述二级目录的id
     * @return
     */
    @GET("article/list/{page}/json")
    Observable<BaseBean<KnowledgeArticleList>> getKnowledgeArticleList(
        @Path("page") int page,
        @Query("cid") int cid
    );

    /**
     * 获取导航数据
     * http://www.wanandroid.com/navi/json
     * @return
     */
    @GET("navi/json")
    Observable<BaseBean<List<Navigation>>> getNavigation();

    /**
     * 获取项目分类树
     * http://www.wanandroid.com/project/tree/json
     * @return
     */
    @GET("project/tree/json")
    Observable<BaseBean<List<ProjectTree>>> getProjectTree();

    /**
     * 获取项目列表数据
     * http://www.wanandroid.com/project/list/1/json?cid=294
     * @param page 拼接在链接中，从1开始
     * @param cid 分类的id，上面项目分类接口
     * @return
     */
    @GET("project/list/{page}/json")
    Observable<BaseBean<ProjectList>> getProjectList(
        @Path("page") int page,
        @Query("cid") int cid
    );


    /**
     * 登陆
     * http://www.wanandroid.com/user/login
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @POST("/user/login")
    @FormUrlEncoded
    Observable<BaseBean<Login>> login(
        @Field("username") String username,
        @Field("password") String password
    );

    /**
     * 注册
     * http://www.wanandroid.com/user/register
     * @param username 用户名
     * @param password 密码
     * @param repassword 重复密码
     * @return
     */
    @POST("user/register")
    @FormUrlEncoded
    Observable<BaseBean<Login>> register(
        @Field("username") String username,
        @Field("password") String password,
        @Field("repassword") String repassword
    );

    /**
     * 获取收藏列表
     * http://www.wanandroid.com/lg/collect/list/0/json
     * @param page 拼接在链接中，从0开始
     * @return
     */
    @GET("lg/collect/list/{page}/json")
    Observable<BaseBean<ArticleList>> getCollectionList(
        @Path("page") int page
    );

    /**
     * 收藏站内文章
     * http://www.wanandroid.com/lg/collect/1165/json
     * @param id 文章id，拼接在链接中
     * @return
     */
    @POST("lg/collect/{id}/json")
    Observable<BaseBean<ArticleList>> addCollectionById(
        @Path("id") int id
    );

    /**
     * 收藏站外文章
     * http://www.wanandroid.com/lg/collect/add/json
     * @param title 标题
     * @param author 作者
     * @param link 链接
     * @return
     */
    @POST("lg/collect/add/json")
    Observable<BaseBean<ArticleList>> addCollectionBySite(
        @Query("title") String title,
        @Query("author") String author,
        @Query("link") String link
    );

    /**
     * 取消收藏: 根据文章id, bean.getData().getDatas().get(x).getId()
     * http://www.wanandroid.com/lg/uncollect_originId/2333/json
     * @param id 拼接在链接上
     * @param originId origin id
     * @return
     */
    @POST("lg/uncollect_originId/{id}/json")
    @FormUrlEncoded
    Observable<BaseBean<ArticleList>> cancelCollection (
        @Path("id") int id,
        @Field("originId") int originId
    );

    /**
     * 移除收藏: 根据收藏列表的id和originId
     * bean.getData().getDatas().get(x).getId()
     * bean.getData().getDatas().get(x).getId()
     * http://www.wanandroid.com/lg/uncollect/2805/json
     * @param id origin id
     * @return
     */
    @POST("lg/uncollect/{id}/json")
    @FormUrlEncoded
    Observable<BaseBean<ArticleList>> removeCollection (
            @Path("id") int id,
            @Field("originId") int originId
    );

    /**
     * 搜索
     * http://www.wanandroid.com/article/query/0/json
     * @param page 拼接在链接上，从0开始
     * @param k 搜索关键词
     * @return
     */
    @POST("article/query/{page}/json")
    @FormUrlEncoded
    Observable<BaseBean<ArticleList>> getSearchList(
        @Path("page") int page,
        @Field("k") String k
    );
}
