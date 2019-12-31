package com.nabeeltech.retrofitrestapi.Controller;

import com.nabeeltech.retrofitrestapi.Model.Comment;
import com.nabeeltech.retrofitrestapi.Model.Post;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface JsonPlaceHolderApi
{
//    //this is a get method for posts
//    @GET("posts")
//    Call<List<Post>> getPosts();


    //this is a get method for posts where userid = 4
//    @GET("posts")
//    Call<List<Post>> getPosts(@Query("userId") int userId);


    //get post where user=1&_sort=id&_order=desc

    @GET("posts")
    Call<List<Post>> getPosts(
            @Query("userId") Integer[] userId, //if you dont want to pass int userId you can make data type Integer userId if multiple userId then Integer[] or Integer....
            @Query("_sort") String sort,
            @Query("_order") String order
    );


    //this is to retreive all comments of post id 2
//    @GET("posts/2/comments")
//    Call<List<Comment>> getComments();

//    @GET("posts/{id}/comments")
//    Call<List<Comment>> getComments(@Path("id") int postId);


    //we want to get posts but we would like to pass paramaeters when we call the api not static type here
    //we will use query map
    @GET("posts")
    Call<List<Post>> getPosts(@QueryMap Map<String, String> parameters);

    //we can directly call via URL
    @GET
    Call<List<Comment>> getComments(@Url String url);

    //post data to server
//    @POST("posts")
//    Call<Post> createPost(@Body Post post);


    //send via form url encoded in kay and value pairs
//    @FormUrlEncoded
//    @POST("posts")
//    Call<Post> createPost(
//            @Field("userId") int userId,
//            @Field("title") String title,
//            @Field("body") String text
//    );

    //we can use query map as well
    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPost(@FieldMap Map<String, String> fields);


    //put method
    @PUT("posts/{id}")
    Call<Post> putPost(@Path("id") int id, @Body Post post);

    //patch method
    @PATCH("posts/{id}")
    Call<Post> patchPost(@Path("id") int id, @Body Post post);

    //delete method
    @DELETE("posts/{id}")
    Call<Void> deletePost(@Path("id") int id);


}
