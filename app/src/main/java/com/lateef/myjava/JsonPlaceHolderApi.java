package com.lateef.myjava;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<Post>> getPost();

    //to query post
    @GET("posts")
    Call<List<Post>> getQueryPost(@Query("userId") int userId);

    //to query post and sort it
    @GET("posts")
    Call<List<Post>> getQuery_sort_Post(
            @Query("userId") int userId,
            @Query("_sort") String sort,
            @Query("_order") String order
    );

    @GET("posts/2/comments")
    Call<List<Comment>> getComment();

    //to make put the id they want
    @GET("posts/{id}/comments")
    Call<List<Comment>> getUserComment(@Path("id") int postId);

    @GET
    Call<List<Comment>> getComment_url(@Url String url);

    @POST("posts")
    Call<Post> createPost(@Body Post post);

    //another way of sending post
    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPost_new(
            @Field("userId") int userId,
            @Field("title") String title,
            @Field("body") String text
    );

    // this update the own fields
    @PUT("posts/{id}")
    Call<Post> putPost(@Path("id") int id, @Body Post post);

    // passing header
    @Headers({"Static-Header1: 123", "Static-Header2: 456"})
    @PUT("posts/{id}")
    Call<Post> putPost_Header(@Header("Dynamic-Header") String header,
                       @Path("id") int id,
                       @Body Post post);

    // this update only the part u want to update
    @PATCH("posts/{id}")
    Call<Post> patchPost(@Path("id") int id, @Body Post post);


    @DELETE("posts/{id}")
    Call<Void> deletePost(@Path("id") int id);
}
