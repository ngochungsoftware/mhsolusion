package com.example.jooq.data.mappers;

import com.example.jooq.data.entity.Genre;
import com.example.jooq.data.request.genre.GenreRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-22T08:39:44+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23 (Oracle Corporation)"
)
@Component
public class GenreMapperImpl implements GenreMapper {

    @Override
    public Genre toEntity(GenreRequest d) {
        if ( d == null ) {
            return null;
        }

        Genre genre = new Genre();

        return genre;
    }

    @Override
    public List<Genre> toListEntity(List<GenreRequest> d) {
        if ( d == null ) {
            return null;
        }

        List<Genre> list = new ArrayList<Genre>( d.size() );
        for ( GenreRequest genreRequest : d ) {
            list.add( toEntity( genreRequest ) );
        }

        return list;
    }

    @Override
    public GenreRequest toDTO(Genre e) {
        if ( e == null ) {
            return null;
        }

        GenreRequest.GenreRequestBuilder genreRequest = GenreRequest.builder();

        return genreRequest.build();
    }

    @Override
    public List<GenreRequest> toListDTO(List<Genre> e) {
        if ( e == null ) {
            return null;
        }

        List<GenreRequest> list = new ArrayList<GenreRequest>( e.size() );
        for ( Genre genre : e ) {
            list.add( toDTO( genre ) );
        }

        return list;
    }
}
