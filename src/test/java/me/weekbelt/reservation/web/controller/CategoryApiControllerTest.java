package me.weekbelt.reservation.web.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class CategoryApiControllerTest extends BasicControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void categoriesV1() throws Exception {
        String requestUri = "/api/v1/categories";
        mockMvc.perform(get(requestUri))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("size").exists())
                .andExpect(jsonPath("items").exists());
    }
//
//    @DisplayName("카테고리 목록 조회")
//    @Test
//    public void categoriesV2() throws Exception {
//        String requestUri = "/api/v2/categories";
//        mockMvc.perform(get(requestUri))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("size").exists())
//                .andExpect(jsonPath("items").exists())
//        .andExpect(header().exists(HttpHeaders.LOCATION))
//        .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaTypes.HAL_JSON_VALUE))
//        .andExpect(jsonPath("_link.self").exists())
////        .andExpect(jsonPath("_link.profile").exists()) TODO: 나중에
//        ;
//    }
}