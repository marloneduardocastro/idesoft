package com.cl.idesoft.domain;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Holiday {
    private String date;
    private String title;
    private String type;
    private boolean inalienable;
    private String extra;
}
