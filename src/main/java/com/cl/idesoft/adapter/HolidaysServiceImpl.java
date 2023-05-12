package com.cl.idesoft.adapter;

import com.cl.idesoft.domain.HolidayList;
import com.cl.idesoft.service.HolidaysService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Slf4j
@Service
public class HolidaysServiceImpl implements HolidaysService {

    @Value(value = "${adapter.host}")
    String baseHost;

    @Value("${adapter.host.holiday}")
    String holiday;

    WebClient webClient;

    @Override
    public Flux<HolidayList> getHolidays() {
        webClient = WebClient.builder()
                .baseUrl(baseHost)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.USER_AGENT, "Mozilla/5.0 Firefox/26.0")
                .build();
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(holiday)
                        .build()
                )
                .accept(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_XML)
                .retrieve()
                .bodyToFlux(HolidayList.class)
                .doOnError(error -> log.error("Error in LisboaResourcesServiceImpl.getVehicles() : {}", error.getMessage()));
    }
}
