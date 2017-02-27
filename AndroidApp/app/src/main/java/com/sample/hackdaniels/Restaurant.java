package com.sample.hackdaniels;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User1 on 2/18/2017.
 */

public class Restaurant{


    /*public interface MoviesLoadedCallback {
        void moviesLoaded();
    }

    public static List<Restaurant> mMovies = new ArrayList<>();

    public static List<Restaurant> getLoadedMovies() {
        return mMovies;
    }

    public static void loadMovies() {
        loadMovies(null);
    }

    public static void loadMovies(MoviesLoadedCallback callback) {
        ParseQuery<Restaurant> movieQuery = new ParseQuery<>(Restaurant.class);
        movieQuery.findInBackground((result, error) -> {
            if (error == null) {
                mMovies = result;
                if (callback != null)
                    callback.moviesLoaded();
            } else {
                Log.wtf("Movie", "Loading movies returned an error from the Parse Server");
            }
        });
    }

    public String getName() {
        return getString("movieName");
    }

    public List<String> getCast() {
        return getList("cast");
    }

    public Date getReleaseDate() {
        return getDate("releaseDate");
    }

    public String getImageURL() {
        return getString("imageURL");
    }

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        return "Movie: {" + getName() + " (" + format.format(getReleaseDate()) + "), featuring " + getCast().get(0) + ".";
    }*/

}
