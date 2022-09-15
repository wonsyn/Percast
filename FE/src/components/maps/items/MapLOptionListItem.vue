<template>
    <b-card>
      <b-row>
        <b-col cols="1">{{index}}</b-col>
        <b-col cols="3">{{place_name}}</b-col>
        <b-col cols="7">{{phone}} </b-col>
      </b-row>
    </b-card>
</template>

<script>
export default {
    props:{
        index:Number,
        place_name:String,
        phone:String,
    }
}
</script>

<style>

</style>