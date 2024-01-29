package br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.dto.request;

import lombok.Getter;

@Getter
public class WatchVideoRequest {

    private String userEmail;
    private String videoTitle;
}
