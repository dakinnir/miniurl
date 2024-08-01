package com.repo.service;

import com.repo.model.URL;
import com.repo.repository.URLShortenerRepository;
import com.repo.utils.URLShortenerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class URLShortenerServiceImplementation implements URLShortenerService {
    /*@Override
    public String getOriginalUrl(URL url) {
        return null;
    }*/
    @Autowired
    private URLShortenerRepository urlShortenerRepository;

    /**
     *
     * @param urlObject - Url from the request json object
     * @return url - The shortened url with the short code for short url
     */
    @Override
    public URL generateShortURL(URL urlObject) {
        Optional<URL> existingUrl = urlShortenerRepository.findByOriginalUrl(urlObject.getOriginalUrl());
        if (existingUrl.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "URL already exist");
        }

        // logic to generate short code for shortened url
        String shortCode = URLShortenerUtils.generateShortCode(6);
        urlObject.setShortCode(shortCode);
        return urlShortenerRepository.save(urlObject);
    }

    /**
     *
     * @return List<URL> - Urls found in the db
     */
    @Override
    public List<URL> getURLs() {
        return urlShortenerRepository.findAll();
    }

}
