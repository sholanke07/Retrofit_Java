package com.lateef.myjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;
    JsonPlaceHolderApi jsonPlaceHolderApi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.text_view_result);

        jsonPlaceHolderApi = RetrofitInstance.getClient().create(JsonPlaceHolderApi.class);

       // getPosts();

        //getQueryPosts();

       // getComments();

       // getUserListComments();

        //createPost();
        //createPost_UrlEncoded();

        updatePost_put();

        //updatePost_patch();

        //deletePost();

        //updatePost_put_header();



    }

    private void getPosts(){

        Call<List<Post>> call = jsonPlaceHolderApi.getPost();


        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()){
                    textViewResult.setText("Code: " + response.code());
                }
                List<Post> posts = response.body();
                for (Post post : posts){
                    String content = "";
                    content +="ID: " + post.getId() + "\n";
                    content +="User ID: " + post.getUserId() + "\n";
                    content +="Title: " + post.getTitle() + "\n";
                    content +="Text: " + post.getText() + "\n\n";

                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textViewResult.setText(t.getMessage());

            }
        });
    }

    private void getQueryPosts(){

        Call<List<Post>> call = jsonPlaceHolderApi.getQueryPost(4);


        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()){
                    textViewResult.setText("Code: " + response.code());
                }
                List<Post> posts = response.body();
                for (Post post : posts){
                    String content = "";
                    content +="ID: " + post.getId() + "\n";
                    content +="User ID: " + post.getUserId() + "\n";
                    content +="Title: " + post.getTitle() + "\n";
                    content +="Text: " + post.getText() + "\n\n";

                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textViewResult.setText(t.getMessage());

            }
        });
    }

    private void getQuery_sort_Posts(){

        Call<List<Post>> call = jsonPlaceHolderApi.getQuery_sort_Post(4, "id", "desc");


        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()){
                    textViewResult.setText("Code: " + response.code());
                }
                List<Post> posts = response.body();
                for (Post post : posts){
                    String content = "";
                    content +="ID: " + post.getId() + "\n";
                    content +="User ID: " + post.getUserId() + "\n";
                    content +="Title: " + post.getTitle() + "\n";
                    content +="Text: " + post.getText() + "\n\n";

                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textViewResult.setText(t.getMessage());

            }
        });
    }

    private void getComments(){
        Call<List<Comment>> call = jsonPlaceHolderApi.getComment();

        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if (!response.isSuccessful()){
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Comment> comments = response.body();
                for (Comment comment : comments){
                    String content = "";
                    content +="ID: " + comment.getId() + "\n";
                    content +="Post ID: " + comment.getPostId() + "\n";
                    content +="Name: " + comment.getName() + "\n";
                    content +="Email: " + comment.getEmail() + "\n";
                    content +="Text: " + comment.getText() + "\n\n";

                    textViewResult.append(content);
                }

            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }

    private void getComment_Url(){
        Call<List<Comment>> call = jsonPlaceHolderApi.getComment_url("posts/3/comments");

        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if (!response.isSuccessful()){
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Comment> comments = response.body();
                for (Comment comment : comments){
                    String content = "";
                    content +="ID: " + comment.getId() + "\n";
                    content +="Post ID: " + comment.getPostId() + "\n";
                    content +="Name: " + comment.getName() + "\n";
                    content +="Email: " + comment.getEmail() + "\n";
                    content +="Text: " + comment.getText() + "\n\n";

                    textViewResult.append(content);
                }

            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }

    private void getUserListComments(){
        Call<List<Comment>> call = jsonPlaceHolderApi.getUserComment(3);

        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if (!response.isSuccessful()){
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Comment> comments = response.body();
                for (Comment comment : comments){
                    String content = "";
                    content +="ID: " + comment.getId() + "\n";
                    content +="Post ID: " + comment.getPostId() + "\n";
                    content +="Name: " + comment.getName() + "\n";
                    content +="Email: " + comment.getEmail() + "\n";
                    content +="Text: " + comment.getText() + "\n\n";

                    textViewResult.append(content);
                }

            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }
    private void createPost(){
        Post post = new Post(23, "new title", "new text");

        Call<Post> call = jsonPlaceHolderApi.createPost(post);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()){
                    textViewResult.setText("Code: " + response.code());
                    return;
                }
                Post postResponse = response.body();
                String content = "";
                content +="Code: " + response.code() + "\n";
                content +="ID: " + postResponse.getId() + "\n";
                content +="Post ID: " + postResponse.getUserId() + "\n";
                content +="Name: " + postResponse.getTitle() + "\n";
                content +="Text: " + postResponse.getText() + "\n\n";

                textViewResult.setText(content);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }

    private void createPost_UrlEncoded(){

        Call<Post> call = jsonPlaceHolderApi.createPost_new(24, "text title", "text body");
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()){
                    textViewResult.setText("Code: " + response.code());
                    return;
                }
                Post postResponse = response.body();
                String content = "";
                content +="Code: " + response.code() + "\n";
                content +="ID: " + postResponse.getId() + "\n";
                content +="Post ID: " + postResponse.getUserId() + "\n";
                content +="Name: " + postResponse.getTitle() + "\n";
                content +="Text: " + postResponse.getText() + "\n\n";

                textViewResult.setText(content);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }

    private void updatePost_put(){
        Post post = new Post(12, null, "new text");

        Call<Post> call = jsonPlaceHolderApi.putPost(5, post);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()){
                    textViewResult.setText("Code: " + response.code());
                    return;
                }
                Post postResponse = response.body();
                String content = "";
                content +="Code: " + response.code() + "\n";
                content +="ID: " + postResponse.getId() + "\n";
                content +="User ID: " + postResponse.getUserId() + "\n";
                content +="Title: " + postResponse.getTitle() + "\n";
                content +="Text: " + postResponse.getText() + "\n\n";

                textViewResult.setText(content);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }

    private void updatePost_patch(){
        Post post = new Post(12, null, "new text");

        Call<Post> call = jsonPlaceHolderApi.patchPost(5, post);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()){
                    textViewResult.setText("Code: " + response.code());
                    return;
                }
                Post postResponse = response.body();
                String content = "";
                content +="Code: " + response.code() + "\n";
                content +="ID: " + postResponse.getId() + "\n";
                content +="User ID: " + postResponse.getUserId() + "\n";
                content +="Title: " + postResponse.getTitle() + "\n";
                content +="Text: " + postResponse.getText() + "\n\n";

                textViewResult.setText(content);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }

    private void updatePost_put_header(){
        Post post = new Post(12, null, "new text");

        Call<Post> call = jsonPlaceHolderApi.putPost_Header( "abc",5, post);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()){
                    textViewResult.setText("Code: " + response.code());
                    return;
                }
                Post postResponse = response.body();
                String content = "";
                content +="Code: " + response.code() + "\n";
                content +="ID: " + postResponse.getId() + "\n";
                content +="User ID: " + postResponse.getUserId() + "\n";
                content +="Title: " + postResponse.getTitle() + "\n";
                content +="Text: " + postResponse.getText() + "\n\n";

                textViewResult.setText(content);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }

    private void deletePost(){
        Call<Void> call = jsonPlaceHolderApi.deletePost(5);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                textViewResult.setText("Code: " + response.code());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                textViewResult.setText(t.getMessage());

            }
        });
    }


}