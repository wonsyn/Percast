<template>
    <text class="TEXT" :x="x" :y="y+20">{{name}}</text>
    <div :id="classname">
    </div>
    <div :id="classname" :x="x" :y="y">
        <div class="TEXT">{{name}}</div>
        <div class="pic">{{score}}</div>
    </div>
</template>

<script>
import { computed } from 'vue';
import { useStore } from 'vuex';
export default {
    props: {
        name: String,        //
        classname: String,  // 클래스 지정
        index: Number,       //
        score: Number,
        x: Number,
        y: Number,
    },
    mounted() {
        console.log("classname");
    },
    methods: {
        InnerRegion() {
            if (this.depth == 0) {
                console.log("get gugun! - " + this.name);
                this.store.dispatch("menuStore/set_depth", 1);
            }
            else {
                console.log("just gugun : " + this.name);
            }
        },
    },
    setup() {
        const store = useStore();
        const depth = computed(() => store.state.menuStore.depth);

        return { store, depth };
    }
}
</script>

<style>

</style>