package com.cl.idesoft.controller;
import com.cl.idesoft.domain.HolidayList;
import com.cl.idesoft.service.HolidaysService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@RestController
@RequestMapping("holiday")
public class HolidayController {

    private final HolidaysService holidaysService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<HolidayList> getHolidays() {
        return holidaysService.getHolidays();
    }

    @GetMapping(value = "/{type}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<HolidayList> getHolidaysByType(@PathVariable String type) {
        return holidaysService.getHolidays()
                .doOnNext(h -> {
                    h.getData().stream().filter(holiday -> holiday.getType().equals(type));
                });
    }
}