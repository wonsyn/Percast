<template>
  <div id="menu_nav">
    <ul>
      <li><a id="menu_type" :class="selected[0]" @click="getInfo(0)">감기</a></li>
      <li><a id="menu_type" :class="selected[1]" @click="getInfo(1)">천식</a></li>
      <li><a id="menu_type" :class="selected[2]" @click="getInfo(2)">피부병</a></li>
      <li><a id="menu_type" :class="selected[3]" @click="getInfo(3)">눈병</a></li>    
      <li><a id="menu_type" :class="selected[4]" @click="getInfo(4)">식중독</a></li>
    </ul>
  </div>
</template>

<script>
export default {
  data(){
    return{
      selected:["","","","",""],
    }
  },
  methods:{
    getInfo(num){

      console.log(num);
      this.selected_class(num);
    },
    selected_class(num){
      for(let i=0;i<this.selected.length;i++)
      {
        this.selected[i] = "";
      }
      if(num!=null && num<this.selected.length)
        this.selected[num] = "on";
    }
  }
}
</script>

<style>
  #menu_nav{
    margin:10px;
    width:100%;
    height: 40px;
    background-color: #1a2844;
    color: #5673eb;
  }
  #menu_nav .on{
    color: #eb5374;
  }
  #menu_nav ul{
    display: flex;
    margin-bottom: 0;
    list-style: none;
    padding-left: 0;
    border: solid 1px #1a2844;
    border-radius: 4px;
    width:20%;
  }

  #menu_nav ul li {
    padding-left: 0;
    border-left: solid 1px #000000;
  }

  
  #menu_nav ul li:first-child {
    border-left: 0;
  }


  #menu_nav ul li a {
    display: block;
    width: 4.5rem;
    height: 2.75rem;
    line-height: 1.5rem;
    padding: 0.5rem 0 0.5rem 0;
    text-transform: uppercase;
    text-decoration: none;
    font-size: 1.0rem;
    font-weight: bold;
    border-bottom: 0;
  }

  #menu_type{
    color: #5673eb;
  }
  #menu_type:hover{
    background-color: rgba(255, 255, 255, 0.075);
    color: gray;
  }
  #menu_type.on{
    background-color: rgba(255, 255, 255, 0.075);
    color: #eb5374;
  }
</style>