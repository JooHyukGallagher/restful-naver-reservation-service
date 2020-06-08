package me.weekbelt.reservation.web.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.linkWithRel;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.links;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class DisplayInfoApiControllerTest extends BasicControllerTest {

    @Autowired
    MockMvc mockMvc;

    @DisplayName("상품 상세 정보 페이지 조회")
    @Test
    public void product_list() throws Exception {

        FieldDescriptor[] productImages = new FieldDescriptor[]{
                fieldWithPath("productId").description("상품 식별 아이디"),
                fieldWithPath("productImageId").description("상품 이미지 식별 아이디"),
                fieldWithPath("type").description("상품 이미지 타입(썸네일, 메인)"),
                fieldWithPath("fileInfoId").description("이미지 파일 식별 아이디"),
                fieldWithPath("fileName").description("이미지 파일 이름"),
                fieldWithPath("saveFileName").description("이미지 파일 경로"),
                fieldWithPath("contentType").description("이미지 타입(png, jpeg, jpg)"),
                fieldWithPath("deleteFlag").description("이미지 삭제 여부"),
                fieldWithPath("createDate").description("이미지 생성 시간"),
                fieldWithPath("modifyDate").description("이미지 수정 시간")
        };

        FieldDescriptor[] displayInfoImages = new FieldDescriptor[]{
                fieldWithPath("id").description("전시 정보 이미지 식별 아이디"),
                fieldWithPath("displayInfoId").description("전시 정보 식별 아이디"),
                fieldWithPath("fileId").description("이미지 식별 아이디"),
                fieldWithPath("fileName").description("이미지 이름"),
                fieldWithPath("saveFileName").description("이미지 경로"),
                fieldWithPath("contentType").description("이미지 타입(png, jpeg, jpg)"),
                fieldWithPath("deleteFlag").description("이미지 삭제 여부"),
                fieldWithPath("createDate").description("이미지 생성 시간"),
                fieldWithPath("modifyDate").description("이미지 수정 시간")
        };

        FieldDescriptor[] productPrices = new FieldDescriptor[]{
                fieldWithPath("id").description("상품 가격 식별 아이디"),
                fieldWithPath("productId").description("상품 식별 아이디"),
                fieldWithPath("priceTypeName").description("상품 가격 타입 이름"),
                fieldWithPath("price").description("상품 가격"),
                fieldWithPath("discountRate").description("상품 가격 할인률"),
                fieldWithPath("createDate").description("상품 가격 생성일"),
                fieldWithPath("modifyDate").description("상품 가격 수정일")
        };

        String requestUri = "/api/v1/displayinfos/{displayInfoId}";
        mockMvc.perform(get(requestUri, 1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("product-displayinfo",
                        links(
                                linkWithRel("self").description("현재 상품 전시 정보 링크"),
                                linkWithRel("product-list").description("상품 리스트"),
                                linkWithRel("profile").description("상품 조회 API 문서 링크")
                        ),
                        responseFields(
                                fieldWithPath("product.id").description("상품 식별자 아이디"),
                                fieldWithPath("product.categoryId").description("카테고리 식별자 아이디"),
                                fieldWithPath("product.displayInfoId").description("전시 정보 식별자 아이디"),
                                fieldWithPath("product.name").description("카테고리명"),
                                fieldWithPath("product.description").description("상품 설명"),
                                fieldWithPath("product.content").description("상품 상세 설명"),
                                fieldWithPath("product.event").description("이벤트"),
                                fieldWithPath("product.openingHours").description("오픈 시간"),
                                fieldWithPath("product.placeName").description("장소 이름"),
                                fieldWithPath("product.placeLot").description("상세 위치"),
                                fieldWithPath("product.placeStreet").description("상세 위치"),
                                fieldWithPath("product.tel").description("전화번호"),
                                fieldWithPath("product.homepage").description("홈페이지"),
                                fieldWithPath("product.email").description("이메일"),
                                fieldWithPath("product.createDate").description("생성 날짜"),
                                fieldWithPath("product.modifyDate").description("수정 날짜"),
                                fieldWithPath("product.fileId").description("상품 이미지 식별 아이디"),
                                fieldWithPath("productImages").description("상품 이미지 목록"),
                                fieldWithPath("displayInfoImages").description("전시 정보 이미지 목록"),
                                fieldWithPath("avgScore").description("상품 리뷰 전체 평점"),
                                fieldWithPath("productPrices").description("상품 가격 종류"),
                                fieldWithPath("_links.self.href").description("현재 상품 상세정보 링크"),
                                fieldWithPath("_links.product-list.href").description("상품 목록 페이지 링크"),
                                fieldWithPath("_links.profile.href").description("상품 조회 API 문서 링크"))
                                .andWithPrefix("productImages[].", productImages)
                                .andWithPrefix("displayInfoImages[].", displayInfoImages)
                                .andWithPrefix("productPrices[].", productPrices)
                ));
    }
}