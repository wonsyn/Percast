<template>
    <div>
        <b-row>
            <menu-header></menu-header>
        </b-row>
        <b-row>
            <b-col>
                <menu-l-option></menu-l-option>
            </b-col>
            <b-col>
                <menu-main/>
            </b-col>
            <b-col>
                <menu-r-option></menu-r-option>
            </b-col>
        </b-row>
        <b-row>
            <menu-footer></menu-footer>
        </b-row>
    </div>
</template>

<script>
    import MenuHeader from "@/components/menu/MenuHeader.vue";
    import MenuFooter from "@/components/menu/MenuFooter.vue";
    import MenuMain from '@/components/menu/MenuMain.vue';
    import MenuROption from '@/components/menu/MenuROption.vue';
    import MenuLOption from '@/components/menu/MenuLOption.vue';

    export default {
    name: 'MenuView',
    components:{
        MenuHeader,
        MenuFooter,
        MenuMain,
        MenuROption,
        MenuLOption,
    }
    }
</script>

<style>

</style>