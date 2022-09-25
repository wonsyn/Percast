<template>
    <b-card id="menu_card">
        <b-card-body>
            <b-row>
                <b-col cols="4">
                    <b-card class="inner_card" style="background-color:#1a2844; color:white">
                        <div id="dust"></div>
                        <div>미세먼지</div>
                        <b-card-text> 36.5 </b-card-text>
                    </b-card>
                </b-col>
                <b-col cols="4">
                    <b-card class="inner_card" style="background-color:#1a2844; color:white">
                        <div id="super_dust"></div>
                        <div>초미세먼지</div>
                        <b-card-text>17</b-card-text>
                    </b-card>
                </b-col>
                <b-col cols="4">
                    <b-card class="inner_card" style="background-color:#1a2844; color:white">
                        <div id="ozon"></div>
                        <div>오존</div>
                        <b-card-text>17</b-card-text>
                    </b-card>
                </b-col>
            </b-row>
        </b-card-body>
    </b-card>
</template>

<script>
export default {
    methods: {
        OnClick() {
            console.log("click!");
        }
    }
}
</script>

<style>

</style>