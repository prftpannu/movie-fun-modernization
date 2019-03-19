package org.superbiz.moviefun.moviesapi;

import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Arrays.asList;

@Component
public class MovieFixtures {

    public List<MovieInfo> load() {
        return asList(
            new MovieInfo("Wedding Crashers", "David Dobkin",7,  "Comedy",  2005),
            new MovieInfo("Starsky & Hutch", "Todd Phillips",6, "Action",  2004),
            new MovieInfo("Shanghai Knights", "David Dobkin", 6, "Action",  2003),
            new MovieInfo("I-Spy", "Betty Thomas", 5,"Adventure",  2002),
            new MovieInfo("The Royal Tenenbaums", "Wes Anderson", 8,"Comedy",  2001),
            new MovieInfo("Zoolander", "Ben Stiller",6, "Comedy",  2001),
            new MovieInfo("Shanghai Noon", "Tom Dey", 7, "Comedy",  2000)
        );
    }
}
