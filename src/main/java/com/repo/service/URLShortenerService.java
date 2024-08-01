package com.repo.service;

import com.repo.model.URL;

import java.util.List;

public interface URLShortenerService {
    /*public String getOriginalUrl(URL url);*/
    public URL generateShortURL(URL requestUrl);
    public List<URL> getURLs();
}
