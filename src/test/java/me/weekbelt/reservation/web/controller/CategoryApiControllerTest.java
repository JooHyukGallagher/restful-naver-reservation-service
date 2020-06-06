package me.weekbelt.reservation.web.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.responseHeaders;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.linkWithRel;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.links;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class CategoryApiControllerTest extends BasicControllerTest {

    @Autowired
    MockMvc mockMvc;

    @DisplayName("카테고리 목록 조회")
    @Test
    public void categoriesV1() throws Exception {

        FieldDescriptor[] categoryList = new FieldDescriptor[]{
                fieldWithPath("id").description("카테고리 식별 아이디"),
                fieldWithPath("name").description("카테고리 명"),
                fieldWithPath("count").description("카테고리에 해당하는 전시 상품 갯수")
        };

        String requestUri = "/api/v1/categories";
        mockMvc.perform(get(requestUri))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("category-list",
                        links(
                                linkWithRel("self").description("현재 링크"),
                                linkWithRel("exhibition-products").description("전시 상품 목록"),
                                linkWithRel("musical-products").description("뮤지컬 상품 목록"),
                                linkWithRel("concert-products").description("콘서트 상품 목록"),
                                linkWithRel("classic-products").description("클래식 상품 목록"),
                                linkWithRel("play-products").description("연극 상품 목록"),
                                linkWithRel("profile").description("카테고리목록 API 문서 링크")
                        ),
                        responseHeaders(
                                headerWithName(HttpHeaders.CONTENT_TYPE).description("Content-Type 헤더")
                        ),
                        responseFields(
                                fieldWithPath("_embedded.categoryDtoList").description("카테고리 목록"),
                                fieldWithPath("_links.self.href").description("현재 링크"),
                                fieldWithPath("_links.exhibition-products.href").description("전시 상품 목록"),
                                fieldWithPath("_links.musical-products.href").description("뮤지컬 상품 목록"),
                                fieldWithPath("_links.concert-products.href").description("콘서트 상품 목록"),
                                fieldWithPath("_links.classic-products.href").description("클래식 상품 목록"),
                                fieldWithPath("_links.play-products.href").description("연극 상품 목록"),
                                fieldWithPath("_links.profile.href").description("카테고리 목록 API 문서 링크")
                        ).andWithPrefix("_embedded.categoryDtoList[]", categoryList)));
    }
}