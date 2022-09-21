<template>
  <div>
    <div id="album">
      <div id="bg_map">
        <menu-main-item v-for="(items,index) in map_data" :key="items.score = scores[index]" v-bind="items"></menu-main-item>
      </div>
    </div>
  </div>
</template>

<script>
import { computed } from 'vue';
import { useStore } from 'vuex';
import MenuMainItem from '@/components/menu/items/MenuMainItem.vue';

export default {
  components: { MenuMainItem },
  data(){
    return{
      circles:null,
    }
  },
  methods: {
    back() {
      this.store.dispatch("menuStore/set_depth", 0);
    }
  },
  mounted(){
    console.log(this.map_data);
  },
  setup() {
    const store = useStore();

    const depth = computed(() => store.state.menuStore.depth);
    const sido = computed(() => store.state.menuStore.sido);
    const gugun = computed(() => store.state.menuStore.gugun);
    const map_data= computed(()=> store.state.menuStore.map_data);
    const scores = computed(()=>store.state.menuStore.scores);
    return { store, depth, sido, gugun, map_data,scores };
  },
}
</script>

<style>
  #album{
    position: relative;
    width: auto;
    height: 100vh;
  }
#bg_map {
  min-width:100%;
  max-width: 100%;
  max-height:100%;
  min-height: 100%;
  z-index: 1;
  background-image: url("../../assets/map.png");
  background-size: cover;
}

#region{
  position: absolute;
  margin: 0 auto;
}

#region .pic{
  width: 50px;
  height: 50px;
  background-color:rgb(255,255,255);
  border-radius: 50%;
}
#region.seoul{
  left:40%;
  top:18%;
}
#region.busan{
  left: 60%;
  top : 80%;
}
#region.daegoo{
  left: 60%;
  top : 80%;
}
#region.incheon{
  left:45%;
  top:18%;
}
#region.daejeon{
  left: 20%;
  top : 50%;
} 


#region.Gwangju{

}


#menu_card{
  background-color:#1a2844
}
#tempt{
  width:40px;
  height:40px;
  background-image: url("../../assets/tempt.svg");
  background-size:cover;
}
#humidity{
  width:40px;
  height:40px;
  background-image: url("../../assets/humidity.svg");
  background-size:cover;
}
#rainy{
  width:40px;
  height:40px;
  background-image: url("../../assets/rainy.svg");
  background-size:cover;
}
</style>