package com.cl.idesoft.service;

import com.cl.idesoft.domain.Holiday;
import com.cl.idesoft.domain.HolidayList;
import reactor.core.publisher.Flux;

public interface HolidaysService {
    Flux<HolidayList> getHolidays();
}
