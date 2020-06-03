package me.weekbelt.reservation.web.controller;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CategoryApiControllerTest extends BasicControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void categories() throws Exception {
        String requestUri = "/api/v1/categories";
        mockMvc.perform(get(requestUri))
                .andExpect(status().isOk())
                .andExpect(jsonPath("size").exists())
                .andExpect(jsonPath("items").exists());
    }
}