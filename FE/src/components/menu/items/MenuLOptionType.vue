<template>
  <div id="menu_nav">
    <a id="menu_type" herf="#" type="link" @click="getInfo(0)">감기</a>
    |
    <a id="menu_type" herf="#"  @click="getInfo(1)">천식</a>
    |
    <a id="menu_type" herf="#"  @click="getInfo(2)">피부병</a>
    |
    <a id="menu_type" herf=#  @click="getInfo(3)">눈병</a>    
    |
    <a id="menu_type" herf="#"  @click="getInfo(4)">식중독</a>
  </div>
</template>

<script>
export default {

}
</script>

<style>
  #menu_nav{
    margin:10px;
    width:100%;
    height: 50px;
    background-color: #1a2844;
    color: #5673eb;
  }
  #menu_nav .on{
    color: #eb5374;
  }
  #menu_type{
    width:20%;
  }
  #menu_between{
  }
</style>