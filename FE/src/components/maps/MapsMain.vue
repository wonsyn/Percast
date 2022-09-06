<template>
    <!-- 
        MT1 대형마트
        CS2 편의점
        PS3 어린이집, 유치원
        SC4 학교
        AC5 학원
        PK6 주차장
        OL7 주유소, 충전소
        SW8 지하철역
        BK9 은행
        CT1 문화시설
        AG2 중개업소
        PO3 공공기관
        AT4 관광명소
        AD5 숙박
        FD6 음식점
        CE7 카페
        HP8 병원
        PM9 약국 
    -->
    <div id="container">
        <div id="rvWrapper">
            <div id="roadview" style="width: 100%; height: 100%"></div>
            <!-- 로드뷰를 표시할 div 입니다 -->
            <div id="close" title="로드뷰닫기" @click="closeRoadview()">
                <span class="img"></span>
            </div>
        </div>
        <div id="mapWrapper" class="map_wrap">
            <div id="map" style="width: 100%; height: 100%; position: relative; overflow: hidden"></div>
            <!-- 지도를 표시할 div 입니다 -->
            <ul id="category">
                <li id="HP8" data-order="0" @click="onClickCategory('HP8', 0)" :class="classname[0]">
                    <span class="category_bg hospital"></span>
                    병원
                </li>
                <li id="PM9" data-order="1" @click="onClickCategory('PM9', 1)" :class="classname[1]">
                    <span class="category_bg pharmacy"></span>
                    약국
                </li>
            </ul>
            <div id="roadviewControl" @click="setRoadviewRoad()"></div>
        </div>
        <b-container id="menu_wrap" class="bg_white">
            <house-list />
        </b-container>
    </div>
</template>

<script>
import { useStore } from "vuex";

export default {
setup() {
const store = useStore();

return { store };
},
data() {
return {
classname: ["", "", "", "", ""],
markers2: [],
markers: [],
marker: null,
infowindow: null,
point: {},
ps: null,
map: null,
roadview: null,
roadviewClient: null,
roadviewContainer: null,
container: null,
overlayOn: true,
openinfo: false,
currCategory: null,
className: "",
info: null,
};
},

}
</script>

<style>
#container {
    overflow: hidden;
    height: 800px;
    position: relative;
}

.map_wrap,
.map_wrap * {
    margin: 0;
    padding: 0;
    font-family: "Malgun Gothic", dotum, "돋움", sans-serif;
    font-size: 12px;
}

.map_wrap {
    position: relative;
    width: 100%;
    height: 350px;
}

#mapWrapper {
    width: 100%;
    height: 800px;
}

#rvWrapper {
    width: 50%;
    height: 800px;
    top: 0;
    right: 0;
    position: absolute;
}

#container.view_roadview #mapWrapper {
    width: 50%;
}

#roadviewControl {
    position: absolute;
    top: 10px;
    left: 120px;
    width: 52px;
    height: 52px;
    z-index: 1;
    cursor: pointer;
    background: url(https://t1.daumcdn.net/localimg/localimages/07/2018/pc/common/img_search.png) 0 -450px no-repeat;
}

#roadviewControl.active {
    background-position: 0 -350px;
}

#close {
    position: absolute;
    padding: 4px;
    top: 5px;
    left: 5px;
    cursor: pointer;
    background: #fff;
    border-radius: 4px;
    border: 1px solid #c8c8c8;
    box-shadow: 0px 1px #888;
}

#close .img {
    display: block;
    background: url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/rv_close.png) no-repeat;
    width: 14px;
    height: 14px;
}

#menu_wrap {
    position: absolute;
    top: 0;
    left: 0;
    bottom: 0;
    width: 350px;
    margin: 100px 0 5px 5px;
    padding: 5px;
    overflow-y: auto;
    background: rgba(255, 255, 255, 0.7);
    z-index: 1;
    font-size: 12px;
    border-radius: 10px;
}

.bg_white {
    background: #fff;
}

#menu_wrap hr {
    display: block;
    height: 1px;
    border: 0;
    border-top: 2px solid #5f5f5f;
    margin: 3px 0;
}

#menu_wrap .option {
    text-align: center;
}

#menu_wrap .option p {
    margin: 10px 0;
}

#menu_wrap .option button {
    margin-left: 5px;
}

#category {
    position: absolute;
    top: 10px;
    left: 10px;
    border-radius: 5px;
    border: 1px solid #909090;
    box-shadow: 0 1px 1px rgba(0, 0, 0, 0.3);
    background: #fff;
    overflow: hidden;
    z-index: 2;
}

#category li {
    float: left;
    list-style: none;
    width: 50px;
    height: 60px;
    border-right: 1px solid #acacac;
    padding: 5px;
    text-align: center;
    cursor: pointer;
}

#category li.on {
    background: #eee;
}

#category li:hover {
    background: #ffe6e6;
    border-left: 1px solid #acacac;
    margin-left: -1px;
}

#category li:last-child {
    margin-right: 0;
    border-right: 0;
}

#category li span {
    display: block;
    margin: 0 auto 3px;
    width: 27px;
    height: 28px;
}

#category li .category_bg {
    background: url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_category.png) no-repeat;
}

#category li .bank {
    background-position: -10px 0;
}

#category li .mart {
    background-position: -10px -36px;
}

#category li .pharmacy {
    background-position: -10px -72px;
}

#category li .oil {
    background-position: -10px -108px;
}

#category li .cafe {
    background-position: -10px -144px;
}

#category li .store {
    background-position: -10px -180px;
}

#category li.on .category_bg {
    background-position-x: -46px;
}

.placeinfo_wrap {
    position: absolute;
    bottom: 28px;
    left: -150px;
    width: 300px;
}

.placeinfo {
    position: relative;
    width: 100%;
    border-radius: 6px;
    border: 1px solid #ccc;
    border-bottom: 2px solid #ddd;
    padding-bottom: 10px;
    background: #fff;
}

.placeinfo:nth-of-type(n) {
    border: 0;
    box-shadow: 0px 1px 2px #888;
}

.placeinfo_wrap .after {
    content: "";
    position: relative;
    margin-left: -12px;
    left: 50%;
    width: 22px;
    height: 12px;
    background: url("https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png");
}

.placeinfo a,
.placeinfo a:hover,
.placeinfo a:active {
    color: #fff;
    text-decoration: none;
}

.placeinfo a,
.placeinfo span {
    display: block;
    text-overflow: ellipsis;
    overflow: hidden;
    white-space: nowrap;
}

.placeinfo span {
    margin: 5px 5px 0 5px;
    cursor: default;
    font-size: 13px;
}

.placeinfo .title {
    font-weight: bold;
    font-size: 14px;
    border-radius: 6px 6px 0 0;
    margin: -1px -1px 0 -1px;
    padding: 10px;
    color: #fff;
    background: #d95050;
    background: #d95050 url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/arrow_white.png) no-repeat right 14px center;
}

.placeinfo .tel {
    color: #0f7833;
}

.placeinfo .jibun {
    color: #999;
    font-size: 11px;
    margin-top: 0;
}
</style>