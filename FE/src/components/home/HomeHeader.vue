<template>
  <div id="jumbotron">
    <div class="jumbotron jumbotron-fluid">
      <!-- <h1 class="display-4">Fluid jumbotron</h1>
        <p class="lead">
          This is a modified jumbotron that occupies the entire horizontal space
          of its parent.
        </p> -->
      <Carousel :autoplay="5000" :wrap-around="true">
        <Slide v-for="(slide, index) in 3" :key="slide">
          <div id="carousel__item" :class="carousel__item[index]">
            감기 걸리기 딱 좋은 날씨네 <br />
            오늘의 날씨, 미세먼지 정보를 토대로 5대 질병의 위험도를
            안내해줍니다. <br />
            계절별 유행 질병도 알려줍니다. <br />
            병원, 약국 위치도 알려줍니다. <br />
          </div>
        </Slide>

        <template #addons>
          <!-- <Navigation /> -->
          <Pagination />
        </template>
      </Carousel>
    </div>
  </div>
</template>

<script>
import { defineComponent } from "vue";
import { Carousel, Pagination, Slide } from "vue3-carousel";

import "vue3-carousel/dist/carousel.css";

// export default {};
export default defineComponent({
  name: "HomeCarousel",
  components: {
    Carousel,
    Slide,
    Pagination,
    // Navigation,
  },
  data() {
    return {
      carousel__item: ["a", "b", "c", "d"],
    };
  },
});
</script>

<style>
#jumbotron {
  height: 500px;
  width: 100%;
  color: white;
  padding-top: 20px;
  /* background-color: gray; */
}
#carousel__item {
  min-height: 400px;
  width: 100%;
  color: var(--vc-clr-white);
  font-size: 20px;
  border-radius: 8px;
  display: flex;
  justify-content: center;
  align-items: center;
}
#carousel__item.a {
  background-image: url("../../assets/sunny.png");
  color: black;
}
#carousel__item.b {
  background-image: url("../../assets/cloudy.png");
}
#carousel__item.c {
  background-image: url("../../assets/raining.png");
}
.carousel__slide {
  padding: 10px;
}

.carousel__prev,
.carousel__next {
  box-sizing: content-box;
  border: 5px solid white;
}
</style>
