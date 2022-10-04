<template>
  <div id="jumbotron">
    <div
      class="jumbotron jumbotron-fluid"
      data-aos="fade-up"
      data-aos-offset="300"
    >
      <Carousel :autoplay="5000" :wrap-around="true">
        <Slide v-for="(slide, index) in 3" :key="slide">
          <div
            id="carousel__item"
            :class="carousel__item[index]"
            v-if="index == 0"
            style="flex-direction: column; padding-left: 20px"
          >
            <div>병에 걸릴까봐 걱정하는 당신!!</div>
            <div style="font-weight: bold; font-size: 30px">
              감기걸리기 딱 좋은 날씨네를
            </div>
            <div style="font-weight: bold; font-size: 30px">
              사용한 후 걱정이 사라집니다.
            </div>
          </div>
          <div
            id="carousel__item"
            :class="carousel__item[index]"
            v-if="index == 1"
            style="flex-direction: column; padding-left: 20px"
          >
            <!-- <div>환절기마다 걱정되는 감기, 천식, 피부병 증상</div>
            <div>여름마다 심해지는 눈병</div> -->
            <div>처음 경험해 본 계절 질병들까지 !!</div>
            <div style="font-weight: bold; font-size: 30px">
              감기걸리기 딱 좋은 날씨네가
            </div>
            <div style="font-weight: bold; font-size: 30px">알려드립니다.</div>
          </div>
          <div
            id="carousel__item"
            :class="carousel__item[index]"
            v-if="index == 2"
            style="flex-direction: column; padding-left: 20px"
          >
            <div>감기걸리기 딱 좋은 날씨네를 만나기 전</div>
            <div style="font-weight: bold; font-size: 30px">
              왜 이렇게 불편하게
            </div>
            <div style="font-weight: bold; font-size: 30px">
              생활했었나 싶어요
            </div>
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
import AOS from "aos";
import "aos/dist/aos.css";

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
  created() {
    AOS.init();
    // console.log(this.comments);
  },
});
</script>

<style>
#jumbotron {
  height: 100vh;
  width: 100%;
  color: white;
  /* background-color: gray; */
}
#carousel__item {
  min-height: 80vh;
  width: 100%;
  color: var(--vc-clr-white);
  font-size: 20px;
  border-radius: 8px;
  display: flex;
  /* justify-content: center; */
  /* align-items: center; */
}
#carousel__item.a {
  background-image: url("../../assets/sunny1.png");
  background-size: cover;
  color: black;
  justify-content: center;
  align-items: start;
}
#carousel__item.b {
  background-image: url("../../assets/cloudy.png");
  background-size: cover;
  justify-content: center;
  align-items: start;
}
#carousel__item.c {
  background-image: url("../../assets/raining.png");
  background-size: cover;
  justify-content: center;
  align-items: start;
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
