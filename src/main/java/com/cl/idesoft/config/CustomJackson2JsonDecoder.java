package com.cl.idesoft.config;

import org.springframework.core.ResolvableType;
import org.springframework.http.MediaType;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.util.MimeType;

import java.util.List;

public class CustomJackson2JsonDecoder extends Jackson2JsonDecoder {
    public CustomJackson2JsonDecoder() {
        super();
    }

    @Override
    public List<MimeType> getDecodableMimeTypes() {
        return List.of(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML);
    }

    @Override
    public boolean canDecode(ResolvableType elementType, MimeType mimeType) {
        return super.canDecode(elementType, mimeType) ||
                mimeType.equals(MediaType.APPLICATION_JSON) ||
                mimeType.equals(MediaType.APPLICATION_XML);
    }

}