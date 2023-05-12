package com.cl.idesoft.controller;

import com.cl.idesoft.domain.Holiday;
import com.cl.idesoft.domain.HolidayList;
import com.cl.idesoft.service.HolidaysService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

public class HolidayControllerTest {

    private HolidayController holidayController;

    @Mock
    private HolidaysService holidaysService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        holidayController = new HolidayController(holidaysService);
    }

    @Test
    void testGetHolidays() {
        HolidayList holidayList=new HolidayList();
        List<Holiday> holidays = Arrays.asList(
                new Holiday("2023-01-01", "Año Nuevo", "Civil", true, "Civil e Irrenunciable"),
                new Holiday("2023-01-02", "Feriado Adicional", "Civil", false, "Civil")
        );
        holidayList.setData(holidays);
        when(holidaysService.getHolidays()).thenReturn(Flux.just(holidayList));
        Flux<HolidayList> result = holidayController.getHolidays();
        StepVerifier.create(result)
                .expectNext(new HolidayList())
                .expectComplete()
                .verify();
    }

    @Test
    void testGetHolidaysByType() {
        HolidayList holidayList=new HolidayList();
        List<Holiday> holidays = Arrays.asList(
                new Holiday("2023-01-01", "Año Nuevo", "Civil", true, "Civil e Irrenunciable"),
                new Holiday("2023-01-02", "Feriado Adicional", "Civil", false, "Civil")
           );
        holidayList.setData(holidays);

        when(holidaysService.getHolidays()).thenReturn(Flux.just(holidayList));

        Flux<HolidayList> result = holidayController.getHolidaysByType("Civil");

        StepVerifier.create(result)
                .expectNext(new HolidayList())
                .expectComplete()
                .verify();
    }
}