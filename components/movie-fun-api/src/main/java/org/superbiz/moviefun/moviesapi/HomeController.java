package org.superbiz.moviefun.moviesapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.superbiz.moviefun.albums.Album;
//import org.superbiz.moviefun.albums.AlbumFixtures;
//import org.superbiz.moviefun.albums.AlbumsBean;
import org.superbiz.moviefun.moviesapi.*;
//import org.superbiz.moviefun.movies.MoviesRepository;



import java.util.Map;

@Controller
public class HomeController {

  //  private final MoviesRepository moviesRepository;
    private final MoviesClient moviesClient;
   // private final AlbumsBean albumsBean;
   private final AlbumsClient albumsClient;
    private final MovieFixtures movieFixtures;
    private final AlbumFixtures albumFixtures;

 /*   public HomeController(MoviesRepository moviesRepository, AlbumsBean albumsBean, MovieFixtures movieFixtures, AlbumFixtures albumFixtures) {
        this.moviesRepository = moviesRepository;
        this.albumsBean = albumsBean;
        this.movieFixtures = movieFixtures;
        this.albumFixtures = albumFixtures;
    }*/
 public HomeController(MoviesClient moviesClient, AlbumsClient albumsClient, MovieFixtures movieFixtures, AlbumFixtures albumFixtures) {
     this.moviesClient = moviesClient;
     this.albumsClient = albumsClient;
     this.movieFixtures = movieFixtures;
     this.albumFixtures = albumFixtures;
 }

    @GetMapping("/")
    public String index() {
        return "index";
    }

/*    @GetMapping("/setup")
    public String setup(Map<String, Object> model) {
        for (MovieInfo movieInfo : movieFixtures.load()) {
            moviesRepository.addMovie(movieInfo);
        }

        for (Album album : albumFixtures.load()) {
            albumsBean.addAlbum(album);
        }

        model.put("movies", moviesRepository.getMovies());
        model.put("albums", albumsBean.getAlbums());

        return "setup";
    }*/

    @GetMapping("/setup")
    public String setup(Map<String, Object> model) {
        for (MovieInfo movieInfo : movieFixtures.load()) {
            moviesClient.addMovie(movieInfo);
        }

        for (AlbumInfo albumInfo : albumFixtures.load()) {
            albumsClient.addAlbum(albumInfo);
        }

        //model.put("movies", moviesRepository.getMovies());
        model.put("movies", moviesClient.getMovies());
        model.put("albums", albumsClient.getAlbums());

        return "setup";
    }
}
