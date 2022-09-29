<template>
  <!-- 강조문일때 -->
  <ul class="emphasize" v-if="isEmphasize">
    <li>
      <pre>{{title}}  <a v-for="item in text" :key="item"> {{item}} </a></pre>
    </li>
    <about-modals-show-item-list
      v-for="item in list"
      :key="item.isEmphasize == false"
      v-bind="item"
    >
    </about-modals-show-item-list>
    <about-modals-show-item-list
      v-for="item in emphasize"
      :key="item.isEmphasize == true"
      v-bind="item"
    >
    </about-modals-show-item-list>
  </ul>
  <!-- 강조문이 아닐때 -->
  <ul v-else>
    <li>
      <pre>{{title}}  <a v-for="item in text" :key="item"> {{item}} </a></pre>
    </li>
    <about-modals-show-item-list
      v-for="item in list"
      :key="item.isEmphasize == false"
      v-bind="item"
    >
    </about-modals-show-item-list>
    <about-modals-show-item-list
      v-for="item in emphasize"
      :key="item.isEmphasize == true"
      v-bind="item"
    >
    </about-modals-show-item-list>
  </ul>
</template>

<script>
export default {
  props: {
    title: Array,
    text: Array,
    list: Array,
    emphasize: Array,
    isEmphasize: Boolean,
  },
};
</script>

<style>
.emphasize {
  margin: 0;
  padding: 0;
  list-style: none;
}

.emphasize li {
  position: relative;
  margin: 2px 0 0 0;
  padding: 0 0 4px 16px;
  font-size: 16px;
  color: white;
}

.emphasize li:after {
  content: "";
  top: 4px;
  left: 0;
  width: 10px;
  height: 10px;
  position: absolute;
  background-image: url("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcT7K63tX5M3uqMo8mN2yPd_9j4JAlgJO9BizSsPqnzaRFBE5EdQ&usqp=CAU");
  background-size: cover;
  background-position: center;

  /*  가운데 정렬할 경우 쓸 것
      top: 50%;
      transform: translateY(-50%); */
}
pre::-webkit-scrollbar {
  height: 6px;
}
pre::-webkit-scrollbar-track {
  background-color: transparent;
}
pre::-webkit-scrollbar-thumb {
  border-radius: 3px;
  background-color: gray;
}
pre::-webkit-scrollbar-button {
  width: 0;
  height: 0;
}
</style>
