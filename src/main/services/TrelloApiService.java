package services;

import pojoClasses.models.Board;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TrelloApiService {
    @POST("boards")
    Call<Board> createBoard (
            @Query("key") String key,
            @Query("token") String token,
            @Body Board board
    );

    @GET("boards/{id}")
    Call<Board> getBoard (
            @Path("id") String id,
            @Query("key") String key,
            @Query("token") String token
    );

    @PUT("boards/{id}")
    Call<Board> updateBoard (
            @Path("id") String id,
            @Query("key") String key,
            @Query("token") String token,
            @Body Board board
    );

    @DELETE("boards/{id}")
    Call<Void> deleteBoard (
            @Path("id") String id,
            @Query("key") String key,
            @Query("token") String token
    );
}