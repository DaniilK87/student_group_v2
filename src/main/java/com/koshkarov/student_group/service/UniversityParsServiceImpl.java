package com.koshkarov.student_group.service;

import com.koshkarov.student_group.dto.UniversityInfoDto;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UniversityParsServiceImpl implements UniversityParsService {

    private final RestTemplate restTemplate;


    public UniversityParsServiceImpl (RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);
    }

    public List<UniversityInfoDto> getCountryInfo(String countryName) {
        String url = "http://universities.hipolabs.com/search?country=" + countryName;
        ResponseEntity<List<UniversityInfoDto>> rateResponse =
                restTemplate.exchange(url,
                        HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<UniversityInfoDto>>() {});
        List<UniversityInfoDto> list = rateResponse.getBody();
       return list;
    }

    @Override
    public List<UniversityInfoDto> getUniversityInfo(String universityName) {
        String url = "http://universities.hipolabs.com/search?name=" + universityName;
        ResponseEntity<List<UniversityInfoDto>> rateResponse =
                restTemplate.exchange(url,
                        HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<UniversityInfoDto>>() {});
        List<UniversityInfoDto> list = rateResponse.getBody();
        return list;
    }

}
