<template>
    <b-card>
      <b-row>
        <b-col cols="1">{{index}}</b-col>
        <b-col cols="3">병원 이름</b-col>
        <b-col cols="7"> 000-0000-0000 </b-col>
      </b-row>
    </b-card>
</template>

<script>
export default {
    props:{
        index:Number,
    }
}
</script>

<style>

</style>