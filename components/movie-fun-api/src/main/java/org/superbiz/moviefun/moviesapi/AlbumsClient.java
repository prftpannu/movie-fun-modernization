package org.superbiz.moviefun.moviesapi;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestOperations;
import org.superbiz.moviefun.moviesapi.AlbumInfo;
import org.springframework.http.HttpMethod.*;

import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import org.springframework.core.ParameterizedTypeReference;
import java.util.List;

import static org.springframework.http.HttpMethod.GET;

public class AlbumsClient {

    private String albumsUrl;
    private RestOperations restOperations;


    public AlbumsClient(String albumsUrl, RestOperations restOperations) {
        this.albumsUrl = albumsUrl;
        this.restOperations = restOperations;
    }

    public void addAlbum(AlbumInfo albumsInfo) {
        restOperations.postForEntity(albumsUrl, albumsInfo, AlbumInfo.class);
    }

    public AlbumInfo find(long id){

        return restOperations.getForEntity(albumsUrl+"/"+ id, AlbumInfo.class).getBody();
    }


   public List<AlbumInfo> getAlbums(){

       ParameterizedTypeReference<List<AlbumInfo>>  albumList =  new ParameterizedTypeReference<List<AlbumInfo>>() {
       };
       return restOperations.exchange(albumsUrl, GET, null, albumList).getBody();
   }


}
