package net.imadness.abe.controllers;

import net.imadness.abe.services.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST-сервис, обслуживающий запросы, связанные с модификацией объектов типа {@code Author}
 */
@RestController
public class AuthorRestService {

    @Autowired
    private AuthorService authorService;

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorRestService.class);


}
