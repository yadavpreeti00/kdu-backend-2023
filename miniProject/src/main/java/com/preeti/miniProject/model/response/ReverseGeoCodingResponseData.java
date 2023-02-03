package com.preeti.miniProject.model.response;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@Data
public class ReverseGeoCodingResponseData {
    private List<GeoCodingResponse> data=new ArrayList<>();
}
