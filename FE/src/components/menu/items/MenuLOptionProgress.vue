<template>
  <h3 style="color:white"> {{region}} 위험단계 </h3>
  <b-card id="menu_card">
    <b-card-body>
        <h1 style="color:red"> {{score}} </h1>
        <b-progress max='100' height="30px" style="background:gray">
          <b-progress-bar :value="score" style="background:linear-gradient( to left, red, blue);"></b-progress-bar>
        </b-progress>
        <div id="menu_text" style="font-size:13px; margin-top:20px">현재 온도, 습도, 풍속, 미세먼지 등 요소를 분석한 결과</div>
        <div id="menu_text" style="font-size:18px">
          현재 {{time}} 기준 {{region}}은 
        </div>
        <div id="menu_text" >{{danger}} 단계입니다.</div>
        <div id="menu_text" style="font-size:15px;">{{text}}</div>
    </b-card-body>
  </b-card>
</template>

<script>
  import {computed} from 'vue';
  import {useStore} from 'vuex';
export default {
  setup(){
    const store = useStore();
    const region = computed(()=>store.state.menuStore.region);
    const score = computed(()=> store.state.menuStore.score);
    const danger = computed(()=>store.state.menuStore.danger);
    return {store, region, score,danger};
  },
  data(){
    return{
      time:"2022.09.14 17:29:00",
    }
  }
}
</script>

<style>
  #menu_text{
    color:#BBBBBB;
  }
</style>