<template>
  <modal-base ref="baseModal">
    <b-row>
      <div class="header">
        <h1>{{content.season}}</h1>
      </div>
    </b-row>
    <b-row>
      <b-card class="body" style="background-color:#1a2844; margin:10px,10px,10px,10px">
        <b-card-header>
          <b-button v-for="(item,index) in content.entity" :key="item.index = index" @click="selItem(index)">{{item.name}}</b-button>
        </b-card-header>
        <b-card-body>
          <p v-for="item in text" :key="item">{{item}}</p>
        </b-card-body>
      </b-card>
    </b-row>
    <b-row>
      <b-card class="footer" style="background-color:#1a2844; margin-top:20px">
        <b-button @click="close_modal"> close </b-button>
      </b-card>
    </b-row>
  </modal-base>
</template>

<script>
  import ModalBase from "@/components/about/modal/ModalBase.vue"
  import {ref} from "vue";
  export default {
  components:{
    ModalBase,
  },
  props:{
    content:Object,
  },
  setup(){
    const baseModal = ref(null);
    // Promise 객체를 핸들링하기 위한 ref
    const resolvePromise = ref(null);

    const show = () => {
      // baseModal을 직접 컨트롤합니다.
      baseModal.value.open();
      // Promise 객체를 사용하여, 현재 모달에서 확인 / 취소의
      // 응답이 돌아가기 전까지 작업을 기다리게 할 수 있습니다.
      return new Promise((resolve,) => {
        // resolve 함수를 담아 외부에서 사용합니다.
        resolvePromise.value = resolve;
      });
    };

    const confirm = () => {
      baseModal.value.close();
      resolvePromise.value(true);
    };

    const cancel = () => {
      baseModal.value.close();
      resolvePromise.value(false);
    };
    return { baseModal, show, confirm, cancel };
  },
  data(){
    return{
      listnum:0,
			selectNum:0,
			text:["데이터에", "저장된 질병 리스트가" , "존재하지 않습니다."],
    }
  },
  methods:{
    selItem(idx){
      console.log(idx);
      this.selectNum = idx;
      this.text = this.content.entity[idx].explain;
    },
    close_modal(){
      this.listnum=0;
			this.selectNum=0;
			this.text=["데이터에", "저장된 질병 리스트가" , "존재하지 않습니다."];
      this.cancel();
    }
  }
}
</script>

<style>

</style>