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
        classname: ["", "",], // 마커 종류가 늘어날수록 더 늘린다.
        markers2: [], // 마커 종류가 늘어날수록 더 늘린다.
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

        mapsrc : "//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=0b3e66bcb81a8bb4498994ff82980dda&libraries=services",
    };
},

mounted(){
    if(window.kakao && window.kakao.maps){
        // 지도 초기화
        this.initMap();
        // 로드뷰 설정
        //this.SetView();
    }else{
        const script = document.createElement('script');
        
        // 아래 주석 빠지면 실행안됨
        /* global kakao */
        script.onload = () => kakao.maps.load(this.initMap);
        // src 속성 추가, service키 활용
        script.src = this.mapsrc;
        // document의 head에 script 추가
        document.head.appendChild(script);
    }

    const contentNode = document.createElement("div");

    contentNode.className = "placeinfo_wrap";
},

methods:{
    initMap(){
        const container = document.getElementById("map");
        const options = {
            center: new kakao.maps.LatLng(37.5666805, 126.974847),
            level: 5,
        }
        this.container = document.getElementById("container");
        this.mapWrapper = document.getElementById("mapWrapper");
        this.mapContainer = document.getElementById("map");

        this.map = new kakao.maps.Map(container, options);

        // 이동 및 축소/확대에따른 이벤트 추가 : searchPlaces
        kakao.maps.event.addListener(this.map, "idle", this.searchPlaces);
        this.info = new kakao.maps.InfoWindow({
            removeable:true,
            zIndex : 2,
        });
    },
    addEventHandle(target, type, callback){
        if(target.addEventListener){
            target.addEventListener(type,callback);
        }else{
            target.attachEvent('on'+type, callback);
        }
    },

    searchPlaces() {
        const ps = new kakao.maps.services.Places(this.map);
        if (!this.currCategory != "") {
            return;
        }
        // 커스텀 오버레이를 숨깁니다
        this.placeOverlay.setMap(null);
        
        // 지도에 표시되고 있는 마커를 제거합니다
        this.removeMarker();

        ps.categorySearch(this.currCategory, this.placesSearchCB, {
            useMapBounds: true,
        });
    },
    placesSearchCB(data, status) {
        if (status === kakao.maps.services.Status.OK) {
            // 정상적으로 검색이 완료됐으면 지도에 마커를 표출합니다
            this.displayPlaces(data);
        } else if (status === kakao.maps.services.Status.ZERO_RESULT) {
            // 검색결과가 없는경우 해야할 처리가 있다면 이곳에 작성해 주세요
            console.log("zero");
        } else if (status === kakao.maps.services.Status.ERROR) {
            // 에러로 인해 검색결과가 나오지 않은 경우 해야할 처리가 있다면 이곳에 작성해 주세요
            console.log("error");
        }
    },

    // 지도에 마커를 표출하는 함수입니다
    displayPlaces(places) {
      // 몇번째 카테고리가 선택되어 있는지 얻어옵니다
      // 이 순서는 스프라이트 이미지에서의 위치를 계산하는데 사용됩니다
      var order = document
        .getElementById(this.currCategory)
        .getAttribute("data-order");

      console.log("displayPlaces : "+this.currCategory);
      places.forEach((place) => {
        // 마커를 생성하고 지도에 표시합니다
        var marker = this.addMarker(
          new kakao.maps.LatLng(place.y, place.x),
          order,
        );

        var content =
          '<div class="placeinfo">' +
          '   <a class="title" href="' +
          place.place_url +
          '" target="_blank" title="' +
          place.place_name +
          '">' +
          place.place_name +
          "</a>";

        if (place.road_address_name) {
          content +=
            '    <span title="' +
            place.road_address_name +
            '">' +
            place.road_address_name +
            "</span>" +
            '  <span class="jibun" title="' +
            place.address_name +
            '">(지번 : ' +
            place.address_name +
            ")</span>";
        } else {
          content +=
            '    <span title="' +
            place.address_name +
            '">' +
            place.address_name +
            "</span>";
        }
        content +=
          '    <span class="tel">' +
          place.phone +
          "</span>" +
          "</div>" +
          '<div class="after"></div>';

        kakao.maps.event.addListener(marker, "click", () => {
          if (this.openinfo && this.info.getContent() == content) {
            this.info.close(this.map, marker);
            this.openinfo = false;
          } else {
            this.info.setContent(content);
            this.info.setPosition(new kakao.maps.LatLng(place.y, place.x));
            this.info.open(this.map, marker);
            this.openinfo = true;
          }
        });
      });
    },

    addMarker(position, order) {
        var imageSrc =
            "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_category.png"; // 마커 이미지 url, 스프라이트 이미지를 씁니다
        const imageSize = new kakao.maps.Size(27, 28); // 마커 이미지의 크기
        const imgOptions = {
            spriteSize: new kakao.maps.Size(72, 208), // 스프라이트 이미지의 크기
            spriteOrigin: new kakao.maps.Point(46, order * 36), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
            offset: new kakao.maps.Point(11, 28), // 마커 좌표에 일치시킬 이미지 내에서의 좌표
        };
        const markerImage = new kakao.maps.MarkerImage(
            imageSrc,
            imageSize,
            imgOptions,
        );
        const marker = new kakao.maps.Marker({
            position: position, // 마커의 위치
            image: markerImage,
        });

        marker.setMap(this.map); // 지도 위에 마커를 표출합니다
        this.markers2.push(marker); // 배열에 생성된 마커를 추가합니다
        return marker;
    },

    onClickCategory(id, classnum) {
        console.log(id+" , "+classnum)
        this.placeOverlay = new kakao.maps.CustomOverlay({ zIndex: 1 });
        this.ps = new kakao.maps.services.Places(this.map);
        this.className = this.classname[classnum];
        this.placeOverlay.setMap(null);

        if (this.className === "on") {
            this.currCategory = "";
            this.changeCategoryClass(null);
            this.removeMarker();
        } else {
            this.currCategory = id;
            this.changeCategoryClass(classnum);
            this.searchPlaces();
        }
    },

    removeMarker() {
        for (var i = 0; i < this.markers2.length; i++) {
            this.markers2[i].setMap(null);
        }
        this.markers2 = [];
    },
    
    //클릭된 카테고리에만 클릭된 스타일 적용
    changeCategoryClass(el) {
        let category = document.getElementById("category");
        let children = category.children;
        for (let i = 0; i < children.length; i++) {
            this.classname[i] = "";
        }
        if (el != null) {
            this.classname[el] = "on";
        }
    },
    
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

.bg_white {
    background: #fff;
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

#category li .hospital {
    background-position: -10px 0;
}

#category li .pharmacy {
    background-position: -10px -36px;
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