package com.example.jooq.data.mappers;

import com.example.jooq.data.entity.Author;
import com.example.jooq.data.request.author.AuthorRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-22T08:39:45+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23 (Oracle Corporation)"
)
@Component
public class AuthorMapperImpl implements AuthorMapper {

    @Override
    public Author toEntity(AuthorRequest d) {
        if ( d == null ) {
            return null;
        }

        Author author = new Author();

        author.setName( d.getName() );
        author.setBirthYear( d.getBirthYear() );
        author.setNationality( d.getNationality() );

        return author;
    }

    @Override
    public List<Author> toListEntity(List<AuthorRequest> d) {
        if ( d == null ) {
            return null;
        }

        List<Author> list = new ArrayList<Author>( d.size() );
        for ( AuthorRequest authorRequest : d ) {
            list.add( toEntity( authorRequest ) );
        }

        return list;
    }

    @Override
    public AuthorRequest toDTO(Author e) {
        if ( e == null ) {
            return null;
        }

        AuthorRequest.AuthorRequestBuilder authorRequest = AuthorRequest.builder();

        authorRequest.name( e.getName() );
        authorRequest.birthYear( e.getBirthYear() );
        authorRequest.nationality( e.getNationality() );

        return authorRequest.build();
    }

    @Override
    public List<AuthorRequest> toListDTO(List<Author> e) {
        if ( e == null ) {
            return null;
        }

        List<AuthorRequest> list = new ArrayList<AuthorRequest>( e.size() );
        for ( Author author : e ) {
            list.add( toDTO( author ) );
        }

        return list;
    }
}
