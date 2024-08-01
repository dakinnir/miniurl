package com.repo.controller;

import com.repo.model.URL;
import com.repo.service.URLShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class URLShortenerController {

    @Autowired
    private URLShortenerService urlShortenerService;

    /**
     *
     * @param requestUrl - Used to serialize the request object
     * @return ResponseEntity<URL> - Response object of the shortened url
     */
    @PostMapping("/shorten")
    public ResponseEntity<URL> createShortUrl(@RequestBody URL requestUrl) {
        URL generatedURL  = urlShortenerService.generateShortURL(requestUrl);
        return new ResponseEntity<>(generatedURL, HttpStatus.CREATED);
    }

    /**
     *
     * @return ResponseEntity<List<URL>> - List of shortened urls
     */
    @GetMapping("/")
    public ResponseEntity<List<URL>> getShortenedURLs() {
        return new ResponseEntity<>(urlShortenerService.getURLs(), HttpStatus.OK);
    }

}
