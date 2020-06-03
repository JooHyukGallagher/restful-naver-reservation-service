package me.weekbelt.reservation.web.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ProductApiControllerTest extends BasicControllerTest {

    @Autowired
    MockMvc mockMvc;

    @DisplayName("전시 상품 목록을 4개씩 두번째 페이지 조회")
    @Test
    public void getProducts() throws Exception {
        String requestUri = "/api/v2/displayinfos";
        mockMvc.perform(get(requestUri)
//        .param("categoryId", "1") TODO: categoryId가 있는 경우, 아닌경우, 0인경우
                .param("page", "1")
                .param("size", "4"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("page").exists())
                .andExpect(jsonPath("_embedded.productDtoList[0]._links.self").exists())
                .andExpect(jsonPath("_links.self").exists())
//                .andExpect(jsonPath("_embedded._links.profile").exists())
        .andDo(document("product-list"))
        ;
    }

}