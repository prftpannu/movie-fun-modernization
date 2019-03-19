package org.superbiz.moviefun.albums;

import org.apache.tika.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.superbiz.moviefun.blobstore.Blob;
import org.superbiz.moviefun.blobstore.BlobStore;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.lang.String.format;

@RestController
@RequestMapping("/albums")
public class AlbumsController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private  AlbumsRepository albumsRepository;
    private final BlobStore blobStore;

    public AlbumsController(AlbumsRepository albumsRepository, BlobStore blobStore) {
        this.albumsRepository = albumsRepository;
        this.blobStore = blobStore;
    }


    @GetMapping
    public  List<Album> getAlbums() {
        return albumsRepository.getAlbums();

    }

    @GetMapping("/{id}")
    public Album thisAlbum(@PathVariable long id) {

        return albumsRepository.find(id);

    }

    @PostMapping
    public void addAlbum(@RequestBody Album album) {
        albumsRepository.addAlbum(album);
    }


}
