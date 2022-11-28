package com.study.javabasic.service;

import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.study.javabasic.domain.BookDTO;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MongoService {
    private final MongoDatabase mongoDatabase;

    public void findAll() {
        MongoCursor<BookDTO> book = mongoDatabase.getCollection("book", BookDTO.class).find().iterator();

        while(book.hasNext()) {
            BookDTO bookDTO = book.next();
            System.out.println(bookDTO);
        }
    }

    public void insert() {
        Document document = new Document()
                .append("_id", new ObjectId())
                .append("name","park")
                .append("author","soo");

         mongoDatabase.getCollection("book").insertOne(document);
    }
}
