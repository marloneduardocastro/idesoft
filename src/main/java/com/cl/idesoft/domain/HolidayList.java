package com.cl.idesoft.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class HolidayList {
    private String status;
    private List<Holiday> data;
}
